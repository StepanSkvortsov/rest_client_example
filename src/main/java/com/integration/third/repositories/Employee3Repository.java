package com.integration.third.repositories;

import com.integration.primary.models.Employee;
import com.integration.third.models.Employee3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee3Repository extends JpaRepository<Employee3, Integer> {
}
