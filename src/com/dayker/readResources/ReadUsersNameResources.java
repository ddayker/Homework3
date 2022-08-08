package com.dayker.readResources;

import com.dayker.domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadUsersNameResources {

    public ArrayList<User> readUsersToArrayList(String fileName) {

        // Getting ClassLoader
        ClassLoader classLoader = this.getClass().getClassLoader();

        // Getting resource file from class loader
        File file = new File(classLoader.getResource(fileName).getFile());

        ArrayList<User> usersArrayList = new ArrayList<>();

        String name;
        int nameIndex = 0;

        String surname;
        int surnameIndex = 1;

        int numberOfFields = 2;

        try {
            Scanner scanner = new Scanner(file);
            for (int lineNumber = 1; scanner.hasNextLine(); lineNumber++) {

                String line = scanner.nextLine();
                String[] words = line.split(",");

                if (words.length != (numberOfFields)) { //if there are fewer words than the fields of the Student class, the data is incorrect.

                    System.out.println("Invalid data line №" + lineNumber + " in the resource file \"" + fileName + "\".");
                    continue;

                } else {

                    name = words[nameIndex];
                    surname = words[surnameIndex];

                }

                usersArrayList.add(new User(name, surname));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return usersArrayList;
    }
}
