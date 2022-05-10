package com.ynu.lossfound.service.impl;

import com.ynu.lossfound.bean.Found;
import com.ynu.lossfound.mapper.FoundMapper;
import com.ynu.lossfound.service.FoundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FoundServiceImpl implements FoundService {
    @Autowired
    FoundMapper foundMapper;

    @Override
    public int selectFoundCount() {
        return foundMapper.selectFoundCount();
    }

    @Override
    public List<Found> selectFound(int start) {
        List<Found> founds = foundMapper.selectFound(start);
        log.info("Service层查到"+founds.size()+"");
        return founds;
    }

    @Override
    public List<Found> selectFoundByStudentID(String studentID) {
        return foundMapper.selectFoundByStudentID(studentID);
    }

    @Override
    public boolean deleteFound(int foundID) {
        int line = foundMapper.deleteFound(foundID);
        if(line > 0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void insertFound(Found found) {
        foundMapper.insertFound(found);
    }
}
