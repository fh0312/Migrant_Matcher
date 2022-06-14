package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ajuda.CatalogoAjudas;
import ajuda.sms.EnviadoresSMS;
import configuration.MinhaConfig;
import handlers.ProcurarAjudaHandler;
import handlers.RegistaMigranteHandler;
import handlers.RegistarAjudaHandler;
import io.InputOutput;
import io.SystemInStrategy;
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
	
	
	
	public MigrantMatcher(InputOutput io) {
		this.catAjudas = new CatalogoAjudas();
		this.catRegioes = new CatalogoRegioes();
		this.catUsers = new CatalogoUtilizadores();
		this.pluginsSms = new ArrayList<EnviadoresSMS>() ;
		this.io = io; 
		carregarPlugins();
		this.io.escreve(("\n\tBem vindo ao programa Migrant Matcher!\n\n").toUpperCase());
		iniciaSistema();
	}
	
	public MigrantMatcher() { //default System.in and System.out
		this(new SystemInStrategy());
	}
                                                                                                                                                                                

	private void carregarPlugins() {
		List<EnviadoresSMS> lista = MinhaConfig.getPropertyAsListOfTypes("plugins");
		for (EnviadoresSMS p : lista) {
			pluginsSms.add(p);
		}
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
				fazerDoacao(user);
				break;
			
			case "sair" :
				this.io.escreve("\n\nObrigado por usar o nosso sistema !\n");
				System.exit(0);
		}
		
		this.io.pergunta("Deseja efetuar mais operações ?");
		if((this.io.recebe().toLowerCase().replaceAll("\\s+","")).equals("sim")) {
			iniciaSistema();
		}
		else this.io.escreve("\n\nObrigado por usar o nosso sistema !\n");
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
		procuraAjuda.localizacao();
		procuraAjuda.escolheAjudas();
		procuraAjuda.confirma();
		
		
		
	}

	private void fazerDoacao(String user) throws NumberFormatException {
		this.u = new Voluntario(Integer.parseInt(user));
		this.catUsers.adicionaUser(u);
		RegistarAjudaHandler registaAjuda= new RegistarAjudaHandler ((Voluntario) this.u, this.catRegioes,
				this.catAjudas,this.pluginsSms,this.io);
		registaAjuda.novaAjuda();
		registaAjuda.querConfirmar();
	}

	

	
	
	
	
	
	
	
	
	
	
	
}
