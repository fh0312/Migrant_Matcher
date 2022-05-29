package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import regiao.CatalogoRegioes;
import regiao.Regiao;

class Tests {

	@Test
	void testRegioes() {
		Regiao r1 = new Regiao("Viseu");
		Regiao r2 = new Regiao("Lisboa");
		CatalogoRegioes catR = new CatalogoRegioes();
		catR.adicionaRegiao(r1);
		catR.adicionaRegiao(r2);
		for(Regiao r : catR.getRegioes()) {
			System.out.println(r.getNome());
		}
		System.out.println("Regiao r2 = "+catR.getRegiao(r2).getNome());
		assertEquals(catR.getRegiao(r1), r1);
		assertEquals(catR.getRegiao(r2), r2);
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

		for(Ajuda a : catA.getAjudas()) {
			System.out.println(a.getNome());
		}
		System.out.println("Ajuda aloj3 = " + catA.getAjuda(aloj3).getNome());
		assertEquals(catA.getAjuda(aloj1), aloj1);
		assertEquals(catA.getAjuda(aloj3), aloj3);
		System.out.println("Removendo ajuda...");
		catA.removeAjuda(aloj5);
		for(Ajuda a : catA.getAjudas()) {
			System.out.println(a.getNome());
		}
		System.out.println("Removendo ajuda...");
		catA.removeAjuda(aloj1);
		for(Ajuda a : catA.getAjudas()) {
			System.out.println(a.getNome());
		}
		
	}



}
