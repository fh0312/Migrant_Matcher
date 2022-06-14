package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.MigrantMatcher;
import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import ajuda.sms.EnviadoresSMS;
import handlers.RegistaMigranteHandler;
import pedido_ajuda.PedidoAjuda;
import regiao.CatalogoRegioes;
import regiao.Regiao;
import utilizador.Familiar;
import utilizador.Migrante;
import utilizador.Voluntario;

class Tests {
	private String nomeMigrante1 = "Manel";
	private int telMigrante1 = 938933680;
	private int telVoluntario = 123456789;
	
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
		Voluntario v = new Voluntario(telVoluntario);
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
	
	
	@Test
	void procurarAjuda() {
		Voluntario v = new Voluntario(telVoluntario);
		Regiao lisboa = new Regiao("Lisboa");
		Ajuda aloj1 = new Alojamento(4, lisboa, v);
		Ajuda aloj2 = new Alojamento(5, lisboa, v);
		Ajuda aloj3 = new Alojamento(6, lisboa, v);
		Ajuda item1 = new Item("brinquedo1");
		Ajuda item2 = new Item("brinquedo2");
		Ajuda item3 = new Item("brinquedo3");
		String[] s = {"Alojamento", "Item"};
		CatalogoAjudas catA = new CatalogoAjudas(s);
		Migrante migrante = new Migrante(nomeMigrante1, telMigrante1);
		
		catA.adicionaAjuda(aloj1);
		catA.adicionaAjuda(aloj2);
		catA.adicionaAjuda(aloj3);
		catA.adicionaAjuda(item1);
		catA.adicionaAjuda(item2);
		catA.adicionaAjuda(item3);
		
		List<Ajuda> lista = catA.getAjudas();
		for(Ajuda a: lista) {
		System.out.println(a.getNome());
		}
		
		migrante.setPaCorrente(new PedidoAjuda(catA));
		migrante.getPaCorrente().adicionaAjuda(lista.get(1));
		migrante.getPaCorrente().adicionaAjuda(lista.get(3));
		migrante.getPaCorrente().adicionaAjuda(lista.get(5));
		migrante.getPaCorrente().confirmaPedido();
		migrante.adicionaPedido(migrante.getPaCorrente());
		
		List<Ajuda> listAjudas = migrante.getListaPedidos().get(0).getAjudasPedidas();
		for(Ajuda a: listAjudas) {System.out.println();
			System.out.println(a.getNome());
			}
		
		assertEquals(3, catA.getAjudas().size()); // confirmar que as ajudas pedidas foram retiradas do catálogo
		assertEquals("Alojamento_LISBOA_5", listAjudas.get(0).getNome());
		assertEquals("brinquedo2", listAjudas.get(1).getNome());
		assertEquals("brinquedo3", listAjudas.get(2).getNome());
	}
	
	@Test
	void registarMigrante() {
	
		Migrante migrante = new Migrante(nomeMigrante1, telMigrante1);
		assertEquals(nomeMigrante1, migrante.getNome());
		assertEquals(telMigrante1, migrante.getTel());
	}
	
	@Test
	void registarFamilia() {
		int pessoasNaFamilia = 6;
		RegistaMigranteHandler handler = new RegistaMigranteHandler(null);
		handler.registaCabecaCasal(nomeMigrante1, pessoasNaFamilia);
		List<String> familia = new ArrayList<>();
		for(int i = 1; i<=pessoasNaFamilia; i++) {
			familia.add("Familiar"+i);
		}
		handler.adicionaFamiliares(familia);
		for(int i = 0; i<pessoasNaFamilia; i++) {
			if(i == 0)
				assertEquals(nomeMigrante1, handler.getMigrante().getNome());
			else {
				assertEquals("Familiar" + (i), handler.getMigrante().getListaFamiliares().get(i-1).getNome());
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




