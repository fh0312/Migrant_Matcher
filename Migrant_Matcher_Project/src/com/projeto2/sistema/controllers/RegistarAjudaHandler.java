package com.projeto2.sistema.controllers;

import java.util.List;

import com.projeto2.sistema.ajuda.CatalogoAjudas;
import com.projeto2.sistema.ajuda.sms.ConfirmaSms;
import com.projeto2.sistema.ajuda.sms.EnviadoresSMS;
import com.projeto2.sistema.controllers.criaAjuda.CriaAjuda;
import com.projeto2.sistema.io.InputOutput;
import com.projeto2.sistema.regiao.CatalogoRegioes;
import com.projeto2.sistema.utilizador.Voluntario;

public class RegistarAjudaHandler {
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Voluntario voluntario;
	private CriaAjuda criaAjuda;
	private List<EnviadoresSMS> pluginsSms;
	private InputOutput io;
	
	public RegistarAjudaHandler(Voluntario v,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,InputOutput io) {
		this.voluntario = v;
		this.catRegioes = catR;	
		this.catAjudas= catA;
		this.pluginsSms = plugins;
		this.io = io;
	}
	
	public void iniciaRegisto() {
		this.io.escreve("\nIndique o tipo de ajuda que deseja fornecer:\n");
		this.io.escreve("Tipos de Ajuda Disponiveis: | ");
		for(String s : catAjudas.getTiposAjuda()) {
			this.io.escreve(s.toUpperCase() + " | ");
		}
		registaAjuda(this.io.pergunta(""));
	}
	
	private void registaAjuda(String tipoAjuda) {
		switch(tipoAjuda.toLowerCase()) {
			case "alojamento" :
				try {
					int num = Integer.parseInt(this.io.pergunta("\nIndique o número"
							+ " máximo de ocupação do alojamento:"));
					
					criaAlojamento(num,this.io.pergunta("\nEscolha uma região das seguintes apresentadas:\n"+
							catRegioes.toString()+"\n"));
				}
				catch(NumberFormatException e) {
					this.io.escreve("\nNúmero não reconhecido. Por favor tente novamente...\n");
					registaAjuda("alojamento");
				}
				break;
				
			case "item" :
				this.io.pergunta("\nIndique a descrição do item a ser oferecido:");
				criaItem(this.io.recebe());
				break;
				
			default :
				this.io.pergunta("\nO tipo de ajuda introduzido não está disponível. \n"
						+ "\t\tPor favor tente novamente...");
				registaAjuda(this.io.pergunta(""));
				break;
		}	
		
	}

	private void criaItem(String desc) {
		this.criaAjuda = new CriaAjuda(desc,this.voluntario);
	}

	private void criaAlojamento(int n, String nomeRegiao) {
		this.criaAjuda = new CriaAjuda(n,this.catRegioes.getRegiao(nomeRegiao.toLowerCase()),this.voluntario);
	}

	public void adicionarAjuda() {
		ConfirmaSms confirm = new ConfirmaSms(pluginsSms);
		confirm.sendCod(String.valueOf(voluntario.getTel()));
		confirma(confirm);

	}

	private void confirma(ConfirmaSms confirm) {
		if(confirm.estahConfirmado(this.io.pergunta("Indique o código que lhe foi enviado por sms:"))) {
			this.voluntario.addAjuda(this.criaAjuda.getAjuda());
			this.catAjudas.adicionaAjuda(criaAjuda.getAjuda());
		}
		else {
			this.io.escreve("Código errado! Porfavor tente novamente.");
			confirma(confirm);
		}
		
		
	}

	public void querConfirmar() {
		
		if(this.io.pergunta("Deseja confirmar a sua doação?").toLowerCase().contains("sim")) {
			adicionarAjuda();
		}
		else {
			
			if(this.io.pergunta("Pretende criar uma nova doação?").toLowerCase().contains("sim")) {
				iniciaRegisto();
			}
			else {
				this.io.escreve("Obrigado por ter utilizado o programa MIGRANT MATCHER!");
				System.exit(0);
			}
		}
		
	}
}
