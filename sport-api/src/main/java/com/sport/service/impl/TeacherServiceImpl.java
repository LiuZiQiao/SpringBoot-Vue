package com.sport.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sport.common.utils.DateUtil;
import com.sport.common.utils.StringUtil;
import com.sport.dao.TeacherDao;
import com.sport.entity.TeacherEntity;
import com.sport.service.TeacherService;
import com.sport.vo.TeacherVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    @Override
    public PageInfo getPageTeacherListByCondition(Integer pageStart, Integer pageSize, TeacherEntity entity) {
        //最终返回结果
        PageInfo<TeacherVO> pageVo=new PageInfo<TeacherVO>();

        PageHelper.startPage(pageStart, pageSize);
        //先查询，然后分页处理
        List<TeacherEntity> teacherEntities = teacherDao.selectAll(entity);
        PageInfo<TeacherEntity> pageInfo = new PageInfo<>(teacherEntities);

        List<TeacherVO> vos=new ArrayList<TeacherVO>();
        for(TeacherEntity teacherEntity:pageInfo.getList()){
            TeacherVO vo=new TeacherVO();
            BeanUtils.copyProperties(teacherEntity, vo);
            vo.setAge(DateUtil.getAge(DateUtil.string2Date(teacherEntity.getBirthday(),DateUtil.yyyy_MM_dd)));
            if(teacherEntity.getSex().equals((byte)1)){
                vo.setSexStr("男");
            }else{
                vo.setSexStr("女");
            }
            vos.add(vo);
        }

        pageVo.setList(vos);
        pageVo.setTotal(pageInfo.getTotal());
        return pageVo;
    }

    @Override
    public TeacherVO login(String name, String password) {
        TeacherVO teacher = null;
        System.out.println(name +"--"+password);
        if (StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(password)){
            TeacherEntity teacherEntity = teacherDao.selectForLogin(name, password);
            if (teacherEntity != null){
                teacher = new TeacherVO();
                BeanUtils.copyProperties(teacherEntity,teacher);
            }
        }
        return teacher;
    }
}
