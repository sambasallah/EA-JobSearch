package edu.miu.cs544.samba.finalproject.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Hiring")
public class HiringManagerInterview extends Interview{

    private int teamSize;
    private LocalDate startDate;

    public HiringManagerInterview() {
    }

    public HiringManagerInterview(int teamSize, LocalDate startDate,LocalDate date, String phone, String email) {
        super.setDate(date);
        super.setPhoneNumber(phone);
        super.setEmail(email);
        this.teamSize = teamSize;
        this.startDate = startDate;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
