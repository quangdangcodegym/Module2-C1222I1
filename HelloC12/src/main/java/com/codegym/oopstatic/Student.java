package com.codegym.oopstatic;

public class Student {
    int rollno;
    String name;

    static String college;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public static String layThongTinTruong() {
        return Student.college;
    }
    public static void main(String[] args) {
        Student s1 = new Student(1, "Quang");
        Student s2 = new Student(2, "Bao");
        Student s3 = new Student(3, "Long");

        System.out.println("Trung tam: " + Student.college);

    }
}
