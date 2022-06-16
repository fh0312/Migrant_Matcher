package com.projeto2.sistema.observer;

import com.projeto2.sistema.ajuda.CatalogoAjudas;
import com.projeto2.sistema.regiao.Regiao;
import com.projeto2.sistema.utilizador.Migrante;

public class ObservaAjudas implements Observer {
	
	private Regiao regiao;
	private Migrante migrante;
	
	public ObservaAjudas(Migrante m, Regiao r) {
		this.migrante = m;
		this.regiao = r;
	}

	@Override
	public void atualiza(CatalogoAjudas catAjudas) {
		if(catAjudas.getAjudasPorRegiao(regiao)!=null) {
			catAjudas.getPluginsSms().get(0).send("Nova ajuda registada na regiao: "+
					regiao.getNome(), String.valueOf(migrante.getTel()));
		}
	}

}
