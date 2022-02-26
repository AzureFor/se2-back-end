package cn.seecoder.courselearning.po.testQuestion;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestQuestion {
    private Integer testId;

    private Integer questionId;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public TestQuestion(int testId, int questionId) {
        this.testId = testId;
        this.questionId=questionId;
    }
}
