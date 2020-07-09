package com.sport.dao;

import com.sport.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao{

    /*
     * 添加所以
     */
    public int insert(StudentEntity studentEntity);

    /**
     * 添加非空字段
     */
    public int insertSelective(StudentEntity entity);

    /**
     * 根据ID查询数据
     */
    public StudentEntity selectByPrimaryKey(Long id);


    /*
     * 查询所有数据
     */
    public List<StudentEntity> selectAll(StudentEntity entity);

    /**
     * 根据ID修改所有
     */
    public int updateByPrimaryKey(StudentEntity entity);

    /**
     * 根据ID修改非空字段
     */
    public int updateByPrimaryKeySelective(StudentEntity entity);


    public StudentEntity selectForLogin(@Param("name") String name, @Param("password") String password);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    public boolean deleteByPrimaryKey(@Param("id")Long id);
}
