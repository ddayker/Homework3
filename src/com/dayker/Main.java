package com.dayker;

import com.dayker.domain.Book;
import com.dayker.domain.Student;
import com.dayker.domain.User;
import com.dayker.util.BookUtil;
import com.dayker.util.InputUtil;
import com.dayker.util.StudentUtil;
import com.dayker.util.UserUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        int choice;
        String resourceFileName = "booksInfo.txt";
        while (true) {
            System.out.print("""
                                        
                    Select action:
                    1. Task №1
                    2. Task №2
                    3. Task №3
                    4. Task №4
                    5. Task №5
                    0. Exit
                    """);
            choice = InputUtil.enterInteger();

            switch (choice) {
                case 1:
                    /*
                    Создать экземпляр класса LinkedList, разместить в нём 20 объектов класса Book.
                    Вывести информацию о всех книгах. Программно удалить из коллекции 7-ю книгу, вывести на экран информацию о оставшихся книгах.
                     */

                    int numberOfBooks = 20;
                    LinkedList<Book> bookLinkedList = BookUtil.generateLinkedList(numberOfBooks);
                    BookUtil.printCollection(bookLinkedList);


                    int deletedBookIndex = 6;
                    bookLinkedList.remove(deletedBookIndex);
                    System.out.println("\nBook №" + (++deletedBookIndex) + " has been deleted.");

                    BookUtil.printCollection(bookLinkedList);

                    break;
                case 2:
                    /*
                    Создать экземпляр класса HashSet, добавить в него 25 экземпляров класса Book, предусмотреть не менее 6 одинаковых книг.
                    Вывести на экран информацию о книгах (содержащихся в коллекции HashSet), название которых начинается с гласной буквы.
                     */

                    numberOfBooks = 25;
                    HashSet<Book> bookHashSet = BookUtil.generateHashSet(numberOfBooks);

                    System.out.println("\nAll books in the HashSet:");
                    BookUtil.printCollection(bookHashSet);

                    System.out.println("\nBooks starting with a vowel letter:");
                    BookUtil.printBeginningWithAVowel(bookHashSet);

                    break;
                case 3:
                    /*
                    Отсортировать коллекцию из 25 книг по фамилии, затем по имени, по отчеству автора книги (эти поля надо добавить в класс Book).
                    Вывести 3 результата сортировки по разным параметрам,
                    предусмотреть возможность передавать поле сортировки в качестве параметра метода.
                     */
                    numberOfBooks = 25;

                    System.out.print("\nBooks are sorted by author's surname:");
                    TreeSet<Book> sortedBySurname = new TreeSet<>(new Book.AuthorSurnameComparator());
                    BookUtil.createTreeSet(numberOfBooks, sortedBySurname);
                    BookUtil.printCollection(sortedBySurname);

                    System.out.print("\nBooks are sorted by author's name:");
                    TreeSet<Book> sortedByName = new TreeSet<>(new Book.AuthorNameComparator());
                    BookUtil.createTreeSet(numberOfBooks, sortedByName);
                    BookUtil.printCollection(sortedByName);

                    System.out.print("\nBooks are sorted by author's patronymic:");
                    TreeSet<Book> sortedByPatronymic = new TreeSet<>(new Book.AuthorPatronymicComparator());
                    BookUtil.createTreeSet(numberOfBooks, sortedByPatronymic);
                    BookUtil.printCollection(sortedByPatronymic);

                    System.out.print("\nBooks are sorted by a publication year:");
                    TreeSet<Book> sortedByPublicationYear = new TreeSet<>(new Book.PublicationYearComparator());
                    BookUtil.createTreeSet(numberOfBooks, sortedByPublicationYear);
                    BookUtil.printCollection(sortedByPublicationYear);


                    break;
                case 4:
                    /*
                    Создать экземпляр класса TreeSet, поместить в него объекты класса Student (надо его спроектировать).
                    Вывести на экран информацию о каждом чётном в списке студенте, каждого нечётного студента удалить из коллекции.
                     */

                    int numberOfStudents = 10;

                    TreeSet<Student> studentTreeSet = StudentUtil.generateTreeSet(numberOfStudents);
                    StudentUtil.printCollection(studentTreeSet);

                    studentTreeSet = StudentUtil.removeUnevenStudents(studentTreeSet);
                    System.out.println("\nAll uneven students have been removed...");
                    StudentUtil.printCollection(studentTreeSet);

                    break;
                case 5:

                    /*
                    Дан класс User. Необходимо сгенерировать объекты класса User,
                    заполнить все поля и список друзей List<User> friends другими объектами класса User.
                    Вывести список имен друзей, друзей друзей и так далее для пользователя до 5 уровня вложенности.
                     */

                    long id = 1;
                    String myName = "Evgeni";
                    String mySurname = "Dayker";
                    int numberOfFriends = 2;
                    ArrayList<User> friends = UserUtil.generateListOfFriends(numberOfFriends);

                    User me = new User(id, myName, mySurname, friends);

                    int numberOfFriendLevels = 5;
                    UserUtil.generateFriendsOfFriends(me.getFriends(), numberOfFriends, numberOfFriendLevels);

                    System.out.print(me.getName() + " " + me.getSurname());
                    UserUtil.printFriends(me.getFriends());

                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Incorrect input! Try again.");
            }
        }
    }
}

