package edu.miu.cs544.samba.finalproject.repository;

import edu.miu.cs544.samba.finalproject.entity.Address;
import edu.miu.cs544.samba.finalproject.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringManagerInterviewRepository extends JpaRepository<Interview, Long> {
}
