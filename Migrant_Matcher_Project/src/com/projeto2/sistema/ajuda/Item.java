package com.projeto2.sistema.ajuda;

import com.projeto2.sistema.utilizador.Voluntario;

public class Item extends Ajuda{

	private String itemDesc;

	public Item(String itemDesc,Voluntario v) {
		super(v);
		this.tipoAjuda = "Item";
		this.itemDesc = itemDesc;
	}
	
	public String getNome() {
		return this.itemDesc;
	}
	
	@Override
	public String toString() {
		return "Item: " + itemDesc;
		
	}
}
