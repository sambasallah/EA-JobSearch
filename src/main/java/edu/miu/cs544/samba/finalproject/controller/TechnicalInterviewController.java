package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.entity.ScreeningInterview;
import edu.miu.cs544.samba.finalproject.entity.TechnicalInterview;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.ScreeningInterviewService;
import edu.miu.cs544.samba.finalproject.service.TechnicalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TechnicalInterviewController {

    @Autowired
    private TechnicalInterviewService technicalInterviewService;

    @GetMapping("/technical-interviews")
    public List<Interview> all() {
        return technicalInterviewService.getAllTechnicalInterviews();
    }

    @GetMapping("/technical-interviews/{id}")
    public Interview one(@PathVariable Long id) {
        return technicalInterviewService.getOneTechnicalInterview(id);
    }

    @PostMapping("/technical-interviews")
    public SuccessResponse newTechnicalInterview(@RequestBody TechnicalInterview technicalInterview) {
        return technicalInterviewService.createTechnicalInterview(technicalInterview);
    }

    @PutMapping("/technical-interview/{id}")
    public SuccessResponse updateTechnicalInterview(@RequestBody TechnicalInterview technicalInterview, @PathVariable Long id) {
        return technicalInterviewService.updateTechnicalInterview(technicalInterview,id);
    }

    @DeleteMapping("/screening-interview/{id}")
    public SuccessResponse deleteTechnicalInterview(@PathVariable Long id) {
        return technicalInterviewService.deleteTechnicalInterview(id);
    }
}
