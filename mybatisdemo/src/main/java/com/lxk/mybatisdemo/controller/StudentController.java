package com.lxk.mybatisdemo.controller;

import com.lxk.mybatisdemo.entity.Student;
import com.lxk.mybatisdemo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "Student")
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "selectOne")
    @GetMapping("selectOne")
    public Student selectOne(@RequestParam("id") Integer id) {
        return this.studentService.queryById(id);
    }

    @ApiOperation(value = "insert")
    @PostMapping("insert")
    public Student insert(@RequestBody Student student) {
        return this.studentService.insert(student);
    }

    @ApiOperation(value = "update")
    @PostMapping("update")
    public Student update(@RequestBody Student student) {
        return this.studentService.update(student);
    }

}