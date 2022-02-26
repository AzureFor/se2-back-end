package cn.seecoder.courselearning.vo.test;

import cn.seecoder.courselearning.po.test.Test;
import lombok.Data;
import lombok.NonNull;

@Data
public class TestVO {
    private Integer testId;

    private String testName;

    private String startTime;

    private String endTime;



    public TestVO(@NonNull Test courseTest){
        testId = courseTest.getTestId();
        testName = courseTest.getTestName();
        startTime = courseTest.getStartTime();
        endTime = courseTest.getEndTime();
    }
}
