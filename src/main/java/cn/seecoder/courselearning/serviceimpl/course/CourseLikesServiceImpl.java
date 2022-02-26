package cn.seecoder.courselearning.serviceimpl.course;

import cn.seecoder.courselearning.mapperservice.course.CourseLikesMapper;
import cn.seecoder.courselearning.service.course.CourseLikesService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseLikesServiceImpl implements CourseLikesService {
    @Resource
    private CourseLikesMapper courseLikesMapper;
    @Override
    public ResultVO<CourseVO> setCourseLike(Integer uid, Integer courseId) {
        if(courseLikesMapper.count(courseId,uid)==1){
            return new ResultVO<CourseVO>(Constant.REQUEST_FAIL,"点赞失败");
        }
        else {
            if(courseLikesMapper.insert(courseId,uid)>0){
                return new ResultVO<CourseVO>(Constant.REQUEST_SUCCESS,"点赞成功");

            }
            else return new ResultVO<CourseVO>(Constant.REQUEST_FAIL,"点赞失败");
        }
    }

    @Override
    public ResultVO<CourseVO> cancelCourseLike(Integer uid, Integer courseId) {
        if(courseLikesMapper.deleteByPrimaryKey(courseId,uid)>0){
            return new ResultVO<CourseVO>(Constant.REQUEST_SUCCESS,"取消点赞成功");
        }
        else return new ResultVO<CourseVO>(Constant.REQUEST_FAIL,"取消点赞失败");
    }

}
