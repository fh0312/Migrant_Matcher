package com.projeto2.sistema.controllers;

import java.util.List;

import com.projeto2.sistema.ajuda.Ajuda;
import com.projeto2.sistema.ajuda.CatalogoAjudas;
import com.projeto2.sistema.ajuda.sms.EnviadoresSMS;
import com.projeto2.sistema.io.InputOutput;
import com.projeto2.sistema.observer.ObservaAjudas;
import com.projeto2.sistema.pedido_ajuda.PedidoAjuda;
import com.projeto2.sistema.regiao.CatalogoRegioes;
import com.projeto2.sistema.regiao.Regiao;
import com.projeto2.sistema.utilizador.Migrante;

public class ProcurarAjudaHandler {
	
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Migrante migrante;
	private Regiao r = null ;
	private List<EnviadoresSMS> pluginsSms;
	private InputOutput io;
	
	public ProcurarAjudaHandler(Migrante m,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,InputOutput io) {
		this.catAjudas = catA;		
		this.catRegioes = catR;
		this.migrante = m;
		this.io=io;
		this.pluginsSms=plugins;
	}
	
	
	public void escolheRegiao() {
		while (this.r == null) {
			this.r = catRegioes.getRegiao(this.io.pergunta("\nPara onde se deseja mover?\n"
		+ this.catRegioes.toString()));
			if(r == null)
				this.io.escreve("Regiao n�o encontrada. Por favor tente novamente...\n");
		}
	}
	
	public void escolheAjudas() {
		String ordem = this.io.pergunta("Indique o m�todo de ordena��o para a lista de "
				+ "ajudas da regiao indicada, tipo ou data:");
		List<Ajuda> list = this.catAjudas.getAjudasPorOrdem(ordem,this.r);
		if(list==null) {
			this.io.escreve("Tipo de ordena��o inv�lido!\nPorfavor tente novamente...\n\n");
			escolheAjudas();
		}
		else if (list.isEmpty()) { 
			this.io.escreve("Ainda n�o existem ajudas nessa regi�o.\n"
					+ "Iremos notifica-lo assim que existir alguma ajuda.\n");
			this.catAjudas.registaObserver(new ObservaAjudas(migrante, r));
		}
		else {
			this.io.escreve(this.catAjudas.imprimeAjudasPorOrdem(this.catAjudas.
					getAjudasPorOrdem(ordem,this.r))+"\n");	
			this.migrante.setPaCorrente(new PedidoAjuda(this.catAjudas));
			do {
				this.migrante.getPaCorrente().adicionaAjuda(getAjudaInidicada(ordem));
			}
			while(((this.io.pergunta("Deseja adionar mais ajudas?").toLowerCase().
					split("\\s"))[0]).equals("sim"));
		}
	}

	private Ajuda getAjudaInidicada(String ordem) {
		
		try {
			int num = Integer.parseInt(this.io.pergunta("\nIndique o n�mero da ajuda desejada:"));
			if(num>this.catAjudas.getAjudasPorOrdem(ordem,this.r).size()-1) {
				this.io.escreve("\nN�mero inv�lido!\nPor favor tente novamente...\n\n\n");
				return getAjudaInidicada(ordem);
			}
			Ajuda a = this.catAjudas.getAjudasPorOrdem(ordem,this.r).get(num);
			if (a == null) {
				this.io.escreve("Ajuda Incorreta...\nPorfavor tente novamente.\n\n");
				return getAjudaInidicada(ordem);
			}
			return a;
		}
		catch(NumberFormatException e) {
			return getAjudaInidicada(ordem);
		}
	}

	public void confirma() {
		if(((this.io.pergunta("\nDeseja confirmar o seu pedido ?").toLowerCase().
				split("\\s"))[0]).equals("sim") && 
				this.migrante.getPaCorrente() != null) {
			this.migrante.getPaCorrente().confirmaPedido();
			this.migrante.adicionaPedido(this.migrante.getPaCorrente());
			voluntarioCheck();
		}
		
	}
	
	private void voluntarioCheck() {
		this.migrante.getPaCorrente()
		.getAjudasPedidas()
		.stream()
		.forEach(a -> {
			pluginsSms.get(0).send("Um migrante requisitou a ajuda: " + a.toString(),
					String.valueOf(a.getDoador().getTel()));
		});
	}



	
}
