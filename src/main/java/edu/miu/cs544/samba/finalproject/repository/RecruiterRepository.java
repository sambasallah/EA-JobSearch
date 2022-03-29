package edu.miu.cs544.samba.finalproject.repository;

import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Company, Long> {
}
