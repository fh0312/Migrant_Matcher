package com.projeto2.sistema.io.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.projeto2.sistema.io.InputOutput;

public class FileInStrategy implements InputOutput {
		
	private Scanner sc;
	private FileWriter wr;
	
	public FileInStrategy() {
		try {
			this.sc = new Scanner(new File("input.txt"));
			File output = new File("output.txt");
			output.createNewFile();
			this.wr = new FileWriter(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private void out(String str) {
		try {
			wr.write(str+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void outSemN(String str) {
		try {
			wr.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String pergunta(String pergunta) {
		out(pergunta);
		outSemN("\t-> ");
		String resposta="";
        resposta += sc.nextLine();
        out(resposta);
		return resposta;
	}

	@Override
	public String getNome(String pronome, String deAlguem) {
		out("Indique o " + pronome + "nome " + deAlguem + ":");
		outSemN("\n\t-> ");
		String resposta="";
        resposta += sc.nextLine();
        out(resposta);
		return resposta;
		
	}

	@Override
	public int getInt() {
		try {
			String resposta="";
			 resposta += sc.nextLine();
		     out(resposta);
			return Integer.parseInt(resposta);
		}
		catch(NumberFormatException e) {
			escreve("O número introduzido não é válido.\n"
					+ "Porfavor tente novamente...\n");
			return getInt();
		}
	}
	
	@Override
	public void escreve(String s) {
		outSemN(s);
	}
	@Override
	public String recebe() {
		String resposta="";
        resposta += sc.nextLine();
        out(resposta);
		return resposta;
	}

	@Override
	public int getTel(String deAlguem) {
		try {
			out("\nIndique o número de telémovel " + deAlguem + ":");
			outSemN("\n\t-> ");
			String resposta="";
			 resposta += sc.nextLine();
		        out(resposta);
			return Integer.parseInt(resposta);
		}
		catch (NumberFormatException e) {
			out("Número de telemovel inválido. \nPor favor tente novamente...");
			return getTel(deAlguem);
		}
	}
	
	public void sair() {
		try {
			this.wr.close();
			this.sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
