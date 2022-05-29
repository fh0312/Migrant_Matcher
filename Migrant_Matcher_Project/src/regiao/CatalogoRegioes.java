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
		this.regioesDisponiveis.put(r.getNome(), r);
	}
	
	public void removeRegiao(Regiao r) {
		this.regioesDisponiveis.remove(r.getNome());
	}
	
	public Regiao getRegiao(Regiao r) {
		return this.regioesDisponiveis.get(r.getNome());
	}
	public List<Regiao> getRegioes(){
		return new ArrayList<>(this.regioesDisponiveis.values());
	}

}
