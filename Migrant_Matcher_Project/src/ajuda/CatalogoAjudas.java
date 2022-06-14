package ajuda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ajuda.strategies.OrdenaPorDataStrategy;
import ajuda.strategies.OrdenaPorTipoStrategy;
import regiao.Regiao;

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
	
	public Ajuda getAjuda(String ajuda) {
		return this.ajudasDisponiveis.get(ajuda).get(0);
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

	public List<Ajuda> getAjudasPorRegiao(Regiao r){
		Stream<Ajuda> stream = this.getAjudas().stream()
				.filter(a -> a.getClass().equals(Alojamento.class) && (a.regiao).equals(r));
		return (List<Ajuda>) stream.collect(Collectors.toList());
	}
	/*
	 * Obtem uma lista de ajudas especificas filtrando de acordo com o predicado indicado
	 */
	public List<Ajuda> getAjudasEspecificas(Predicate<? super Ajuda> p) {
		Stream<Ajuda> stream = this.getAjudas().stream()
				.filter(p);
		return (List<Ajuda>) stream.collect(Collectors.toList());
	}
	

	public List<Ajuda> getAjudasPorOrdem(String ordem) {
		if(ordem.toLowerCase().contains("data"))
			return new OrdenaPorDataStrategy().ordena(this);
		
		else if(ordem.toLowerCase().contains("tipo"))
			return new OrdenaPorTipoStrategy().ordena(this);
		
		return Arrays.asList();
	}
	
	public String imprimeAjudasPorOrdem(List<Ajuda> list) {
		StringBuilder result = new StringBuilder();
		result.append("\nLista de Ajudas Disponiveis:\n");
		int count = 0;
		for(Ajuda a : list) {
			result.append(count+" - "+a.toString().toUpperCase()+"\n");
			count++;
			}
		return result.toString();
	}

	public String[] getTiposAjuda() {
		String[] tipos = {"Alojamento","Item"};
		return tipos;
	}

		
}
