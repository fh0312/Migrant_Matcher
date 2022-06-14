package ajuda.strategies;

import java.util.ArrayList;
import java.util.List;

import ajuda.Ajuda;

public class OrdenaPorTipoStrategy implements OrdenaAjudas {


	public OrdenaPorTipoStrategy() {}

	@Override
	public List<Ajuda> ordena(List<Ajuda> listAjudas) {
		List<Ajuda> newList = new ArrayList<>();
		for(Ajuda a : listAjudas) {
			if(a.getTipoAjuda().equals("Alojamento"))
				newList.add(a);
		}
		for(Ajuda a : listAjudas) {
			if(a.getTipoAjuda().equals("Item"))
				newList.add(a);
		}
		return newList;
	}

}
