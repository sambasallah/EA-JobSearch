package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.HiringManagerInterview;
import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.entity.ScreeningInterview;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.HiringManagerInterviewService;
import edu.miu.cs544.samba.finalproject.service.ScreeningInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScreeningInterviewController {

    @Autowired
    private ScreeningInterviewService screeningInterviewService;

    @GetMapping("/screening-interviews")
    public List<Interview> all() {
        return screeningInterviewService.getAllScreeningInterviews();
    }

    @GetMapping("/screening-interviews/{id}")
    public Interview one(@PathVariable Long id) {
        return screeningInterviewService.getOneScreeningInterview(id);
    }

    @PostMapping("/screening-interviews")
    public SuccessResponse newScreeningInterview(@RequestBody ScreeningInterview screeningInterview) {
        return screeningInterviewService.createScreeningInterview(screeningInterview);
    }

    @PutMapping("/screening-interviews/{id}")
    public SuccessResponse updateScreeningInterview(@RequestBody ScreeningInterview screeningInterview, @PathVariable Long id) {
        return screeningInterviewService.updateScreeningInterview(screeningInterview,id);
    }

    @DeleteMapping("/screening-interviews/{id}")
    public SuccessResponse deleteScreeningInterview(@PathVariable Long id) {
        return screeningInterviewService.deleteScreeningInterview(id);
    }
}
