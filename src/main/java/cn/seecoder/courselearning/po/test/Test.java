package cn.seecoder.courselearning.po.test;

import cn.seecoder.courselearning.vo.test.TestVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
@Data
@NoArgsConstructor
public class Test {
    private Integer testId;

    private Integer courseId;

    private String testName;

    private List<Integer> testQsList;


    private String startTime;

    private String endTime;


    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) { this.testName = testName == null ? null : testName.trim(); }

    public List<Integer> getQuestions() {
        return testQsList;
    }

    public void setQuestions(List<Integer> testQsList) {
        this.testQsList = testQsList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) { this.startTime = startTime== null ? null : startTime.trim(); }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) { this.endTime = endTime== null ? null : endTime.trim(); }

    public Test(@NonNull TestVO courseTestVO){
        this.testId = courseTestVO.getTestId();
        this.testName = courseTestVO.getTestName();
        this.startTime = courseTestVO.getStartTime();
        this.endTime = courseTestVO.getEndTime();
    }
}
