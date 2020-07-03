package com.sport.controller;

import com.github.pagehelper.PageInfo;
import com.sport.common.result.CommResult;
import com.sport.common.result.HttpResult;
import com.sport.common.utils.DateUtil;
import com.sport.common.utils.MD5Util;
import com.sport.entity.StudentEntity;
import com.sport.service.RedisService;
import com.sport.service.StudentService;
import com.sport.vo.StudentVO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "API - StudentController", description = "学生接口说明")
@ResponseBody
@Controller
@RequestMapping(value = "student")
public class StudentController{

    @Resource
    private StudentService studentService;

    @Resource
    private RedisService redisService;

    @ApiOperation(value = "学生登录",response = CommResult.class)
    @PostMapping(value = "studentLogin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult studentLogin(HttpServletRequest request,
                                   @ApiParam(value = "学生姓名") @RequestParam(value = "name",required = false)String name,
                                   @ApiParam(value = "登录密码") @RequestParam(value = "password",required = false)String password){
        System.out.println(name+"--->"+password);
        password = MD5Util.hash(password);
        System.out.println(name+"--->"+password);
        StudentVO student = studentService.login(name,password);
        System.out.println("------------------------------------->>>>>>"+student);
        if (student != null){
            if (student.getStatus().equals((byte)1)){
                return CommResult.error("用户未经审核无法登录");
            }
            String tokenString = student.getName()+student.getPassword()+ DateUtil.getCurrentTime();
            String token = MD5Util.hash(tokenString);
            redisService.set(token,student,86400);
            student.setToken(token);
            return CommResult.ok();
        }else {
            return CommResult.error("登录失败，用户账号密码错误！");
        }
    }

    @ApiOperation(value = "注册",response = CommResult.class)
    @PostMapping(value = "register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult registerStudent(HttpServletRequest request,StudentEntity entity){

        System.out.println("entity--->"+entity);
        StudentEntity register = new StudentEntity();
        register.setName(entity.getName());
        List<StudentVO> has = studentService.getAllStudentListByCondition(register);
        System.out.println("has--->"+has);
        if (has.size()>0){
            return CommResult.error("注册失败，姓名已经存在！");
        }else {
            entity.setPassword(MD5Util.hash(entity.getPassword()));
            boolean flag = studentService.insertStudent(entity);
            if (flag){
                return CommResult.ok();
            }
        }
        return CommResult.error("添加失败");
    }


    @ApiOperation(value="添加", response= CommResult.class)
    @PostMapping(value = "insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult insertStudent(HttpServletRequest request, StudentEntity entity){
        entity.setPassword(MD5Util.hash(entity.getPassword()));
        boolean flag = studentService.insertStudent(entity);
        if(flag){
            return CommResult.ok();
        }
        return CommResult.error("添加失败。");
    }

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value="分页查询所有数据", response=CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response= StudentVO.class)
    })
    @PostMapping(value = "getAllByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpResult<StudentVO> getAllByPageStudent(HttpServletRequest request,
                                                     @ApiParam(value = "起始页",required = true)@RequestParam(value = "page",defaultValue = "1")Integer page,
                                                     @ApiParam(value = "每页条数",required = true)@RequestParam(value = "size",defaultValue = "2")Integer size, StudentEntity entity){
        System.out.println(page+"------>"+size+"--->"+entity);
        HttpResult<StudentVO> result = new HttpResult<StudentVO>();
        PageInfo<StudentVO> pages = studentService.getPageStudentListByCondition(page,size,entity);
        result.setData(pages.getList());
        System.out.println(result);
        return result;
    }


    @ApiOperation(value = "审核学生通过",response = CommResult.class)
    @PostMapping(value = "approvalRegister",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult approvalRegister(HttpServletRequest request,
                                       @ApiParam(value = "学生Id",required = true)
                                       @RequestParam(value = "studentId",required = true)Long studentId){

        boolean flag = studentService.approvalRegister(studentId);
        if (flag){
            return CommResult.ok("审核成功！");
        }else {
            return CommResult.error("审核失败！");
        }
    }

    /**
     * 学生退出
     */
    @ApiOperation(value="学生退出", response=CommResult.class)
    @PostMapping(value = "studentLogout", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult studentLogout(HttpServletRequest request) {
        String token = request.getHeader("token");
        redisService.remove(token);
        return CommResult.ok("退出成功！");
    }
}