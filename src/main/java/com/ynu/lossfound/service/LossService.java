package com.ynu.lossfound.service;


import com.ynu.lossfound.bean.Loss;

import java.util.List;

public interface LossService {
    public void insertLoss(Loss loss);
    public List<Loss> selectLoss(int start);
    public int selectLossCount();
    public List<Loss> selectLossByStudentID(String studentID);
    public boolean deleteLossByLossID(int lossID);
}
