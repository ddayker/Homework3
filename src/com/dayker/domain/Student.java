package com.dayker.domain;

public class Student implements Comparable {

    private String name;

    private String surname;

    private String patronymic;

    private int age;

    private int year;

    private double GPA;

    public Student() {
    }

    public Student(String name, String surname, String patronymic, int age, int year, double GPA) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.year = year;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (year != student.year) return false;
        if (Double.compare(student.GPA, GPA) != 0) return false;
        if (!name.equals(student.name)) return false;
        if (!surname.equals(student.surname)) return false;
        return patronymic.equals(student.patronymic);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + patronymic.hashCode();
        result = 31 * result + age;
        result = 31 * result + year;
        temp = Double.doubleToLongBits(GPA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", year=" + year +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Object other) {

        return this.hashCode() - other.hashCode();
    }
}
