package ajuda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import regiao.Regiao;

public class CatalogoAjudas {
private HashMap<String,List<Ajuda>> ajudasDisponiveis;
private String[] tiposDeAjuda ;
	
	public CatalogoAjudas(String[] strings) {
		this.tiposDeAjuda = strings;
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
	
	public List<String> getTiposAjuda(){
		return Arrays.asList(this.tiposDeAjuda);
	}

	public void imprimeAjudas(String ordem) {
		List<Ajuda> list = new ArrayList<Ajuda>();
		for(Ajuda a : getAjudas()) {
			list.add(a);
		}
		if(ordem.toLowerCase().contains("data"))
			list = getAjudasPorData(list);
		else if(ordem.toLowerCase().contains("tipo"))
			list = getAjudasPorTipo(new ArrayList<>());
		System.out.println("Lista de Ajudas Disponiveis:");
		for(Ajuda a : list) {
			System.out.println(a.getNome().toUpperCase());
			}
		}

	private List<Ajuda> getAjudasPorData(List<Ajuda> list) {
		list.sort((x,y) -> x.getDataCriacao().compareTo(y.getDataCriacao()));
		return list;
	}

	private List<Ajuda> getAjudasPorTipo(List<Ajuda> list) {
		Collections.shuffle(list);
		for(Ajuda a : getAjudasEspecificas(x -> x.tipoAjuda.equals("Alojamento"))) {
			list.add(a);
		}
		for(Ajuda a : getAjudasEspecificas(x -> x.tipoAjuda.equals("Item"))) {
			list.add(a);
		}
		return list;
	}

		
}
