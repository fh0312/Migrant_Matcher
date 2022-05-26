package utilizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Migrante extends Utilizador {
	
	protected String nome;
	//private PedidoAjuda paCorrente;
	private List<Familiar> lf;
	private Scanner sc = new Scanner(System.in);
	
	public Migrante(String nome, int tel) {
		super(tel);
		this.nome = nome;
	}
	
	public Migrante(int numPessoas) {
		super(0);
		this.lf= new ArrayList<Familiar>();
		this.tel = getTelInput();
		this.nome = getNomeInput("cabeça de casal:");
		adicionaFamilia(numPessoas-1);
	}

	private void adicionaFamilia(int n) {
		for(int i = 0;i<n;i++) {
			lf.add(new Familiar(getNomeInput("familiar:"),getTelInput()));
		}
	}

	private String getNomeInput(String tipo) {
		System.out.println("Insira o nome do " + tipo);
		sc = new Scanner(System.in);
		String name = sc.next();
		return nome;
	}

	private int getTelInput() {
		System.out.println("Insira o numero de telemovel respetivo:");

		int tel =  sc.nextInt();
		sc.close();
		return tel;
	}
	
	public int getTel() {
		return this.tel;
	}
	public String getName() {
		return this.nome;
	}
	
	
	

}
