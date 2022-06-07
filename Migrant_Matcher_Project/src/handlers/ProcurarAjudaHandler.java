package handlers;

import java.util.List;
import java.util.Scanner;

import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
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
	//private List<EnviadoresSMS> pluginsSms;
	
	public ProcurarAjudaHandler(Migrante m,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,Scanner sc) {
		
		this.catAjudas = catA;
		catAjudas.adicionaAjuda(new Alojamento(3, catR.getRegiao("viseu")));
		catAjudas.adicionaAjuda(new Alojamento(2, catR.getRegiao("viseu")));
		catAjudas.adicionaAjuda(new Alojamento(4, catR.getRegiao("viseu")));
		catAjudas.adicionaAjuda(new Alojamento(5, catR.getRegiao("viseu")));
		String locais = "faca,garfo,colher,vela,barco,pinha,foto,toalhaDeMesa";
		for(String s : locais.split(",")) {
			catAjudas.adicionaAjuda(new Item(s));
		}
		this.catRegioes = catR;
		this.migrante = m;
		this.sc=sc;
		//this.pluginsSms=plugins;
	}
	
	public void localizacao() {
		System.out.println(this.catRegioes.toString());
		while (this.r == null) {
			pergunta("Para onde se deseja mover?");
			this.r = catRegioes.getRegiao(sc.next());
			if(r.equals(null))
				System.out.println("Regiao não encontrada. Por favor tente novamente...");
			pergunta("Indique o método de ordenação, tipo ou data:");
			this.catAjudas.imprimeAjudas(sc.next());
		}
	}

	

	private void pergunta(String string) {
		System.out.println(string);
		System.out.print("\t-> \n");
	}

	
}
