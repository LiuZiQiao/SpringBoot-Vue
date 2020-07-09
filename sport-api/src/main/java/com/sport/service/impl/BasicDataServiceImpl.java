package com.sport.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sport.common.entity.BasicEntity;
import com.sport.dao.BasicDataDao;
import com.sport.entity.BasicDataEntity;
import com.sport.service.BasicDataService;
import com.sport.vo.BasicDataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 4:01 下午
 */
@Transactional
@Service("basicDataService")
public class BasicDataServiceImpl implements BasicDataService {

    @Resource
    private BasicDataDao basicDataDao;

    @Transactional(readOnly = true)
    @Override
    public List<BasicDataVO> getBasicDataByType(Short type) {
        List<BasicDataVO> vos = new ArrayList<>();
        List<BasicDataEntity> basicEntities = basicDataDao.selectByType(type);
        if (basicEntities != null && basicEntities.size()>0){
            for (BasicEntity entity:basicEntities){
                BasicDataVO vo = new BasicDataVO();
                BeanUtils.copyProperties(entity,vo);
                vos.add(vo);
            }
        }
        return vos;
    }

    @Override
    public boolean insertBasicData(BasicDataEntity entity) {
        int ret = basicDataDao.insertSelective(entity);
        if (ret>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBasicData(BasicDataEntity entity) {
        int ret = basicDataDao.updateByPrimaryKeySelective(entity);
        if (ret>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBasicDataByTypeAndBasicCode(Short type, String basicCode) {
        int ret = basicDataDao.deleteByTypeAndBasicCode(type, basicCode);
        if(ret>0){
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BasicDataVO> getAllBasicDataListByCondition(BasicDataEntity entityCondition) {
        List<BasicDataVO> vos = new ArrayList<>();
        List<BasicDataEntity> list = basicDataDao.selectAll(entityCondition);
        if (list !=null && list.size()>0){
            for (BasicDataEntity entity: list){
                BasicDataVO vo = new BasicDataVO();
                BeanUtils.copyProperties(entity,vo);
                vos.add(vo);
            }
        }
        return vos;
    }

    @Override
    public PageInfo<BasicDataVO> getPageBasicDataListByCondition(Integer pageStart, Integer pageSize, BasicDataEntity entityCondition) {
        PageInfo<BasicDataVO> pageVo = new PageInfo<>();
        List<BasicDataEntity> basicDataEntities = basicDataDao.selectAll(entityCondition);
        System.out.println(basicDataEntities.size());
        PageInfo<BasicDataEntity> pageInfo = new PageInfo<>(basicDataEntities);
        PageHelper.startPage(pageStart,pageSize);


        List<BasicDataVO> vos = new ArrayList<>();
        for (BasicDataEntity entity:basicDataEntities){
            BasicDataVO vo = new BasicDataVO();
            BeanUtils.copyProperties(entity,vo);
            vos.add(vo);
        }
        pageVo.setList(vos);
        pageVo.setTotal(pageInfo.getTotal());
        return pageVo;
    }

    @Override
    public List<BasicDataVO> getAllNames() {
        List<BasicDataVO> vos = new ArrayList<>();
        List<BasicDataEntity> list = basicDataDao.getAllNames();
        if (list !=null && list.size()>0){
            for (BasicDataEntity entity:list){
                BasicDataVO vo = new BasicDataVO();
                BeanUtils.copyProperties(entity,vo);
                vos.add(vo);
            }
        }
        return vos;
    }
}
