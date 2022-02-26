package cn.seecoder.courselearning.vo.AnswerSheet;

import cn.seecoder.courselearning.po.question.Question;
import lombok.Data;

@Data
public class AnswerSheetVO {
    private Integer questionId;
    //题型，只有填空、简答
    private Integer type;

    private String description;//题干

    private String studentAnswer;//学生答案

    private String correctAnswer;

    private String explanation;//解析
    //本题的得分
    private int grade;
    public  AnswerSheetVO(Question question, int score,String studentAnswer1){
        this.questionId=question.getQuestionId();
        this.type=question.getType();
        this.description=question.getDescription();
        this.correctAnswer=question.getCorrectAnswer();
        this.explanation=question.getExplanation();
        this.grade=score;
        this.studentAnswer=studentAnswer1;
    }

}
