package com.rightguy.services.job;

import com.rightguy.dtos.JobRequestDto;
import com.rightguy.model.Job;

import java.util.List;

public interface JobService {
    Job createJob(JobRequestDto jobRequestDto);
    Job postJob(Job job);
    List<Job> getAllJobs();
    Job getJobById(Long id);
    void deleteJob(Long id);
}
