package ru.job4j.different;

public class Profession {
    private String name;
    private String profession;
}

class Doctor extends Profession {
    public void treat(Patient name) {
    }
}

class Patient {
    private String name;
}

class Engineer extends Profession {
    void build(House house) {
    }
}

class House {
}

class Teacher extends Profession {
    public void learn() {
    }
}