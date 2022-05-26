package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import utilizador.Migrante;

class Tests {

	@Test
	void testPass() {
		Migrante m1 = new Migrante("Antonio",112);
		Migrante m2 = new Migrante (4);
		assertEquals("Antonio",m1.getName());
		assertEquals(112,m1.getTel());
//		assertEquals("Joao",m2.getName());
//		assertEquals(111,m2.getTel());
	}


}
