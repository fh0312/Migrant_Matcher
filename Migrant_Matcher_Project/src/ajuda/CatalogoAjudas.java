package ajuda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogoAjudas {
	
	private HashMap<String,List<Ajuda>> ajudasDisponiveis;
	
	public CatalogoAjudas() {
		this.ajudasDisponiveis = new HashMap<>();
	}
	
	public void adicionaAjuda(Ajuda a) {
		if(this.ajudasDisponiveis.get(a.getNome())==null) { // nao tem nenhuma ajuda com "x" nome
			this.ajudasDisponiveis.put(a.getNome(),new ArrayList<Ajuda>());
		}
		this.ajudasDisponiveis.get(a.getNome()).add(a);
	}
	
	public void removeAjuda(Ajuda a) {
		if(this.ajudasDisponiveis.get(a.getNome())!=null) { // se existe entao...
			this.ajudasDisponiveis.get(a.getNome()).remove(a);
		}
	}
	
	public Ajuda getAjuda(Ajuda a) {
		return this.ajudasDisponiveis.get(a.getNome()).get(0);
	}
	public List<Ajuda> getAjudas(){
		List<Ajuda> ajudas = new ArrayList<>();
		for(List<Ajuda> listA : this.ajudasDisponiveis.values() ) {
			if(!listA.isEmpty()) {
				ajudas.add(listA.get(0));
			}
		}
		return ajudas;
	}

}
