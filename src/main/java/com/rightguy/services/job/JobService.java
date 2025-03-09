package com.rightguy.services.job;

import com.rightguy.dtos.JobRequestDto;
import com.rightguy.dtos.JobResponseDto;
import com.rightguy.model.Job;
import org.springframework.data.domain.Page;


import java.util.List;

public interface JobService {
    Job createJob(JobRequestDto jobRequestDto);
    Job postJob(Job job);
    Page<JobResponseDto> getAllJobs(int page, int size, String sort, String keyword);
    JobResponseDto getJobById(Long id);
    void deleteJob(Long id);
    JobResponseDto updateJob(Long jobId, JobRequestDto jobRequestDto);
    public List<JobResponseDto> searchJobs(String keyword);
}
