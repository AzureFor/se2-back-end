package cn.seecoder.courselearning.dto.AnswerSheet;

import cn.seecoder.courselearning.vo.course.CourseVO;
import lombok.Data;

import java.util.List;

/**
 * 答题信息类DTO
 */
@Data
public class AnswerSheetDTO {
    //学生（用户）id
    private int uid;
    //测试id
    private int tid;

    //作答 list
    private List<StudentAnswer> answerList;

}
