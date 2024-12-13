package com.techelevator;

import javax.swing.text.html.HTMLDocument;

public class Exercises {

	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		String greeting = "Hello " + name + "!";

		return greeting;
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba,
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		String abba = a + b + b + a;
		return abba;
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		String htmlTag = "<" + tag + ">" + word + "</" + tag + ">";
		return htmlTag;
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		String firstTwoChars = out.substring(0,2);
		String lastTwoChars = out.substring(2,4);
		String finalWord = firstTwoChars + word + lastTwoChars;
		return finalWord;
	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		String repetitive = str.substring(str.length() -2);
		String finalPhrase = repetitive + repetitive + repetitive;
		return finalPhrase;
	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		String firstTwoCharsFinal;

		if (str.length() <= 1) {
			firstTwoCharsFinal = str;
		} else {
			firstTwoCharsFinal = str.substring(0,2);
		}

		return firstTwoCharsFinal;
	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		int halfway = str.length() / 2;
		String firstHalf = str.substring(0,halfway);
		return firstHalf;
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell".
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		String missingEnds = str.substring(1, str.length() - 1);
		return missingEnds;
	}

	/*
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
	 on the outside and the longer string on the inside. The strings will not be the same length, but
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		String shortLongShort;
		if (a.length() > b.length()) {
			shortLongShort = b + a + b;
		} else {
			shortLongShort = a + b + a;
		}

		return shortLongShort;
	}

	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		String noStart = a.substring(1) + b.substring(1);
		return noStart;
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		String firstTwo = str.substring(0,2);
		String lastChars = str.substring(2);
		String rotated = lastChars + firstTwo;
		return rotated;
	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		String lastTwoChars = str.substring(str.length() - 2);
		String firstChars = str.substring(0, str.length() - 2);
		String reverseRotate = lastTwoChars + firstChars;
		return reverseRotate;
	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		String singleChar = "";
		if (front) {
			singleChar = str.substring(0,1);
		} else {
			singleChar = str.substring(str.length() - 1);
		}
		return singleChar;
	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string
	 may be any length, including 0.
	 withoutEnd2("Hello") → "ell"
	 withoutEnd2("abc") → "b"
	 withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {
		String withoutEndTwo;
		if (str.length() <= 2) {
			withoutEndTwo = "";
		} else {
			withoutEndTwo = str.substring(1, str.length() - 1);
		}
		return withoutEndTwo;
	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string"
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		int midway = str.length() / 2;
		String midTwo = str.substring(midway - 1, midway + 1);
		return midTwo;
	}

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		boolean containsLy;
		boolean lyAtEnd;
		boolean endsLy = false;

		if (str.indexOf("ly") > -1) {
			containsLy = true;
		} else {
			containsLy = false;
		}

		if (str.indexOf("ly") == (str.length() - 2)) {
			lyAtEnd = true;
		} else {
			lyAtEnd = false;
		}

		if (containsLy && lyAtEnd) {
			endsLy = true;
		}
		return endsLy;
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The
	 string length will be at least n.
	 nTwice("Hello", 2) → "Helo"
	 nTwice("Chocolate", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		String firstLastN = str.substring(0, n) + str.substring(str.length() - n);
		return firstLastN;
	}

	/*
	 Given a string and an int n, return a string that starts at n and has a length of 2. Note that n may or may not be a valid
	 location in the string. If n is too low or too high to define a string of length 2, return the string's first 2 characters.
	 The string length will be at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int n) {
		String twoChars;

		if (n > (str.length() - 2) || n < 1) {
			twoChars = str.substring(0, 2);
		} else {
			twoChars = str.substring(n, n + 2);
		}

		return twoChars;
	}

	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		String middleChars;
		int offset = (str.length() - 3) / 2; //will evaluate to zero when string length is 3 --> 3-3=0, 0/2=0

		middleChars = str.substring(offset, str.length() - offset);

		return middleChars;


	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {
		boolean hasBadAtStart = false;

		if (str.indexOf("bad") == 0 || str.indexOf("bad") == 1) {
			hasBadAtStart = true;
		}
		return hasBadAtStart;
	}

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		String multipled = str.repeat(n);
		return multipled;
	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		boolean has3Chars;
		String frontChars;

		if (str.length() >= 3) {
			has3Chars = true;
		} else {
			has3Chars = false;
		}

		if (has3Chars) {
			frontChars = str.substring(0,3).repeat(n);
		} else {
			frontChars = str.substring(0).repeat(n);
		}
		return frontChars;
	}

	/*
	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") → 3
	 */
	public int countXX(String str) {
		int countX = 0;
		String newStr = str;
		int locationXX = 0;
		int hardCodeString = newStr.length(); //takes a snapshot of this var at this point in time

		//see if there is an instance of xx
		//edit string so first x is removed
		//increase count
		//see if there is an instance of xx

		for (int i = 0; i < hardCodeString; i++) {
			if (newStr.indexOf("xx") == -1) {
				break; //returns count as zero if xx not present
			}
			countX++;
			locationXX = newStr.indexOf("xx");
			newStr = newStr.substring(locationXX + 1);

		}

		return countX;
	}

	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
		boolean doppioX = false;

		if (str.indexOf("xx") > str.indexOf("x")) {
			doppioX = false;
		} else if (str.indexOf("xx") == -1){
			doppioX = false;
		} else {
			doppioX = true;
		}

		return doppioX;
	}

	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String everyOther = "";

		if (str.length() == 0) {
			everyOther = "";
		} else if (str.length() == 1) {
			everyOther = str;
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (i % 2 != 0) {
					continue;
				}
				everyOther = everyOther + str.substring(i, i + 1);
			}
		}

		return everyOther;
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		String buildUp = "";

		for (int i = 0; i < str.length() + 1; i++) {
			buildUp = buildUp + str.substring(0, i);
		}
		return buildUp;
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and
	 also as the last 2 chars of the string.

	 We don't count the end subString, so "hixxxhi" yields 1, but the subString may overlap a prior position by one.
	 For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1. The third pair at
	 position 2 is the end subString, which we don't count.

	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 last2("xxxx") -> 2
	 */
	public int last2(String str) {
		int counter = 0;

		// If the string length is less than 2, return 0 (not enough characters for a substring of length 2)
		if (str.length() < 2) {
			return 0;
		}
		// Get the last 2 characters of the string
		String last2 = str.substring(str.length() - 2);

		// Loop through the string, stopping at the second to last character
		for (int i = 0; i < str.length() - 2; i++) {
			// Extract the current substring of length 2
			String sub = str.substring(i, i + 2);

			// Check if the substring matches the last 2 characters
			if (sub.equals(last2)) {
				counter++;
			}
		}
		return counter;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		boolean startsWithX;
		boolean endsWithX;
		boolean startsEndsWithX;
		String sansX = str.replace("x", "");

		if (str.length() < 2) {
			sansX = str;
		} else if (str.startsWith("x") && str.endsWith("x")) {
			sansX = "x" + sansX + "x";
		} else if (str.endsWith("x")) {
			sansX = sansX + "x";
		} else if (str.startsWith("x")) {
			sansX = "x" + sansX;
		}   else {
			sansX = str.replace("x","");
		}

		return sansX;
	}

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 altPairs("kitten") → "kien"
	 altPairs("Chocolate") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		String alts = "";

		if (str.length() <= 2) {
			alts = str;
		} else {
			for (int i = 0; i < str.length(); i+=4) {
				 if (i == str.length() - 1) { //will i go off end with this iteration
					alts = alts + str.substring(i, i + 1);
				} else {
					alts = alts + str.substring(i, i + 2);
				}
			}
		}

		return alts;
	}

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
	 The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		String noYak = str.replace("yak", "");
		return noYak;
	}

}
