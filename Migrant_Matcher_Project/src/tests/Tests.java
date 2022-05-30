package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import handlers.AdcionarAjudaHandler;
import handlers.criaAjuda.CriaAjuda;
import regiao.CatalogoRegioes;
import regiao.Regiao;

class Tests {
	
	

	//@Test
	void testRegioes() {
		Regiao r1 = new Regiao("Viseu");
		Regiao r2 = new Regiao("Lisboa");
		CatalogoRegioes catR = new CatalogoRegioes();
		catR.adicionaRegiao(r1);
		catR.adicionaRegiao(r2);
		for(Regiao r : catR.getRegioes()) {
			System.out.println(r.getNome());
		}
	}
	
	@Test
	void testAjudas() {
		Regiao viseu = new Regiao("Viseu");
		Regiao lisboa = new Regiao("Lisboa");
		Ajuda aloj1 = new Alojamento(4, viseu );
		Ajuda aloj2 = new Alojamento(2, viseu );
		Ajuda aloj3 = new Alojamento(4, lisboa );
		Ajuda aloj4 = new Alojamento(3, lisboa );
		Ajuda aloj5 = new Alojamento(4, viseu );
		Ajuda item1 = new Item("brinquedo");
		Ajuda item2 = new Item("manta");
		Ajuda item3 = new Item("peluche");
		
		CatalogoAjudas catA = new CatalogoAjudas();
		catA.adicionaAjuda(aloj1);
		catA.adicionaAjuda(aloj2);
		catA.adicionaAjuda(aloj3);
		catA.adicionaAjuda(aloj4);
		catA.adicionaAjuda(aloj5);
		catA.adicionaAjuda(item1);
		catA.adicionaAjuda(item2);
		catA.adicionaAjuda(item3);
//		System.out.println("itens:");
//		for(Ajuda a : catA.getAjudasEspecificas(a -> a.getClass().equals(Item.class))) {
//			System.out.println(a.getNome());
//		}
//		System.out.println("regiao viseu :");
//		for(Ajuda a : catA.getAjudasPorRegiao(viseu)) {
//			System.out.println(a.getNome());
//		}
		
		AdcionarAjudaHandler aah = new AdcionarAjudaHandler();
		System.out.println(aah.cA.getAjuda().getNome());
	}
		
	//@Test
	public void testCriaAjuda() {
		CatalogoRegioes catR = new CatalogoRegioes();
		List<String> list = Arrays.asList("Lisboa","Porto","Braga","Setúbal","Beja","Evora");
		for(String r : list) {
			catR.adicionaRegiao(new Regiao(r));
		}
		CriaAjuda cAjuda = new CriaAjuda("brinquedo",catR);
		CriaAjuda cAjuda2 = new CriaAjuda(3,catR);
		assertEquals("true","true");

	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
