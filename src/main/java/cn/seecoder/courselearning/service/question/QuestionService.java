package cn.seecoder.courselearning.service.question;

import cn.seecoder.courselearning.dto.question.QuestionDTO;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.question.QuestionVO;

import java.util.List;

public interface QuestionService {
    // 创建题目，并返回创建结果
    ResultVO<QuestionVO> createQuestion(QuestionDTO courseQuestionDTO);
    //从题库中获取全部题目的集合
    List<QuestionVO> getQuestions();

    List<QuestionVO> getQuestionsByTid(int tid);
}
