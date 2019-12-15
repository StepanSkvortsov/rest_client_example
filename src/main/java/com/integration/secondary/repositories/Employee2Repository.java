package com.integration.secondary.repositories;

import com.integration.primary.models.Employee;
import com.integration.secondary.models.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee2Repository extends JpaRepository<Employee2, Integer> {
}
