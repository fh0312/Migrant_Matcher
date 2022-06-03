package ajuda;

import regiao.Regiao;

public abstract class Ajuda {
	
	protected Regiao regiao ;
	protected String tipoAjuda;
	
	public Ajuda(Regiao r) {
		this.regiao = r;
	}
	
	public Ajuda() {
	}
	
	public abstract String getNome();

	public String getTipoAjuda() {
		return this.tipoAjuda;
	}
	

}
