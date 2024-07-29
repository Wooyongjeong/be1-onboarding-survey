package com.innercircle.survey.repository;

import com.innercircle.survey.core.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
