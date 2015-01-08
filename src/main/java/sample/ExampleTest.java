package sample;

import static org.junit.Assert.*;

import org.junit.Test;


public class ExampleTest {

	@Test
	public void nice() throws Exception {
		assertEquals(1, 1);
	}

	@Test
	public void naughty() throws Exception {
		assertEquals(1, 2);
	}

}
