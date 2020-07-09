package com.sport.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sport.common.utils.DateUtil;
import com.sport.dao.BasicDataDao;
import com.sport.dao.ScoreDao;
import com.sport.dao.StudentDao;
import com.sport.dao.TeacherDao;
import com.sport.entity.BasicDataEntity;
import com.sport.entity.ScoreEntity;
import com.sport.entity.StudentEntity;
import com.sport.entity.TeacherEntity;
import com.sport.service.ScoreService;
import com.sport.vo.ScoreVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 10:21 上午
 */
@Transactional
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreDao scoreDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private BasicDataDao basicDataDao;

    /**
     * 添加
     * @param scoreEntity
     * @return
     */

    @Override
    public boolean insertScore(ScoreEntity scoreEntity) {
        boolean flag = false;
        int result = scoreDao.insert(scoreEntity);
        if (result>0){
            flag = true;
        }
        return flag;
    }

    /**
     * update Score
     *
     * @param scoreEntity
     * @return
     */
    @Override
    public boolean updateScore(ScoreEntity scoreEntity) {
        boolean flag = false;
        int ret = scoreDao.updateByPrimaryKey(scoreEntity);
        if (ret>0){
            flag = true;
        }
        return flag;
    }

    /**
     * delete score by id
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteScoreById(Long id) {
        boolean flag = false;
        int ret = scoreDao.deleteByPrimaryKey(id);
        if (ret>0){
            flag=true;
        }
        return flag;
    }

    /**
     * get score by id
     * @param id
     * @return
     */
    @Override
    public ScoreVO getScoreById(Long id) {
        ScoreVO vo = new ScoreVO();
        ScoreEntity entity = scoreDao.selectByPrimaryKey(id);
        if (entity != null){
            BeanUtils.copyProperties(entity,vo);
        }
        return vo;
    }

    /**
     * 按条件获取全部
     *
     * @param scoreEntity
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<ScoreVO> getAllScoreListByCondition(ScoreEntity scoreEntity) {
        List<ScoreVO> vos = new ArrayList<>();
        List<ScoreEntity> list = scoreDao.selectAll(scoreEntity);
        if (list != null && list.size()>0){
            for (ScoreEntity entity:list){
                ScoreVO vo = new ScoreVO();
                BeanUtils.copyProperties(entity,vo);
                vos.add(vo);
            }
        }
        return vos;
    }

    /**
     * 按条件分页查询
     *
     * @param pageStart
     * @param pageSize
     * @param scoreEntity
     * @return
     */
    @Override
    public PageInfo<ScoreVO> getPageScoreListByCondition(Integer pageStart, Integer pageSize, ScoreEntity scoreEntity) {
        PageInfo<ScoreVO> pageVo = new PageInfo<>();
        List<ScoreEntity> scoreEntities = scoreDao.selectAll(scoreEntity);
        PageInfo<ScoreEntity> pageInfo = new PageInfo<>(scoreEntities);
        PageHelper.startPage(pageStart,pageSize);

        List<ScoreVO> vos = new ArrayList<>();
        for (ScoreEntity entity:pageInfo.getList()){
            ScoreVO vo = new ScoreVO();
            BeanUtils.copyProperties(entity,vo);

            StudentEntity studentEntity = studentDao.selectByPrimaryKey(entity.getStudentId());
            if (studentEntity != null){
                vo.setStudentName(studentEntity.getName());
            }
            TeacherEntity teacherEntity = teacherDao.selectByPrimaryKey(entity.getTeacherId());
            if (teacherEntity != null){
                vo.setTeacherId(entity.getTeacherId());
            }
            vo.setUpdateTimeStr(DateUtil.date2String(entity.getUpdateTime(),DateUtil.yyyy_MM_dd_HH_mm_ss));
            BasicDataEntity basicDataEntity = basicDataDao.selectBasicDataByTypeCode((short)1,entity.getProject().toString());
            if (basicDataEntity!=null){
                vo.setProjectStr(basicDataEntity.getBasicName());
            }
            vos.add(vo);
        }
        pageVo.setList(vos);
        pageVo.setTotal(pageInfo.getTotal());
        System.out.println("------>"+pageVo);
        return pageVo;
    }
}
