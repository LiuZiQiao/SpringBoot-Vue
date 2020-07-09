package com.sport.dao;

import com.sport.entity.ScoreEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 10:29 上午
 */
@ResponseBody
public interface ScoreDao {

    /**
     * 添加所有
     * @param scoreEntity
     * @return
     */
    public int insert(ScoreEntity scoreEntity);


    /**
     * 添加非空字段
     * @param scoreEntity
     * @return
     */
    public int insertSelective(ScoreEntity scoreEntity);

    /**
     * 根据id修改非空字段
     * @param scoreEntity
     * @return
     */
    public int updateByPrimaryKeySelective(ScoreEntity scoreEntity);

    /**
     * 根据id修改所有
     * @param scoreEntity
     * @return
     */
    public int updateByPrimaryKey(ScoreEntity scoreEntity);


    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * 根据id查询所有
     * @param id
     * @return
     */
    public ScoreEntity selectByPrimaryKey(Long id);

    /**
     * 查询所有数据
     * @param scoreEntity
     * @return
     */
    public List<ScoreEntity> selectAll(ScoreEntity scoreEntity);
}
