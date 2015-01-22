package reilaender.test;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sprueche.*;

public class SpruecheTest {
	private Sprueche sprueche;
	@Before
	public void beforeEachTest() {
		try {
			sprueche = new SpruchSammlung("req\\sprueche.txt");
		} catch (FileNotFoundException e) {
			// TODO
			System.err.println("Pech beforeEachTest(): " + e.getMessage());
		}
	}
	
	@Test
	public void testAppendNewSaying() {
		System.out.println(sprueche.readFirstLine());
	}
}