package com.sport.dao;


import com.sport.entity.TeacherEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {


    public int insert(TeacherEntity entity);

    public int updateByPrimaryKey(TeacherEntity entity);



    public int updateByPrimaryKeySelective(TeacherEntity entity);


    public int deleteByPrimaryKey(Long id);


    public TeacherEntity selectByPrimaryKey(Long id);

    public List<TeacherEntity> selectAll(TeacherEntity entity);


    public TeacherEntity selectForLogin(@Param("name")String name, @Param("password")String password);
}
