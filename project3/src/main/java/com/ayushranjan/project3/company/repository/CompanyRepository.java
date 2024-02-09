package com.ayushranjan.project3.company.repository;

import com.ayushranjan.project3.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
