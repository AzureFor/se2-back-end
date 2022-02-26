package cn.seecoder.courselearning.mapperservice.test;

import cn.seecoder.courselearning.po.test.Test;

import java.util.List;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test test);

    List<Test> selectByCourseId(Integer courseId);
}
