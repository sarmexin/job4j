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
        System.out.println("key  " + key);
        this.init();
        List<Item> list = new ArrayList<Item>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from application where name=?");
            statement.setString(1, key);
            ResultSet resultSet = statement.executeQuery ();
            System.out.println(">>>" + resultSet.getString("name"));
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("name"), resultSet.getString("descc"), String.format("%s", resultSet.getTimestamp("created")));
                item.setId(String.valueOf(resultSet.getInt("id")));
                list.add(item);
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
        this.init();
        Item item = null;
        System.out.println(id);
        try {
            PreparedStatement statement = connection.prepareStatement("select * from application where id=?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery ();
            System.out.println(resultSet.getString("name"));
            System.out.println(">>>" + resultSet.getString("name"));
            while (resultSet.next()) {
                item = new Item(resultSet.getString("name"), resultSet.getString("descc"), String.format("%s", resultSet.getTimestamp("created")));
                item.setId(String.valueOf(resultSet.getInt("id")));
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
        System.out.println(item.getName());
        return item;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public List<Item> findAll() {  //работает
        this.init();
        List<Item> list = new ArrayList<Item>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery ("select * from application;");
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("name"), resultSet.getString("descc"), String.format("%s", resultSet.getTimestamp("created")));
                item.setId(String.valueOf(resultSet.getInt("id")));
                list.add(item);
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
}