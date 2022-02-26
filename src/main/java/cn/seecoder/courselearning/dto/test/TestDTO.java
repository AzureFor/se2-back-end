package cn.seecoder.courselearning.dto.test;

import lombok.Data;

import java.util.List;

/**
 * 测试信息DTO类
 */
@Data
public class TestDTO {

    private String testName;

    private Integer courseId;

    private String startTime;

    private String endTime;

    List<Integer> testQsList;
}
