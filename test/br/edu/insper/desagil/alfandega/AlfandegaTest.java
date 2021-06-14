package br.edu.insper.desagil.alfandega;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlfandegaTest {
	private static double DELTA = 0.01;

	private Alfandega alfandega;

	@BeforeEach
	void setUp() {
		alfandega = new Alfandega();
	}

	@Test
	void testA() {
		alfandega.declaraItem(new Item("a", 25.0, 5.12));
		alfandega.declaraItem(new Item("b", 50.0, 6.19));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(4.38, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testB() {
		alfandega.declaraItem(new Item("a", 50.0, 5.12));
		alfandega.declaraItem(new Item("b", 25.0, 6.19));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(4.11, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testC() {
		alfandega.declaraItem(new Item("a", 25.0, 5.12));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 50.0, 6.19, 0.6));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(186.98, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testD() {
		alfandega.declaraItem(new Item("a", 50.0, 5.12));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 25.0, 6.19, 0.6));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(95.41, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testE() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 25.0, 5.12, 0.6));
		alfandega.declaraItem(new Item("b", 50.0, 6.19));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(79.9, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testF() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 50.0, 5.12, 0.6));
		alfandega.declaraItem(new Item("b", 25.0, 6.19));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(155.15, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testG() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 25.0, 5.12, 0.6));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 50.0, 6.19, 0.6));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(262.5, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testH() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 50.0, 5.12, 0.6));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 25.0, 6.19, 0.6));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(246.45, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testI() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 25.0, 5.12, 0.8));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 50.0, 6.19, 0.8));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(350.0, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testJ() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 50.0, 5.12, 0.8));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 25.0, 6.19, 0.8));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(328.6, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testK() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 25.0, 5.12, 0.6));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 50.0, 6.19, 0.8));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(324.4, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testL() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 50.0, 5.12, 0.6));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 25.0, 6.19, 0.8));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(277.4, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testM() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 25.0, 5.12, 0.8));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 50.0, 6.19, 0.6));
		assertEquals(437.5, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(288.1, alfandega.getTotalDevido(), DELTA);
	}

	@Test
	void testN() {
		alfandega.declaraItemTarifado(new ItemTarifado("a", 50.0, 5.12, 0.8));
		alfandega.declaraItemTarifado(new ItemTarifado("b", 25.0, 6.19, 0.6));
		assertEquals(410.75, alfandega.getTotalDeclarado(), DELTA);
		assertEquals(297.65, alfandega.getTotalDevido(), DELTA);
	}
}
