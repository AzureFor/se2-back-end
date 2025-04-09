package cn.seecoder.courselearning.controller.test;


import cn.seecoder.courselearning.dto.test.TestDTO;
import cn.seecoder.courselearning.service.test.TestService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService courseTestService;


    /**
     * 教师创建测试
     * @param courseTest 测试VO
     */

    //已测试
    @PostMapping("/create")
    public ResultVO<TestVO> createCourseTest(@RequestBody TestDTO courseTest) {
        return courseTestService.createTest(courseTest);
    }

    @GetMapping("/{cid}")
    public List<TestVO> getTestByCourse(@PathVariable Integer cid){
        return courseTestService.getTestByCourse(cid);
    }

    @GetMapping("/test")
    public List<TestVO> getTesT(){
        return "HelloWorld";
    }

}
