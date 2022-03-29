package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.HiringManagerInterview;
import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.entity.ScreeningInterview;
import edu.miu.cs544.samba.finalproject.repository.HiringManagerInterviewRepository;
import edu.miu.cs544.samba.finalproject.repository.ScreeningInterviewRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningInterviewService {

    @Autowired
    private ScreeningInterviewRepository screeningInterviewRepository;

    public List<Interview> getAllScreeningInterviews() {
        return screeningInterviewRepository.findAll();
    }

    public SuccessResponse createScreeningInterview(ScreeningInterview screeningInterview) {
        screeningInterviewRepository.save(screeningInterview);
        return UtilFunctions.handleSuccessResponse(true, "ScreeningInterview Created!");
    }


    public Interview getOneScreeningInterview(Long id) {
        return screeningInterviewRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("ScreeningInterview with id " + id + " not found!");
        });

    }

    public SuccessResponse updateScreeningInterview(ScreeningInterview screeningInterview, Long id) {
        Interview screeningInterviewToUpdate = getOneScreeningInterview(id);
        screeningInterviewToUpdate.setPhoneNumber(screeningInterview.getPhoneNumber());
        screeningInterviewToUpdate.setEmail(screeningInterview.getEmail());
        screeningInterviewToUpdate.setDate(screeningInterview.getDate());

        screeningInterviewRepository.save(screeningInterviewToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "ScreeningInterview Updated!");

    }

    public SuccessResponse deleteScreeningInterview(Long id) {
        Interview screeningInterview = getOneScreeningInterview(id);
        screeningInterviewRepository.delete(screeningInterview);
        return UtilFunctions.handleSuccessResponse(true, "ScreeningInterview with id " + id + " deleted!");
    }
}


