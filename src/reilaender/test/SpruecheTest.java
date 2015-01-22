package reilaender.test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
	@Ignore
	public void testAppendNewSayingNormalStrings() {
		sprueche.appendNewSaying("Test1234");
		assertEquals("Test", "Test1234", sprueche.readLastSaying());
	}
	@Test
	@Ignore
	public void testAppendNewSayingSpecialCharacters() {
		sprueche.appendNewSaying("\\!\"§%$%/$%/$?!§$%&/()=?`+#");
		assertEquals("TestSpecialCharacters", "\\!\"§%$%/$%/$?!§$%&/()=?`+#", sprueche.readLastSaying());
	}
	@Test
	public void testReadFirstLine() {
		System.out.println("ReadFirstLine: " + sprueche.readFirstLine());
	}
}