package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ajuda.CatalogoAjudas;
import ajuda.sms.EnviadoresSMS;
import handlers.ProcurarAjudaHandler;
import handlers.RegistarAjudaHandler;
import regiao.CatalogoRegioes;
import utilizador.CatalogoUtilizadores;
import utilizador.Utilizador;
import utilizador.Voluntario;

public class MigrantMatcher {
	
	private Utilizador u;
	private CatalogoRegioes catRegioes;
	private CatalogoAjudas catAjudas;
	private CatalogoUtilizadores catUsers;
	private List<EnviadoresSMS> pluginsSms = new ArrayList<EnviadoresSMS>();
	
	
	
	public MigrantMatcher() {
		System.out.println(("\tBem vindo ao programa Migrant Matcher!\n").toUpperCase());
		
		help();
	}
                                                                                                                                                                                
	private void help() {
		System.out.println(" - Para procurar uma ajuda:\t indique o seu nome");
		System.out.println(" - Para fazer uma doação:\t indique o seu número de telefone");
		Scanner sc = new Scanner(System.in);
		init(sc.next());
	}
	
	private void init(String user) {
		try{
			this.u = new Voluntario(Integer.parseInt(user));
			new RegistarAjudaHandler((Voluntario) this.u, catRegioes,catAjudas);
		}
		catch(NumberFormatException e) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" - Para fazer um registo individual:\t indique o seu numero de telemovel.");
			System.out.println(" - Para fazer um registo coletivo:\t indique o seu número do agregado familiar");
			new ProcurarAjudaHandler();
		}
	}
	

	
	
}
