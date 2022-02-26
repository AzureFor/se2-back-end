package cn.seecoder.courselearning.serviceimpl.question;

import cn.seecoder.courselearning.dto.question.QuestionDTO;
import cn.seecoder.courselearning.mapperservice.question.QuestionMapper;
import cn.seecoder.courselearning.po.question.Question;
import cn.seecoder.courselearning.service.question.QuestionService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.question.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;
    private Object QuestionDTO;

    @Override
    public ResultVO<QuestionVO> createQuestion(QuestionDTO courseQuestionDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(courseQuestionDTO, question);
        if(questionMapper.insert(question) > 0){
            return new ResultVO<QuestionVO>(Constant.REQUEST_SUCCESS, "题目创建成功。", new QuestionVO(question));
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "题目创建失败。");
    }

    @Override
    public List<QuestionVO> getQuestions() {
        List<QuestionVO> ret = new ArrayList<>();
        List<Question> questionList = questionMapper.selectAll();
        for(Question question:questionList){
            QuestionVO questionVO=new QuestionVO(question);
            ret.add(questionVO);
        }
        return ret;
    }

    @Override
    public List<QuestionVO> getQuestionsByTid(int tid) {
        List<QuestionVO> ret = new ArrayList<>();
        List<Question> questionList = questionMapper.selectByTid(tid);
        for(Question question:questionList){
            QuestionVO questionVO=new QuestionVO(question);
            ret.add(questionVO);
        }
        return ret;
    }
}
