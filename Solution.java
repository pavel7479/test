import com.sun.source.tree.BreakTree;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

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

    }

    public static StringBuilder getLine(String... words) {
        StringBuilder [] stringBuilders = new StringBuilder[words.length];
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (String s : words) {
            stringBuilders [i] = new StringBuilder(s);
            i++;
        }

        Stream stream = Arrays.stream(stringBuilders);
     //   stream.forEach(System.out :: println);

        List<StringBuilder> arr = Arrays.asList(stringBuilders);
       // System.out.println(arr.get(0).charAt(arr.get(0).length()-1));
        for (int j = 0; j < arr.size(); j++) {
            for (int k = j+1; k < arr.size(); k++) {
                if ((arr.get(j).charAt(arr.get(j).length()-1).equalsIgnoreCase(arr.get(k).charAt(0)))
                        && ! arr.get(k).equals(arr.get(j+1))) {
                    StringBuilder time = arr.get(j+1);
                    arr.set((j+1), (arr.get(k)));
                    arr.set((k), time);

                }
            }
        }
        for (StringBuilder s : arr) {
            System.out.println(s);
        }

        for (int j = 0; j < words.length; j++) {
            result.append(stringBuilders[j]).append(" ");
        }

 //       System.out.println(result);
        return result;
    }

}