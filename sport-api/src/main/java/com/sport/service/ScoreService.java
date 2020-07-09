package com.sport.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sport.entity.ScoreEntity;
import com.sport.vo.ScoreVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 10:04 上午
 */

public interface ScoreService {

    /**
     * 添加
     * @param scoreEntity
     * @return
     */
    public boolean insertScore(ScoreEntity scoreEntity);

    /**
     * update Score
     * @param scoreEntity
     * @return
     */
    public boolean updateScore(ScoreEntity scoreEntity);

    /**
     * delete score by id
     * @param id
     * @return
     */
    public boolean deleteScoreById(Long id);

    /**
     * get score by id
     * @param id
     * @return
     */
    public ScoreVO getScoreById(Long id);

    /**
     * 按条件获取全部
     * @param scoreEntity
     * @return
     */
    public List<ScoreVO> getAllScoreListByCondition(ScoreEntity scoreEntity);

    /**
     * 按条件分页查询
     * @param pageStart
     * @param pageSize
     * @param scoreEntity
     * @return
     */
    public PageInfo<ScoreVO> getPageScoreListByCondition(Integer pageStart, Integer pageSize, ScoreEntity scoreEntity);
}
