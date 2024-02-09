package com.ayushranjan.project3.job.repository;

import com.ayushranjan.project3.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
