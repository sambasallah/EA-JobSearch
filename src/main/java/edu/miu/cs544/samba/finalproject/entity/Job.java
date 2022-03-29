package edu.miu.cs544.samba.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="Job.findByState", query = "SELECT j from Job j WHERE j.company.address.state = :state")
@NamedQuery(name="Job.getAllJobsInIOWA", query = "SELECT j from Job j WHERE j.company.address.state = 'IOWA'")
public class Job implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    @NotBlank(message = "Job title is mandatory")
    private String title;
    @Positive(message = "Salary cannot be empty")
    @Min(30000)
    private double salary;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Application application;
    @JsonManagedReference
    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Job() {
    }

    public Job(String title, double salary, Company company) {
        this.title = title;
        this.salary = salary;
        this.company = company;
    }

    public Job(String title, double salary, Application application, Company company) {
        this.title = title;
        this.salary = salary;
        this.application = application;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSkills(List<Skill> skills) {
        for(Skill skill : skills) {
            this.skills.add(skill);
            skill.setJob(this);
        }
    }

    public void setSkill(Skill skill) {
        this.skills.add(skill);
        skill.setJob(this);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                '}';
    }
}