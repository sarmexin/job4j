package NewProjects;

import java.sql.*;

public class WorkSql {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/rent";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    Connection connection = null;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    public void createTableClient() {
        final String SQL = "CREATE TABLE client (" + " id serial primary key, " + " name VARCHAR(50)," + " surname varchar(50), " + "passport varchar(50)" + ")";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }


    public void viewingTableCars() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
            while(resultSet.next()){
                System.out.println((String.format("%s %s %s %s",resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("color"), resultSet.getInt("year"))));
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

    public void addCars(String name, String color, int year) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cars(name, color, year) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, color);
            preparedStatement.setInt(3, year);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
    public void viewForColorCars(String color) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars WHERE color IN (?) ");
            preparedStatement.setString(1, color);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println((String.format("%s %s %s",resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("year"))));
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
    public void statistic(){
        System.out.println("Предпоследний из самого свежий атвомобиль");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(year) FROM cars WHERE year NOT IN (SELECT MAX(year) FROM cars);");
            while(resultSet.next()) {
                System.out.println((String.format("%s",resultSet.getRow())));
            }
            resultSet.close();
        } catch (Exception e) {
        System.out.println("Ошибка");
    }
    }

}

