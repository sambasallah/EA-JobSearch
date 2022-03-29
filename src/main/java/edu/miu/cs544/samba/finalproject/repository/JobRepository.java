package edu.miu.cs544.samba.finalproject.repository;

import edu.miu.cs544.samba.finalproject.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

    public List<Job> getAllJobsInIOWA();

    public List<Job> findByState(String state);

}
