package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Application;
import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.ApplicationService;
import edu.miu.cs544.samba.finalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs/{id}/applications")
    public Application getAllJobsApplication(@PathVariable Long id) {
        return jobService.getOneJob(id).getApplication();
    }

    @GetMapping("/applications/{id}")
    public Application one(@PathVariable Long id) {
        return applicationService.getOneApplication(id);
    }

    @PostMapping("/applications")
    public SuccessResponse newApplication(@RequestBody Application application) {
        return applicationService.createApplication(application);
    }

    @PutMapping("/applications/{id}")
    public SuccessResponse updateCompany(@RequestBody Application application, @PathVariable Long id) {
        return applicationService.updateApplication(application,id);
    }

    @DeleteMapping("/applications/{id}")
    public SuccessResponse deleteJob(@PathVariable Long id) {
        return applicationService.deleteApplication(id);
    }
}
