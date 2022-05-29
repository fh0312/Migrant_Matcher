package regiao;

import java.util.ArrayList;
import java.util.List;

import ajuda.Ajuda;

public class Regiao {
	
	private String nome; //nome da regiao
	private List<Ajuda> listaAjudas; //lista de ajudas nesta regiao
	
	
	public Regiao(String nome) {
		this.nome = nome;
		this.listaAjudas= new ArrayList<Ajuda>();
	}
	
	public void adicionaAjuda(Ajuda ajuda) {
		this.listaAjudas.add(ajuda);
	}
	public void retiraAjuda(Ajuda ajuda) {
		this.listaAjudas.remove(ajuda);
	}
	
	public List<Ajuda> getListaAjudas(){
		return this.listaAjudas;
	}
	
	public String getNome() {
		return this.nome;
	}

}
