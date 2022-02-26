package cn.seecoder.courselearning.service.course;

import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseVO;

public interface CourseLikesService {

     ResultVO<CourseVO> setCourseLike(Integer uid,Integer courseId);

     ResultVO<CourseVO> cancelCourseLike(Integer uid,Integer courseId);
}
