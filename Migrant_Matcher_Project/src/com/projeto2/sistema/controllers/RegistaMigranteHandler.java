package com.projeto2.sistema.controllers;

import java.util.ArrayList;
import java.util.List;

import com.projeto2.sistema.io.InputOutput;
import com.projeto2.sistema.utilizador.Familiar;
import com.projeto2.sistema.utilizador.Migrante;

public class RegistaMigranteHandler {
	
	private Migrante cabecaCasal ;
	private String nome;
	private InputOutput io;
	
	public RegistaMigranteHandler(InputOutput io){
		this.io = io;
	}

	public int iniciaRegisto() throws NumberFormatException{
		io.escreve(" - Para se inscrever individualmente:\t indique o seu numero de telemovel\n"
				+ " - Para inscrever a sua familia:\t indique o numero de pessoas do seu agregado"
				+ " familiar\n\n\t-> ");
		int num =io.getInt();
		return num;
	}
	
	public void continuaRegisto(int num) {
		if(num>100) { // individual
			this.nome= io.getNome("seu ","");
			this.cabecaCasal= new Migrante(this.nome,num);
		}
		else { // familia
			List<String> nomeFamiliares=new ArrayList<>();
			try {
				registaCabecaCasal(io.getNome("o ", "do cabeça de casal"),
						io.getTel("do cabeca de casal"));
				getNomeFamiliares(nomeFamiliares,num);
				adicionaFamiliares(nomeFamiliares);
			}
			catch (NumberFormatException e) {
				System.out.println("Número de telemovel inválido. \nPor favor tente novamente...\n");
				registaCabecaCasal(io.getNome("o ", "do cabeça de casal"),
						io.getTel("do cabeca de casal"));
				getNomeFamiliares(nomeFamiliares,num);
				adicionaFamiliares(nomeFamiliares);
			}
		}
	}

	private void getNomeFamiliares(List<String> lf,int num) {
		for(int i = 0;i<num-1;i++) {
			lf.add(io.getNome("","do familiar"));
		}
	}
	
	public void registaCabecaCasal (String nomeCabecaCasal,int telCabecaCasal) throws NumberFormatException{		
		this.cabecaCasal = new Migrante(nomeCabecaCasal,telCabecaCasal);
	}

	
	public void adicionaFamiliares(List<String> nomeFamiliares) {
		for(int i = 0;i<nomeFamiliares.size();i++) {
			this.cabecaCasal.adicionaFamiliar(new Familiar(nomeFamiliares.get(i)));
		}
	}

	public Migrante getMigrante() {
		return this.cabecaCasal;
	}

}
