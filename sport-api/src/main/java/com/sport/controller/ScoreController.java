package com.sport.controller;

import com.github.pagehelper.PageInfo;
import com.sport.common.result.CommResult;
import com.sport.common.result.HttpResult;
import com.sport.entity.ScoreEntity;
import com.sport.service.RedisService;
import com.sport.service.ScoreService;
import com.sport.vo.ScoreVO;
import com.sport.vo.TeacherVO;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 10:02 上午
 */
@Api(value = "API-ScoreController",description = "成绩接口说明")
@Controller
@ResponseBody
@RequestMapping("score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;
    @Resource
    private RedisService redisService;


    @ApiOperation(value = "添加", response = CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
    })
    @PostMapping(value = "/insertScore",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult insertScore(HttpServletRequest request, ScoreEntity entity){
        TeacherVO teacher = (TeacherVO) redisService.get(request.getHeader("token"));
        entity.setUpdateTime(new Date());
        entity.setTeacherId(teacher.getId());
        boolean ret = scoreService.insertScore(entity);
        if (ret){
            return CommResult.ok();
        }
        return CommResult.error("添加失败");
    }

    @ApiOperation(value = "更新",response = CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
    })
    @PostMapping(value = "/updateScore",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult updateScore(HttpServletRequest request,ScoreEntity entity){
        TeacherVO teacher = (TeacherVO) redisService.get(request.getHeader("token"));
        entity.setUpdateTime(new Date());
        entity.setTeacherId(teacher.getId());
        boolean ret = scoreService.updateScore(entity);
        if (ret){
            return CommResult.ok();
        }
        return CommResult.error("修改失败");
    }

    @ApiOperation(value = "删除",response = CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
    })
    @PostMapping(value = "deleteScore",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult deleteScore(@ApiParam(value = "id",required = true) @RequestParam("id")Long id){
        boolean ret = scoreService.deleteScoreById(id);
        if (ret){
            return CommResult.ok();
        }
        return CommResult.error("删除失败");
    }

    @ApiOperation(value = "通过id获取",response = CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
    })
    @PostMapping(value = "getScoreById",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult getScoreById(@ApiParam("id")Long id){
        if (id==null){
            return CommResult.error("id不能为空");
        }
        ScoreVO vo = scoreService.getScoreById(id);
        return CommResult.ok(vo);
    }

    @ApiOperation(value = "获取全部",response = CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
    })
    @PostMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult getAllScore(HttpServletRequest request, ScoreEntity scoreEntity){
        List<ScoreVO> scoreVOList = scoreService.getAllScoreListByCondition(scoreEntity);
        return CommResult.ok(scoreVOList);
    }

    @ApiOperation(value = "分页获取",response = CommResult.class)
    @ApiResponses(
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=ScoreVO.class)
    )
    @PostMapping(value = "/getAllByPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpResult<ScoreVO> getAllByPageScore(HttpServletRequest request,
                                                 @ApiParam(value = "起始页",required = true) @RequestParam(value = "page",defaultValue = "1") Integer startPage,
                                                 @ApiParam(value = "每页条数",required = true)@RequestParam(value = "size",defaultValue = "10") Integer pageSize, ScoreEntity entity){
        HttpResult<ScoreVO> svos = new HttpResult<>();
        PageInfo<ScoreVO> list = scoreService.getPageScoreListByCondition(startPage, pageSize, entity);
        svos.setData(list.getList());
        svos.setiTotalRecords(list.getTotal());
        return svos;
    }

}
