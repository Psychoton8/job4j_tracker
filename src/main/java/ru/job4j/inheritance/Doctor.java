package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String diagnosis;

    public Doctor() {
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Doctor(String diagnosis) {
        super();
        this.diagnosis = diagnosis;
    }
}
