package cn.seecoder.courselearning.controller.question;


import cn.seecoder.courselearning.dto.question.QuestionDTO;
import cn.seecoder.courselearning.service.question.QuestionService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.question.QuestionVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService QuestionService;


    /**
     * 教师创建题目
     * @param courseQuestion 题目VO
     */

    //已测试
    @PostMapping("/create")
    public ResultVO<QuestionVO> createCourseQuestion(@RequestBody QuestionDTO courseQuestion) {
        return QuestionService.createQuestion(courseQuestion);
    }
    /**
     * 获取问题列表
     * @param
     */

    //已测试
    @GetMapping("/all")
    public List<QuestionVO> getQuestions() {
        return QuestionService.getQuestions();
    }

    @GetMapping("/{tid}")
    public List<QuestionVO> getQuestionsByTid(@PathVariable Integer tid){
        return QuestionService.getQuestionsByTid(tid);
    }
}
