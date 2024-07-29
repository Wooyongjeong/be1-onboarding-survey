package com.innercircle.survey.controller.dto.request;

import com.innercircle.survey.exception.RequiredAnswerMissingException;
import com.innercircle.survey.core.entity.Answer;
import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.Response;
import com.innercircle.survey.core.entity.Survey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubmitResponseRequestDto {
    private List<SubmitResponseAnswerRequestDto> answers;

    public Response toResponseEntity(Survey survey) {
        Response response = Response.builder()
                .survey(survey)
                .version(survey.getVersion())
                .build();
        List<Question> questions = survey.getQuestions();
        List<Answer> answerEntities = answers.stream()
                .map(answer -> answer.toAnswerEntity(response, questions))
                .filter(Objects::nonNull)
                .toList();
        questions.forEach(question -> {
            Boolean isRequired = question.getIsRequired();
            if (!isRequired) {
                return;
            }
            answerEntities.stream()
                    .filter(answer -> Objects.equals(answer.getQuestionOrder(), question.getQuestionOrder()))
                    .findAny()
                    .orElseThrow(() -> new RequiredAnswerMissingException(question.getId()));
        });
        response.setAnswers(answerEntities);
        return response;
    }
}
