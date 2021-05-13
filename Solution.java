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

    }

    public static StringBuilder getLine(String... words) {
        List<String> arr = Arrays.asList(words);
        List<String> arr_copy;
        for (String s : arr) {
            arr_copy.set()
        }
        arr_copy

        StringBuilder result = new StringBuilder();
        int i = 0;
     //   Stream stream = Arrays.stream(arr.get());
     //   stream.forEach(System.out :: println);

        for (int j = 0; j < arr.size(); j++) {
            for (int k = j+1; k < arr.size(); k++) {
                if ((arr.get(j).charAt(arr.get(j).length()-1) == ((arr.get(k).charAt(0)))
                        && ! arr.get(k).equals(arr.get(j+1)))) {
                    String time = arr.get(j+1);
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