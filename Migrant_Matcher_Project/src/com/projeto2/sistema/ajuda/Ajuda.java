package com.projeto2.sistema.ajuda;

import java.util.Date;

import com.projeto2.sistema.regiao.Regiao;
import com.projeto2.sistema.utilizador.Voluntario;

public abstract class Ajuda {
	
	protected Regiao regiao ;
	protected String tipoAjuda;
	private Date dataCriacao;
	private Voluntario doador;
	
	
	public Ajuda(Regiao r,Voluntario v) {
		this.regiao = r;
		this.doador = v;
		this.dataCriacao = new Date();
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Ajuda(Voluntario v) {
		this.doador = v;
		this.dataCriacao = new Date();
	}
	
	public abstract String getNome();

	public String getTipoAjuda() {
		return this.tipoAjuda;
	}
	
	public Voluntario getDoador() {
		return this.doador;
	}
	

}
