package ru.job4j.different;

public class Profession {
    String name;
    String profession;
}

class Doctor extends Profession {
    public void treat(Patient name) {
    }
}

class Patient {
    String name;
}

class Engineer extends Profession {
    public void build(House house) {
    }
}

class House {
}

class Teacher extends Profession {
    public void learn() {
    }
}