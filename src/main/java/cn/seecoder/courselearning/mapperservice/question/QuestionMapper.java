package cn.seecoder.courselearning.mapperservice.question;

import cn.seecoder.courselearning.po.question.Question;
import cn.seecoder.courselearning.vo.question.QuestionVO;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question question);

    List<Question> selectAll();

    List<Question> selectByTid(Integer tid);
}
