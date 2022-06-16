package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import ajuda.Ajuda;
import ajuda.Alojamento;
import ajuda.CatalogoAjudas;
import ajuda.Item;
import handlers.RegistaMigranteHandler;
import pedido_ajuda.PedidoAjuda;
import regiao.CatalogoRegioes;
import regiao.Regiao;
import utilizador.Migrante;
import utilizador.Voluntario;

class Tests {
	private String nomeMigrante1 = "Manel";
	private int telMigrante1 = 938933680;
	private int telVoluntario = 123456789;
	
	@Test
	void testRegioes() {
		Regiao r1 = new Regiao("Madrid");
		Regiao r2 = new Regiao("Paris");
		CatalogoRegioes catR = new CatalogoRegioes();
		catR.adicionaRegiao(r1);
		catR.adicionaRegiao(r2);
		assertEquals(r1, catR.getRegiao(r1.getNome()));
		assertEquals(r2, catR.getRegiao(r2.getNome()));
	}
	
	@Test
	void addAjuda() {
		Voluntario v = new Voluntario(telVoluntario);
		Regiao lisboa = new Regiao("Lisboa");
		Ajuda aloj1 = new Alojamento(4, lisboa, v);
		Ajuda item1 = new Item("brinquedo",v);
		CatalogoAjudas catA = new CatalogoAjudas(null);
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
		Ajuda item1 = new Item("brinquedo1",v);
		Ajuda item2 = new Item("brinquedo2",v);
		Ajuda item3 = new Item("brinquedo3",v);
		CatalogoAjudas catA = new CatalogoAjudas(null);
		Migrante migrante = new Migrante(nomeMigrante1, telMigrante1);
		
		catA.adicionaAjuda(aloj1);
		catA.adicionaAjuda(aloj2);
		catA.adicionaAjuda(aloj3);
		catA.adicionaAjuda(item1);
		catA.adicionaAjuda(item2);
		catA.adicionaAjuda(item3);
		
		List<Ajuda> lista = catA.getAjudas();
		
		migrante.setPaCorrente(new PedidoAjuda(catA));
		migrante.getPaCorrente().adicionaAjuda(lista.get(1));
		migrante.getPaCorrente().adicionaAjuda(lista.get(3));
		migrante.getPaCorrente().adicionaAjuda(lista.get(5));
		migrante.getPaCorrente().confirmaPedido();
		migrante.adicionaPedido(migrante.getPaCorrente());
		
		List<Ajuda> listAjudas = migrante.getListaPedidos().get(0).getAjudasPedidas();
		
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
	
	@Test
	void listaRegioes() {
		String[] lista = {"lisboa","porto","setubal","braga","aveiro","faro", "leiria","santarem","coimbra","viseu","madeira","acores"};
		List<String> lista_de_testes = new ArrayList<>();
		for(String s: lista) {
			lista_de_testes.add(s);
		}
		
		CatalogoRegioes catR = new CatalogoRegioes();
		List<String> lista_do_catalogo = new ArrayList<>();
		for(Regiao r: catR.getRegioes()) {
			lista_do_catalogo.add(r.getNome());
		}
		
		Collections.sort(lista_de_testes);
		Collections.sort(lista_do_catalogo);
		
		for(int i = 0; i < lista_do_catalogo.size(); i++) {
			assertEquals(lista_de_testes.get(i), lista_do_catalogo.get(i));
		}
	} 
	
}




