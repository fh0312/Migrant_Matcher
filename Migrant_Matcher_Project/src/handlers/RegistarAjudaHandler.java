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
	
	public void novaAjuda() {
		this.io.escreve("Indique o tipo de ajuda que deseja fornecer:\n");
		this.io.escreve("\t Tipos de Ajuda Disponiveis:");
		for(String s : catAjudas.getTiposAjuda()) {
			this.io.escreve("\t\t"+ s.toUpperCase());
		}
		this.io.pergunta("");
		qualAjuda(this.io.recebe());
	}
	
	private void qualAjuda(String input) {
		switch(input.toLowerCase()) {
			case "alojamento" :
				this.io.pergunta("Indique o n�mero m�ximo de ocupa��o do alojamento:");
				try {
					int num = this.io.getInt();
					this.io.pergunta("Escolha uma regi�o das seguintes apresentadas:\n"+
				catRegioes.toString()+"\n");
					criaAlojamento(num,this.io.recebe());
				}
				catch(NumberFormatException e) {
					this.io.escreve("N�mero n�o reconhecido. Por favor tente novamente...\n");
					qualAjuda("alojamento");
				}
				break;
				
			case "item" :
				this.io.pergunta("Indique a descri��o do item a ser oferecido:");
				criaItem(this.io.recebe());
				break;
				
			default :
				this.io.pergunta("\n\t\tO tipo de ajuda introduzido n�o est� dispon�vel. \n"
						+ "\t\tPor favor tente novamente...");
				qualAjuda(this.io.recebe());
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
		this.io.pergunta("Indique o c�digo que lhe foi enviado por sms:");
		confirma(confirm);

	}

	private void confirma(ConfirmaSms confirm) {
		if(confirm.estahConfirmado(this.io.recebe())) {
			this.voluntario.addAjuda(this.criaAjuda.getAjuda());
			this.catAjudas.adicionaAjuda(criaAjuda.getAjuda());
		}
		else {
			this.io.escreve("C�digo errado! Porfavor tente novamente.");
			confirma(confirm);
		}
		
		
	}

	public void querConfirmar() {
		this.io.pergunta("Deseja confirmar a sua doa��o?");
		if(this.io.recebe().toLowerCase().equals("sim")) {
			adicionarAjuda();
		}
		else {
			this.io.escreve("Pretende criar uma nova doa��o?");
			if(this.io.recebe().toLowerCase().equals("sim")) {

			}
			else {
				this.io.escreve("Obrigado por ter utilizado o programa MIGRANT MATCHER!");
				System.exit(0);
			}
		}
		
	}
}
