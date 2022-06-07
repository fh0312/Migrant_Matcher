package regiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogoRegioes {
	
	private HashMap<String,Regiao> regioesDisponiveis;
	
	public CatalogoRegioes() {
		this.regioesDisponiveis = new HashMap<>();
		String regioes = "lisboa,porto,setubal,braga,aveiro,faro,leiria,santarem,"
				+ "coimbra,viseu,madeira,açores";
		for(String s : regioes.split(",")) {
			adicionaRegiao(new Regiao(s));
		}
	}
	
	public void adicionaRegiao(Regiao r) {
		this.regioesDisponiveis.put(r.getNome().toLowerCase(), r);
	}
	
	public void removeRegiao(Regiao r) {
		this.regioesDisponiveis.remove(r.getNome().toLowerCase());
	}
	
	public Regiao getRegiao(String nome) {
		return this.regioesDisponiveis.get(nome.toLowerCase());
	}
	public List<Regiao> getRegioes(){
		return new ArrayList<>(this.regioesDisponiveis.values());
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Regiao r : this.getRegioes()) {
			result.append("\t" + r.toString() + "\n");
		}
		return result.toString();
	}
}
