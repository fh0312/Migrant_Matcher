package com.projeto2.sistema.ajuda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.projeto2.sistema.ajuda.sms.EnviadoresSMS;
import com.projeto2.sistema.ajuda.strategies.OrdenaPorDataStrategy;
import com.projeto2.sistema.ajuda.strategies.OrdenaPorTipoStrategy;
import com.projeto2.sistema.observer.Observable;
import com.projeto2.sistema.observer.Observer;
import com.projeto2.sistema.regiao.Regiao;

public class CatalogoAjudas implements Observable {
	
	private HashMap<String,List<Ajuda>> ajudasDisponiveis;
	private List<Observer> observers; 
	private List<EnviadoresSMS> pluginsSms;
	
	public CatalogoAjudas(List<EnviadoresSMS> plugins) {
		this.pluginsSms = plugins;
		this.ajudasDisponiveis = new HashMap<>();
		this.observers = new ArrayList<>();
	}
	
	public void adicionaAjuda(Ajuda a) {
		if(this.ajudasDisponiveis.get(a.getNome())==null) { // nao tem nenhuma ajuda com "x" nome
			this.ajudasDisponiveis.put(a.getNome(),new ArrayList<Ajuda>());
		}
		this.ajudasDisponiveis.get(a.getNome()).add(a);
		this.notificaObservers();
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


	/*
	 * Obtem uma lista de ajudas especificas filtrando de acordo com o predicado indicado
	 */
	public List<Ajuda> getAjudasEspecificas(Predicate<? super Ajuda> p) {
		Stream<Ajuda> stream = this.getAjudas().stream()
				.filter(p);
		return (List<Ajuda>) stream.collect(Collectors.toList());
	}
	

	public List<Ajuda> getAjudasPorOrdem(String ordem,Regiao r) {
		if(ordem.toLowerCase().contains("data"))
			return new OrdenaPorDataStrategy().ordena(this.getAjudasPorRegiao(r));
		
		else if(ordem.toLowerCase().contains("tipo"))
			return new OrdenaPorTipoStrategy().ordena(this.getAjudasPorRegiao(r));
		
		return null;
	}
	
	public List<Ajuda> getAjudasPorRegiao(Regiao r){
		Stream<Ajuda> stream = this.getAjudas().stream()
				.filter(a -> a.getClass().equals(Item.class) || (a.getClass().equals(Alojamento.class) && (a.regiao).equals(r) ));
		return (List<Ajuda>) stream.collect(Collectors.toList());
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

	@Override
	public void registaObserver(Observer obs) {
		if(obs != null)
			this.observers.add(obs);
	}

	@Override
	public void notificaObservers() {
		for(Observer obs : this.observers) {
			obs.atualiza(this);
		}
	}

	@Override
	public void removeObserver(Observer obs) {
		if(obs != null)
			this.observers.remove(obs);
	}

	/**
	 * @return the pluginsSms
	 */
	public List<EnviadoresSMS> getPluginsSms() {
		return pluginsSms;
	}

		
}
