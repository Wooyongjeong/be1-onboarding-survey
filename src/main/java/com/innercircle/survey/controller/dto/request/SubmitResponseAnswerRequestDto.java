package com.innercircle.survey.controller.dto.request;

import com.innercircle.survey.core.entity.Answer;
import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.QuestionType;
import com.innercircle.survey.core.entity.Response;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubmitResponseAnswerRequestDto {
    private Integer questionOrder;
    private String questionType;
    private String answerValue;
    private Integer answerSingleOption;
    private String answerMultipleOptions;

    public Answer toAnswerEntity(Response response, List<Question> questions) {
        for (Question question : questions) {
            if (!Objects.equals(question.getQuestionOrder(), questionOrder)) {
                continue;
            }
            return Answer.builder()
                    .question(question)
                    .response(response)
                    .questionOrder(questionOrder)
                    .questionType(QuestionType.valueOf(questionType))
                    .answerValue(answerValue)
                    .answerSingleOption(answerSingleOption)
                    .answerMultipleOptions(answerMultipleOptions)
                    .version(response.getVersion())
                    .build();
        }
        return null;
    }
}
