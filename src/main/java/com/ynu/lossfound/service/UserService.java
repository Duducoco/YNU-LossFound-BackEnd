package com.ynu.lossfound.service;

import com.ynu.lossfound.bean.Found;
import com.ynu.lossfound.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public int insertUser(User user);
    public int selectUserByStudentID(String studentID);
    public User selectUser(String studentID, String password);
    public int updateUser(User user);
    public int updateUserPassword(String studentID, String origin_password, String password, String password2);

    public String selectEmailByStudentID(String studentID);
    public String selectEmailByPhone(String phone);
    public Boolean sendEmail(String email,String name, String teleMethod);

    public List<Found> selectFoundByHostStudentID(String studentID);
    public List<Found> selectFoundByHostPhone(String phone);
    public List<Found> selectFoundByHostEmail(String email);
}
