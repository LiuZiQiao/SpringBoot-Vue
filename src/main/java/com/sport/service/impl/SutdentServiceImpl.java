package com.sport.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sport.common.utils.DateUtil;
import com.sport.common.utils.StringUtil;
import com.sport.dao.StudentDao;
import com.sport.entity.StudentEntity;
import com.sport.service.StudentService;
import com.sport.vo.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("studentService")
public class SutdentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public boolean insertStudent(StudentEntity entity) {
        boolean flag=false;
        int result = studentDao.insertSelective(entity);
        if(result > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateStudent(StudentEntity entity) {
        return false;
    }

    @Override
    public boolean deleteStudentById(Long id) {
        return false;
    }

    @Override
    public boolean approvalRegister(Long studentId) {
        boolean flag = false;
        if (studentId>0){
            StudentEntity student = new StudentEntity();
            student.setId(studentId);
            student.setStatus((byte)2);
            int result = studentDao.updateByPrimaryKeySelective(student);
            if(result > 0){
               flag = true;
            }
        }
        return flag;
    }

    /*
     * 获取全部
     */
    @Override
    @Transactional(readOnly = true)
    public List<StudentVO> getAllStudentListByCondition(StudentEntity entityCondition) {
        List<StudentVO> vos = new ArrayList<>();
        List<StudentEntity> list = studentDao.selectAll(entityCondition);
        if (list != null && list.size()>0){
            for (StudentEntity entity:list) {
                StudentVO vo = new StudentVO();
                BeanUtils.copyProperties(entity,vo);
                vos.add(vo);
            }
        }
        return vos;
    }


    /*
     * 获取分页数据
     * @param pageStart 开始页数
     * @param pageSize 每页条数
     * @param entityCondition
     */
//    @Override
//    @Transactional(readOnly = true)
//    public PageInfo<StudentVO> getPageStudentListByCondition(Integer pageStart, Integer pageSize, StudentEntity entityCondition) {
//        PageInfo<StudentVO> pageVo = new PageInfo<>();//返回结果
//
//        //查询结果
////        PageInfo<StudentEntity> pageInfo =
//        PageInfo<StudentEntity> pageInfo = PageHelper.startPage(pageStart, pageSize).doSelectPageInfo(new ISelect() {
//            @Override
//            public void doSelect() {
//                List<StudentEntity> studentEntities = studentDao.selectAll(entityCondition);
//                System.out.println(studentEntities);
//            }
//        });
//        System.out.println("----->"+pageInfo);
//        List<StudentVO> vos = new ArrayList<>();
//        for (StudentEntity entity:pageInfo.getList()){
//            StudentVO vo = new StudentVO();
//            BeanUtils.copyProperties(entity,vo);
//            if (entity.getBirthday() != null){
//                vo.setAge(DateUtil.getAge(DateUtil.string2Date(entity.getBirthday(),DateUtil.yyyy_MM_dd)));
//            }
//            if (entity.getSex() != null){
//                if (entity.getSex().equals((byte)1)){
//                    vo.setSexStr("男");
//                }else {
//                    vo.setSexStr("女");
//                }
//            }
//            if(entity.getStudentType() != null){
//                switch (entity.getStudentType()){
//                    case 1:
//                        vo.setStudentTypeStr("专科");
//                        break;
//                    case 2:
//                        vo.setStudentTypeStr("本科");
//                        break;
//                    case 3:
//                        vo.setStudentTypeStr("研究生");
//                        break;
//                    case 4:
//                        vo.setStudentTypeStr("留学生");
//                        break;
//                    case 5:
//                        vo.setStudentTypeStr("交换生");
//                        break;
//                    case 6:
//                        vo.setStudentTypeStr("国防生");
//                        break;
//                }
//            }
//            vos.add(vo);
//        }
//        pageVo.setList(vos);
//        pageVo.setTotal(pageInfo.getTotal());
//        return pageVo;
//    }


    @Override
    @Transactional(readOnly = true)
    public PageInfo<StudentVO> getPageStudentListByCondition(Integer pageStart,Integer pageSize, StudentEntity entityCondition){
        PageInfo<StudentVO> pageVo = new PageInfo<>();//返回结果
        //分页查询以及结果处理
        PageHelper.startPage(pageStart,pageSize);
        //查询结果
        List<StudentEntity> studentEntities =  studentDao.selectAll(entityCondition);
        PageInfo<StudentEntity> pageInfo = new PageInfo<>(studentEntities);

        System.out.println("----->"+pageInfo);
        List<StudentVO> vos = new ArrayList<>();
        for (StudentEntity entity:pageInfo.getList()){
            StudentVO vo = new StudentVO();
            BeanUtils.copyProperties(entity,vo);
            if (entity.getBirthday() != null){
                vo.setAge(DateUtil.getAge(DateUtil.string2Date(entity.getBirthday(),DateUtil.yyyy_MM_dd)));
            }
            if (entity.getSex() != null){
                if (entity.getSex().equals((byte)1)){
                    vo.setSexStr("男");
                }else {
                    vo.setSexStr("女");
                }
            }
            if(entity.getStudentType() != null){
                switch (entity.getStudentType()){
                    case 1:
                        vo.setStudentTypeStr("专科");
                        break;
                    case 2:
                        vo.setStudentTypeStr("本科");
                        break;
                    case 3:
                        vo.setStudentTypeStr("研究生");
                        break;
                    case 4:
                        vo.setStudentTypeStr("留学生");
                        break;
                    case 5:
                        vo.setStudentTypeStr("交换生");
                        break;
                    case 6:
                        vo.setStudentTypeStr("国防生");
                        break;
                }
            }
            vos.add(vo);
        }
        pageVo.setList(vos);
        pageVo.setTotal(pageInfo.getTotal());
        return pageVo;
    }

    @Override
    public StudentVO login(String name, String password) {
        StudentVO student = null;
        if (StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(password)){
            StudentEntity entity = studentDao.selectForLogin(name,password);
            if (entity != null){
                student = new StudentVO();
                BeanUtils.copyProperties(entity,student);
            }
        }
        return student;
    }

}
