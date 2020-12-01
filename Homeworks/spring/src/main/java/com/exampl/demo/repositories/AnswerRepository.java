package com.exampl.demo.repositories;

import com.exampl.demo.models.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    public Page<Answer> findByQuestionId(Long questionId, Pageable pageable);
    public Optional<Answer> findByIdAndQuestionId(Long id, Long questionId);
}
