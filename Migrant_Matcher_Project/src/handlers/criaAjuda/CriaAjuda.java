package handlers.criaAjuda;

import java.util.Scanner;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.Item;
import regiao.CatalogoRegioes;

public class CriaAjuda {
	
	private CatalogoRegioes catR;
	private Ajuda ajuda;
	
	public CriaAjuda(String itemDesc,CatalogoRegioes cat) {
		this.catR = cat;
		this.ajuda = new Item(itemDesc);
	}
	
	public CriaAjuda(int numMax,CatalogoRegioes cat) {
		this.catR = cat;
		Scanner sc = new Scanner(System.in);
		System.out.print("Escolha uma região das seguintes apresentadas:");
		System.out.println(catR.toString());
		this.ajuda = new Alojamento(numMax,catR.getRegiao(sc.next()));
	}
	
	public Ajuda getAjuda() {
		return ajuda;
	}

}
