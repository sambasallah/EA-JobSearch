package edu.miu.cs544.samba.finalproject.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Technical")
public class TechnicalInterview extends Interview{

    private int durationInMinutes;
    private Location location;
    private String questions;

    public TechnicalInterview() {
    }

    public TechnicalInterview(int durationInMinutes, Location location, String questions, LocalDate date, String phone, String email) {
        super.setDate(date);
        super.setEmail(email);
        super.setPhoneNumber(phone);
        this.durationInMinutes = durationInMinutes;
        this.location = location;
        this.questions = questions;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }


}
