package NewProjects;

public class Client {
    private String name;
    private String surname;
    private int passport;


    public Client(String name, String surname, int passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPassport() {
        return passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    }
