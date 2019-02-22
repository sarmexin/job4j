package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(TrackerSQL.class);
    private Connection connection;

    public boolean init() {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String username = "postgres";
        String password = "322132";
        //Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
//        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
//            Properties config = new Properties();
//            config.load(in);
//            Class.forName(config.getProperty("driver-class-name"));
//            this.connection = DriverManager.getConnection(
//                    config.getProperty("jdbc:postgresql://localhost:5432/tracker"),
//                    config.getProperty("postgres"),
//                    config.getProperty("322132")
//            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection != null;
    }

    @Override
    public Item add(Item item) {
        System.out.println("перед");
        this.init();
        System.out.println("после");
        try {
            System.out.println("запрос ушёл 1" + connection);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO application(name, descc) values(?, ?)");
            statement.setString(1, "Заявка 1");
            statement.setString(2, "1111");
            statement.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
return true;
    }

    @Override
    public boolean delete(String id) {
return true;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public List<Item> findAll() {
        return null;
    }
}