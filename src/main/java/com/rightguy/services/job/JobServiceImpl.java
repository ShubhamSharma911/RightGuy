package com.rightguy.services.job;

import com.rightguy.dtos.JobRequestDto;

import com.rightguy.dtos.JobResponseDto;
import com.rightguy.mapper.JobMapper;
import com.rightguy.model.Job;
import com.rightguy.model.User;
import com.rightguy.repositories.JobRepository;
import com.rightguy.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

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
    public Page<JobResponseDto> getAllJobs(int page, int size, String sort, String keyword) {

        String[] sortParam = sort.split(",");

        Sort.Direction direction = sortParam[1].equalsIgnoreCase("desc")? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page,size,Sort.by(direction, sortParam[0]));

        Page<Job> jobPage;

        if(keyword != null && !keyword.trim().isEmpty()) {
            jobPage = jobRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword, pageable);
        }else {
            jobPage = jobRepository.findAll(pageable);
        }

        return jobPage.map(job -> JobMapper.mapToResponseDto(job));
    }

    @Override
    public JobResponseDto getJobById(Long jobId) {
       Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found" + jobId));

       return JobMapper.mapToResponseDto(job);
    }

    @Override
    public void deleteJob(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()-> new RuntimeException("Job not found with id: " + jobId));
        job.setDeleted(true);
        jobRepository.save(job);
    }

    @Override
    public JobResponseDto updateJob(Long jobId, JobRequestDto jobRequestDto) {

        Job existingJob = jobRepository.findById(jobId)
                .orElseThrow(()-> new RuntimeException("Requester not found" + jobId));

        User requester = userService.getUserById(jobRequestDto.getRequesterId())
                .orElseThrow(()-> new RuntimeException("Requester NOT Found"));


        existingJob.setTitle(jobRequestDto.getTitle());
        existingJob.setDescription(jobRequestDto.getDescription());
        existingJob.setPostedDate(LocalDateTime.now());
        existingJob.setRequester(requester);

        Job updatedJob = jobRepository.save(existingJob);

        return JobMapper.mapToResponseDto(updatedJob);
    }

    public List<JobResponseDto> searchJobs(String keyword) {

        List<Job> jobs = jobRepository.searchJobs(keyword);

        return jobs.stream()
                .map(JobMapper :: mapToResponseDto)
                .collect(Collectors.toList());
    }
}
