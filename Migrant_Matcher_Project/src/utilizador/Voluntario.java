package utilizador;

import java.util.ArrayList;
import java.util.List;

import ajuda.Ajuda;

public class Voluntario extends Utilizador {
	
	private List<Ajuda> listaAjudasDadas;
	
	public Voluntario(int tel) {
		super(tel);
		listaAjudasDadas = new ArrayList<>();
	}
	
	public void addAjuda(Ajuda a) {
		this.listaAjudasDadas.add(a);
	}
	
	public List<Ajuda> getAjudasDadas(){
		return this.listaAjudasDadas;
	}

}
