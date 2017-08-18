package com.prudle.prudle_ggl_translator;

	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.OutputStreamWriter;
	import java.util.ArrayList;
	import java.util.Enumeration;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Properties;
	import java.util.Set;

	
	import com.google.auto.value.processor.escapevelocity.ParseException;
	import com.google.cloud.translate.Translate;
	import com.google.cloud.translate.Translate.TranslateOption;
	import com.google.cloud.translate.TranslateOptions;
	import com.google.cloud.translate.Translation;
	import com.google.gson.JsonArray;
	import com.google.gson.JsonElement;
	import com.google.gson.JsonObject;
	import com.google.gson.JsonParser;

	/**
	 * Hello world!
	 *
	 */
	public class PropTranslate 
	{
		
		private static String translation_Tbl  = "tbl_translationmem";
		private static String srcClm = "Name";
		private static String targetClm = "Value";
		private static String srcLangClm = "SourceLang";
		private static String targetLangClm = "TargetLang";
		
		private static String srcLang = "en";
		private static String srcLangPrint = "EN-US";
		private static String[] targetLang = {"es","ar"};
		private static String[] targetLangPrint = {"ES-XM","AR-SA"};
		
		private static String sqlFileName = "insertTMProperties.sql";
		private static String transMemoryFileName = "transMemory.txt";
		
		
		private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/nucleus-utils/src/main/resources";
		//private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/Gooru-FE-nile-develop/app/locales/en/originalJSon";
		//private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/quizzes/app/locales/en/quizzes";
		//private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/GooruFE-NEW";
		private static boolean isJSonFile = false;
		
		
		
		// Instantiates a client
	    Translate translate = TranslateOptions.getDefaultInstance().getService();

	    public static void main( String[] args )
	    {
	    	
	    	File f = new File(srcFolderName);
	    	File[] matchingFiles = f.listFiles() ;
	    	
	    	PropTranslate prudleTranslator = new PropTranslate();
	    	
	    	for (int i = 0; i < matchingFiles.length; i++) {
	    		prudleTranslator.translate(matchingFiles[i]);
			}
	           
	    }
	    
	    ArrayList<String> listOfValues;
	    ArrayList<String> listOfValuesWithParam = new ArrayList<String>();
	    
	    private void translate(File file) {
	    	initializeFileWriters();
	    	
	    	FileInputStream fileInput = null;
	    	Translations translationsRepo = new Translations();
	    	try {

	    		properties = new Properties();
				
				
				if (isJSonFile) {
					listOfValues = new ArrayList<String>();
					getPropertiesFromJSON(file);
					
					for (int i = 0; i < listOfValues.size(); i++) {
						String value = listOfValues.get(i);
						
						if(value.contains("{{") && value.contains("}}")){
							listOfValuesWithParam.add(value);
						} else {
							translate(value,0);
							translate(value,1);
						}
						
					}
					
					
					for (int i = 0; i < listOfValuesWithParam.size(); i++) {
						String value = listOfValuesWithParam.get(i);
							translate(value,0);
							translate(value,1);
						
					}
					
					
					
					
					
					
					return;
				} else {
					fileInput = new FileInputStream(file);
					properties.load(fileInput);
					fileInput.close();

				}
				
				Properties propertiesArabic = new Properties();
				Properties propertiesSpanish = new Properties();
				
				Enumeration<Object> enuKeys = properties.keys();
				while (enuKeys.hasMoreElements()) {
					String key = (String) enuKeys.nextElement();
					String value = properties.getProperty(key);
					//System.out.println(key + ": " + value);
					
					Translation translation =
				            translate.translate(
				                value,
				                TranslateOption.sourceLanguage(srcLang),
				                TranslateOption.targetLanguage(targetLang[0]));
					
					String translatedValue = translation.getTranslatedText();
					writeToSQLFile(value,translatedValue,targetLang[0]);
					
					translationsRepo.translationsPropSpanish.put(value, translatedValue);
					writeToTransMemoryFile(value,translatedValue,"translationsPropSpanish");
					propertiesSpanish.put(key, translatedValue);
					
					translation =
				            translate.translate(
				                value,
				                TranslateOption.sourceLanguage(srcLang),
				                TranslateOption.targetLanguage(targetLang[1]));
					
					translatedValue = translation.getTranslatedText();
					writeToSQLFile(value,translatedValue,targetLang[1]);
					translationsRepo.translationsPropArabic.put(value, translatedValue);
					writeToTransMemoryFile(value,translatedValue,"translationsPropArabic");
					propertiesArabic.put(key, translatedValue);
				}
				
				
				// create properties file foe each language and dump the properties
				File outfilear = new File(srcFolderName + "/messages_ar.properties");
	    		FileOutputStream outputar = new FileOutputStream(outfilear);
	    		BufferedWriter propFileWriterAr = new BufferedWriter(new OutputStreamWriter(outputar));
	    		
	    		if (!outfilear.exists()) {
	    			outfilear.createNewFile();
				}
	    		propertiesArabic.store(propFileWriterAr, "");
	    		
	    		
	    		
	    		File outfilesp = new File(srcFolderName + "/messages_sp.properties");
	    		FileOutputStream outputsp = new FileOutputStream(outfilesp);
	    		
	    		BufferedWriter propFileWriterSp = new BufferedWriter(new OutputStreamWriter(outputsp));
	    		
	    		if (!outfilesp.exists()) {
	    			outfilesp.createNewFile();
				}
	    		propertiesSpanish.store(propFileWriterSp, "");
				
				
				}catch (IOException io) {
			    		io.printStackTrace();
			    	} finally {
			    		if (fileInput != null) {
			    			try {
			    				fileInput.close();
			    			} catch (IOException e) {
			    				e.printStackTrace();
			    			}
			    		}

			    	}
	    }
	    
	    
	    private void translate(String value, int indexOfTargetLang) {
	    	Translation translation =
		            translate.translate(
		                value,
		                TranslateOption.sourceLanguage(srcLang),
		                TranslateOption.targetLanguage(targetLang[indexOfTargetLang]));
			
			writeToSQLFile(value,translation.getTranslatedText(),targetLangPrint[indexOfTargetLang]);
	    }
	    
	    
	    
	    
	    
	    

	    private void writeToSQLFile(String src,String target,String targetLangValue) {
	    	
	    	String sqlQuery = "INSERT INTO " + translation_Tbl 
	    					+ "(" + srcClm + "," + targetClm + "," + srcLangClm + "," + targetLangClm + ") VALUES(\""
	    					+ src + "\",\"" + target + "\",'" + srcLangPrint + "','" + targetLangValue + "');";
	    	
	    	
	    	System.out.println(sqlQuery);
	    	try {
	    		SQFileWriter.write(sqlQuery);
	    		SQFileWriter.newLine();
	    		SQFileWriter.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    
        private void writeToTransMemoryFile(String src,String target,String targetLangMap) {
	    	
	    	String stringToWrite = targetLangMap + ".put( \"" + src + "\",\"" + target + "\");"  ;
	    	
	    	System.out.println(stringToWrite);
	    	try {
	    		transMemFileWriter.write(stringToWrite);
	    		transMemFileWriter.newLine();
	    		transMemFileWriter.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    BufferedWriter SQFileWriter = null;
	    BufferedWriter transMemFileWriter = null;
	    
	    private void initializeFileWriters() {
	    	
	    	
	    	
	    	try {
	    		File outfile = new File(sqlFileName);
	    		FileOutputStream output = new FileOutputStream(outfile);
	    		
	    		SQFileWriter = new BufferedWriter(new OutputStreamWriter(output));
	    		
	    		if (!outfile.exists()) {
	    			outfile.createNewFile();
				}
	    		
	    		File outfileTM = new File(transMemoryFileName);
	    		FileOutputStream outputTM = new FileOutputStream(outfileTM);
	    		
	    		transMemFileWriter = new BufferedWriter(new OutputStreamWriter(outputTM));
	    		
	    		if (!outfileTM.exists()) {
	    			outfileTM.createNewFile();
				}
	    		
	    		
	    	}catch (IOException io) {
	    		io.printStackTrace();
	    	} finally {
	    	
	    	}
	    	
	    }
	    
	    public static Properties properties = null;

	    public static JsonObject jsonObject = null;
	    
	    private Properties getPropertiesFromJSON(File file) {
	    	
	    	try {

	    		 JsonParser  jsonParser = new JsonParser();

	              
	            Object object = jsonParser.parse(new FileReader(file));

	            jsonObject = (JsonObject) object;

	            parseJson(jsonObject);

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    	return properties;
	    }
	    
	    public void parseJson(JsonObject jsonObject) throws ParseException {

	    	Set<Map.Entry<String, JsonElement>> set  =  jsonObject.entrySet();
	    	Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
	    	
	    	while (iterator.hasNext()) {
	    		Map.Entry<String, JsonElement> obj = iterator.next();
		    	if(obj.getValue().isJsonObject()) {
		    		parseJson((JsonObject) obj.getValue());
		    	} else if (obj.getValue().isJsonArray()) {
		    		getArray(obj.getValue());
		    	} else {
		    		listOfValues.add(obj.getValue().getAsString());
		    		System.out.println(obj.getKey() + "\t"
		                    + obj.getValue());
		    	}
	    	}
	    	
	    	
	    	
	    	
	    	
	        /*Set<String> set = jsonObject.;
	        Iterator<String> iterator = set.iterator();
	        while (iterator.hasNext()) {
	            String obj = iterator.next();
	            if (jsonObject.get(obj) instanceof JSONArray) {
	                System.out.println(obj.toString());
	                getArray(jsonObject.get(obj));
	            } else {
	                if (jsonObject.get(obj) instanceof JSONObject) {
	                    parseJson((JSONObject) jsonObject.get(obj));
	                } else {
	                    System.out.println(obj.toString() + "\t"
	                            + jsonObject.get(obj));
	                }
	            }
	        }*/
	    }
	    
	    
	    public  void getArray(Object object2) throws ParseException {

	    	JsonArray jsonArr = (JsonArray) object2;

	        for (int k = 0; k < jsonArr.size(); k++) {

	            if (jsonArr.get(k) instanceof JsonObject) {
	                parseJson((JsonObject) jsonArr.get(k));
	            } else {
	            	listOfValues.add(jsonArr.get(k).getAsString());
	                System.out.println(jsonArr.get(k));
	            }

	        }
	    }
	    
	    
	    
}


