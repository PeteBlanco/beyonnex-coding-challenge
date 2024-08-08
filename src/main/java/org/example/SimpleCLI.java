package org.example;

import java.util.List;
import java.util.Scanner;

public class SimpleCLI {
    boolean runProgram = true;

    public void startCLI() {
        Anagrams anagramService = new Anagrams();
        Scanner scanner = new Scanner(System.in);

        while (runProgram) {
            System.out.println("--- Beyonnex Coding Challenge ---");
            System.out.println("Please choose an option:");
            System.out.println("1. Check if two texts are anagrams");
            System.out.println("2. Find all anagrams for a given string");
            System.out.println("3. Exit program");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter the first string: ");
                    String text1 = scanner.nextLine();
                    System.out.print("Enter the second string: ");
                    String text2 = scanner.nextLine();

                    boolean areAnagrams = anagramService.checkAnagram(text1, text2);
                    System.out.println("Are anagrams: " + areAnagrams);

                    if (areAnagrams) {
                        anagramService.addAnagram(text1, text2);
                    }
                    break;
                case 2:
                    System.out.print("Enter the text to find anagrams for: ");
                    String text = scanner.nextLine();

                    List<String> anagrams = anagramService.findAnagrams(text);
                    anagrams.remove(text);

                    System.out.println("Anagrams found for " + text + ": " + anagrams);
                    break;
                case 3:
                    System.out.println("Closing program...");
                    scanner.close();
                    runProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
    }
}}
