package com.sport.dao;

import com.sport.entity.BasicDataEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 12:45 下午
 */

@ResponseBody
public interface BasicDataDao {

    /**
     * 根据type获取基本数据类型
     * @param type
     * @return
     */
    List<BasicDataEntity> selectByType(Short type);

    /**
     * 根据type和basicCode获取基本数据类型
     * @param type
     * @param basicCode
     * @return
     */
    BasicDataEntity selectBasicDataByTypeCode(@Param("type")Short type,@Param("basicCode") String basicCode);

    /**
     * 添加所有
     * @param entity
     * @return
     */
    public int insert(BasicDataEntity entity);


    /**
     * 添加非空字段
     * @param basicDataEntity
     * @return
     */
    public int insertSelective(BasicDataEntity basicDataEntity);

    /**
     * 根据id修改所有
     * @param basicDataEntity
     * @return
     */
    public int updateByPrimaryKey(BasicDataEntity basicDataEntity);


    /**
     * 根据id修改非空字段
     * @param basicDataEntity
     * @return
     */
    public int updateByPrimaryKeySelective(BasicDataEntity basicDataEntity);


    /**根据type和basicCode删除
     * @param type
     * @param basicCode
     * @return
     */
    public int deleteByTypeAndBasicCode(@Param("type")Short type,@Param("basicCode")String basicCode);

    /**
     * 查询所有数据
     * @param basicDataEntity
     * @return
     */
    public List<BasicDataEntity> selectAll(BasicDataEntity basicDataEntity);

    /**
     * 获取所有名称，去重
     * @return
     */
    public List<BasicDataEntity> getAllNames();
}
