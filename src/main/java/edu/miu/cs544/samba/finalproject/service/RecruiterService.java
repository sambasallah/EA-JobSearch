package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.entity.Recruiter;
import edu.miu.cs544.samba.finalproject.repository.RecruiterRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public List<Company> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    public SuccessResponse createRecruiter(Recruiter recruiter) {
        recruiterRepository.save(recruiter);
        return UtilFunctions.handleSuccessResponse(true, "Recruiter Created!");
    }


    public Company getOneRecruiter(Long id) {
        return recruiterRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("Recruiter with id " + id + " not found!");
        });

    }

    public SuccessResponse updateRecruiter(Recruiter recruiter, Long id) {
        Company recruiter1 = getOneRecruiter(id);
        recruiter1.setName(recruiter.getName());
        recruiter1.setAddress(recruiter.getAddress());
        recruiter1.setJobs(recruiter.getJobs());
        recruiterRepository.save(recruiter1);
        return UtilFunctions.handleSuccessResponse(true, "Recruiter Updated!");

    }

    public SuccessResponse deleteRecruiter(Long id) {
        Company recruiter = getOneRecruiter(id);
        recruiterRepository.delete(recruiter);
        return UtilFunctions.handleSuccessResponse(true, "Recruiter with id " + id + " deleted!");
    }
}


