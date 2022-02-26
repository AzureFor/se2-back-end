package cn.seecoder.courselearning.service.test;

import cn.seecoder.courselearning.dto.test.TestDTO;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;

import java.util.List;

public interface TestService {
    // 创建测试，并返回创建结果
    ResultVO<TestVO> createTest(TestDTO courseTestDTO);

    List<TestVO> getTestByCourse(int courseId);
}
