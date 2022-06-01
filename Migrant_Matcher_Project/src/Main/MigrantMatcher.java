package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ajuda.CatalogoAjudas;
import ajuda.sms.EnviadoresSMS;
import ajuda.sms.plugins.AdaptadorPidgeonSMS;
import ajuda.sms.plugins.AdaptadorTelegramSMS;
import configuration.MinhaConfig;
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
	private Scanner sc = new Scanner(System.in);
	
	
	
	public MigrantMatcher() {
		this.catAjudas = new CatalogoAjudas();
		this.catRegioes = new CatalogoRegioes();
		this.catUsers = new CatalogoUtilizadores();
		System.out.println(("\t\tBem vindo ao programa Migrant Matcher!\n").toUpperCase());
		carregarPlugins();
		help();
		init(sc.next());
	}
                                                                                                                                                                                
	private void carregarPlugins() {
		List<EnviadoresSMS> lista = MinhaConfig.getPropertyAsListOfTypes("plugins");
		for (EnviadoresSMS p : lista) {
			pluginsSms.add(p);
		}
//		pluginsSms.add(new SemSMS());
		//pluginsSms.add(AdaptadorTelegramSMS.class);
		//pluginsSms.add(AdaptadorPidgeonSMS.class);
		
	}

	private void help() {
		System.out.println(" - Para procurar uma ajuda: indique o seu nome");
		System.out.println(" - Para fazer uma doa��o: indique o seu n�mero de telefone");
		System.out.print("\n\t-> ");
	}
	
	private void init(String user) {
		try{
			fazerDoacao(user);
			System.out.println("Obrigado !");
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	private void fazerDoacao(String user) throws NumberFormatException {
		this.u = new Voluntario(Integer.parseInt(user));
		RegistarAjudaHandler registaAjuda= new RegistarAjudaHandler
				((Voluntario) this.u, catRegioes,catAjudas,pluginsSms);
		registaAjuda.novaAjuda();
		System.out.println("Deseja confirmar a sua doa��o?");
		System.out.print("\n\t-> ");
		if(sc.next().toLowerCase().equals("sim")) {
			registaAjuda.adicionarAjuda();
		}
		else {
			System.out.println("Pretende criar uma nova doa��o?");
			if(sc.next().toLowerCase().equals("sim")) {
				fazerDoacao(user);
			}
			else {
				System.out.println("Obrigado por ter utilizado o programa MIGRANT MATCHER!");
				System.exit(0);
			}
		}
	}
	
	private void procurarAjuda(String User) {
		System.out.println(" - Para fazer um registo individual: indique o seu numero de telemovel.");
		System.out.println(" - Para fazer um registo coletivo: indique o n�mero de pessoas do agregado familiar");
		new ProcurarAjudaHandler();
		 //TODO
	}
	

	
	
}
