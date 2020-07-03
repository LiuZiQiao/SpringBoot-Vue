package com.sport.service;

import com.github.pagehelper.PageInfo;
import com.sport.entity.TeacherEntity;
import com.sport.vo.TeacherVO;


public interface TeacherService {

    public PageInfo getPageTeacherListByCondition(Integer page, Integer size, TeacherEntity entity);

    public TeacherVO login(String name, String password);
}
