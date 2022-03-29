package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Application;
import edu.miu.cs544.samba.finalproject.entity.Client;
import edu.miu.cs544.samba.finalproject.repository.ApplicationRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public SuccessResponse createApplication(Application application) {
        applicationRepository.save(application);
        return UtilFunctions.handleSuccessResponse(true, "Application Created!");
    }


    public Application getOneApplication(Long id) {
        return applicationRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("Application with id " + id + " not found!");
        });

    }

    public SuccessResponse updateApplication(Application application, Long id) {
        Application application1 = getOneApplication(id);
        application1.setResumeVersion(application.getResumeVersion());
        application1.setDate(application.getDate());
        application1.setJob(application.getJob());
        applicationRepository.save(application1);
        return UtilFunctions.handleSuccessResponse(true, "Application Updated!");

    }

    public SuccessResponse deleteApplication(Long id) {
        Application application = getOneApplication(id);
        applicationRepository.delete(application);
        return UtilFunctions.handleSuccessResponse(true, "Application with id " + id + " deleted!");
    }
}


