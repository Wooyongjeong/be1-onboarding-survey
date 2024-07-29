package com.innercircle.survey.core.questionoption;

import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.QuestionOption;

import java.util.List;

public interface QuestionOptionAppender {
    List<QuestionOption> createQuestionOptions(List<QuestionOptionCreateDefinition> definitions, Question question);

    record QuestionOptionCreateDefinition(
            Integer questionOptionOrder,
            String questionOptionValue
    ) {
        public QuestionOption toEntity(Question question) {
            return QuestionOption.builder()
                    .question(question)
                    .questionOptionOrder(questionOptionOrder)
                    .questionOptionValue(questionOptionValue)
                    .version(question.getVersion())
                    .build();
        }
    }
}
