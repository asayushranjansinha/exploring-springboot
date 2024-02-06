package com.ayushranjan.project3.job.service;

import com.ayushranjan.project3.job.entity.Job;

import java.util.List;
public interface JobService {
     List<Job> findAll();

     void createJob(Job job);

     Job getJobById(Long id);

     boolean deleteJobById(Long id);

     boolean updateJobById(Long id, Job updatedJob);
}
