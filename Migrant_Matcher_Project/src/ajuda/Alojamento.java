package ajuda;

import regiao.Regiao;

public class Alojamento extends Ajuda {
	
	private int maxPessoas;
	
	public Alojamento(int numPessoas, Regiao regiao) {
		super(regiao);
		this.maxPessoas = numPessoas;
	}
	public Regiao getRegiao() {
		return this.regiao;
	}
	
	public int getMaxPessoas() {
		return this.maxPessoas;
	}
	
	public String getNome() {
		return ("Alojamento_" + this.regiao.getNome() + maxPessoas);
	}

}
