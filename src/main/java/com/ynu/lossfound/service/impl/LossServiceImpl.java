package com.ynu.lossfound.service.impl;

import com.ynu.lossfound.bean.Loss;
import com.ynu.lossfound.mapper.LossMapper;
import com.ynu.lossfound.service.LossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LossServiceImpl implements LossService {
    @Autowired
    LossMapper lossMapper;

    @Override
    public List<Loss> selectLoss(int start) {
        return lossMapper.selectLoss(start);
    }

    @Override
    public int selectLossCount() {
        return lossMapper.selectLossCount();
    }

    @Override
    public void insertLoss(Loss loss) {
        lossMapper.insertLoss(loss);
    }

    @Override
    public List<Loss> selectLossByStudentID(String studentID) {
        return lossMapper.selectLossByStudentID(studentID);
    }

    @Override
    public boolean deleteLossByLossID(int lossID) {
        int line = lossMapper.deleteLossByLossID(lossID);
        if (line > 0) {
            return true;
        }else {
            return false;
        }
    }
}
