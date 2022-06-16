package main;

import java.util.ArrayList;
import java.util.List;

import ajuda.CatalogoAjudas;
import ajuda.sms.EnviadoresSMS;
import configuration.MinhaConfig;
import handlers.ProcurarAjudaHandler;
import handlers.RegistaMigranteHandler;
import handlers.RegistarAjudaHandler;
import io.InputOutput;
import regiao.CatalogoRegioes;
import utilizador.CatalogoUtilizadores;
import utilizador.Migrante;
import utilizador.Utilizador;
import utilizador.Voluntario;

public class MigrantMatcher {
	
	private Utilizador u;
	private CatalogoRegioes catRegioes;
	private CatalogoAjudas catAjudas;
	private CatalogoUtilizadores catUsers;
	private List<EnviadoresSMS> pluginsSms;
	private InputOutput io;
	
	
	
	public MigrantMatcher() {
		this.pluginsSms = new ArrayList<EnviadoresSMS>() ; 
		carregarPlugins();
		this.catRegioes = new CatalogoRegioes();
		this.catUsers = new CatalogoUtilizadores();
		this.catAjudas = new CatalogoAjudas(this.pluginsSms);
		this.io.escreve(("\n\tBem vindo ao programa Migrant Matcher!\n\n").toUpperCase());
		iniciaSistema();
	}
                                                                                                                                                                                

	private void carregarPlugins() {
		List<EnviadoresSMS> lista = MinhaConfig.getPropertyAsListOfTypes("plugins");
		for (EnviadoresSMS p : lista) {
			pluginsSms.add(p);
		}
		List<InputOutput> listaIO = MinhaConfig.getPropertyAsListOfTypes("pluginsIO");
		this.io = listaIO.get(0);
	}
	
	private void iniciaSistema() {
		String user = this.io.pergunta(" - Para procurar uma ajuda:\t escreva migrante\n"
				+ " - Para fazer uma doação:\t escreva voluntario\n"
				+ " - Para sair do programa:\t escreva sair\n")
				.toLowerCase().replaceAll("\\s+","");
		switch (user) {
			case "migrante" : 
				pedirAjuda();
				break;
			
			case "voluntario":
				fazerDoacao(this.io.getTel(""));
				break;
			
			case "sair" :
				this.io.escreve("\n\nObrigado por utilizar o nosso sistema !\n");
				System.exit(0);
		}
		
		
		if((this.io.pergunta("Deseja efetuar mais operações ?").toLowerCase().replaceAll("\\s+","")).equals("sim")) {
			this.io.escreve("\n\n");
			iniciaSistema();
		}
		else this.io.escreve("\n\nObrigado por utilizar o nosso sistema !\n");
	}
	
	private void pedirAjuda() throws NumberFormatException {
		RegistaMigranteHandler registo = new RegistaMigranteHandler(this.io);
		try{
			registo.iniciaRegisto();
			this.u = registo.getMigrante();
			this.catUsers.adicionaUser(u);
		}
		catch(NumberFormatException e) {
			this.io.escreve(" Número de telemovel inválido! \nPor favor tente novamente...\n\n");
			new RegistaMigranteHandler(this.io);
		}

		ProcurarAjudaHandler procuraAjuda = new ProcurarAjudaHandler((Migrante) this.u,
				this.catRegioes,this.catAjudas,this.pluginsSms,this.io);
		procuraAjuda.escolheRegiao();
		procuraAjuda.escolheAjudas();
		procuraAjuda.confirma();
		
		
		
	}

	private void fazerDoacao(int userTel) throws NumberFormatException {
		this.u = new Voluntario(userTel);
		this.catUsers.adicionaUser(u);
		RegistarAjudaHandler registaAjuda= new RegistarAjudaHandler ((Voluntario) this.u, this.catRegioes,
				this.catAjudas,this.pluginsSms,this.io);
		registaAjuda.iniciaRegisto();
		registaAjuda.querConfirmar();
	}

	

	
	
	
	
	
	
	
	
	
	
	
}
