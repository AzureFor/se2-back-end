package cn.seecoder.courselearning.serviceimpl.AnswerSheet;

import cn.seecoder.courselearning.dto.AnswerSheet.AnswerSheetDTO;
import cn.seecoder.courselearning.dto.AnswerSheet.StudentAnswer;
import cn.seecoder.courselearning.mapperservice.AnswerSheet.AnswerSheetMapper;
import cn.seecoder.courselearning.mapperservice.question.QuestionMapper;
import cn.seecoder.courselearning.mapperservice.test.TestMapper;
import cn.seecoder.courselearning.po.AnswerSheet.AnswerSheet;
import cn.seecoder.courselearning.po.question.Question;
import cn.seecoder.courselearning.service.AnswerSheet.AnswerSheetService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.AnswerSheet.AnswerSheetVO;
import cn.seecoder.courselearning.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerSheetServiceImpl implements AnswerSheetService {
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private TestMapper testMapper;
    @Resource
    private AnswerSheetMapper answerSheetMapper;

    //提交学生回答，DTO数据见DTO类
    @Override
    public ResultVO<AnswerSheetVO> submitAnswerSheet(AnswerSheetDTO answerSheetDTO) {
        AnswerSheet answerSheet = new AnswerSheet();
        BeanUtils.copyProperties(answerSheetDTO, answerSheet);
        List<Question> questionList = questionMapper.selectByTid(answerSheet.getTid());
        answerSheet.setAnswersList(answerSheetDTO.getAnswerList());
        List<StudentAnswer> answerList = answerSheet.getAnswerList();
        //判断是否已经提交过
        boolean isValid=true;
        Integer temp=answerSheetMapper.selectExist(answerSheet.getUid(), answerSheet.getTid());
        if(temp!=0){
            isValid=false;
        }
        if(isValid) {
            for(int i=0;i<questionList.size();i++){
                Question question=questionList.get(i);
                StudentAnswer answer=answerList.get(i);
                int score=0;
                if(question.getCorrectAnswer().equals(answer.getAnswer())){
                    score=100;
                }
                answerSheetMapper.insert(answerSheet.getUid(), answerSheet.getTid(), answer.getQuestionId(),score,answer.getAnswer());
            }
            return new ResultVO<AnswerSheetVO>(Constant.REQUEST_SUCCESS, "提交答案成功");
        }else {
            return new ResultVO<>(Constant.REQUEST_FAIL, "请勿重复提交");
        }

    }

    //查询学生在某次测试的答卷
    //uid:用户id
    //tid:测试id
    @Override
    public List<AnswerSheetVO> getGradeAndAnswer(int uid, int tid) {
        List<Question> questionList = questionMapper.selectByTid(tid);
        List<AnswerSheetVO> answerSheetVOList=new ArrayList<>();
        for(Question question:questionList){
            int score=answerSheetMapper.getScore(uid,tid,question.getQuestionId());
            String studentAnswer=answerSheetMapper.getStudentAnswer(uid,tid,question.getQuestionId());
            answerSheetVOList.add(new AnswerSheetVO(question,score,studentAnswer));
        }
        return answerSheetVOList;
    }
}
