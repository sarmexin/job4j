package ru.job4j.tracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(TrackerSQL.class);
    private Connection connection;

    public boolean init() {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String username = "postgres";
        String password = "322132";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection != null;
    }

    @Override
    public Item add(Item item) {
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
        this.init();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE application SET descc=? where id=?");
            statement.setString(1, item.getDescription());
            statement.setInt(2, Integer.parseInt(id));
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
    public boolean delete(String id) {
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
            ResultSet resultSet = statement.executeQuery();
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from application where id=?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
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
        return item;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public List<Item> findAll() {
        this.init();
        List<Item> list = new ArrayList<Item>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from application;");
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