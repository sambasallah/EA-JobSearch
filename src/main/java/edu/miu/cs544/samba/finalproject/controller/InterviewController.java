package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/interviews/start/end")
    public List<Interview> getAllInterviews(@PathVariable LocalDate start, @PathVariable LocalDate end) {
        return interviewService.getAllInterviewsBetween(start,end);
    }

}
