package com.innercircle.survey.core.question;

import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.QuestionType;
import com.innercircle.survey.core.entity.Survey;

public interface QuestionAppender {
    Question createQuestion(QuestionCreateDefinition definition, Survey survey);

    record QuestionCreateDefinition(
            String question,
            String description,
            String questionType,
            Boolean isRequired,
            Integer questionOrder
    ) {
        public Question toEntity(Survey survey) {
            return Question.builder()
                    .survey(survey)
                    .question(question)
                    .description(description)
                    .isRequired(isRequired)
                    .questionType(QuestionType.valueOf(questionType))
                    .version(survey.getVersion())
                    .build();
        }
    }

}
