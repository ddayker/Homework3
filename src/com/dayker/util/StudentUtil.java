package com.dayker.util;

import com.dayker.domain.Student;
import com.dayker.readResources.ReadStudentResources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import static java.lang.Math.random;

public class StudentUtil {

    public static void printCollection(Collection<Student> studentsSet) {
        {
            //output List of Book in the form of a table

            int num = 1;
            System.out.println("\n|№ |                    Name                | Age | Year |  GPA |");
            for (Student students : studentsSet) {
                System.out.printf("|%2d| %10s   %10s   %12s | %3d |  %2d  | %4.1f |\n",
                        num, students.getSurname(), students.getName(), students.getPatronymic(),
                        students.getAge(), students.getYear(), students.getGPA());
                num++;
            }
        }
    }

    public static TreeSet<Student> generateTreeSet(int numOfStudents) {

        String resourceFileName = "studentsInfo.txt";
        ReadStudentResources readStudentResources = new ReadStudentResources();

        ArrayList<Student> allStudents = readStudentResources.readStudentToArrayList(resourceFileName);
        TreeSet<Student> studentTreeSet = new TreeSet<>();

        for (int i = 0; i < numOfStudents; i++) {
            Student newStudent = allStudents.get((int) (random() * allStudents.size()));
            studentTreeSet.add(newStudent);

        }
        return studentTreeSet;


    }

    public static TreeSet<Student> removeUnevenStudents(TreeSet<Student> studentTreeSet) {

        TreeSet<Student> newStudentsTreeSet = new TreeSet<>();

        int num = 1;
        int divider = 2;
        int remainderOfEven = 0;

        for (Student student : studentTreeSet) {
            if (num % divider == remainderOfEven) {
                newStudentsTreeSet.add(student);
            }
            num++;
        }
        return newStudentsTreeSet;
    }
}
