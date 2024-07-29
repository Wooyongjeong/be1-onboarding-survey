package com.innercircle.survey.controller.dto.response;

import com.innercircle.survey.core.entity.QuestionOption;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyQuestionOptionResponseDto {
    private Integer questionOptionOrder;
    private String questionOptionValue;

    public static SurveyQuestionOptionResponseDto fromQuestionOptionEntity(QuestionOption questionOption) {
        return SurveyQuestionOptionResponseDto.builder()
                .questionOptionOrder(questionOption.getQuestionOptionOrder())
                .questionOptionValue(questionOption.getQuestionOptionValue())
                .build();
    }
}
