import com.sun.source.tree.BreakTree;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
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
        System.out.println(result);
    }

    public static StringBuilder getLine(String... words) {
        List<String> arr = Arrays.asList(words);
        List<String> arr_copy = new ArrayList<>();
        // Collections.copy(arr_copy, arr);
        for (int i = 0; i < words.length; i++) {
            arr_copy.add(i, arr.get(i).toLowerCase());
        }

        StringBuilder result = new StringBuilder();
        //   Stream stream = Arrays.stream(arr.get());
        //   stream.forEach(System.out :: println);

        for (int j = 0; j < arr.size(); j++) {
            for (int k = j+1; k < arr.size(); k++) {
                if ((arr_copy.get(j).charAt(arr_copy.get(j).length()-1) == ((arr_copy.get(k).charAt(0)))
                        && ! arr_copy.get(k).equals(arr_copy.get(j+1)))) {
                    String time = arr.get(j+1);
                    arr.set((j+1), (arr.get(k)));
                    arr.set((k), time);

                }
            }
        }
        for (String s : arr) {
            result = result.append(s).append(' ');
        }

        return result.delete(result.length()-1, result.length());
    }

}