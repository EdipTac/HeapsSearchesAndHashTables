package com.Group2Q6ASG3.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Question6 {

    String[] hashTable;
    String[] ArrString;
    byte[] ArrUTF;
    ArrayList<String> list;

    public void perform() throws IOException {
        readText();
        hashTable();
        foldingHash(ArrString, hashTable);
        findKeys();
    }

    public int findKeys() {
        int counter = 0;
        String[] keys = {"Azevedo, Ana", "Silva, Rui", "Boussebough, Imane", "Terracina, Giorgio", "Lefebvre, Peter",
            "Houghten, Sher", "Revesz, Peter"};
        //once again, we are removing all the blank spaces from the keys provided
        for (int i = 0; i < keys.length; i++) {
            int probe = 0;
            keys[i] = keys[i].replaceAll("\\s", "");
            int keyHashIndex = hashIndexCreator(keys[i]);
            String foundName = hashTable[keyHashIndex];
            if (foundName.equals(keys[i])) {
                probe = 1;
            } 
            System.out.println("\n Found Name = " + foundName);

        }
        return counter;
    }

    public void hashTable() {
        hashTable = new String[2657];

        for (int i = 0; i < 2657; i++) {
            hashTable[i] = "";
        }
    }

    public String[] readText() throws FileNotFoundException, IOException {
        BufferedReader textFile = new BufferedReader(new FileReader("/Users/aidasharifrohani/Desktop/JavaQ6text.txt"));
        String names;
        // adding names into and array list while it is read, it continues until
        // there are no more names
        list = new ArrayList<>();
        while ((names = textFile.readLine()) != null) {
            list.add(names);
        }
        ArrString = new String[list.size()];
        for (int i = 0; i < ArrString.length; i++) {
            ArrString[i] = list.get(i);
        }
        for (int s = 0; s < ArrString.length; s++) {
            ArrString[s] = ArrString[s].replaceAll("\\s", "");
        }
        return ArrString;
    }

    public String[] foldingHash(String[] ArrString, String[] hashTable) throws UnsupportedEncodingException {
        for (int i = 0; i < ArrString.length; i++) {
            int hashIndex = hashIndexCreator(ArrString[i]);
            String cell=hashTable[hashIndex];
  
            
            hashTable[hashIndex] = ArrString[i];
        }
        System.out.println("\nhashTable = " + Arrays.toString(hashTable));
        return hashTable;
    }

    public int hashIndexCreator(String name) {
        int hashIndex = 0;
        name = name.replaceAll("\\s", "");
        ArrUTF = name.getBytes(Charset.forName("UTF-8"));
        for (int j = 0; j < ArrUTF.length; j++) {
            hashIndex = hashIndex + ArrUTF[j];
            hashIndex = hashIndex % 2657;
        }
        return hashIndex;
    }

    public static void main(String[] args) throws IOException {
        Question6 question6 = new Question6();
        question6.perform();
    }
}
