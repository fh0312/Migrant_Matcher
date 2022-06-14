package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Main.MigrantMatcher;
import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import ajuda.sms.EnviadoresSMS;
import pedido_ajuda.PedidoAjuda;
import regiao.CatalogoRegioes;
import regiao.Regiao;
import utilizador.Familiar;
import utilizador.Migrante;
import utilizador.Voluntario;

class Tests {
	private String nomeMigrante1 = "Manel";
	private int telMigrante1 = 938933680;
	
//	@Test
//	void testRegioes() {
//		Regiao r1 = new Regiao("Viseu");
//		Regiao r2 = new Regiao("Lisboa");
//		CatalogoRegioes catR = new CatalogoRegioes();
//		catR.adicionaRegiao(r1);
//		catR.adicionaRegiao(r2);
//		for(Regiao r : catR.getRegioes()) {
//			System.out.println(r.getNome());
//		}
//		System.out.println("Regiao r2 = "+catR.getRegiao(r2).getNome());
//		assertEquals(catR.getRegiao(r1), r1);
//		assertEquals(catR.getRegiao(r2), r2);
//	}
//	
//	@Test
//	void testAjudas() {
//		Regiao viseu = new Regiao("Viseu");
//		Regiao lisboa = new Regiao("Lisboa");
//		Ajuda aloj1 = new Alojamento(4, viseu );
//		Ajuda aloj2 = new Alojamento(2, viseu );
//		Ajuda aloj3 = new Alojamento(4, lisboa );
//		Ajuda aloj4 = new Alojamento(3, lisboa );
//		Ajuda aloj5 = new Alojamento(4, viseu );
//		Ajuda item1 = new Item("brinquedo");
//		Ajuda item2 = new Item("manta");
//		Ajuda item3 = new Item("peluche");
//		
//		CatalogoAjudas catA = new CatalogoAjudas();
//		catA.adicionaAjuda(aloj1);
//		catA.adicionaAjuda(aloj2);
//		catA.adicionaAjuda(aloj3);
//		catA.adicionaAjuda(aloj4);
//		catA.adicionaAjuda(aloj5);
//		catA.adicionaAjuda(item1);
//		catA.adicionaAjuda(item2);
//		catA.adicionaAjuda(item3);
//
//		for(Ajuda a : catA.getAjudas()) {
//			System.out.println(a.getNome());
//		}
//		System.out.println("Ajuda aloj3 = " + catA.getAjuda(aloj3).getNome());
//		assertEquals(catA.getAjuda(aloj1), aloj1);
//		assertEquals(catA.getAjuda(aloj3), aloj3);
//		System.out.println("Removendo ajuda...");
//		catA.removeAjuda(aloj5);
//		for(Ajuda a : catA.getAjudas()) {
//			System.out.println(a.getNome());
//		}
//		System.out.println("Removendo ajuda...");
//		catA.removeAjuda(aloj1);
//		for(Ajuda a : catA.getAjudas()) {
//			System.out.println(a.getNome());
//		}
	
	@Test
	void addAjuda() {
		Voluntario v = new Voluntario(938933680);
		Regiao lisboa = new Regiao("Lisboa");
		Ajuda aloj1 = new Alojamento(4, lisboa, v);
		Ajuda item1 = new Item("brinquedo");
		String[] s = {"Alojamento", "Item"};
		CatalogoAjudas catA = new CatalogoAjudas(s);
		catA.adicionaAjuda(aloj1);
		catA.adicionaAjuda(item1);
		assertEquals(aloj1, catA.getAjuda(aloj1.getNome()));
		assertEquals(item1, catA.getAjuda(item1.getNome()));
	}
	
//	@Test
//	void addVariasAjudas() {
//		
//	}
//	
	
//	@Test
//	void procurarAjuda() {
//		Voluntario v = new Voluntario(938933680);
//		Regiao lisboa = new Regiao("Lisboa");
//		Ajuda aloj1 = new Alojamento(4, lisboa, v);
//		Ajuda item1 = new Item("brinquedo");
//		String[] s = {"Alojamento", "Item"};
//		CatalogoAjudas catA = new CatalogoAjudas(s);
//		catA.adicionaAjuda(aloj1);
//		catA.adicionaAjuda(item1);
//		
//		Migrante m = new Migrante(nomeMigrante1, telMigrante1);
//		PedidoAjuda pa = new PedidoAjuda(catA);
//		System.out.println(pa.getAjudasPedidas());
//		m.adicionaPedido(pa);
//		System.out.println(m.getListaPedidos());
//		
//		
//		assertEquals(true, m.getListaPedidos().contains(catA.getAjuda(aloj1.getNome())));
//		assertEquals(true, m.getListaPedidos().contains(catA.getAjuda(item1.getNome())));
//	}
	
	@Test
	void registarMigrante() {
	
		Migrante migrante = new Migrante(nomeMigrante1, telMigrante1);
		assertEquals(nomeMigrante1, migrante.getNome());
		assertEquals(telMigrante1, migrante.getTel());
	}
	
	@Test
	void registarFamilia() {
		int pessoasNaFamilia = 6;
		Migrante migrante = new Migrante(nomeMigrante1, telMigrante1);
		for(int i = 0; i<pessoasNaFamilia-1; i++) { // pessoasNaFamilia-1 para retirar o cabeça de casal
			Familiar f = new Familiar("Familiar"+i);
			f.setPai(migrante);
			migrante.adicionaFamiliar(f);
			System.out.println(migrante.getListaFamiliares().get(i).getNome());
		}
		for(int i = 0; i<pessoasNaFamilia; i++) {
			if(i == 0)
				assertEquals(nomeMigrante1, migrante.getNome());
			else {
				assertEquals("Familiar" + (i+1), migrante.getListaFamiliares().get(i).getNome());
				System.out.println(migrante.getListaFamiliares().get(i).getNome());
			}
		}
	}
//	
//	@Test
//	void registarProcurar() {
//		
//	}
//	
//	@Test
//	void registarVoluntarioOp() {
//		
//	}
	
}




