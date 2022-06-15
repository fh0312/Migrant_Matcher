package regiao;

import java.util.ArrayList;
import java.util.List;

import ajuda.Ajuda;

public class Regiao {
	
	private String nome; //nome da regiao
	private List<Ajuda> listaAjudas; //lista de ajudas nesta regiao
	
	
	/**
	 * Construtor de Regiao, recebe o nome de uma Regiao para a registar no sistema
	 * @param nome o nome de uma Regiao
	 */
	public Regiao(String nome) {
		this.nome = nome;
		this.listaAjudas= new ArrayList<Ajuda>();
	}
	
	/**
	 * Adiciona uma Ajuda às Ajudas da Regiao
	 * @param ajuda uma Ajuda
	 */
	public void adicionaAjuda(Ajuda ajuda) {
		this.listaAjudas.add(ajuda);
	}
	/**
	 * Retira uma Ajuda das Ajudas da Regiao
	 * @param ajuda uma Ajuda
	 */
	public void retiraAjuda(Ajuda ajuda) {
		this.listaAjudas.remove(ajuda);
	}
	
	/**
	 * Devolve a lista de Ajudas da Regiao
	 * @return a lista de Ajudas da Regiao
	 */
	public List<Ajuda> getListaAjudas(){
		return this.listaAjudas;
	}
	
	/**
	 * Devolve o nome da Regiao
	 * @return o nome da Regiao
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Passa para String o nome da Regiao
	 */
	@Override
	public String toString() {
		return nome.toUpperCase();
		
	}
}
