package cn.seecoder.courselearning.mapperservice.testQuestion;

import cn.seecoder.courselearning.po.test.Test;
import cn.seecoder.courselearning.po.testQuestion.TestQuestion;

import java.util.List;

public interface TestQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestQuestion testQuestion);



}
