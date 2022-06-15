package regiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogoRegioes {
	
	private HashMap<String,Regiao> regioesDisponiveis;
	
	/**
	 * Construtor de CatalogoRegioes, cria um HashMap para guardar regioes, inicializando este ja com algumas regioes
	 */
	public CatalogoRegioes() {
		this.regioesDisponiveis = new HashMap<>();
		String regioes = "lisboa,porto,setubal,braga,aveiro,faro,leiria,santarem,"
				+ "coimbra,viseu,madeira,acores";
		for(String s : regioes.split(",")) {
			adicionaRegiao(new Regiao(s));
		}
	}
	
	/**
	 * Adiciona uma Regiao ao sistema
	 * @param r uma Regiao
	 */
	public void adicionaRegiao(Regiao r) {
		this.regioesDisponiveis.put(r.getNome().toLowerCase(), r);
	}
	
	/**
	 * Remove uma Regiao do sistema
	 * @param r uma Regiao
	 */
	public void removeRegiao(Regiao r) {
		this.regioesDisponiveis.remove(r.getNome().toLowerCase());
	}
	
	/**
	 * Devolve uma regiao atraves do seu nome
	 * @param nome o nome de uma Regiao
	 * @return uma Regiao
	 */
	public Regiao getRegiao(String nome) {
		return this.regioesDisponiveis.get(nome.toLowerCase());
	}
	/**
	 * Devolve umaa lista com as regioes disponiveis
	 * @return uma lista com as regioes disponiveis
	 */
	public List<Regiao> getRegioes(){
		return new ArrayList<>(this.regioesDisponiveis.values());
	}
	
	/**
	 * Passa para String a lista de Regioes
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Regiao r : this.getRegioes()) {
			result.append("\t" + r.toString() + "\n");
		}
		return result.toString();
	}
}
