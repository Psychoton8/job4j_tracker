package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Computer is working " + active);
        System.out.println("Computer status is " + status);
        System.out.println("Computer is " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 5, "working good");
        error.printInfo();
        System.out.println();
        Error noWork = new Error(false, 0, "not working");
        noWork.printInfo();
    }
}
