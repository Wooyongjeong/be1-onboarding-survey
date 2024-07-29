package com.innercircle.survey.application;

import com.innercircle.survey.core.question.QuestionAppender;
import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.Survey;
import com.innercircle.survey.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionService implements QuestionAppender {
    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(QuestionCreateDefinition definition, Survey survey) {
        Question question = definition.toEntity(survey);
        return questionRepository.save(question);
    }
}
