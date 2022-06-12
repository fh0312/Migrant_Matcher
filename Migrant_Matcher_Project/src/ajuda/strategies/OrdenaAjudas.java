package ajuda.strategies;

import java.util.List;

import ajuda.Ajuda;
import ajuda.CatalogoAjudas;

public interface OrdenaAjudas {
	public List<Ajuda> ordena(CatalogoAjudas cat);
}
