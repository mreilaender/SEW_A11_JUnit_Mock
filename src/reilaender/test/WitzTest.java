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

public class WitzTest {
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
				"sagen, und wirft eine M�nze ein. �H�r mal�, sagt er zu seiner Frau und zeigt ihr die kleine, wei�e"+
				"Karte. �Hier steht, dass ich energisch, intelligent, fantasievoll und �berhaupt ein toller Mensch bin.�"+   
				"�Ja�, nickt darauf seine Frau, �und dein Gewicht stimmt auch nicht.�";
		String actual = w.readFirstJoke();
		System.out.println("testReadFirstJoke");
		assertEquals(expected, actual);
	}
	@Test
	public void testReadLastJoke() {
		String expected = "Computerkunde: \"Ich m�chte das neue OS/2 v2.0 kaufen."+ 
				"Verk�ufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?";
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
		String expected = "Eine Lehrerin hat schlechte Laune und will sie an ihrer Klasse auslassen. Deshalb sagt sie: �Alle, die"+
				"glauben, dass sie dumm sind, stehen jetzt mal auf!� Nach einigen Sekunden steht ein einziges"+
				"Kind langsam auf. Darauf sagt die Lehrerin: �Du glaubst also, dass du dumm bist?�"+
				"�Nein ��, antwortet das Kind, �� aber ich kann nicht sehen, wie Sie ganz allein dastehen.�";
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
				"sagen, und wirft eine M�nze ein. �H�r mal�, sagt er zu seiner Frau und zeigt ihr die kleine, wei�e"+
				"Karte. �Hier steht, dass ich energisch, intelligent, fantasievoll und �berhaupt ein toller Mensch bin.�"+   
				"�Ja�, nickt darauf seine Frau, �und dein Gewicht stimmt auch nicht.�";
		String actual = w.readJoke(1);
		System.out.println("testReadJoke");
		assertEquals(expected, actual);
	}
	@Test
	public void testReadJokeNegativeParameter() {
		String expected = "Ein Ehemann tritt auf eine dieser Jahrmarktswaagen, die einem beim Wiegen das Schicksal voraus-"+
				"sagen, und wirft eine M�nze ein. �H�r mal�, sagt er zu seiner Frau und zeigt ihr die kleine, wei�e"+  
				"Karte. �Hier steht, dass ich energisch, intelligent, fantasievoll und �berhaupt ein toller Mensch bin.�"+   
				"�Ja�, nickt darauf seine Frau, �und dein Gewicht stimmt auch nicht.�|"+
				"Eine Lehrerin hat schlechte Laune und will sie an ihrer Klasse auslassen. Deshalb sagt sie: �Alle, die"+  
				"glauben, dass sie dumm sind, stehen jetzt mal auf!� Nach einigen Sekunden steht ein einziges"+  
				"Kind langsam auf. Darauf sagt die Lehrerin: �Du glaubst also, dass du dumm bist?�"+ 
				"�Nein ��, antwortet das Kind, �� aber ich kann nicht sehen, wie Sie ganz allein dastehen.�|"+
				"Ein Mann geht zur Untersuchung ins Krankenhaus. Nach wochenlangen Tests kommt der Arzt"+  
				"und sagt: �Ich habe eine gute und eine schlechte Nachricht f�r Sie.� �Welches ist die schlechte"+  
				"Nachricht?�, will der Mann wissen. �Ich f�rchte, Sie haben eine sehr seltene, unheilbare Krankheit.�"+  
				"�Oh Gott, das ist ja schrecklich�, sagt der Mann. �Und was ist die gute Nachricht?� �Nun ja�,"+
				"erwidert der Arzt, �wir werden sie nach Ihnen benennen.�|"+
				"Two fish in a tank. One turns to the other and says: �Do you know how to drive this?�|"+
				"Ein �lteres Paar ist zum Essen bei einem anderen Paar eingeladen. Nach der Mahlzeit erheben sich"+  
				"die beiden Frauen und gehen in die K�che. Die beiden �lteren Herren unterhalten sich weiter."+  
				"Einer sagt: �Gestern Abend waren wir in einem neuen Restaurant, das war wirklich toll. Ich kann es"+
				"nur empfehlen.� Darauf der andere: �Wie hie� denn das Restaurant?� Der erste Mann denkt"+  
				"lange nach und sagt schlie�lich: �Wie hei�t doch noch diese Blume, die man manchmal einer Frau"+  
				"gibt,wenn man sie liebt? Sie wissen schon � sie ist rot und hat Dornen.� �Sie meinen eine Rose?�"+  
				"�Ja, richtig�, antwortet der andere. Dann wendet er sich in Richtung der K�che und ruft: �Rose, wie"+  
				"hie� noch das Restaurant, in dem wir gestern waren?�|"+
				"Auf einem belebten Platz kommt ein Mann auf eine Frau zu und fragt: �Entschuldigung, haben"+
				"Sie hier irgendwo einen Polizisten gesehen?� �Tut mir leid�, sagt die Frau, �ich habe schon ewig"+  
				"keinen mehr gesehen.� �Na gut, dann geben Sie mir jetzt Ihre Uhr und Ihre Halskette.�|"+
				"Zwei J�ger gehen durch den Wald, da bricht der eine pl�tzlich zusammen. Es sieht aus, als w�rde er"+  
				"nicht mehr atmen, und seine Augen sind glasig. Der andere zieht sein Handy heraus und w�hlt"+
				"den Notruf. �Mein Freund ist tot�, keucht er, �was soll ich tun?� �Immer mit der Ruhe�, sagt der"+  
				"Mann am anderen Ende. �Erst mal m�ssen wir genau wissen, ob er tot ist.� Schweigen, dann h�rt"+  
				"man einen Schuss. Der andere Mann greift wieder zum Telefon und sagt: �Okay, und jetzt?�|"+
				"Ein OS/2-Entwickler besucht ein Windows95-Seminar. Danach kommt Bill Gates auf ihn zu und fragt ihn,"+ 
				"was ihm an Windows 95 am besten gefallen h�tte. Seine Antwort: \"Das ihr damit arbeiten m�sst...\"|"+
				"Mit Computern hat man Zeit, Dinge zu tun, die man ohne sie nicht tun m��te...|"+
				"Je gr��er eine Festplatte ist, desto schneller ist sie voll...|"+
				"Assembler ist eine Methode, Programme, die zu langsam laufen, so umzuschreiben,"+ 
				"da� sie �berhaupt nicht mehr laufen...|"+
				"Frage: Ich installiere gerade Windows98, was soll ich dr�cken? Antwort: Am besten beide Daumen...|"+
				"Der gr��te Vorteil des iPhones ist: Frauen k�nnen nur noch solange telefonieren, wie der Akku reicht.|"+
				"iPhone-User trifft Android-User.  iPhone-User: \"Sorry, ich bin zu sp�t, mein Wecker hat nicht geklingelt!\""+
				"Android-User: \"Treffen war doch sowieso verschoben. SMS nicht bekommen?|"+
				"Frage: Was bedeutet \"Booten\"? Antwort: La� es mich so erkl�ren:"+
				"Es gibt Programme, die ziehen dir die Schuhe aus. Danach mu�t du neu booten... |"+
				"Na, hattest du auf deiner Griechenlandtour Schwierigkeiten mit deinem neuen Sprachcomputer?\""+ 
				"Ich nicht, aber die Griechen...\"|"+
				"Und wie wechseln 100 Windows-Anwender eine kaputte Gl�hbirne?"+ 
				"Einer schraubt und 99 klicken die Fehlermeldungen weg...|"+
				"Computerkunde: \"Ich m�chte das neue OS/2 v2.0 kaufen.\""+
				"Verk�ufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?\"|"+
				"Morgenstund ha";
//		System.out.println(w.readJoke(-10));
		String actual = w.readJoke(-10);
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
		String expected = "Computerkunde: \"Ich m�chte das neue OS/2 v2.0 kaufen."+
				"Verk�ufer: \"Ach, haben Sie die alte Version schon zu Ende gespielt?";
		w.deleteLastJoke();
		String actual = w.readLastJoke();
		System.out.println("testDeleteLastJoke");
		assertEquals(expected, actual);
	}
	@Test
	@Ignore
	public void testDeleteJoke() {
		System.out.println("asd");
		String expected = "Eine Lehrerin hat schlechte Laune und will sie an ihrer Klasse auslassen. Deshalb sagt sie: �Alle, die"+
				"glauben, dass sie dumm sind, stehen jetzt mal auf!� Nach einigen Sekunden steht ein einziges"+
				"Kind langsam auf. Darauf sagt die Lehrerin: �Du glaubst also, dass du dumm bist?�"+
				"�Nein ��, antwortet das Kind, �� aber ich kann nicht sehen, wie Sie ganz allein dastehen.�";
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