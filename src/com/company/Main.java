package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> myMap = new HashMap<Integer, String>();

        int num;
        String add;
        String again = " ";

        while(! again.equalsIgnoreCase("n")){
            System.out.print("Enter a number: ");
             num = scanner.nextInt();

            if (myMap.get(num) == null){
                System.out.print("Number not found. Please spell to add: ");
                add = scanner.next();
                myMap.put(num, add);
            } else {
                System.out.println("You entered " + myMap.get(num));
            }
            System.out.print("Would you like to enter another? (y/n): ");
            again = scanner.next();
        }

        // Writing keys and values to a file
        String filename = (System.getProperty("user.dir") + File.separatorChar + "UsingHashMaps.txt");


        // Error Handling
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e){
            System.out.println("File does not exist!");
        }

        // print both the key and the value on the same line
        // for each key in the key set write the key, a tab and the value
        for (Integer key : myMap.keySet()){
            System.out.println("write this line: " + key);
            writer.println(key + "\t" + myMap.get(key));
        }
        writer.close();

        // read from a file
        System.out.println("read from a file");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] key_value_pair = line.split("\t");
                System.out.println("KV Pair:" + key_value_pair[0] + " " +
                key_value_pair[1]);
                //the key is in key_value_pair[0]
                //the value is in key_value_pair[1]
                //now you could add it back to the hash map if it isn't there already

                line = reader.readLine();
            }
        } catch (IOException e){
            System.out.println("File does not exist!");
        }


    }
}
