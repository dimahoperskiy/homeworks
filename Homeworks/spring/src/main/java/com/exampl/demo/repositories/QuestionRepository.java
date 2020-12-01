package com.exampl.demo.repositories;

import com.exampl.demo.models.Answer;
import com.exampl.demo.models.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
