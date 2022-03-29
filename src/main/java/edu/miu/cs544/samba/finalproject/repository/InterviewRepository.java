package edu.miu.cs544.samba.finalproject.repository;

import edu.miu.cs544.samba.finalproject.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    @Query("SELECT interview FROM Interview interview WHERE interview.date BETWEEN ?1 AND ?1")
    public List<Interview> getAllInterviewsBetween(LocalDate startDate, LocalDate endDate);
}
