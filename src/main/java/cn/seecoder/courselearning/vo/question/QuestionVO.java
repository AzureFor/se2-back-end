package cn.seecoder.courselearning.vo.question;

import cn.seecoder.courselearning.po.question.Question;
import lombok.Data;
import lombok.NonNull;

@Data
public class QuestionVO {
    private Integer questionId;

    private Integer type;

    private String description;//题干

    private String correctAnswer;

    private String explanation;//解析
    public QuestionVO(@NonNull Question courseQuestion){
        questionId = courseQuestion.getQuestionId();
        type = courseQuestion.getType();
        description = courseQuestion.getDescription();
        correctAnswer = courseQuestion.getCorrectAnswer();
        explanation = courseQuestion.getExplanation();
    }
}
