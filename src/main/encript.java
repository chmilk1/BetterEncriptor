package main;

import java.util.List;
import java.util.Random;

public class encript {
	static public String concatanate(List<Character> list) {return list.stream().reduce("", (a, b) -> a + b, (a, b) -> a + b);}

	static public char getEncodedChar(char c, String code) {
		char C = ("" + c).toUpperCase().toCharArray()[0];
		int charCode = C;
		System.out.println(charCode);
		if (charCode > 90 || charCode < 65) {
			return c;
		}
		return code.toCharArray()[charCode - 65];
	}

	static public String encode(String orig, String code) {
		char[] origA = orig.toCharArray();
		StringBuilder ret = new StringBuilder();
		for (char I : origA) {
			ret.append(getEncodedChar(I, code));
		}
		return ret.toString();

	}
//	static public String encode(String orig, String code) {
//	char[] list = orig.toCharArray();
//	List<Character> charList = new ArrayList<Character>(list);
//	
//	charList.stream().map(i -> encript.getEncodedChar(i, code));
//
//}

	static public String decode(String coded, String code) {
		char[] codedA = coded.toCharArray();
		char[] codeA = code.toCharArray();
		StringBuilder ret = new StringBuilder();
		for (char I : codedA) {
			int curLen = ret.toString().length();
			for (int j = 0; j < codeA.length; j++) {
				char c = codeA[j];
				if (I == c) {
					char k = (char) (65 + j);
					ret.append(("" + k).toLowerCase());
					break;
				}

			}
			if (curLen == ret.toString().length()) {
				ret.append(I);
			}
		}
		return ret.toString();

	}
	static public String generateKey(){
		Random rand  = new Random();
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			ret.append((char)(rand.nextInt(255)));
		}
		return ret.toString();
		
	}
}
