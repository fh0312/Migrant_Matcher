package handlers;

import java.util.List;

import ajuda.CatalogoAjudas;
import ajuda.sms.ConfirmaSms;
import ajuda.sms.EnviadoresSMS;
import handlers.criaAjuda.CriaAjuda;
import io.InputOutput;
import regiao.CatalogoRegioes;
import utilizador.Voluntario;

public class RegistarAjudaHandler {
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Voluntario voluntario;
	private CriaAjuda criaAjuda;
	private List<EnviadoresSMS> pluginsSms;
	private InputOutput io;
	
	public RegistarAjudaHandler(Voluntario v,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,InputOutput io) {
		this.voluntario = v;
		this.catRegioes = catR;	
		this.catAjudas= catA;
		this.pluginsSms = plugins;
		this.io = io;
	}
	
	public void iniciaRegisto() {
		this.io.escreve("\nIndique o tipo de ajuda que deseja fornecer:\n");
		this.io.escreve("Tipos de Ajuda Disponiveis: | ");
		for(String s : catAjudas.getTiposAjuda()) {
			this.io.escreve(s.toUpperCase() + " | ");
		}
		qualAjuda(this.io.pergunta(""));
	}
	
	private void qualAjuda(String input) {
		switch(input.toLowerCase()) {
			case "alojamento" :
				
				try {
					int num = Integer.parseInt(this.io.pergunta("\nIndique o n�mero"
							+ " m�ximo de ocupa��o do alojamento:"));
					
					criaAlojamento(num,this.io.pergunta("\nEscolha uma regi�o das seguintes apresentadas:\n"+
							catRegioes.toString()+"\n"));
				}
				catch(NumberFormatException e) {
					this.io.escreve("\nN�mero n�o reconhecido. Por favor tente novamente...\n");
					qualAjuda("alojamento");
				}
				break;
				
			case "item" :
				this.io.pergunta("\nIndique a descri��o do item a ser oferecido:");
				criaItem(this.io.recebe());
				break;
				
			default :
				this.io.pergunta("\nO tipo de ajuda introduzido n�o est� dispon�vel. \n"
						+ "\t\tPor favor tente novamente...");
				qualAjuda(this.io.pergunta(""));
				break;
		}	
		
	}

	private void criaItem(String desc) {
		this.criaAjuda = new CriaAjuda(desc,this.voluntario);
	}

	private void criaAlojamento(int n, String nomeRegiao) {
		this.criaAjuda = new CriaAjuda(n,this.catRegioes.getRegiao(nomeRegiao.toLowerCase()),this.voluntario);
	}

	public void adicionarAjuda() {
		ConfirmaSms confirm = new ConfirmaSms(pluginsSms);
		confirm.sendCod(String.valueOf(voluntario.getTel()));
		confirma(confirm);

	}

	private void confirma(ConfirmaSms confirm) {
		if(confirm.estahConfirmado(this.io.pergunta("Indique o c�digo que lhe foi enviado por sms:"))) {
			this.voluntario.addAjuda(this.criaAjuda.getAjuda());
			this.catAjudas.adicionaAjuda(criaAjuda.getAjuda());
		}
		else {
			this.io.escreve("C�digo errado! Porfavor tente novamente.");
			confirma(confirm);
		}
		
		
	}

	public void querConfirmar() {
		
		if(this.io.pergunta("Deseja confirmar a sua doa��o?").toLowerCase().contains("sim")) {
			adicionarAjuda();
		}
		else {
			
			if(this.io.pergunta("Pretende criar uma nova doa��o?").toLowerCase().contains("sim")) {
				iniciaRegisto();
			}
			else {
				this.io.escreve("Obrigado por ter utilizado o programa MIGRANT MATCHER!");
				System.exit(0);
			}
		}
		
	}
}
