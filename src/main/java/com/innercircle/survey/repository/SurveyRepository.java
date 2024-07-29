package com.innercircle.survey.repository;

import com.innercircle.survey.core.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
