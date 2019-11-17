package com.sbt.javaschoolrnd.d1zab.lesson03;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static com.sbt.javaschoolrnd.d1zab.lesson03.ParseText.sortByValueInDecreasingOrder;
import static com.sbt.javaschoolrnd.d1zab.lesson03.ParseText.sortWordsLengthInIncreasingOrder;

public class Assignment03 {

    public static void main(String[] args) {

        Path srcFile = Paths.get("C:/Users/ElonMusk/Desktop/Sberbank/SbertechProjects/src/com/sbt/javaschoolrnd/d1zab/lesson03",
                "KISS.txt");

        Charset charset = Charset.forName("ISO-8859-1");

        List<String> lines = new ArrayList<>();
        List<String> words = new ArrayList<>();
        List<String> linesSaved = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();

        if (ParseText.FillLinesAndMap(wordMap, lines, linesSaved, words, srcFile, charset) == false) {

            // Task 1;
            ParseText.WordsCounter(words, wordMap);

            // Task 2;
            List<Map.Entry<String, Integer>> list = sortWordsLengthInIncreasingOrder(wordMap);

            System.out.println("Task 2. List of words from file sorted in theirs length and lexicographical order.\n\n");
            for (Map.Entry<String, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey());
                }
            }


            // Task 3;
            List<Map.Entry<String, Integer>> list2 = sortByValueInDecreasingOrder(wordMap);

            System.out.println("\n\nTask 3. List of repeated word from file and their count.");
            for (Map.Entry<String, Integer> entry : list2) {
                if (entry.getValue() > 0) {
                    System.out.println(entry.getKey() + " ---> " + entry.getValue() + " times");
                }
            }


            // Task 4;
            System.out.println("\n\nTask 4. List of all lines of the text in reverse order.\n");
            int linesTotal = ParseText.ShowAllLinesBackwards(linesSaved);


            // Task 5;
            System.out.println("\n\nTask 5. An iterator for a list of all lines of text to pass in reverse order.");
            ParseText.BackwardsIterator(linesSaved, linesTotal);


            // Task 6;
            System.out.println("\n\nTask 6. Display the lines whose numbers are set by the user in random order.");
            ParseText.ShowRandomLines(linesSaved, linesTotal);

        } else {
            System.out.println("Sorry, error has occurred while reading file.\n" +
                    "Impossible to proceed.");
        }
    }
}