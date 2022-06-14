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
	private List<EnviadoresSMS> pluginsSms ;
	private InputOutput io;
	private Scanner sc;
	
	
	
	public MigrantMatcher(String tiposAjuda,Scanner scanner) {
		this.catAjudas = new CatalogoAjudas(tiposAjuda.split(","));
		this.catRegioes = new CatalogoRegioes();
		this.catUsers = new CatalogoUtilizadores();
		this.pluginsSms = new ArrayList<EnviadoresSMS>() ;
		this.sc = scanner;
		this.io = new SystemInStrategy();
		System.out.println(("\n\tBem vindo ao programa Migrant Matcher!\n").toUpperCase());
		carregarPlugins();
		help();
		init(sc.next().toLowerCase().replaceAll("\\s+",""));
	}
	
	public MigrantMatcher(String tiposAjuda) { //default input
		this(tiposAjuda,new Scanner(System.in));

	}
                                                                                                                                                                                

	private void carregarPlugins() {
		List<EnviadoresSMS> lista = MinhaConfig.getPropertyAsListOfTypes("plugins");
		for (EnviadoresSMS p : lista) {
			pluginsSms.add(p);
		}
	}

	private void help() {
		System.out.println(" - Para procurar uma ajuda:\t escreva migrante");
		System.out.println(" - Para fazer uma doação:\t escreva voluntario");
		System.out.println(" - Para sair do programa:\t escreva sair");
		System.out.print("\n\t-> ");
	}
	
	private void init(String user) {
		switch (user) {
			case "migrante" : {
				pedirAjuda();
				break;
			}
			case "voluntario": {
				fazerDoacao(user);
				break;
			}	
			case "sair" :{
				System.out.println("\n\nObrigado por usar o nosso sistema !");
				System.exit(0);
			}
		}
		System.out.println("Deseja efetuar mais operações ?");
		System.out.print("\n\t-> ");
		if((sc.next().toLowerCase().split("\\s"))[0].equals("sim")) {
			help();
			init(sc.next());
		}
		else System.out.println("\n\nObrigado por usar o nosso sistema !");
	}
	
	private void pedirAjuda() throws NumberFormatException {
		RegistaMigranteHandler registo =new RegistaMigranteHandler(this.sc);
		this.u = registo.getMigrante();
		try{
			registo.iniciaRegisto();
		}
		catch(NumberFormatException e) {
			System.out.println(" Número de telemovel inválido! \nPor favor tente novamente...\n");
			new RegistaMigranteHandler(sc);
		}

		ProcurarAjudaHandler procuraAjuda = new ProcurarAjudaHandler((Migrante) this.u,
				this.catRegioes,this.catAjudas,this.pluginsSms,this.sc);
		procuraAjuda.localizacao();
		procuraAjuda.escolheAjudas();
		procuraAjuda.confirma();
		
		
		
	}

	private void fazerDoacao(String user) throws NumberFormatException {
		this.u = new Voluntario(Integer.parseInt(user));
		RegistarAjudaHandler registaAjuda= new RegistarAjudaHandler ((Voluntario) this.u, this.catRegioes,
				this.catAjudas,this.pluginsSms,this.sc);
		registaAjuda.novaAjuda();
		registaAjuda.querConfirmar();
	}

	

	
	
	
	
	
	
	
	
	
	
	
}
