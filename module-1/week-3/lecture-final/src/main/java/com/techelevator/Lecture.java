package com.techelevator;

import java.util.*;

public class Lecture {

    public static void main(String[] args) {

        // Queues:
        //   FIFO - First In, First Out
        // Declaration            Instantiation    Initialization (empty queue)
        Queue<String> toDoList =  new LinkedList<>();

        // Adding
        toDoList.offer("Do your exercises");
        toDoList.offer("Reconsider how you pronounce literally everything you say");
        toDoList.offer("Warsh the dishes");

        // Removing
        System.out.println(toDoList.size());
        String output = toDoList.poll();
        System.out.println(output);

        System.out.println("Polling once: " + toDoList.poll());
        System.out.println("Polling twice: " + toDoList.poll());
        System.out.println("Polling thrice: " + toDoList.poll());
        System.out.println(toDoList.size());


        // Stacks:
        //   LIFO - Last In, First Out
        Stack<String> browserHistory = new Stack<>();

        // Add: .push(element)
        browserHistory.push("www.techelevator.com");
        browserHistory.push("www.google.com");
        browserHistory.push("www.hackerrank.com");

        // Remove: .pop()
        String lastVisited = browserHistory.pop();
        System.out.println("Last visited: " + lastVisited);

        System.out.println("Peek: " + browserHistory.peek());
        System.out.println(browserHistory.size());



        // LISTS!
        // Indexed!
        List<String> names = new ArrayList<>();
        names.add("John"); // 0
        names.add("Audra");// 1
        names.add("Caity");// 2

        System.out.println(names.get(1));

        names.remove(0);
        System.out.println(names.get(1));

        names.add(1, "Tom");

        System.out.println("===========================");
        // FOR EACH LOOP
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("===========================");
        // FOR LOOP
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("Done!");

        Scanner keyboard = new Scanner(System.in);
        boolean flag = false;
        while(flag) {
            String nextName = keyboard.nextLine();
            if (nextName.equals("Tom")) {
                flag = false;
            } else {
                names.add(nextName);
            }
        }

        Map<Integer, String> zip2City = new HashMap<>();
        zip2City.put(90210, "Beverly Hills");
        zip2City.put(15233, "Pittsburgh");
        zip2City.put(27124, "Beaverton");


        System.out.println("That's where I want to be -- " + zip2City.get(90210));

        // Iterate!
        for (int key : zip2City.keySet()) {
            String value = zip2City.get(key);

            System.out.println("Zip code " + key + " is: " + value);
        }

        for (Map.Entry<Integer, String> kvPair : zip2City.entrySet()) {
            int key = kvPair.getKey();
            String value = kvPair.getValue();
        }

        Set<String> uniques = new HashSet<>();
        uniques.add("Tom");
        System.out.println(uniques.size());

        uniques.add("John");
        System.out.println(uniques.size());

        uniques.add("Tom");
        System.out.println(uniques.size());


    }


}
