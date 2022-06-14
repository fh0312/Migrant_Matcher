package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new MigrantMatcher(); //usa o default (system.in)
		//usaScanner(); //para os testes no ficheiro
		
		
	}
	
//	public static void usaScanner() {
//		try {
//			String tiposAjuda = "alojamento,item";
//			Scanner fileSc = new Scanner(new File("input.txt"));
//			new MigrantMatcher(tiposAjuda, fileSc);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
}
