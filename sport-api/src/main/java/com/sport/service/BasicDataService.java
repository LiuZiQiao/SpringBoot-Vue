package com.sport.service;

import com.github.pagehelper.PageInfo;
import com.sport.entity.BasicDataEntity;
import com.sport.vo.BasicDataVO;

import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 3:58 下午
 */

public interface BasicDataService {


    public List<BasicDataVO> getBasicDataByType(Short type);


    public boolean insertBasicData(BasicDataEntity entity);

    public boolean updateBasicData(BasicDataEntity entity);
    public boolean deleteBasicDataByTypeAndBasicCode(Short type,String basicCode);

    public List<BasicDataVO> getAllBasicDataListByCondition(BasicDataEntity entityCondition);
    public PageInfo<BasicDataVO> getPageBasicDataListByCondition(Integer pageStart, Integer pageSize, BasicDataEntity entityCondition);


    public List<BasicDataVO> getAllNames();
}
