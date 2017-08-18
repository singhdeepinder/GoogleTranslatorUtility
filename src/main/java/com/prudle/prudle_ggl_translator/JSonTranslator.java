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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.auto.value.processor.escapevelocity.ParseException;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class JSonTranslator {


	private static String translation_Tbl  = "tbl_translationmem";
	private static String srcClm = "Name";
	private static String targetClm = "Value";
	private static String srcLangClm = "SourceLang";
	private static String targetLangClm = "TargetLang";
	
	private static String srcLang = "en";
	private static String srcLangPrint = "EN-US";
	private static String[] targetLang = {"es","ar"};
	private static String[] targetLangPrint = {"ES-XM","AR-SA"};
	
	private static String sqlFileName = "translationsFENew_ES-XM.json";
	//private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/nucleus-handlers-class/src/main/resources";
	//private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/Gooru-FE-nile-develop/app/locales/en/originalJSon";
	//private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/quizzes/app/locales/en/quizzes/originalJSon";
	private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/GooruFE-NEW";
	private static boolean isJSonFile = true;
	
	
	
	// Instantiates a client
    Translate translate = TranslateOptions.getDefaultInstance().getService();

    public static void main( String[] args )
    {
    	
    	File f = new File(srcFolderName);
    	File[] matchingFiles = f.listFiles() ;
    	
    	JSonTranslator prudleTranslator = new JSonTranslator();
    	
    	for (int i = 0; i < matchingFiles.length; i++) {
    		prudleTranslator.translate(matchingFiles[i]);
		}
           
    }
    
    
    private void translate(File file) {
    	initializeSQLFile();
    	FileInputStream fileInput = null;
    	
    	try {

    		properties = new Properties();
			
			
			if (isJSonFile) {
				getPropertiesFromJSON(file);
				
				return;
			} else {
				fileInput = new FileInputStream(file);
				properties.load(fileInput);
				fileInput.close();

			}
			
			
			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				//System.out.println(key + ": " + value);
				
				/*Translation translation =
			            translate.translate(
			                value,
			                TranslateOption.sourceLanguage(srcLang),
			                TranslateOption.targetLanguage(targetLang[0]));
				
				writeToSQLFile(value,translation.getTranslatedText(),targetLang[0]);
				
				
				/*translation =
			            translate.translate(
			                value,
			                TranslateOption.sourceLanguage(srcLang),
			                TranslateOption.targetLanguage(targetLang[1]));
				
				writeToSQLFile(value,translation.getTranslatedText(),targetLang[1]);*/
			}
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
    
    
    BufferedWriter writer = null;
    
    private void initializeSQLFile() {
    	
    	
    	
    	try {
    		File outfile = new File(sqlFileName);
    		FileOutputStream output = new FileOutputStream(outfile);
    		
    		writer = new BufferedWriter(new OutputStreamWriter(output,"UTF8"));
    		
    		if (!outfile.exists()) {
    			outfile.createNewFile();
			}
    		
    		
    	}catch (IOException io) {
    		io.printStackTrace();
    	} finally {
    	
    	}
    	
    }
    
    public static Properties properties = null;

    public static JsonObject jsonObject = null;
    Translations translation = new Translations();
    private Properties getPropertiesFromJSON(File file) {
    	
    	try {

    		translation.initialize(); 
    		 JsonParser  jsonParser = new JsonParser();

              
            Object object = jsonParser.parse(new FileReader(file));

            jsonObject = (JsonObject) object;

            parseJson(jsonObject);
            
            System.out.println("translatedJson");
            String  translatedJson = jsonObject.toString();
            System.out.println(translatedJson);
            writer.write(translatedJson);
    		writer.newLine();
    		writer.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return properties;
    }
    
    public void parseJson(JsonObject jsonObject) throws ParseException {
         
    	
    	Set<Map.Entry<String, JsonElement>> set  =  jsonObject.entrySet();
    	Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
    	HashMap<String, String>  tempMap = new HashMap<String, String>();
    	while (iterator.hasNext()) {
    		Map.Entry<String, JsonElement> obj = iterator.next();
	    	if(obj.getValue().isJsonObject()) {
	    		parseJson((JsonObject) obj.getValue());
	    	} else if (obj.getValue().isJsonArray()) {
	    		getArray(obj.getValue());
	    	} else {
	    		
	    		String value = obj.getValue().getAsString();
	    		String translatedValue = translation.translationsFENewSpanish.get(value);
	    		//System.out.println(value + " -> " + translatedValue);
	    		if(translatedValue != null ) {
	    			tempMap.put(obj.getKey(), translatedValue);
	    			//jsonObject.remove(obj.getKey());
	    			//jsonObject.addProperty(obj.getKey(), translatedValue);
	    		} else {
	    			System.out.println("Translation Not found : " + value);
	    		}
	    		
	    	}
    	}
    	
    	
    	Set<Map.Entry<String, String>> set2  =  tempMap.entrySet();
    	Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
    	
    	while (iterator2.hasNext()) {
    		Map.Entry<String, String> obj = iterator2.next();
    		//System.out.println("Removing : " + obj.getKey());
    		jsonObject.remove(obj.getKey());
    		
    		//System.out.println("Adding : " + obj.getKey() + "-> " + obj.getValue());
			jsonObject.addProperty(obj.getKey(), obj.getValue());
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
        	JsonElement obj = jsonArr.get(k); 
            if (obj instanceof JsonObject) {
                parseJson((JsonObject) jsonArr.get(k));
            } else if (obj.isJsonArray()) {
	    		getArray(obj);
	    	} else {
            	
	    		String value = obj.getAsString();
	    		String translatedValue = translation.translationsFENewSpanish.get(value);
	    		
	    		if(translatedValue != null ) {
	    			//String key = ((JsonPrimitive)obj).
	    			//jsonObject.remove(obj.getKey());
	    			//jsonObject.addProperty(obj.getKey(), translatedValue);
	    		} else {
	    			System.out.println("Translation Not found : " + value);
	    		}
            }

        }
    }
    
    

}
