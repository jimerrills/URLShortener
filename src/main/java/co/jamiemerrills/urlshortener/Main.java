package co.jamiemerrills.urlshortener;

import co.jamiemerrills.urlshortener.url.URLManager;
import co.jamiemerrills.urlshortener.util.CC;

import java.net.URL;
import java.util.Scanner;

import static co.jamiemerrills.urlshortener.util.CC.*;

public class Main {
    public static void main(String[] args) {
        menu();

    }

    private static void menu() {
        while(true) {
            System.out.println(CC.formatColoredMessage("----------------------------", WHITE));
            System.out.println(CC.formatColoredMessage("Welcome to URL Shortener!", CYAN));
            System.out.println(CC.formatColoredMessage("----------------------------", WHITE));

            System.out.println(CC.formatColoredMessage("Enter a URL to shorten:", BLUE));
            System.out.println(CC.formatColoredMessage("(http://www.example.com)", GRAY));

            System.out.println(CC.formatColoredMessage("URL: ", BLUE));
            Scanner scanner = new Scanner(System.in);
            String url = scanner.nextLine();

            System.out.print(CC.formatColoredMessage("Shortened URL: ", BLUE));

            String short_url = URLManager.shortenURL(url); // Shorten the URL

            if (short_url == null) {
                System.out.print(CC.formatColoredMessage("Invalid URL", RED));
                System.out.println(); // New line
            } else {
                System.out.print(CC.formatColoredMessage("%s", GREEN, short_url)); // Print the shortened URL
                System.out.println();
            }
        }
    }
}