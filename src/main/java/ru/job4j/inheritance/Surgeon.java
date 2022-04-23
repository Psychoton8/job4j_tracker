package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String surgery;

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon(String surgery, String diagnosis) {
        super();
        this.surgery = surgery;
    }
}
