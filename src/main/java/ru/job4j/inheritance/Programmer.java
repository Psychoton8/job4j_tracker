package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Programmer(String code, String design) {
        super();
        this.code = code;
    }
}
