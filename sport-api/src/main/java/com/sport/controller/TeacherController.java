package com.sport.controller;

import com.github.pagehelper.PageInfo;
import com.sport.common.result.CommResult;
import com.sport.common.result.HttpResult;
import com.sport.common.utils.DateUtil;
import com.sport.common.utils.MD5Util;
import com.sport.entity.TeacherEntity;
import com.sport.service.RedisService;
import com.sport.service.TeacherService;
import com.sport.vo.TeacherVO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(value = "API - TeacherController",produces = "老师接口说明")
@RequestMapping(value = "teacher")
@ResponseBody
@Controller
public class TeacherController {

    @Resource
    private TeacherService teacherService;
    @Resource
    private RedisService redisService;

    @ApiOperation(value = "教师登录",response = CommResult.class)
    @PostMapping(value = "teacherLogin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult teacherLogin(HttpServletRequest request,
                                   @ApiParam(value = "教师姓名",required = true)@RequestParam(value = "name")String name,
                                   @ApiParam(value = "登录密码",required = true)@RequestParam(value = "password")String password){
        System.out.println(name+"---->"+password);
        password = MD5Util.hash(password);
        System.out.println(name+"---->"+password);
        TeacherVO teacher = teacherService.login(name,password);
        System.out.println(teacher);
        if (teacher != null){
            String tokenString = teacher.getName() + teacher.getPassword() + DateUtil.getCurrentTime();
            String token = MD5Util.hash(tokenString);
            redisService.set(token, teacher, 86400);
            teacher.setToken(token);
            return CommResult.ok(teacher);
        }else {
            return CommResult.error("登录失败，用户密码错误！");
        }
    }
    /**
     * 教师退出
     */
    @ApiOperation(value="教师退出", response=CommResult.class)
    @PostMapping(value = "teacherLogout", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult teacherLogout(HttpServletRequest request) {
        String token = request.getHeader("token");
        redisService.remove(token);
        return CommResult.ok("退出成功！");
    }

    /*
     * 分页查询
     */
    @ApiOperation(value="分页查询所有数据", response=CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=TeacherVO.class)
    })
    @PostMapping(value = "getAllByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpResult<TeacherVO> getAllByPageTeacher(HttpServletRequest request,
                                                     @ApiParam(value = "起始页",required = true)@RequestParam(value = "page",defaultValue="1")Integer page,
                                                     @ApiParam(value = "每页条数",required = true)@RequestParam(value = "size",defaultValue="10")Integer size, TeacherEntity entity){
        HttpResult<TeacherVO> httpResult = new HttpResult<>();
        PageInfo pages = teacherService.getPageTeacherListByCondition(page,size,entity);
        httpResult.setData(pages.getList());
        httpResult.setiTotalRecords(pages.getTotal());
        System.out.println(httpResult);
        return httpResult;
    }

}
