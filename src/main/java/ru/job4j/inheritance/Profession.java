package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Profession() {
    }

    public class Engineer extends Profession {
        public Engineer(String name, String surname, String education, String birthday) {
            super(name, surname, education, birthday);
        }

        private String design;

        public Engineer(String design) {
            super();
            this.design = design;
        }

        public Engineer() {
        }
    }

    public class Doctor extends Profession {
        public Doctor(String name, String surname, String education, String birthday) {
            super(name, surname, education, birthday);
        }

        private String diagnosis;

        public Doctor(String diagnosis) {
            super();
            this.diagnosis = diagnosis;
        }

        public Doctor() {
        }
    }

    public class Programmer extends Engineer {
        public Programmer(String name, String surname, String education, String birthday) {
            super(name, surname, education, birthday);
        }

        private String code;

        public Programmer(String code, String design) {
            super();
            this.code = code;
        }
    }

    public class Builder extends Engineer {
        public Builder(String name, String surname, String education, String birthday) {
            super(name, surname, education, birthday);
        }

        private int score;

        public Builder(int score, String design) {
            super();
            this.score = score;
        }
    }

    public class Surgeon extends Doctor {
        public Surgeon(String name, String surname, String education, String birthday) {
            super(name, surname, education, birthday);
        }

        private String surgery;

        public Surgeon(String surgery, String diagnosis) {
            super();
            this.surgery = surgery;
        }

    }

    public class Dentist extends Doctor {
        public Dentist(String name, String surname, String education, String birthday) {
            super(name, surname, education, birthday);
        }

        private String tooth;

        public Dentist(String tooth, String diagnosis) {
            super();
            this.tooth = tooth;
        }
    }
}
