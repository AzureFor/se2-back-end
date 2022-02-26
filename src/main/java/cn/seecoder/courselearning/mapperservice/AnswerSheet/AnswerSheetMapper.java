package cn.seecoder.courselearning.mapperservice.AnswerSheet;

import cn.seecoder.courselearning.po.AnswerSheet.AnswerSheet;
import cn.seecoder.courselearning.po.testQuestion.TestQuestion;

import java.util.List;

public interface AnswerSheetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Integer uid,Integer tid, Integer qid,Integer score,String studentAnswer);
    //查找对应uid，tid答题记录条数（即是否有过答题记录）
    int selectExist(Integer uid,Integer tid);

    int getScore(Integer uid,Integer tid,Integer qid);

    String getStudentAnswer(Integer uid,Integer tid,Integer qid);
}
