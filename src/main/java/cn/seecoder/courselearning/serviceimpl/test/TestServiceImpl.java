package cn.seecoder.courselearning.serviceimpl.test;

import cn.seecoder.courselearning.dto.test.TestDTO;
import cn.seecoder.courselearning.mapperservice.test.TestMapper;
import cn.seecoder.courselearning.mapperservice.testQuestion.TestQuestionMapper;
import cn.seecoder.courselearning.po.test.Test;
import cn.seecoder.courselearning.po.testQuestion.TestQuestion;
import cn.seecoder.courselearning.service.test.TestService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;
    @Resource
    private TestQuestionMapper testQuestionMapper;
    private Object TestDTO;

    @Override
    public ResultVO<TestVO> createTest(TestDTO courseTestDTO) {
        Test test = new Test();
        BeanUtils.copyProperties(courseTestDTO, test);
        if(testMapper.insert(test) > 0){
            List<Integer> questionList =courseTestDTO.getTestQsList();
            //存储测试id和题目id
            for (Integer questionId : questionList) {
                TestQuestion testQuestion = new TestQuestion(test.getTestId(),questionId);
                testQuestionMapper.insert(testQuestion);
            }
            return new ResultVO<TestVO>(Constant.REQUEST_SUCCESS, "测试创建成功。", new TestVO(test));
        }

        return new ResultVO<>(Constant.REQUEST_FAIL, "测试创建失败。");
    }

    @Override
    public List<TestVO> getTestByCourse(int courseId) {
        List<TestVO> ret = new ArrayList<>();
        List<Test> testList = testMapper.selectByCourseId(courseId);
        for(Test test:testList){
            TestVO testVO=new TestVO(test);
            ret.add(testVO);
        }
        return ret;
    }
}
