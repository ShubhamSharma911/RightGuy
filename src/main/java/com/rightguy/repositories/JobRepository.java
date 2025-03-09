package com.rightguy.repositories;

import com.rightguy.dtos.JobResponseDto;
import com.rightguy.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByDeletedFalse();

    @Query("SELECT j FROM Job j WHERE j.deleted = false AND (LOWER(j.title) LIKE LOWER( CONCAT('%', : keyword, '%')) OR LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<Job> searchJobs(String keyword);

    Page<Job> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase( String title, String description, Pageable pageable);

}
