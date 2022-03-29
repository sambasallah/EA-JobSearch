package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Skill;
import edu.miu.cs544.samba.finalproject.repository.SkillRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public SuccessResponse createSkill(Skill skill) {
        skillRepository.save(skill);
        return UtilFunctions.handleSuccessResponse(true, "Skill Created!");
    }


    public Skill getOneSkill(Long id) {
        return skillRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("Skill with id " + id + " not found!");
        });

    }

    public SuccessResponse updateSkill(Skill skill, Long id) {
        Skill skillToUpdate = getOneSkill(id);
        skillToUpdate.setName(skill.getName());
        skillToUpdate.setDescription(skill.getDescription());
        skillToUpdate.setExperience(skill.getExperience());
        skillToUpdate.setLanguage(skill.getLanguage());

        skillRepository.save(skillToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "Skill Updated!");

    }

    public SuccessResponse deleteSkill(Skill skill) {
        skillRepository.delete(skill);
        return UtilFunctions.handleSuccessResponse(true, "Skill with id " + skill.getId() + " deleted!");
    }
}
