package observer;

import ajuda.CatalogoAjudas;
import regiao.Regiao;
import utilizador.Migrante;

public class ObservaAjudas implements Observer {
	
	private Regiao regiao;
	private Migrante migrante;
	
	public ObservaAjudas(Migrante m, Regiao r) {
		this.migrante = m;
		this.regiao = r;
	}

	@Override
	public void atualiza(CatalogoAjudas catAjudas) {
		if(catAjudas.getAjudasPorRegiao(regiao)!=null) {
			catAjudas.getPluginsSms().get(0).send("Nova ajuda registada na regiao: "+
					regiao.getNome(), String.valueOf(migrante.getTel()));
		}
	}

}
