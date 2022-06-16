package com.projeto2.sistema.utilizador;

public class Familiar extends Migrante{
	
	private Migrante cabeca ;
	
	/**
	 * Construtor de Familiar, recebo o nome do Familiar para o registar no sistema
	 * @param nome o nome do familiar
	 */
	public Familiar(String nome) {
		super(nome,0);
	}
	
	/**
	 * Define o cabeca de casal do Familiar
	 * @param cabeca o cabeca de casal do Familiar
	 */
	public void setCabeca(Migrante cabeca) {
		this.cabeca = cabeca;
	}
	
	/**
	 * Devolve o cabeca de casal do Familiar	 
	 * @return o cabeca de casal do Familiar
	 */
	public Migrante getCabeca() {
		return cabeca;
	}
	

}
