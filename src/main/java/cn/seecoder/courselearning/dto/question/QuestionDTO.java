package cn.seecoder.courselearning.dto.question;

import lombok.Data;

@Data
public class QuestionDTO {
    /**
     * 由于用户不能直接给出questionId，需要根据数据库中已有的question自增生成，所以接受前端createQuestion的数据
     *        时是不会有questionId的，与QuestionVO中的成员变量相悖，所以新建 DTO 用于接受前端数据。
     */


    private Integer type;

    private String description;//题干

    private String correctAnswer;

    private String explanation;//解析
}
