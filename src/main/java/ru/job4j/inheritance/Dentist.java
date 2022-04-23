package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String tooth;

    public String getTooth() {
        return tooth;
    }

    public void setTooth(String tooth) {
        this.tooth = tooth;
    }

    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Dentist(String tooth, String diagnosis) {
        super();
        this.tooth = tooth;
    }
}
