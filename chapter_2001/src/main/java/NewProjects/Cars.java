package NewProjects;

public class Cars {
    private final String name;
    private final String color;
    private final int year;

    public Cars(String name, String color, int year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Name: " + name + "Color: " + color + "Year: " + year;
    }

}
