package reilaender.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import witze.Witze;
import witze.WitzeSammlung;

public class WitzSammlungTest {
	private Witze w;
	@Before
	public void setUp() throws Exception {
		w = new WitzeSammlung("req\\witze_save.txt");
	}
	@After
	public void afterMethod() throws Exception {
		
		File old = new File("req\\witze.txt");
		File neu = new File("req\\witze_save.txt");
		
		BufferedWriter writer_neu = new BufferedWriter(new FileWriter(neu, false));
		writer_neu.write("");
		writer_neu.close();
		
//		if(neu.exists()) {
//			System.err.println("File exists, try to delete File");
//			if(neu.delete()) System.err.println("Successfully deleted file!");
//			else { System.err.println("Error! Couldn't delete file, aborting!"); System.exit(1); } 
//			neu = new File("req\\witze_save.txt");
//			neu.createNewFile();
//		}
		
		BufferedReader read = new BufferedReader(new FileReader(old));
		PrintWriter write = new PrintWriter(neu);
		
		
		String tmp;
		while((tmp = read.readLine()) != null) {
			write.println(tmp);
			write.flush();
		}
		
		read.close(); write.close();
		
		System.out.println("Finished cleaning");
	}
	@Test
	public void testReadFirstJoke() {
		String expected = "Ein Ehemann tritt auf eine dieser Jahrmarktswaagen, die einem beim Wiegen das Schicksal voraus-"+  
				"sagen, und wirft eine Münze ein. »Hör mal«, sagt er zu seiner Frau und zeigt ihr die kleine, weiße"+
				"Karte. »Hier steht, dass ich energisch, intelligent, fantasievoll und überhaupt ein toller Mensch bin.«"+   
				"»Ja«, nickt darauf seine Frau, »und dein Gewicht stimmt auch nicht.«";
		String actual = w.readFirstJoke();
		System.out.println("testReadFirstJoke");
		assertEquals(expected, actual);
	}
	@Test
	public void testReadLastJoke() {
		String expected = "Computerkunde: \"Ich möchte das neue OS/2 v2.0 kaufen."+ 
				"Verkäufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?";
		String actual = w.readLastJoke();
		System.out.println("testReadLastJoke");
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
		System.out.println("testGoToJoke");
		assertEquals(expected, actual);
	}
	@Test
	public void testGoToJokeParameterGreaterThanAllJokesInFile() {
		String expected = "Morgenstund ha";
		String actual = w.readJoke((int)w.goToJoke(10000000));
		System.out.println("testGoToJokeParameterGreaterThanAllJokesInFile");
		assertEquals(expected, actual);
	}
	@Test
	public void testCount() {
		int expected = 18;
		int actual = w.count();
		System.out.println("testCount");
		assertEquals(expected, actual);
	}

	@Test
	public void testReadJoke() {
		String expected = "Ein Ehemann tritt auf eine dieser Jahrmarktswaagen, die einem beim Wiegen das Schicksal voraus-"+  
				"sagen, und wirft eine Münze ein. »Hör mal«, sagt er zu seiner Frau und zeigt ihr die kleine, weiße"+
				"Karte. »Hier steht, dass ich energisch, intelligent, fantasievoll und überhaupt ein toller Mensch bin.«"+   
				"»Ja«, nickt darauf seine Frau, »und dein Gewicht stimmt auch nicht.«";
		String actual = w.readJoke(1);
		System.out.println("testReadJoke");
		assertEquals(expected, actual);
	}
	@Test
	public void testAppendNewJoke() {
		String expected = "1234";
		w.appendNewJoke(expected);
		String actual = w.readLastJoke();
		System.out.println("testAppendNewJoke");
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteLastJoke() {
		String expected = "Computerkunde: \"Ich möchte das neue OS/2 v2.0 kaufen."+
				"Verkäufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?";
		w.deleteLastJoke();
		String actual = w.readLastJoke();
		System.out.println("testDeleteLastJoke");
		assertEquals(expected, actual);
	}
	@Test
	@Ignore
	public void testDeleteJoke() {
		System.out.println("asd");
		String expected = "Eine Lehrerin hat schlechte Laune und will sie an ihrer Klasse auslassen. Deshalb sagt sie: »Alle, die"+
				"glauben, dass sie dumm sind, stehen jetzt mal auf!« Nach einigen Sekunden steht ein einziges"+
				"Kind langsam auf. Darauf sagt die Lehrerin: »Du glaubst also, dass du dumm bist?«"+
				"»Nein …«, antwortet das Kind, »… aber ich kann nicht sehen, wie Sie ganz allein dastehen.«";
		System.out.println("asd1");
		w.deleteJoke(1);
		System.out.println("asd2");
		String actual = w.readFirstJoke();
		System.out.println("asd3");
		assertEquals(expected, actual);
	}
	@Test
	public void testInsertJoke() {
		String expected = "TestInsert";
		w.insertJoke(expected, 1);
		String actual = w.readFirstJoke();
		System.out.println("testInsertJoke");
		assertEquals(expected, actual);
	}
}