package reilaender.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import witze.Witze;

public class WitzeMockTest {
	private Witze w;
	@Before
	public void setUp() throws Exception {
		w = mock(witze.Witze.class);
	}
	
	@Test
	public void testReadFirstJoke() {
		String expected = "asd";
		when(w.readFirstJoke()).thenReturn(expected);
		String actual = w.readFirstJoke();
//		verify(w).readFirstJoke();
		assertEquals(expected, actual);
	}
	@Test
	public void testReadLastJoke() {
		String expected = "asd";
		when(w.readLastJoke()).thenReturn(expected);
		String actual = w.readLastJoke();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReadRandomJoke() {
		String expected = "asd";
		when(w.readLastJoke()).thenReturn(expected);
		String actual = w.readLastJoke();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGoToJoke() {
		int gotoJ = 1;
		long expected = 2l;
		when(w.goToJoke(gotoJ)).thenReturn(expected);
		long actual = w.goToJoke(gotoJ);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCount() {
		int expected = 1;
		when(w.count()).thenReturn(expected);
		int actual = w.count();
		assertEquals(expected, actual);
	}

	@Test
	public void testReadJoke() {
		int read = 1;
		String expected = "asd";
		when(w.readJoke(read)).thenReturn(expected);
		String actual = w.readJoke(read);
		assertEquals(expected, actual);
	}

	@Test
	public void testAppendNewJoke() {
		String param = "asd";
		w.appendNewJoke(param);
		verify(w).appendNewJoke(param);
	}

	@Test
	public void testDeleteLastJoke() {
		w.deleteLastJoke();
		verify(w).deleteLastJoke();
	}

	@Test
	public void testDeleteJoke() {
		int param = 1;
		w.deleteJoke(param);
		verify(w).deleteJoke(param);
	}
	
	@Test
	public void testInsertJoke() {
		String param = "asd";
		int param2 = 1;
		w.insertJoke(param, param2);
		verify(w).insertJoke(param, param2);
	}

}