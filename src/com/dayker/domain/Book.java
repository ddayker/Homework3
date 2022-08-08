package com.dayker.domain;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Random;

public class Book {

    public static final String bookDefaultField = "unknown";

    private String title;

    private String authorsName;

    private String authorsSurname;

    private String authorsPatronymic;

    private String publisher;

    private int publicationYear;

    public Book() {
        this.title = bookDefaultField;
        this.authorsSurname = bookDefaultField;
        this.authorsName = bookDefaultField;
        this.authorsPatronymic = bookDefaultField;
        this.publisher = bookDefaultField;
    }

    public Book(String title, String authorsName, String authorsSurname, String authorsPatronymic, String publisher, int publicationYear) {
        this.title = title;
        this.authorsName = authorsName;
        this.authorsSurname = authorsSurname;
        this.authorsPatronymic = authorsPatronymic;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }

    public String getAuthorsSurname() {
        return authorsSurname;
    }

    public void setAuthorsSurname(String authorsSurname) {
        this.authorsSurname = authorsSurname;
    }

    public String getAuthorsPatronymic() {
        return authorsPatronymic;
    }

    public void setAuthorsPatronymic(String authorsPatronymic) {
        this.authorsPatronymic = authorsPatronymic;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publicationYear != book.publicationYear) return false;
        if (!title.equals(book.title)) return false;
        if (!authorsName.equals(book.authorsName)) return false;
        if (!authorsSurname.equals(book.authorsSurname)) return false;
        if (!authorsPatronymic.equals(book.authorsPatronymic)) return false;
        return publisher.equals(book.publisher);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + authorsName.hashCode();
        result = 31 * result + authorsSurname.hashCode();
        result = 31 * result + authorsPatronymic.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + publicationYear;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorsName='" + authorsName + '\'' +
                ", authorsSurname='" + authorsSurname + '\'' +
                ", authorsPatronymic='" + authorsPatronymic + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public String generateString(int size) {
        // method for generating a random string (any characters)
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);

        return generatedString;
    }

    public static class AuthorSurnameComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {

            int returnResult = o1.getAuthorsSurname().compareTo(o2.getAuthorsSurname());
            int stringsAreTheSameResult = 0;
            if (returnResult != stringsAreTheSameResult) {
                return returnResult;
            } else return 1;

        }
    }

    public static class AuthorNameComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            int returnResult = o1.getAuthorsName().compareTo(o2.getAuthorsName());
            int stringsAreTheSameResult = 0;
            if (returnResult != stringsAreTheSameResult) {
                return returnResult;
            } else return 1;
        }
    }

    public static class AuthorPatronymicComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            int returnResult = o1.getAuthorsPatronymic().compareTo(o2.getAuthorsPatronymic());
            int stringsAreTheSameResult = 0;
            if (returnResult != stringsAreTheSameResult) {
                return returnResult;
            } else return 1;
        }
    }


    public static class PublicationYearComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            if (o1.getPublicationYear() > o2.getPublicationYear())
                return 1;
            else if (o1.getPublicationYear() < o2.getPublicationYear())
                return -1;
            else
                return 1;
        }
    }

}
