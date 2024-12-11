package com.techelevator;

import java.util.*;

public class Exercises {

    /*
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "Herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * animalGroupName("giraffe") → "Tower"
     * animalGroupName("") -> "unknown"
     * animalGroupName("walrus") -> "unknown"
     * animalGroupName("Rhino") -> "Crash"
     * animalGroupName("rhino") -> "Crash"
     * animalGroupName("elephants") -> "unknown"
     *
     */
    public String animalGroupName(String animalName) {
        Map<String, String> animals = new HashMap<String, String>();
        String animalGroup = "";

        animals.put("rhino", "Crash");
        animals.put("giraffe", "Tower");
        animals.put("elephant", "Herd");
        animals.put("lion", "Pride");
        animals.put("crow", "Murder");
        animals.put("pigeon", "Kit");
        animals.put("flamingo", "Pat");
        animals.put("deer", "Herd");
        animals.put("dog", "Pack");
        animals.put("crocodile", "Float");

        //avoid NPE error by specifying what to do if the input is null
        if (animalName == null) {
            return "unknown";
        }
        // make it case insensitive
        String newAnimalName = animalName.toLowerCase();
        String thing = "unknown";

        if (animals.containsKey(newAnimalName)) {
            //newAnimalName = "";
            return animals.get(newAnimalName);

        } else {
            return thing;
        }
        //return animalGroup;

    }

    /*
     * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
     * If the item is not on sale, return 0.00.
     *
     * If the item number is empty or null, return 0.00.
     *
     * "KITCHEN4001" -> 0.20
     * "GARAGE1070" -> 0.15
     * "LIVINGROOM"	-> 0.10
     * "KITCHEN6073" -> 0.40
     * "BEDROOM3434" -> 0.60
     * "BATH0073" -> 0.15
     *
     * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
     * should all return 0.20.
     *
     * isItOnSale("kitchen4001") → 0.20
     * isItOnSale("") → 0.00
     * isItOnSale("GARAGE1070") → 0.15
     * isItOnSale("dungeon9999") → 0.00
     *
     */
    public double isItOnSale(String itemNumber) {
        Map<String, Double> skus = new HashMap<String, Double>();

        skus.put("KITCHEN4001", 0.20);
        skus.put("GARAGE1070", 0.15);
        skus.put("LIVINGROOM", 0.10);
        skus.put("KITCHEN6073", 0.40);
        skus.put("BEDROOM3434", 0.60);
        skus.put("BATH0073", 0.15);
        skus.put("unknown", 0.0);

        if (itemNumber == null) {
            return 0.0;
        }

        String newItemNumber = itemNumber.toUpperCase();

        double percentOff = 0.0;

        if (skus.containsKey(newItemNumber)) {
            percentOff = skus.get(newItemNumber);
        } else if (skus.containsValue(null)) {
            percentOff = 0.0;
        }

        return percentOff;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
     * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
     * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
     *
     */
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
        final int PETER_MIN = 0;
        final int PAUL_MIN = 1000;
        Map<String, Integer> peterPaulMoney = new HashMap<>();
        int halfOfPetersMoney = peterPaul.get("Peter") / 2;
        int paulsMoney = (peterPaul.get("Peter") + peterPaul.get("Paul")) - (halfOfPetersMoney + 1);

        //condition if Peter has to give money over and Peter value is not divis by 2
        if (peterPaul.get("Peter") > PETER_MIN && peterPaul.get("Paul") < PAUL_MIN && peterPaul.get("Peter") % 2 != 0) {
            peterPaulMoney.put("Peter", halfOfPetersMoney + 1);
            peterPaulMoney.put("Paul", paulsMoney);
            return peterPaulMoney;

            //condition if Peter has to give money and value is even
        } else if (peterPaul.get("Peter") > PETER_MIN && peterPaul.get("Paul") < PAUL_MIN) {
            peterPaulMoney.put("Peter", halfOfPetersMoney);
            peterPaulMoney.put("Paul", peterPaul.get("Paul") + halfOfPetersMoney);
            return peterPaulMoney;
        } else {
            return peterPaul;
        }
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
     * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
     * current worth.
     *
     * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
     * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
     *
     */
    public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
        Map<String, Integer> partnership = new HashMap<>();
        final int PETER_MIN = 5000;
        final int PAUL_MIN = 10000;
        double quarterPeter = peterPaul.get("Peter") / 4.0;
        double quarterPaul = peterPaul.get("Paul") / 4.0;
        int quarterPeterInt = (int) quarterPeter;
        int quarterPaulInt = (int) quarterPaul;


        if (peterPaul.get("Peter") >= PETER_MIN && peterPaul.get("Paul") >= PAUL_MIN) {
            partnership.put("Peter", peterPaul.get("Peter") - quarterPeterInt);
            partnership.put("Paul", peterPaul.get("Paul") - quarterPaulInt);
            partnership.put("PeterPaulPartnership", quarterPeterInt + quarterPaulInt);
        } else {
            return peterPaul;
        }
        return partnership;
    }

    /*
     * Given an array of non-empty strings, return a Map<String, String> where, for every String in the array,
     * there is an entry whose key is the first character of the string.
     *
     * The value of the entry is the last character of the String. If multiple Strings start with the same letter, then the
     * value for that key should be the later String's last character.
     *
     * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
     * beginningAndEnding(["code", "bug", "cat"]) → {"b": "g", "c": "t"}
     * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
     */
    public Map<String, String> beginningAndEnding(String[] words) {
        Map<String, String> startAndEnd = new HashMap<>();

        for (String parola : words) {
            startAndEnd.put(parola.substring(0, 1), parola.substring(parola.length() - 1));
        }
        return startAndEnd;
    }

    /*
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */
    public Map<String, Integer> wordCount(String[] words) {
        Map<String, Integer> count = new HashMap<>();

        //accounts if value is null
        if (count == null) {
            return count;
        }

        for (String parola : words) {
            String p = parola; //define new String
            if (count.containsKey(p)) { //if String p has been found in map
                int counter = count.get(p); //initialize counter to set index
                count.put(p, counter + 1); //add the phrase that was found already, add one to the counter
            } else {
                count.put(parola, 1); //otherwise it is the String and 1
            }
        }

        return count;
    }

    /*
     * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
     * number of times that int appears in the array.
     *
     * ** The lesser known cousin of the the classic wordCount **
     *
     * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
     * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
     * intCount([]) → {}
     *
     */
    public Map<Integer, Integer> integerCount(int[] ints) {
        Map<Integer, Integer> counter = new HashMap<>();

        if (counter == null) {
            return counter;
        }

        for (Integer i : ints) {
            int j = i;
            if (counter.containsKey(j)) {
                int k = counter.get(j);
                counter.put(j, k + 1);
            } else {
                counter.put(i, 1);
            }
        }

        return counter;
    }

    /*
     * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
     * is true only if that String appears 2 or more times in the array.
     *
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
     * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     *
     */
    public Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Boolean> multiple = new HashMap<>();

        for (String str : words) {
            if (!multiple.containsKey(str)) {
                multiple.put(str, false);
            } else {
                multiple.put(str, true);
            }
        }

        return multiple;
    }

    /*
     * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
     * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
     *
     * Unmatched keys and their int values in Map2 are simply added to Map1.
     *
     * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
     * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
     *
     */
    public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
                                                     Map<String, Integer> remoteWarehouse) {
        Map<String, Integer> inv = new HashMap<>(mainWarehouse);

        if (inv == null) {
            return inv;
        }

        for (String key : remoteWarehouse.keySet()) {
            if (inv.containsKey(key)) {
                Integer value = inv.get(key);
                value += remoteWarehouse.get(key);
                inv.put(key, value);
            } else {
                inv.put(key, remoteWarehouse.get(key));
            }
        }

        return inv;
    }

    /*
     * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
     *
     * Given an array of Strings, for each String, its last2 count is the number of times that a subString length 2
     * appears in the String and also as the last 2 chars of the String.
     *
     * We don't count the end subString, so "hixxxhi" has a last2 count of 1, but the subString may overlap a prior
     * position by one.  For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1.
     * The third pair at position 2 is the end subString, which we don't count.
     *
     * Return a Map<String, Integer> where the keys are the Strings from the array and the values are the last2 counts.
     *
     * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
     *
     */
    public Map<String, Integer> last2Revisited(String[] words) {
        Map<String, Integer> last2 = new HashMap<>();

        if (last2 == null) {
            return last2;
        }


        for (int i = 0; i < words.length; i++) {
           String phrase = words[i];
           String last2Phrase = phrase.substring(phrase.length() - 2, phrase.length());
           int counter = 0;
           int test = phrase.length();
           for (int j = 0; j < phrase.length() - 2; j++) {
               String twoChars = phrase.substring(j, j+2);
               if(twoChars.equals(last2Phrase)) {
                   counter++;
               }
           }
           last2.put(phrase, counter);
        }

        return last2;
    }

}
