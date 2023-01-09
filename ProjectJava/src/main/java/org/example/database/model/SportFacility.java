package org.example.database.model;

import com.opencsv.bean.CsvBindByPosition;

public class SportFacility {
    @CsvBindByPosition(position = 0)
    private Integer number;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String subject;
    @CsvBindByPosition(position = 3)
    private String address;
    @CsvBindByPosition(position = 4)
    private String date;


    public SportFacility() {
    }

    public SportFacility(Integer number, String name, String subject, String address, String date) {
        this.number = number;
        this.name = name;
        this.subject = subject;
        this.address = address;
        this.date = date;
    }

    public Integer getNumber() {

        return number;
    }

    public void setNumber(Integer number) {

        this.number = number;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {

        this.subject = subject;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SportObject{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
