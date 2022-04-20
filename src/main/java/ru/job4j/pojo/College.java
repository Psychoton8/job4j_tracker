package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup("Porcupines");
        student.setDate("14.11.2021");

        System.out.println(student.getName() + System.lineSeparator() + student.getGroup() + System.lineSeparator() + student.getDate());
    }
}
