package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Address;
import edu.miu.cs544.samba.finalproject.entity.HiringManagerInterview;
import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.AddressService;
import edu.miu.cs544.samba.finalproject.service.HiringManagerInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HiringManagerInterviewController {

    @Autowired
    private HiringManagerInterviewService hiringManagerInterviewService;

    @GetMapping("/hiring-manager-interviews")
    public List<Interview> all() {
        return hiringManagerInterviewService.getAllHiringManagerInterviews();
    }

    @GetMapping("/hiring-manager-interviews/{id}")
    public Interview one(@PathVariable Long id) {
        return hiringManagerInterviewService.getOneHiringManagerInterview(id);
    }

    @PostMapping("/hiring-manager-interviews")
    public SuccessResponse newHiringManagerInterview(@RequestBody HiringManagerInterview hiringManagerInterview) {
        return hiringManagerInterviewService.createHiringManagerInterview(hiringManagerInterview);
    }

    @PutMapping("/hiring-manager-interviews/{id}")
    public SuccessResponse updateHiringManagerInterview(@RequestBody HiringManagerInterview hiringManagerInterview, @PathVariable Long id) {
        return hiringManagerInterviewService.updateHiringManagerInterview(hiringManagerInterview,id);
    }

    @DeleteMapping("/hiring-manager-interviews/{id}")
    public SuccessResponse deleteHiringManagerInterview(@PathVariable Long id) {
        return hiringManagerInterviewService.deleteHiringManagerInterview(id);
    }
}
