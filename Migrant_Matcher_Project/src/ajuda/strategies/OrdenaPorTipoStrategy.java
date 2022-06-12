package ajuda.strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ajuda.Ajuda;
import ajuda.CatalogoAjudas;

public class OrdenaPorTipoStrategy implements OrdenaAjudas {


	public OrdenaPorTipoStrategy() {
	}

	@Override
	public List<Ajuda> ordena(CatalogoAjudas catAjudas) {
		List<Ajuda> list = new ArrayList<>();
		for(Ajuda a : catAjudas.getAjudasEspecificas(x -> x.getTipoAjuda().equals("Alojamento"))) {
			list.add(a);
		}
		for(Ajuda a : catAjudas.getAjudasEspecificas(x -> x.getTipoAjuda().equals("Item"))) {
			list.add(a);
		}
		return list;
	}

}
