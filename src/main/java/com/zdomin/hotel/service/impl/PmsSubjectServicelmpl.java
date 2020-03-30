package com.zdomin.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdomin.hotel.mbg.mapper.PmsSubjectMapper;
import com.zdomin.hotel.mbg.model.PmsSubject;
import com.zdomin.hotel.mbg.model.PmsSubjectExample;
import com.zdomin.hotel.service.PmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;

@Service
public class PmsSubjectServicelmpl implements PmsSubjectService {

    @Autowired
    PmsSubjectMapper subjectMapper;

    @Override
    public List<PmsSubject> listAllSubject() {

        return subjectMapper.selectByExample(new PmsSubjectExample());
    }

    @Override
    public int create(PmsSubject pmsSubject) {
        pmsSubject.setId(null);
        subjectMapper.insert(pmsSubject);
        return 1;
    }

    @Override
    public int update(int id, PmsSubject pmsSubject) {
        pmsSubject.setId(id);
        subjectMapper.updateByPrimaryKeySelective(pmsSubject);
        return 1;

    }

    @Override
    public int delete(int id) {
        subjectMapper.deleteByPrimaryKey(id);
        return 1;
    }

    public List<PmsSubject> getSubjectList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return subjectMapper.selectByExample(new PmsSubjectExample());
    }

    @Override
    public PmsSubject getItem(int id) {

        return subjectMapper.selectByPrimaryKey(id);
    }
}
