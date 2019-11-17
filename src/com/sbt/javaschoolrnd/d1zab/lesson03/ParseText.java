package com.sbt.javaschoolrnd.d1zab.lesson03;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ParseText {

    public static boolean FillLinesAndMap(Map<String, Integer> wordMap, List<String> lines, List<String> linesSaved,
                                          List<String> words, Path srcFile, Charset charset) {

        boolean fileNotFound = false;
        File file = new File("C:/Users/ElonMusk/Desktop/Sberbank/SbertechProjects/src/com/sbt/javaschoolrnd/d1zab/lesson03/KISS.txt");

        if (file.exists()) {
            try {
                lines = Files.readAllLines(srcFile, charset);
//                for (String line : lines) {
//                    //System.out.println(line);
//                }

            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
                System.out.println(e);
            }

//            Converting ArrayList lines to [] parts and
//            then split every part by space to single word.
//            Then add them to wordMap

            int srcSize = lines.size();
            for (String line : lines) {
                //System.out.println(line);
                linesSaved.add(line);
            }

            String arrLine[] = new String[srcSize];
            lines.toArray(arrLine);

            for (int i = 0; i < srcSize; ++i) {
                String[] arrWords = arrLine[i].split("\\s+");

                for (int j = 0; j < arrWords.length; ++j) {
                    arrWords[j] = arrWords[j].toLowerCase();
                    words.add(arrWords[j]);
                }
            }

            for (String word : words) {
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, (wordMap.get(word) + 1));
                } else {
                    wordMap.put(word, 1);
                }
            }

            System.out.println("\nReading from the file has been successfully completed!\n\n");
            // System.out.println(words);
            System.out.println();
            return fileNotFound;
        } else {
            fileNotFound = true;
            return fileNotFound;
        }
    }


    //        Задание 1: Подсчитайте количество различных слов в файле.
    public static int WordsCounter(List<String> words, Map<String, Integer> wordMap) {

        int wordMapSize = wordMap.size();
        System.out.println("Assignment 1: Total quantity of Unique words is " + wordMapSize + " \n\n");
        return wordMapSize;
    }


    //    Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
    //    (компаратор сначала по длине слова, потом по тексту).
    public static List<Map.Entry<String, Integer>> sortWordsLengthInIncreasingOrder(Map<String, Integer> wordMap) {
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getKey().length() != o2.getKey().length()){
                    return o1.getKey().length() - o2.getKey().length();
                }
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        return list;
    }


    //    Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public static List<Map.Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }


    //    Задание 4: Выведите на экран все строки файла в обратном порядке.
    public static int ShowAllLinesBackwards(List<String> linesSaved) {
        int totalLines = linesSaved.size();

        for (int i = linesSaved.size() - 1; i > -1; --i) {
            System.out.println(linesSaved.get(i));
        }
        return totalLines;
    }


//    Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
    public static void BackwardsIterator(List<String> linesSaved, int linesTotal) {

        ListIterator<String> listIter = linesSaved.listIterator(linesTotal);
        //System.out.println(linesSaved);
        while (listIter.hasPrevious()) {
            System.out.println(listIter.previous());
        }
    }


    //    Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    public static void ShowRandomLines(List<String> linesSaved, int linesTotal) {

        System.out.println("\n\nPlease enter number of String you want to see from 0 to " + (linesTotal - 1));
        System.out.println("For exit enter 0");
        Scanner in = new Scanner(System.in);

        int number;
        int stop = 1;

        while (stop != -1) {

            do {
                System.out.print("Please enter a right String number: ");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.printf("\"%s\" is not a valid number." + input + "\n\n");
                }
                number = in.nextInt();
            } while (number < 0 | number > linesTotal - 1);

            System.out.printf("You have entered a number " + number + "\n\n");
            System.out.println(linesSaved.get(number));

            System.out.println("One more time? Press any number to repeat." +
                    "\nFor exit enter -1");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.printf("\"%s\" is not a valid number." + input + "\n\n");
                System.out.println("One more time? Press any number to repeat." +
                        "\nFor exit enter -1");
            }
            stop = in.nextInt();
        }
    }
}