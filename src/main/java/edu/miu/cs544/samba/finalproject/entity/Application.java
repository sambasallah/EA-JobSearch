package edu.miu.cs544.samba.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Application implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private LocalDate date;
    private int resumeVersion;
    @JsonBackReference
    @JsonIgnoreProperties("application")
    @OneToOne(mappedBy = "application", cascade = CascadeType.PERSIST)
    private Job job;

    public Application() {
    }

    public Application(LocalDate date, int resumeVersion) {
        this.date = date;
        this.resumeVersion = resumeVersion;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
           this.job = job;
           job.setApplication(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(int resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", date=" + date +
                ", resumeVersion=" + resumeVersion +
                '}';
    }
}