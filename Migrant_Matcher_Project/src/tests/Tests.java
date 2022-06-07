package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

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
		
	}
		
	//@Test
	public void testCriaAjuda() {
		CatalogoRegioes catR = new CatalogoRegioes();
		List<String> list = Arrays.asList("Lisboa","Porto","Braga","Set�bal","Beja","Evora");
		for(String r : list) {
			catR.adicionaRegiao(new Regiao(r));
		}
		//CriaAjuda cAjuda = new CriaAjuda("brinquedo",catR);
		//CriaAjuda cAjuda2 = new CriaAjuda(3,catR);
		assertEquals("true","true");

	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
