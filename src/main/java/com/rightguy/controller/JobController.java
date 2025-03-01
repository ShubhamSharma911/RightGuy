package com.rightguy.controller;

import com.rightguy.dtos.JobRequestDto;
import com.rightguy.dtos.JobResponseDto;
import com.rightguy.mapper.JobMapper;
import com.rightguy.model.Job;
import com.rightguy.services.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    public ResponseEntity<JobResponseDto> createJob(@RequestBody JobRequestDto jobRequestDto) {
        Job job = jobService.createJob(jobRequestDto);
        JobResponseDto response = JobMapper.mapToResponseDto(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
