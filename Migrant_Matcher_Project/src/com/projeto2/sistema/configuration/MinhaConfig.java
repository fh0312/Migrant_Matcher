package com.projeto2.sistema.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MinhaConfig {

	public static String getProperty(String chave) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("input.properties")));
			return p.getProperty(chave);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[] getPropertyAsList(String chave) {
		return getProperty(chave).split(",");
	}
	
	public static <T> List<T> getPropertyAsListOfTypes(String chave) {
		List<T> ar = new ArrayList<>();
		for (String klassName : getPropertyAsList(chave)) {
			ar.add(MinhaConfig.getClass(klassName, null));
		}
		return ar;
	}
	
	public static <T> T getClass(String klassName, T defaul) {
		try {
			Class<?> klass = Class.forName(klassName);
			@SuppressWarnings("unchecked")
			T s = (T) klass.getConstructor().newInstance();
			return s;	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return defaul;
	}
          
        //Código realizado em aula pelo professor Alcides da cadeira de DCO
        //Apenas ligeiramente alterado.

}
