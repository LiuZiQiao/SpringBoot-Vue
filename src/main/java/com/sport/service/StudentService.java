package com.sport.service;

import com.github.pagehelper.PageInfo;
import com.sport.entity.StudentEntity;
import com.sport.vo.StudentVO;

import java.util.List;

public interface StudentService {
    public boolean insertStudent(StudentEntity entity);
    /**
     * 修改
     */
    public boolean updateStudent(StudentEntity entity);
    /**
     * 根据ID删
     */
    public boolean deleteStudentById(Long id);
    /**
     * 根据ID查询
     */

    public boolean approvalRegister(Long studentId);

    public List<StudentVO> getAllStudentListByCondition(StudentEntity entityCondition);

    public PageInfo<StudentVO> getPageStudentListByCondition(Integer pageStart,Integer pageSize,final StudentEntity entityCondition);
    
    /**
    * @Description: 学生登录
    * @Param:  * @param null
    * @return:
    * @Author: xiaokun·liu
    * @Date: 2020/5/19
    */
    public StudentVO login(String name, String password);

}
