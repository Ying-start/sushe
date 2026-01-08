package com.sushe.service.impl;

import com.github.pagehelper.PageInfo;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.StudentCleanDao;
import com.sushe.po.StudentClean;
import com.sushe.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 学生卫生接口实现
 * @author: Joyrocky
 * @create: 2019-04-25 12:16
 **/
@Service("studentCleanService")
@Transactional
public class StudentCleanServiceImpl implements StudentCleanService {
    // classDao
    @Autowired
    private StudentCleanDao studentCleanDao;


    //分页查询
    @Override
    @PageQuery
    public PageInfo<StudentClean> findPageInfo(StudentClean studentClean) {

            List<StudentClean> studentCleanList =	studentCleanDao.getStudentCleanList(studentClean.getS_studentid(),studentClean.getS_name(),studentClean.getS_dormitoryid());

        return new PageInfo<>(studentCleanList);
    }

    @Override
    public List<StudentClean> getAll(){
        List<StudentClean> studentCleanList = studentCleanDao.getAll();
        return studentCleanList;
    }

    //添加宿舍卫生信息
    @Override
    public int addStudentClean(StudentClean studentclean) {
        return studentCleanDao.addStudentClean(studentclean);
    }

    //通过id删除宿舍卫生信息
    @Override
    public int deleteStudentClean(Integer g_id) {
        return studentCleanDao.deleteStudentClean(g_id);
    }

    //修改宿舍卫生信息
    @Override
    public int updateStudentClean(StudentClean studentclean) {
        return studentCleanDao.updateStudentClean(studentclean);
    }

    @Override
    public StudentClean findStudentCleanById (Integer g_id){
        StudentClean d = studentCleanDao.findStudentCleanById(g_id);
        return  d;
    }

}

