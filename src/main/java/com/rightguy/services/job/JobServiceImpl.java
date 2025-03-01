package com.rightguy.services.job;

import com.rightguy.dtos.JobRequestDto;
import com.rightguy.model.Job;
import com.rightguy.model.User;
import com.rightguy.repositories.JobRepository;
import com.rightguy.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final UserService userService;
    @Autowired
    public JobServiceImpl(JobRepository jobRepository, UserService userService) {
        this.jobRepository = jobRepository;
        this.userService = userService;
    }


    @Override
    public Job createJob(JobRequestDto jobRequestDto) {
       User requester = userService.getUserById(jobRequestDto.getRequesterId())
               .orElseThrow(()-> new RuntimeException("User NOT Found"));

       Job job  = new Job();

       job.setTitle(jobRequestDto.getTitle());
       job.setDescription(jobRequestDto.getDescription());
       job.setPostedDate(LocalDateTime.now());
       job.setRequester(requester);

       return jobRepository.save(job);
    }

    @Override
    public Job postJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found" + jobId));
    }

    @Override
    public void deleteJob(Long jobId) {
        if(jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
        }else{
            throw new RuntimeException("Job not found" + jobId);
        }
    }
}
