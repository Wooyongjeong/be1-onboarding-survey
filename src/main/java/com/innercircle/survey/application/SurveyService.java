package com.innercircle.survey.application;

import com.innercircle.survey.core.survey.SurveyAppender;
import com.innercircle.survey.core.entity.Survey;
import com.innercircle.survey.repository.SurveyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SurveyService implements SurveyAppender {
    private final SurveyRepository surveyRepository;

    @Transactional
    @Override
    public Survey createSurvey(SurveyCreateDefinition definition) {
        Survey survey = definition.toEntity();
        return surveyRepository.save(survey);
    }
}
