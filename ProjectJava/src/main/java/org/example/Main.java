package org.example;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.database.SqlConnection;
import org.example.database.model.SportFacility;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
        SqlConnection sqliteConnection = new SqlConnection("database.sqlite");
        sqliteConnection.createTables();
        List<SportFacility> sportFacilities = readCsv("Объекты спорта.csv");

        for (SportFacility sportFacility : sportFacilities) {
            sqliteConnection.insertSportObject(sportFacility);
            System.out.println(sportFacility);
        }
        sqliteConnection.task1();
        sqliteConnection.task2();

    }
    public static List<SportFacility> readCsv(String fileName) throws FileNotFoundException {
        return (List<SportFacility>) new CsvToBeanBuilder(new FileReader(fileName)).withSkipLines(1).withType(SportFacility.class).build().parse();
    }

}