package com.projeto2.sistema.ajuda.strategies;

import java.util.List;

import com.projeto2.sistema.ajuda.Ajuda;

public class OrdenaPorDataStrategy implements OrdenaAjudas {

	public OrdenaPorDataStrategy() {}

	@Override
	public List<Ajuda> ordena(List<Ajuda> list) {
		list.sort((x,y) -> x.getDataCriacao().compareTo(y.getDataCriacao()));
		return list;
	}

}
