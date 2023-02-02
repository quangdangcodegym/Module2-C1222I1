package com.codegym.oop;

// Quy tắc đặt tên lớp: theo Pascal
public class Student {
    // field: hay còn gọi là thuộc tính: là những đặc điểm đặc tính của đối tượng
    public int id;
    public String name;
    public int age;
    public String address;

    // Phương thức khởi tạo không tham số
    public Student() {
        // int: 0, String: null,
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "id: " + this.id + " name: " + this.name + " age: " + this.age + " address: " + this.address;
    }

    public static void main(String[] args) {
        Student student0 = null;               // có giá trị là NULL
//        System.out.println(student0.getInfo()); // biến student0 là null nên không thể truy cập đến phương thức getInfo()


        student0 = new Student();       // 0x9ABC
        System.out.println(student0.getInfo());

        int a = 5;


        Student student1 = new Student();       // 0x935B
        System.out.println(student1.getInfo());

        Student student2 = new Student(1, "Ngọc Long", 20, "28 NTP");
        System.out.println(student2.getInfo());

        Student student3 = new Student(1, "Sinh Nhật", 31);
        System.out.println(student3.getInfo());

    }
}
