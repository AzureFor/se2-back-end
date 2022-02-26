package cn.seecoder.courselearning.controller.AnswerSheet;


import cn.seecoder.courselearning.dto.AnswerSheet.AnswerSheetDTO;
import cn.seecoder.courselearning.service.AnswerSheet.AnswerSheetService;
import cn.seecoder.courselearning.vo.AnswerSheet.AnswerSheetVO;
import cn.seecoder.courselearning.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class AnswerSheetController {
    @Resource
    AnswerSheetService answerSheetService;

    @PostMapping("/submitAnswerSheet")
    public ResultVO<AnswerSheetVO> submitAnswerSheet(@RequestBody AnswerSheetDTO answerSheetDTO){
        return answerSheetService.submitAnswerSheet(answerSheetDTO);

    }

    @GetMapping("/getGrade/{tid}")
    public List<AnswerSheetVO> getGradeAndAnswer(@RequestParam(required = false, defaultValue = "") Integer uid, @PathVariable Integer tid){
        return answerSheetService.getGradeAndAnswer(uid,tid);
    }
}
