package com.dayker.util;

import com.dayker.domain.Book;
import com.dayker.readResources.ReadBooksResources;

import java.util.*;

import static java.lang.Math.random;


public class BookUtil {


    public static void printCollection(Collection<Book> book) {
        {
            //output List of Book in the form of a table
            int num = 1;
            System.out.println("\n|№ |             Title              |                   Author                   |    Publisher   | Year |");
            for (Book books : book) {
                System.out.printf("|%2d| %30s | %10s   %12s   %14s | %14s | %4d |\n",
                        num, books.getTitle(), books.getAuthorsSurname(), books.getAuthorsName(),
                        books.getAuthorsPatronymic(), books.getPublisher(), books.getPublicationYear());
                num++;
            }
        }
    }

    public static LinkedList<Book> generateLinkedList(int numberOfBooks) {

        String resourceFileName = "booksInfo.txt";
        ReadBooksResources readBooksResources = new ReadBooksResources();

        ArrayList<Book> allBooks = readBooksResources.readBooksToArrayList(resourceFileName);
        LinkedList<Book> bookLinkedList = new LinkedList<>();

        for (int i = 0; i < numberOfBooks; i++) {
            bookLinkedList.add(allBooks.get((int) (random() * allBooks.size())));
        }

        return bookLinkedList;
    }

    public static HashSet<Book> generateHashSet(int numberOfBooks) {
        //generating a hashset of books with a chance of duplicate books
        //the task №2 states to provide for the adding duplicate books

        String resourceFileName = "booksInfo.txt";
        ReadBooksResources readBooksResources = new ReadBooksResources();

        ArrayList<Book> allBooks = readBooksResources.readBooksToArrayList(resourceFileName);
        HashSet<Book> bookHashSet = new HashSet<>();

        for (int i = 0; i < numberOfBooks; i++) {
            Book newBook = allBooks.get(i % allBooks.size());
            bookHashSet.add(newBook);

            if (random() * 10 >= 5) { //the book is added to the HashSet once again with a chance of 50%
                bookHashSet.add(newBook);
                i++;
            }
        }

        return bookHashSet;
    }

    public static void createTreeSet(int numberOfBooks, TreeSet<Book> treeSet) {

        String resourceFileName = "booksInfo.txt";
        ReadBooksResources readBooksResources = new ReadBooksResources();

        ArrayList<Book> allBooks = readBooksResources.readBooksToArrayList(resourceFileName);
        int num = 0;
        for (Book book : allBooks) {
            treeSet.add(book);

            num++;
            if (num == numberOfBooks) {
                break;
            }
        }
    }


    public static void printBeginningWithAVowel(HashSet<Book> bookHashSet) {

        ArrayList<Book> titleWithAVowelLetterBooks = new ArrayList<>();
        VowelLetters[] vowelLetters = VowelLetters.values();

        for (Book book : bookHashSet) {

            for (VowelLetters letters : vowelLetters) {

                if (book.getTitle().toUpperCase().startsWith(letters.toString())) {
                    titleWithAVowelLetterBooks.add(book);
                }
            }
        }
        //output of books with the title of which begins with a vowel letter
        printCollection(titleWithAVowelLetterBooks);

    }


}
