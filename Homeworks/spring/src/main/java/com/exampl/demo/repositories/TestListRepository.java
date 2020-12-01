package com.exampl.demo.repositories;

import com.exampl.demo.models.TestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestListRepository extends JpaRepository<TestList, Long> {
}
