package com.javarush.task.task22.task2209;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException  {
        //...
        String line;
        try (BufferedReader reader = new BufferedReader (new FileReader("C:\\a1.txt"))) {
            line = reader.readLine();
        }
        String [] str = line.split(" ");
        StringBuilder result = getLine(str);
//        System.out.println(result.toString());
//        for (String s : str) {
//            System.out.println(s);
//        }
    }

    public static StringBuilder getLine(String... words) {
        String [] strings = new String[words.length];
        for (int i = 0; i < words.length-1; i++) {
            if (words[i].charAt(0) == words [i+1].charAt(words[i+1].length()-1)) {
                words [i+1] = null;
                strings [i] = words [i];
                strings [i+1] = words [i+1];
            }
        }
        StringBuilder stringBuilder =
        return null;
    }
}
