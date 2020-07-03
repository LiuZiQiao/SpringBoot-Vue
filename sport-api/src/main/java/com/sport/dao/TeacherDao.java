package com.sport.dao;


import com.sport.entity.TeacherEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {

    public TeacherEntity selectForLogin(@Param(value = "name") String name, @Param(value = "password") String password);

    public List<TeacherEntity> selectAll(TeacherEntity entity);
}
