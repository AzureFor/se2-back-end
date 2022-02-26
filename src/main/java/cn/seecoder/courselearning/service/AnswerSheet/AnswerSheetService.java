package cn.seecoder.courselearning.service.AnswerSheet;

import cn.seecoder.courselearning.dto.AnswerSheet.AnswerSheetDTO;
import cn.seecoder.courselearning.vo.AnswerSheet.AnswerSheetVO;
import cn.seecoder.courselearning.vo.ResultVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AnswerSheetService {
    //提交答题信息
    ResultVO<AnswerSheetVO> submitAnswerSheet(AnswerSheetDTO answerSheetDTO);
    //获取对应答题信息及成绩
    List<AnswerSheetVO> getGradeAndAnswer(int uid,int tid);
}
