package com.rightguy.mapper;

import com.rightguy.dtos.JobRequestDto;
import com.rightguy.dtos.JobResponseDto;
import com.rightguy.model.Job;

public class JobMapper {

    public static JobResponseDto mapToResponseDto(Job job) {

        JobResponseDto dto = new JobResponseDto();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setPostedDate(job.getPostedDate());
        dto.setRequesterId(job.getRequester().getId());
        return dto;
    }

    public static Job mapToEntity(JobRequestDto dto) {
        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setPostedDate(java.time.LocalDateTime.now());
        return job;
    }
}
