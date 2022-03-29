package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.entity.ScreeningInterview;
import edu.miu.cs544.samba.finalproject.entity.TechnicalInterview;
import edu.miu.cs544.samba.finalproject.repository.ScreeningInterviewRepository;
import edu.miu.cs544.samba.finalproject.repository.TechnicalInterviewRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalInterviewService {

    @Autowired
    private TechnicalInterviewRepository technicalInterviewRepository;

    public List<Interview> getAllTechnicalInterviews() {
        return technicalInterviewRepository.findAll();
    }

    public SuccessResponse createTechnicalInterview(TechnicalInterview technicalInterview) {
        technicalInterviewRepository.save(technicalInterview);
        return UtilFunctions.handleSuccessResponse(true, "TechnicalInterview Created!");
    }


    public Interview getOneTechnicalInterview(Long id) {
        return technicalInterviewRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("TechnicalInterview with id " + id + " not found!");
        });

    }

    public SuccessResponse updateTechnicalInterview(TechnicalInterview technicalInterview, Long id) {
        Interview techincalInterviewToUpdate = getOneTechnicalInterview(id);
        techincalInterviewToUpdate.setDate(technicalInterview.getDate());
        techincalInterviewToUpdate.setEmail(technicalInterview.getEmail());
        techincalInterviewToUpdate.setPhoneNumber(technicalInterview.getPhoneNumber());

        technicalInterviewRepository.save(techincalInterviewToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "TechnicalInterview Updated!");

    }

    public SuccessResponse deleteTechnicalInterview(Long id) {
        Interview technicalInterview = getOneTechnicalInterview(id);
        technicalInterviewRepository.delete(technicalInterview);
        return UtilFunctions.handleSuccessResponse(true, "TechnicalInterview with id " + id + " deleted!");
    }
}


