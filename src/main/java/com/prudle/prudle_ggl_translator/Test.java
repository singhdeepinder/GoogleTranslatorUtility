package com.prudle.prudle_ggl_translator;

public class Test {

	
	public static void main(String[] args) {
		 Translations translation = new Translations();
		 translation.initialize(); 
		 
		 String translatedValue = translation.translationsFENewArabic.get("Never");
		 
		 System.out.println(translatedValue);
	}
}
