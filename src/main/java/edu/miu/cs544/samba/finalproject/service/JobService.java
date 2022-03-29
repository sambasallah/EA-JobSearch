package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Job;
import edu.miu.cs544.samba.finalproject.exception.ResourceNotFoundException;
import edu.miu.cs544.samba.finalproject.repository.JobRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public SuccessResponse createJob(Job job) {
        jobRepository.save(job);
        return new SuccessResponse(true,"Job Created!");
    }

    public List<Job> getAllJobsInIOWA() {
        return jobRepository.getAllJobsInIOWA();
    }

    public List<Job> getAllJobsByState(String state) {
        return jobRepository.findByState(state);
    }


    public Job getOneJob(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Job With " + id + " Not Found!");
        });
    }

    public SuccessResponse updateJob(Job job, Long id) {
        Job jobToUpdate = jobRepository.getById(id);
        jobToUpdate.setSalary(job.getSalary());
        jobToUpdate.setTitle(job.getTitle());
        jobRepository.save(jobToUpdate);

        return new SuccessResponse(true, "Job Updated!");

    }

    public SuccessResponse updateJob(Job job) {
        jobRepository.save(job);
        return new SuccessResponse(true, "Job Updated!");

    }

    public SuccessResponse deleteJob(Long id) {
        jobRepository.deleteById(id);
        return new SuccessResponse(true,"Job Deleted!");
    }

}
