package cn.seecoder.courselearning.dto.AnswerSheet;


import lombok.Data;

/**
 * StudentAnswer类
 */
@Data
public class StudentAnswer {
    //学生回答
    private String answer;
    //题目id
    private Integer questionId;

}
