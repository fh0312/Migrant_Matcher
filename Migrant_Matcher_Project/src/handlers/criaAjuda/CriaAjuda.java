package handlers.criaAjuda;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.Item;
import regiao.Regiao;
import utilizador.Voluntario;

public class CriaAjuda {
	
	private Ajuda ajuda;
	private Voluntario doador;
	
	public CriaAjuda(String itemDesc,Voluntario v) {
		this.doador = v;
		this.ajuda = new Item(itemDesc,v);
	}
	
	public CriaAjuda(int numMax,Regiao r,Voluntario v) {
		this.doador = v;
		this.ajuda = new Alojamento(numMax,r,v);
	}
	
	public Ajuda getAjuda() {
		return ajuda;
	}
	
	public Voluntario getVoluntario() {
		return this.doador;
	}
}
