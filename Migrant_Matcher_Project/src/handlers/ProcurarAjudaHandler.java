package handlers;

import java.util.List;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import ajuda.sms.EnviadoresSMS;
import io.InputOutput;
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
	private List<EnviadoresSMS> pluginsSms;
	private InputOutput io;
	
	public ProcurarAjudaHandler(Migrante m,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,InputOutput io) {
		this.catAjudas = catA;
		
		//DEFAULT Helps
				Voluntario defaultV = new Voluntario(000);
				catAjudas.adicionaAjuda(new Alojamento(3, catR.getRegiao("viseu"),defaultV));
				catAjudas.adicionaAjuda(new Alojamento(2, catR.getRegiao("viseu"),defaultV));
				catAjudas.adicionaAjuda(new Alojamento(4, catR.getRegiao("viseu"),defaultV));
				catAjudas.adicionaAjuda(new Alojamento(5, catR.getRegiao("viseu"),defaultV));
				String locais = "faca,garfo,colher,vela,barco,pinha,foto,toalhaDeMesa";
				for(String s : locais.split(",")) {
					catAjudas.adicionaAjuda(new Item(s,defaultV));
				}
		//DEFAULT Helps
		
		this.catRegioes = catR;
		this.migrante = m;
		this.io=io;
		this.pluginsSms=plugins;
	}
	
	public void localizacao() {
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
		this.io.escreve(this.catAjudas.imprimeAjudasPorOrdem(this.catAjudas.getAjudasPorOrdem(ordem,this.r))+"\n");
		this.migrante.setPaCorrente(new PedidoAjuda(this.catAjudas));
		do {
			this.migrante.getPaCorrente().adicionaAjuda(getAjudaInidicada(ordem));
			
		}
		while(((this.io.pergunta("Deseja adionar mais ajudas?").toLowerCase().split("\\s"))[0]).equals("sim"));
	}

	private Ajuda getAjudaInidicada(String ordem) {
		
		try {
			int num = Integer.parseInt(this.io.pergunta("\nIndique o n�mero da ajuda desejada:"));
			if(num>=this.catAjudas.getAjudasPorOrdem(ordem,this.r).size()-1) {
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
		if(((this.io.pergunta("Deseja confirmar o seu pedido ?").toLowerCase().split("\\s"))[0]).equals("sim")) {
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