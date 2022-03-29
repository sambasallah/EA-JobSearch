package edu.miu.cs544.samba.finalproject.repository;

import edu.miu.cs544.samba.finalproject.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
