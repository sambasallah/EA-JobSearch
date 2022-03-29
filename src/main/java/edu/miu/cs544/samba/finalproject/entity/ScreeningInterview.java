package edu.miu.cs544.samba.finalproject.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Screening")
public class ScreeningInterview extends Interview{

    private String name;
    private String result;

    public ScreeningInterview() {
    }

    public ScreeningInterview(String name, String result, LocalDate date, String phone, String email) {
        super.setDate(date);
        super.setEmail(email);
        super.setPhoneNumber(phone);
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
