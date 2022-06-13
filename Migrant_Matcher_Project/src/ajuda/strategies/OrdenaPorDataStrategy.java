package ajuda.strategies;

import java.util.List;

import ajuda.Ajuda;
import ajuda.CatalogoAjudas;

public class OrdenaPorDataStrategy implements OrdenaAjudas {

	public OrdenaPorDataStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Ajuda> ordena(CatalogoAjudas cat) {
		List<Ajuda> list = cat.getAjudas();
		list.sort((x,y) -> x.getDataCriacao().compareTo(y.getDataCriacao()));
		return list;
	}

}
