package reilaender.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import witze.Witze;
import witze.WitzeSammlung;

public class WitzSammlungTest {
	private Witze w;
	@Before
	public void setUp() throws Exception {
		w = new WitzeSammlung("req\\witze.txt");
	}
	@Test
	public void testReadFirstJoke() {
		String expected = "Ein Ehemann tritt auf eine dieser Jahrmarktswaagen, die einem beim Wiegen das Schicksal voraus-"+  
				"sagen, und wirft eine Münze ein. »Hör mal«, sagt er zu seiner Frau und zeigt ihr die kleine, weiße"+
				"Karte. »Hier steht, dass ich energisch, intelligent, fantasievoll und überhaupt ein toller Mensch bin.«"+   
				"»Ja«, nickt darauf seine Frau, »und dein Gewicht stimmt auch nicht.«";
		String actual = w.readFirstJoke();
		assertEquals(expected, actual);
	}

	@Test
	public void testReadLastJoke() {
		String expected = "Computerkunde: \"Ich möchte das neue OS/2 v2.0 kaufen."+ 
			    		  "Verkäufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?";
		String actual = w.readLastJoke();
		assertEquals(expected, actual);
	}
	@Test
	public void testReadRandomJoke() {
		fail("Not yet implemented");
	}
	@Test
	public void testGoToJoke() {
		String expected = "Eine Lehrerin hat schlechte Laune und will sie an ihrer Klasse auslassen. Deshalb sagt sie: »Alle, die"+
				 		  "glauben, dass sie dumm sind, stehen jetzt mal auf!« Nach einigen Sekunden steht ein einziges"+
				 		  "Kind langsam auf. Darauf sagt die Lehrerin: »Du glaubst also, dass du dumm bist?«"+
				 		  "»Nein …«, antwortet das Kind, »… aber ich kann nicht sehen, wie Sie ganz allein dastehen.«";
		String actual = w.readJoke((int)w.goToJoke(2));
		assertEquals(expected, actual);
	}
	@Test
	public void testCount() {
		int expected = 18;
		int actual = w.count();
		assertEquals(expected, actual);
	}

	@Test
	public void testReadJoke() {
		String expected = "Ein Ehemann tritt auf eine dieser Jahrmarktswaagen, die einem beim Wiegen das Schicksal voraus-"+  
				"sagen, und wirft eine Münze ein. »Hör mal«, sagt er zu seiner Frau und zeigt ihr die kleine, weiße"+
				"Karte. »Hier steht, dass ich energisch, intelligent, fantasievoll und überhaupt ein toller Mensch bin.«"+   
				"»Ja«, nickt darauf seine Frau, »und dein Gewicht stimmt auch nicht.«";
		String actual = w.readJoke(0);
		assertEquals(expected, actual);
	}
	@Test
	public void testAppendNewJoke() {
		String expected = "1234";
		w.appendNewJoke(expected);
		String actual = w.readLastJoke();
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteLastJoke() {
		String expected = "Computerkunde: \"Ich möchte das neue OS/2 v2.0 kaufen."+
						  "Verkäufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?";
		w.deleteLastJoke();
		String actual = w.readLastJoke();
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteJoke() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertJoke() {
		fail("Not yet implemented");
	}
}