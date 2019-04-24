package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> myMap = new HashMap<Integer, String>();

        int num;
        String line;
        String add;
        String again = " ";

        String filename = (System.getProperty("user.dir") + File.separatorChar + "UsingHashMaps.txt");


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    String keyString = parts[0];
                    int key = Integer.parseInt(keyString);
                    String value = parts[1];
                    myMap.put(key, value);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File does not exist!");
        }


            while (!again.equalsIgnoreCase("n")) {
                System.out.print("Enter a number: ");
                num = scanner.nextInt();

                if (myMap.get(num) == null) {
                    System.out.print("Number not found. Please spell to add: ");
                    add = scanner.next();
                    myMap.put(num, add);
                } else {
                    System.out.println("You entered " + myMap.get(num));
                }
                System.out.print("Would you like to enter another? (y/n): ");
                again = scanner.next();
            }


            // Error Handling
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new File(filename));
            } catch (FileNotFoundException er) {
                System.out.println("File does not exist!");
            }

            // print both the key and the value on the same line
            // for each key in the key set write the key, a tab and the value
            for (Integer key : myMap.keySet()) {
                System.out.println("write this line: " + key);
                writer.println(key + "\t" + myMap.get(key));
            }
            writer.close();



    }
}

