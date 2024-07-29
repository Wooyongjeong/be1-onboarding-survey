package com.innercircle.survey.repository;

import com.innercircle.survey.core.entity.Response;
import com.innercircle.survey.core.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findBySurveyAndVersion(Survey survey, Integer version);
}
