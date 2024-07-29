package com.innercircle.survey.application;

import com.innercircle.survey.core.questionoption.QuestionOptionAppender;
import com.innercircle.survey.core.entity.Question;
import com.innercircle.survey.core.entity.QuestionOption;
import com.innercircle.survey.repository.QuestionOptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionOptionService implements QuestionOptionAppender {
    private final QuestionOptionRepository questionOptionRepository;

    @Transactional
    @Override
    public List<QuestionOption> createQuestionOptions(List<QuestionOptionCreateDefinition> definitions, Question question) {
        List<QuestionOption> questionOptions = definitions.stream()
                .map(definition -> definition.toEntity(question))
                .toList();
        return questionOptionRepository.saveAll(questionOptions);
    }
}
