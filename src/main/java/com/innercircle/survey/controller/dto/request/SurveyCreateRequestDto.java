package com.innercircle.survey.controller.dto.request;

import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.Survey;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyCreateRequestDto {
    @NotBlank(message = "질문 제목을 입력해 주세요.")
    private String title;

    private String description;

    private List<SurveyQuestionCreateRequestDto> questions;

    public Survey toSurveyEntity() {
        return Survey.builder()
                .title(title)
                .description(description)
                .build();
    }

    public List<Question> toQuestionEntities(Survey survey) {
        return questions.stream()
                .map(question -> question.toQuestionEntity(survey))
                .toList();
    }
}
