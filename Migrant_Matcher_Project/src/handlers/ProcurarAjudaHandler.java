package handlers;

import java.util.List;
import java.util.Scanner;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import ajuda.sms.EnviadoresSMS;
import pedido_ajuda.PedidoAjuda;
import regiao.CatalogoRegioes;
import regiao.Regiao;
import utilizador.Migrante;
import utilizador.Voluntario;

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
		
		//DEFAULT CITIES
				Voluntario defaultV = new Voluntario(000);
				catAjudas.adicionaAjuda(new Alojamento(3, catR.getRegiao("viseu"),defaultV));
				catAjudas.adicionaAjuda(new Alojamento(2, catR.getRegiao("viseu"),defaultV));
				catAjudas.adicionaAjuda(new Alojamento(4, catR.getRegiao("viseu"),defaultV));
				catAjudas.adicionaAjuda(new Alojamento(5, catR.getRegiao("viseu"),defaultV));
				String locais = "faca,garfo,colher,vela,barco,pinha,foto,toalhaDeMesa";
				for(String s : locais.split(",")) {
					catAjudas.adicionaAjuda(new Item(s));
				}
		//DEFAULT CITIES
		
		this.catRegioes = catR;
		this.migrante = m;
		this.sc=sc;
		this.pluginsSms=plugins;
	}
	
	public void localizacao() {
		while (this.r == null) {
			pergunta("\nPara onde se deseja mover?\n"+ this.catRegioes.toString());
			this.r = catRegioes.getRegiao(sc.next());
			if(r == null)
				System.out.println("Regiao não encontrada. Por favor tente novamente...");
		}
	}
	
	public void escolheAjudas() {
		pergunta("Indique o método de ordenação para a lista de "
				+ "ajudas da regiao indicada, tipo ou data:");
		String ordem = sc.next();
		System.out.println(this.catAjudas.imprimeAjudasPorOrdem(this.catAjudas.getAjudasPorOrdem(ordem)));
		this.migrante.setPaCorrente(new PedidoAjuda(this.catAjudas));
		do {
			this.migrante.getPaCorrente().adicionaAjuda(getAjudaInidicada(ordem));
			pergunta("Deseja adionar mais ajudas?");
		}
		while(((sc.next().toLowerCase().split("\\s"))[0]).equals("sim"));
	}

	private Ajuda getAjudaInidicada(String ordem) {
		pergunta("\nIndique o número da ajuda desejada:");
		try {
			Ajuda a = this.catAjudas.getAjudasPorOrdem(ordem).get(sc.nextInt());
			if (a == null) {
				System.out.println("Ajuda Incorreta...\nPorfavor tente novamente.");
				return getAjudaInidicada(ordem);
			}
			return a;
		}
		catch(NumberFormatException e) {
			return getAjudaInidicada(ordem);
		}
	}

	public void confirma() {
		pergunta("Deseja confirmar o seu pedido ?");
		if(((sc.next().toLowerCase().split("\\s"))[0]).equals("sim")) {
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

	private void pergunta(String string) {
		System.out.println(string);
		System.out.print("\t-> ");
	}



	
}
