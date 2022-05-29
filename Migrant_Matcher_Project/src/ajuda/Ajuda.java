package ajuda;

import regiao.Regiao;

public abstract class Ajuda {
	
	protected Regiao regiao ;
	
	public Ajuda(Regiao r) {
		this.regiao = r;
	}
	
	public Ajuda() {
	}
	
	public abstract String getNome();
	

}
