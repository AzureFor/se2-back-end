package cn.seecoder.courselearning.po.question;

import cn.seecoder.courselearning.vo.question.QuestionVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer questionId;

    private Integer type;

    private String description;//题干

    private String correctAnswer;

    private String explanation;//解析

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description == null ? null : description.trim(); }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String answer) { this.correctAnswer = answer== null ? null : answer.trim(); }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) { this.explanation = explanation == null ? null : explanation.trim(); }

    public Question(@NonNull QuestionVO courseQuestionVO){
        this.questionId = courseQuestionVO.getQuestionId();
        this.type = courseQuestionVO.getType();
        this.description = courseQuestionVO.getDescription();
        this.correctAnswer= courseQuestionVO.getCorrectAnswer();
        this.explanation = courseQuestionVO.getExplanation();
    }
}
