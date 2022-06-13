package handlers.criaAjuda;

import java.util.Scanner;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.Item;
import regiao.CatalogoRegioes;
import utilizador.Voluntario;

public class CriaAjuda {
	
	private CatalogoRegioes catR;
	private Ajuda ajuda;
	private Voluntario doador;
	
	public CriaAjuda(String itemDesc,CatalogoRegioes cat,Voluntario v) {
		this.catR = cat;
		this.doador = v;
		this.ajuda = new Item(itemDesc);
	}
	
	public CriaAjuda(int numMax,CatalogoRegioes cat) {
		this.catR = cat;
		Scanner sc = new Scanner(System.in);
		System.out.print("Escolha uma região das seguintes apresentadas:\n");
		System.out.println(catR.toString());
		System.out.print("\t-> ");
		this.ajuda = new Alojamento(numMax,catR.getRegiao(sc.next().toLowerCase()),this.doador);
	}
	
	public Ajuda getAjuda() {
		return ajuda;
	}

}
