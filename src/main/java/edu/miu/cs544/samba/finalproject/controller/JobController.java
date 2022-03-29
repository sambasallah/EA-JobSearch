package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Job;
import edu.miu.cs544.samba.finalproject.jms.Sender;
import edu.miu.cs544.samba.finalproject.service.JobService;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobController {


    @Autowired
    private JobService jobManager;
    @Autowired
    private Sender sender;

    @GetMapping("/jobs")
    public List<Job> all() {
        return jobManager.getAllJobs();
    }

    @GetMapping("/jobs/in/iowa")
    public List<Job> getAllJobsInIOWA() {
        return jobManager.getAllJobsInIOWA();
    }

    @GetMapping("/jobs/by/state/{state}")
    public List<Job> getJobByState(@PathVariable String state) {
        return jobManager.getAllJobsByState(state);
    }

    @GetMapping("/jobs/{id}")
    public Job one(@PathVariable Long id) {
        return jobManager.getOneJob(id);
    }

    @PostMapping("/jobs")
    public SuccessResponse newJob(@Valid @RequestBody Job job) {
        sender.send(job);
        return UtilFunctions.handleSuccessResponse(true, "Job Created!");
    }

    @PutMapping("/jobs/{id}")
    public SuccessResponse updateJob(@Valid @RequestBody Job job, @PathVariable Long id) {
        return jobManager.updateJob(job,id);
    }

    @DeleteMapping("/jobs/{id}")
    public SuccessResponse deleteJob(@PathVariable Long id) {
       return jobManager.deleteJob(id);
    }
}
