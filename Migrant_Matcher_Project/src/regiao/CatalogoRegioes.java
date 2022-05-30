package regiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogoRegioes {
	
	private HashMap<String,Regiao> regioesDisponiveis;
	
	public CatalogoRegioes() {
		this.regioesDisponiveis = new HashMap<>();
	}
	
	public void adicionaRegiao(Regiao r) {
		this.regioesDisponiveis.put(r.getNome().toLowerCase(), r);
	}
	
	public void removeRegiao(Regiao r) {
		this.regioesDisponiveis.remove(r.getNome().toLowerCase());
	}
	
	public Regiao getRegiao(String nome) {
		return this.regioesDisponiveis.get(nome);
	}
	public List<Regiao> getRegioes(){
		return new ArrayList<>(this.regioesDisponiveis.values());
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nLista de regioes disponiveis:\n");
		for(Regiao r : this.getRegioes()) {
			result.append("\t" + r.toString() + "\n");
		}
		return result.toString();
	}
}
