package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book programming = new Book("Clean code", 500);
        Book biology = new Book("Genetics", 488);
        Book chemistry = new Book("Fundamentals of physical chemistry", 1580);
        Book physics = new Book("Electromagnetic field", 750);
        Book[] read = new Book[4];
        read[0] = programming;
        read[1] = biology;
        read[2] = chemistry;
        read[3] = physics;
        System.out.println("Books we have: ");
        for (Book book : read) {
            System.out.println(book.getName() + ", " + book.getPage());
        }

        System.out.println("New list after replacing:");
        Book temp = new Book(programming.getName(), programming.getPage());
        read[0] = read[3];
        read[3] = temp;
        for (Book book : read) {
            System.out.println(book.getName() + ", " + book.getPage());
        }

        System.out.println("All books with the name \"clean code\":");
        for (Book book : read) {
            book.displayBooksByPhrase("clean code");
        }
    }
}

