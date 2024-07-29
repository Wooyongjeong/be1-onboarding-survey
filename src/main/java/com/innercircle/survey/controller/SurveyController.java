package com.innercircle.survey.controller;

import com.innercircle.survey.controller.dto.request.SubmitResponseRequestDto;
import com.innercircle.survey.controller.dto.request.SurveyCreateRequestDto;
import com.innercircle.survey.controller.dto.request.SurveyUpdateRequestDto;
import com.innercircle.survey.controller.dto.response.SurveyResponseDto;
import com.innercircle.survey.controller.dto.response.SurveyResponseResponseDtos;
import com.innercircle.survey.application.OldSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/api/surveys")
@RestController
public class SurveyController {
    private final OldSurveyService oldSurveyService;

    @PostMapping
    public ResponseEntity<SurveyResponseDto> createSurvey(
            @RequestBody SurveyCreateRequestDto surveyCreateRequestDto
    ) {
        SurveyResponseDto responseDto = oldSurveyService.createSurvey(surveyCreateRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{surveyId}")
    public ResponseEntity<SurveyResponseDto> updateSurvey(
            @PathVariable("surveyId") Long surveyId,
            @RequestBody SurveyUpdateRequestDto surveyUpdateRequestDto
    ) {
        SurveyResponseDto responseDto = oldSurveyService.updateSurvey(surveyId, surveyUpdateRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{surveyId}/responses")
    public ResponseEntity<String> submitResponse(
            @PathVariable("surveyId") Long surveyId,
            @RequestBody SubmitResponseRequestDto submitResponseRequestDto
    ) {
        oldSurveyService.submitResponse(surveyId, submitResponseRequestDto);
        return ResponseEntity.ok("Successfully submitted");
    }

    @GetMapping("/{surveyId}/responses")
    public ResponseEntity<SurveyResponseResponseDtos> getSurveyResponses(
            @PathVariable("surveyId") Long surveyId
    ) {
        SurveyResponseResponseDtos answers = oldSurveyService.getSurveyResponses(surveyId);
        return ResponseEntity.ok(answers);
    }
}
