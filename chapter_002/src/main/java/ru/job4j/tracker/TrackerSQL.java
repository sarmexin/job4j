package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection != null;
    }

    @Override
    public Item add(Item item) { //работает
        this.init();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO application(name, descc, created) values(?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
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
    public boolean delete(String id) {  //работает
        this.init();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM application WHERE id=?");
            statement.setInt(1, Integer.parseInt(id));
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
return true;
    }

    @Override
    public List<Item> findByName(String key) {
        this.init();
        List<Item> list = new ArrayList<Item>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from application where name=?");
            statement.setString(1, key);
            ResultSet resultSet = statement.executeQuery ();
            System.out.println(">>>" + resultSet.getString("name"));
           // statement.executeUpdate();
           // List<Item> list = new ArrayList<Item>();
            while (resultSet.next()) {
                list.add((Item) resultSet);
                System.out.println("+" + list);
            }
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
        return list;
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