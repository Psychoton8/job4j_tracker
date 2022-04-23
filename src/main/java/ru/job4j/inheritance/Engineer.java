package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String design;

    public Engineer() {
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Engineer(String design) {
        super();
        this.design = design;
    }
}
