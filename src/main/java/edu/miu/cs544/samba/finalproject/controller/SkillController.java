package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Address;
import edu.miu.cs544.samba.finalproject.entity.Job;
import edu.miu.cs544.samba.finalproject.entity.Skill;
import edu.miu.cs544.samba.finalproject.jms.Sender;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.JobService;
import edu.miu.cs544.samba.finalproject.service.SkillService;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class SkillController {

    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;


    @GetMapping("/jobs/{id}/skills")
    public List<Skill> getAllJobSkills(@PathVariable Long id) {
        return jobService.getOneJob(id).getSkills();
    }

    @PostMapping("/jobs/{id}/skills")
    public SuccessResponse newSkill(@RequestBody Skill skill, @PathVariable Long id) {
        jobService.getOneJob(id).setSkill(skill);
        Job job = jobService.getOneJob(id);
        return  jobService.updateJob(job);
    }

    @PutMapping("/jobs/{id}/skills")
    public SuccessResponse updateSkill(@RequestBody Skill skill, @PathVariable Long id) {
        return skillService.updateSkill(skill,skillService.getOneSkill(id).getId());
    }

    @DeleteMapping("/jobs/{id}/skills/{skill_id}")
    public SuccessResponse deleteSkill(@PathVariable Long id, @PathVariable Long skill_id) {
        return skillService.deleteSkill(jobService.getOneJob(id).getSkills().stream().filter(s -> s.getId() == skill_id).collect(Collectors.toList()).get(0));
    }
}
