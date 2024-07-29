package com.innercircle.survey.core.survey;

import com.innercircle.survey.core.entity.Survey;

public interface SurveyAppender {
    Survey createSurvey(SurveyCreateDefinition definition);

    record SurveyCreateDefinition(
            String title,
            String description
    ) {
        public Survey toEntity() {
            return Survey.builder()
                    .title(title)
                    .description(description)
                    .build();
        }
    }
}
