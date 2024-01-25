package com.pravar.blacklightspringboot.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "leaderboard")
public class User {
    @Id
    @Column(name = "UID")
    private String UID;

    @Column(name = "name")
    private String Name;

    @Column(name = "score")
    private Integer Score;

    @Column(name = "country")
    private String Country;

    @Column(name = "timeStamp")
    private Timestamp TimeStamp;

    public User() {

    }

    // getters and setters


    public User(String UID, String name, Integer score, String country, Timestamp timeStamp) {
        this.UID = UID;
        Name = name;
        Score = score;
        Country = country;
        TimeStamp = timeStamp;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Timestamp getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        TimeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "UID='" + UID + '\'' +
                ", Name='" + Name + '\'' +
                ", Score=" + Score +
                ", Country='" + Country + '\'' +
                ", TimeStamp=" + TimeStamp +
                '}';
    }
}
