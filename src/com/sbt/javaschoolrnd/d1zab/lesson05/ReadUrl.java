package com.sbt.javaschoolrnd.d1zab.lesson05;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ReadUrl {

    private static boolean readContent(String url) throws IOException {
        Object content = new URL(url).getContent();

        if (content instanceof InputStream) {
            InputStream contentStream = (InputStream) content;

            try (Scanner contentScanner = new Scanner(contentStream)) {
                while (contentScanner.hasNext()) {
                    System.out.println(contentScanner.next());
                }
            }
        } else {
            throw new IOException("Unsupported content kind");
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // System.in закрывать не нужно

        boolean flag = true;

        do {
            System.out.println("Type url");
            String url = scanner.next();

            if (url.equalsIgnoreCase("q")) {
                System.out.println("");
                break;
            }

            try {
                flag = readContent(url);


            } catch (MalformedURLException e) {
                System.out.println("Malformed URL specified!");
            } catch (UnknownHostException e) {
                System.out.println("Unknown host!");
            } catch (IOException e) {
                System.out.println("Unable to get site content. " + e.getMessage());
                throw e;
            }

            System.out.println("Try again");
        } while (flag);
    }

}
