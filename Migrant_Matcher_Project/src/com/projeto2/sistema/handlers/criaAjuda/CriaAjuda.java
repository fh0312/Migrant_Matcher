package com.projeto2.sistema.handlers.criaAjuda;

import com.projeto2.sistema.ajuda.Ajuda;
import com.projeto2.sistema.ajuda.Alojamento;
import com.projeto2.sistema.ajuda.Item;
import com.projeto2.sistema.regiao.Regiao;
import com.projeto2.sistema.utilizador.Voluntario;

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
