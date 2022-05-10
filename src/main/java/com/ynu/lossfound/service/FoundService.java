package com.ynu.lossfound.service;

import com.ynu.lossfound.bean.Found;

import java.util.List;

public interface FoundService {
    public void insertFound(Found found);
    public List<Found> selectFound(int start);
    public int selectFoundCount();
    public List<Found> selectFoundByStudentID(String studentID);
    public boolean deleteFound(int foundID);
}
