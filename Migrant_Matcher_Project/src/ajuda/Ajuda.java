package ajuda;

import java.util.Date;

import regiao.Regiao;

public abstract class Ajuda {
	
	protected Regiao regiao ;
	protected String tipoAjuda;
	private Date dataCriacao;
	
	
	public Ajuda(Regiao r) {
		this.regiao = r;
		this.dataCriacao = new Date();
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Ajuda() {
		this.dataCriacao = new Date();
	}
	
	public abstract String getNome();

	public String getTipoAjuda() {
		return this.tipoAjuda;
	}
	

}
