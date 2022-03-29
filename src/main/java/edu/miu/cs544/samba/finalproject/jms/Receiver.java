package edu.miu.cs544.samba.finalproject.jms;

import edu.miu.cs544.samba.finalproject.entity.Job;
import edu.miu.cs544.samba.finalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    private JobService jobService;

    @JmsListener(destination = "${springjms.mqName}")
    public void receive(Job job) {
        jobService.createJob(job);
        System.out.println("Created Job => " + job);
    }
}