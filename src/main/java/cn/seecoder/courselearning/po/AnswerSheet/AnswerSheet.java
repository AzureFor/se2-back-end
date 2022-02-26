package cn.seecoder.courselearning.po.AnswerSheet;

import cn.seecoder.courselearning.dto.AnswerSheet.StudentAnswer;

import java.util.List;

public class AnswerSheet {


    //学生（用户）id
    private int uid;
    //测试id
    private int tid;

    //作答 list
    private List<StudentAnswer> answerList;


    public int getUid() {
        return uid;
    }

    public int getTid() {
        return tid;
    }

    public List<StudentAnswer> getAnswerList() {
        return answerList;
    }

    public void setUid(int uid1) {
        this.uid = uid1;
    }

    public void setTid(int tid1) {
        this.tid = tid1;
    }

    public void setAnswersList(List<StudentAnswer> studentAnswers) {
        this.answerList = studentAnswers;
    }

    public AnswerSheet() {
    }

    public AnswerSheet(int uid1, int tid1, List<StudentAnswer> studentAnswers) {
        this.uid = uid1;
        this.tid = tid1;
        this.answerList = studentAnswers;
    }

}
