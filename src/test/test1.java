package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.encript;

public class test1 {
	String code1 = "¡ßç®©¥µ•≥ø÷º–“æ≠‘«45879632";
	@Test
	public void test1() {
		String message = "i do play games";
		String messageC = encript.encode(message, code1);
		assertEquals("≥ ®æ ≠º¡3 µ¡–©4", messageC);
		assertEquals(message, encript.decode(messageC, code1));
		
	}
	@Test
	public void testCodGen(){
		String key = encript.generateKey();
		System.out.println(key);
		assertNotSame("ABCDEFGHIJKMNLOPQRSTUVXWYZ", key);
	}

}
