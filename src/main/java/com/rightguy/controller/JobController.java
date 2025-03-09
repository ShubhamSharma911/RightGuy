package com.rightguy.controller;

import com.rightguy.dtos.JobRequestDto;
import com.rightguy.dtos.JobResponseDto;
import com.rightguy.mapper.JobMapper;
import com.rightguy.model.Job;
import com.rightguy.services.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobResponseDto> createJob(@RequestBody JobRequestDto jobRequestDto) {
        Job job = jobService.createJob(jobRequestDto);
        JobResponseDto response = JobMapper.mapToResponseDto(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobResponseDto>  getJobById(@PathVariable Long jobId){
       JobResponseDto response = jobService.getJobById(jobId);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping
    public ResponseEntity<Page<JobResponseDto>> getAllJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "postedDate,desc") String sort,
            @RequestParam (required = false)String keyword) {

        Page<JobResponseDto> jobs = jobService.getAllJobs(page,size,sort, keyword);
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<JobResponseDto> updateJob( @PathVariable Long jobId, @RequestBody JobRequestDto jobRequestDto){

        JobResponseDto response = jobService.updateJob(jobId, jobRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId){
        jobService.deleteJob(jobId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobResponseDto>> searchJob(@RequestParam String keyword){
        List<JobResponseDto> jobs = jobService.searchJobs(keyword);
        return  ResponseEntity.ok(jobs);
    }
}
