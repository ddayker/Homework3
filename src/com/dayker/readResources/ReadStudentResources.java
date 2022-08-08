package com.dayker.readResources;

import com.dayker.domain.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadStudentResources {

    public ArrayList<Student> readStudentToArrayList(String fileName) {

        // Getting ClassLoader
        ClassLoader classLoader = this.getClass().getClassLoader();

        // Getting resource file from class loader
        File file = new File(classLoader.getResource(fileName).getFile());

        ArrayList<Student> studentArrayList = new ArrayList<>();

        String surname;
        int surnameIndex = 0;

        String name;
        int nameIndex = 1;

        String patronymic;
        int patronymicIndex = 2;

        int age;
        int ageIndex = 3;

        int year;
        int yearIndex = 4;

        double GPA;
        int GPAIndex = 5;

        int numberOfFields = 6;

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
                    patronymic = words[patronymicIndex];

                    try {
                        age = Integer.parseInt(words[ageIndex]);
                        year = Integer.parseInt(words[yearIndex]);
                        GPA = Double.parseDouble(words[GPAIndex]);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid data line №" + lineNumber + " (incorrect number data) in the resource file \"" + fileName + "\".");
                        continue;
                    }

                }

                studentArrayList.add(new Student(name, surname, patronymic, age, year, GPA));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return studentArrayList;
    }
}


