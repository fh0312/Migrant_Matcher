package com.projeto2.sistema.pedido_ajuda;

import java.util.ArrayList;
import java.util.List;

import com.projeto2.sistema.ajuda.Ajuda;
import com.projeto2.sistema.ajuda.CatalogoAjudas;

public class PedidoAjuda {
	
	List<Ajuda> ajudasPedidas;
	CatalogoAjudas catAjudas;
	
	/**
	 * Construtor de PedidoAjuda, regista no sistema um Catalogo de Ajudas
	 * @param catA um Catalago de Ajudas
	 */
	public PedidoAjuda(CatalogoAjudas catA) {
		this.catAjudas=catA;
		this.ajudasPedidas = new ArrayList<Ajuda>();
	}
	
	/**
	 * Adiciona uma Ajuda ao Catalago
	 * @param a uma Ajuda
	 */
	public void adicionaAjuda(Ajuda a) {
		this.ajudasPedidas.add(a);
	}
	
	/**
	 * Devolve as Ajudas Pedidas
	 * @return Ajudas Pedidas
	 */
	public List<Ajuda> getAjudasPedidas(){
		return ajudasPedidas;
	}
	
	/**
	 * Confirma as Ajudas pedidas
	 */
	public void confirmaPedido(){
		this.ajudasPedidas.stream()		
			.forEach((a) -> {
				this.catAjudas.removeAjuda(a);
			});
	}
	

}
