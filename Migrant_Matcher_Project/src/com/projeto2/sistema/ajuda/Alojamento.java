package com.projeto2.sistema.ajuda;

import com.projeto2.sistema.regiao.Regiao;
import com.projeto2.sistema.utilizador.Voluntario;

public class Alojamento extends Ajuda {
	
	private int maxPessoas;
	
	public Alojamento(int numPessoas, Regiao regiao, Voluntario v) {
		super(regiao,v);
		this.tipoAjuda="Alojamento";
		this.maxPessoas = numPessoas;
	}
	public Regiao getRegiao() {
		return this.regiao;
	}
	
	public int getMaxPessoas() {
		return this.maxPessoas;
	}
	
	public String getNome() {
		return ("Alojamento_" + this.regiao.getNome().toUpperCase() + "_" + maxPessoas);
	}
	@Override
	public String toString() {
		return ("Alojamento para " + maxPessoas + " pessoas na região de " + this.regiao.getNome().toUpperCase());
	}
}
