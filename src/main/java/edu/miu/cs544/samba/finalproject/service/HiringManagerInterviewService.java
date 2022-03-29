package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Address;
import edu.miu.cs544.samba.finalproject.entity.HiringManagerInterview;
import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.repository.AddressRepository;
import edu.miu.cs544.samba.finalproject.repository.HiringManagerInterviewRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringManagerInterviewService {

    @Autowired
    private HiringManagerInterviewRepository hiringManagerInterviewRepository;

    public List<Interview> getAllHiringManagerInterviews() {
        return hiringManagerInterviewRepository.findAll();
    }

    public SuccessResponse createHiringManagerInterview(HiringManagerInterview hiringManagerInterview) {
        hiringManagerInterviewRepository.save(hiringManagerInterview);
        return UtilFunctions.handleSuccessResponse(true, "HiringManagerInterview Created!");
    }


    public Interview getOneHiringManagerInterview(Long id) {
        return hiringManagerInterviewRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("HiringManagerInterview with id " + id + " not found!");
        });

    }

    public SuccessResponse updateHiringManagerInterview(HiringManagerInterview hiringManagerInterview, Long id) {
        Interview hiringManagerInterviewToUpdate = getOneHiringManagerInterview(id);
        hiringManagerInterviewToUpdate.setDate(hiringManagerInterview.getDate());
        hiringManagerInterviewToUpdate.setEmail(hiringManagerInterview.getEmail());
        hiringManagerInterviewToUpdate.setPhoneNumber(hiringManagerInterview.getPhoneNumber());

        hiringManagerInterviewRepository.save(hiringManagerInterviewToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "HiringManagerInterview Updated!");

    }

    public SuccessResponse deleteHiringManagerInterview(Long id) {
        Interview hiringManagerInterview = getOneHiringManagerInterview(id);
        hiringManagerInterviewRepository.delete(hiringManagerInterview);
        return UtilFunctions.handleSuccessResponse(true, "HiringManagerInterview with id " + id + " deleted!");
    }
}


