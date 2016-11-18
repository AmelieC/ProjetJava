package Projet;

import static org.junit.Assert.*;

import org.junit.Test;

public class BateauTest {

	@Test
	public void testBateauStringInt() {
		Bateau b = new Bateau("PorteAvion", 5);
		Bateau c = new Bateau("SousMarin", 2);
		assertNotNull(b);
		assertEquals("PorteAvion", b.getNom());
		assertEquals(5, b.getTaille());
		assertEquals("SousMarin", c.getNom());
		assertEquals(2, c.getTaille());
	}
}