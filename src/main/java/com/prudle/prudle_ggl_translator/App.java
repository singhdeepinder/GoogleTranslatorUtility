package com.prudle.prudle_ggl_translator;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

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
public class App 
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
	
	private static String sqlFileName = "insertTMGooruNew0407.sql";
	private static String srcFolderName = "E:/Prasoon/Prudle/SourceFile/ProjectWithTranslation/GooruFE-NEW";
	private static boolean isJSonFile = true;
	
		
	// Instantiates a client
    Translate translate = TranslateOptions.getDefaultInstance().getService();
    public static Properties properties = null;
    public static JsonObject jsonObject = null;
    ArrayList<String> listOfValues;
    ArrayList<String> listOfValuesWithParam = new ArrayList<String>();
    



    public static void main( String[] args )
    {
    	
    	File f = new File(srcFolderName);
    	File[] matchingFiles = f.listFiles() ;
    	
    	App prudleTranslator = new App();
    	
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
    		writer.write(sqlQuery);
    		writer.newLine();
    		writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    BufferedWriter writer = null;
    
    private void initializeSQLFile() {
    	try {
    		File outfile = new File(sqlFileName);
    		FileOutputStream output = new FileOutputStream(outfile);
    		
    		writer = new BufferedWriter(new OutputStreamWriter(output));
    		
    		if (!outfile.exists()) {
    			outfile.createNewFile();
			}
    		
    		
    	}catch (IOException io) {
    		io.printStackTrace();
    	} finally {
    	
    	}
    	
    }
    
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
