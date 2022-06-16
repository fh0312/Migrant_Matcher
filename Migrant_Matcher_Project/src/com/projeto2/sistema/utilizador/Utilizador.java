package com.projeto2.sistema.utilizador;

public abstract class Utilizador {
	protected int tel;
	
	/**
	 * Construtor de Utilizador, recebe o numero de telemovel do Utilizador para o registar no sistema
	 * @param tel o numero de telemovel do Utilizador
	 */
	public Utilizador(int tel) {
		this.tel = tel;
	}
	/**
	 * @return o numero de telemovel do Utilizador
	 */
	public int getTel() {
		return this.tel; 
	}
}
