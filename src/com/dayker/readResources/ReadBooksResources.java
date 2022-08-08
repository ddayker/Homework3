package com.dayker.readResources;


import com.dayker.domain.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadBooksResources {

    public ArrayList<Book> readBooksToArrayList(String fileName) {

        // Getting ClassLoader
        ClassLoader classLoader = this.getClass().getClassLoader();

        // Getting resource file from class loader
        File file = new File(classLoader.getResource(fileName).getFile());

        ArrayList<Book> bookArrayList = new ArrayList<>();

        String title;
        int titleIndex = 0;

        String authorsSurname;
        int authorsSurnameIndex = 1;

        String authorsName;
        int authorsNameIndex = 2;

        String authorsPatronymic;
        int authorsPatronymicIndex = 3;

        String publisher;
        int publisherIndex = 4;

        int publicationYear;
        int publicationYearIndex = 5;

        final int numberOfFields = 6;

        try {
            Scanner scanner = new Scanner(file);
            for (int lineNumber = 1; scanner.hasNextLine(); lineNumber++) {

                String line = scanner.nextLine();
                String[] words = line.split(",");

                if (words.length != (numberOfFields)) { //if there are fewer words than the fields of the Book class, the data is incorrect.

                    System.out.println("Invalid data line №" + lineNumber + " in the resource file \"" + fileName + "\".");
                    continue;

                } else {
                    title = words[titleIndex];

                    authorsName = words[authorsNameIndex];

                    authorsSurname = words[authorsSurnameIndex];

                    authorsPatronymic = words[authorsPatronymicIndex];

                    publisher = words[publisherIndex];

                    try {
                        publicationYear = Integer.parseInt(words[publicationYearIndex]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid data line №" + lineNumber + " (incorrect publication year) in the resource file \"" + fileName + "\".");
                        continue;
                    }

                }

                bookArrayList.add(new Book(title, authorsName, authorsSurname, authorsPatronymic, publisher, publicationYear));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bookArrayList;
    }
}



