package com.projeto2.sistema.utilizador;

import java.util.ArrayList;
import java.util.List;

import com.projeto2.sistema.ajuda.Ajuda;

public class Voluntario extends Utilizador {
	
	private List<Ajuda> listaAjudasDadas;
	
	/**
	 * Construtor de Voluntario, recebe o numero de telemovel do Voluntario para o registar no sistema
	 * @param tel o numero de telemovel do Voluntario
	 */
	public Voluntario(int tel) {
		super(tel);
		listaAjudasDadas = new ArrayList<>();
	}
	
	/**
	 * @param a uma Ajuda
	 */
	public void addAjuda(Ajuda a) {
		this.listaAjudasDadas.add(a);
	}
	
	/**
	 * @return a lista com as Ajudas que o Voluntario ja deu
	 */
	public List<Ajuda> getAjudasDadas(){
		return this.listaAjudasDadas;
	}

}
