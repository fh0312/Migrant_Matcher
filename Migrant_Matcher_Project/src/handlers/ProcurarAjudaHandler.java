package handlers;

import java.util.List;
import java.util.Scanner;

import ajuda.Ajuda;
import ajuda.CatalogoAjudas;
import ajuda.sms.EnviadoresSMS;
import regiao.CatalogoRegioes;
import regiao.Regiao;
import utilizador.Migrante;

public class ProcurarAjudaHandler {
	
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Migrante migrante;
	private Regiao r = null ;
	private Scanner sc;
	private List<EnviadoresSMS> pluginsSms;
	
	public ProcurarAjudaHandler(Migrante m,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,Scanner sc) {
		
		this.catAjudas = catA;
		this.catRegioes = catR;
		this.migrante = m;
		this.sc=sc;
		this.pluginsSms=plugins;
	}
	
	public void localizacao() {
		this.catRegioes.toString();
		while (this.r.equals(null)) {
			pergunta("Para onde se deseja mover?");
			this.r = catRegioes.getRegiao(sc.next());
			if(r.equals(null))
				System.out.println("Regiao não encontrada. Por favor tente novamente...");
			this.catAjudas.imprimeAjudas("default");
		}
		
		
	}

	

	private void pergunta(String string) {
		System.out.println(string);
		System.out.println("\t-> ");
	}

	
}
