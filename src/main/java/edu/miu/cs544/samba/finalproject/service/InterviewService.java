package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.HiringManagerInterview;
import edu.miu.cs544.samba.finalproject.entity.Interview;
import edu.miu.cs544.samba.finalproject.repository.HiringManagerInterviewRepository;
import edu.miu.cs544.samba.finalproject.repository.InterviewRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    public List<Interview> getAllInterviewsBetween(LocalDate startDate, LocalDate endDate) {
        return interviewRepository.getAllInterviewsBetween(startDate, endDate);
    }
}


