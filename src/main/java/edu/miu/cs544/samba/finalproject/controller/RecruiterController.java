package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Application;
import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.entity.Recruiter;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/recruiters")
    public List<Company> all() {
        return recruiterService.getAllRecruiters();
    }

    @GetMapping("/recruiters/{id}")
    public Company one(@PathVariable Long id) {
        return recruiterService.getOneRecruiter(id);
    }

    @PostMapping("/recruiters")
    public SuccessResponse newRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterService.createRecruiter(recruiter);
    }

    @PutMapping("/recruiters/{id}")
    public SuccessResponse updateCompany(@RequestBody Recruiter recruiter, @PathVariable Long id) {
        return recruiterService.updateRecruiter(recruiter,id);
    }

    @DeleteMapping("/recruiters/{id}")
    public SuccessResponse deleteJob(@PathVariable Long id) {
        return recruiterService.deleteRecruiter(id);
    }
}
