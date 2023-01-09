package org.example.database;

import org.example.database.model.SportFacility;

import java.sql.*;

public class SqlConnection {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public SqlConnection(String databaseName) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", databaseName));
    }

    public void insertSportObject(SportFacility sportFacility) {
        try {
            statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO 'sport_object' ('number', 'name','subject','address','date') VALUES (%d, '%s','%s','%s','%s');", sportFacility.getNumber()
                    , sportFacility.getName()
                    , sportFacility.getSubject()
                    , sportFacility.getAddress()
                    , sportFacility.getDate()));
        } catch (SQLException e) {

        }
    }

    public void close() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }


    public void task1() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT AVG(number) FROM sport_object;");
        System.out.println("Среднее количество регионов спорта:");
        while (resultSet.next()) {
            int avg = resultSet.getInt(1);
            System.out.printf("%d\n", avg);
        }
    }

    public void task2() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT subject,COUNT(number) FROM sport_object GROUP BY subject ORDER BY COUNT(number) DESC LIMIT 3;");
        System.out.println("Регион Количество обьектов спорта");
        while (resultSet.next()) {
            String subject = resultSet.getString(1);
            int count = resultSet.getInt(2);
            System.out.printf("%s %d\n", subject, count);
        }
    }

    public void createTables() throws SQLException {
        statement = connection.createStatement();
        statement.execute("CREATE TABLE if not exists 'sport_object' ('number' INTEGER PRIMARY KEY , 'name' text, 'subject' text, 'address' text, 'date' text);");
        System.out.println("Таблица создана или уже существует.");
    }
}

