package com.ynu.lossfound.service.impl;

import com.ynu.lossfound.bean.Found;
import com.ynu.lossfound.bean.User;
import com.ynu.lossfound.mapper.UserMapper;
import com.ynu.lossfound.service.EmailService;
import com.ynu.lossfound.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailService emailService;

    @Override
    public User selectUser(String studentID, String password) {
        User a;
        // md5加密,密码
        password = DigestUtils.md5DigestAsHex((password+"ynu").getBytes());

        a = userMapper.select_user(studentID, password);
        if (a != null) {
            log.info(a +"登陆成功");
        }else{
            log.info(studentID +"登录失败");
        }
        return a;
    }

    @Override
    public int selectUserByStudentID(String studentID) {
        return userMapper.select_user_by_studentID(studentID);
    }

    /**
     * 异步操作，根据注册用户查询是否有其已经丢失的被发布的物品，如果有，则发送邮件
     * @param studentID 学号
     * @param phone 手机号
     * @param email 邮箱
     */
    @Async
    public void selectFoundAndSendEmail(String studentID, String phone,String email) {
        List<Found> foundList = selectFoundByHostStudentID(studentID);
        //如果根据学号能找到
        if (foundList.size() > 0) {
            for (Found found : foundList) {
                sendEmail(email,found.getFoundName(),found.getAuthorTeleMethod());
            }
            return ;
        }
        //根据手机号找
        foundList = selectFoundByHostPhone(phone);
        if (foundList.size() > 0) {
            for (Found found : foundList) {
                sendEmail(email,found.getFoundName(),found.getAuthorTeleMethod());
            }
            return ;
        }
        //根据邮箱查找
        foundList = selectFoundByHostEmail(phone);
        if (foundList.size() > 0) {
            for (Found found : foundList) {
                sendEmail(email,found.getFoundName(),found.getAuthorTeleMethod());
            }
        }
    }

    @Override
    public int insertUser(User user){
        // md5加密,密码
        String md5Str = DigestUtils.md5DigestAsHex((user.getPassword()+"ynu").getBytes());
        user.setPassword(md5Str);
        int userNumber = selectUserByStudentID(user.getStudentID());
        if(userNumber == 0){
            int res = userMapper.insert_user(user);
            // 查找有没有这个用户的东西被找到
            selectFoundAndSendEmail(user.getStudentID(),user.getPhone(),user.getEmail());
            return res;
        }else{
            return 0;
        }
    }



    @Override
    public int updateUser(User user){
        return userMapper.update_user(user);
    }

    @Override
    public int updateUserPassword(String studentID, String origin_password, String password, String password2) {
        return userMapper.update_user_password(studentID, origin_password, password, password2);
    }

    @Override
    public String selectEmailByStudentID(String studentID) {
        return userMapper.select_email_by_studentID(studentID);
    }

    @Override
    public String selectEmailByPhone(String phone) {
        return userMapper.select_email_by_phone(phone);
    }

    @Override
    public Boolean sendEmail(String email,String name,String teleMathod){
        emailService.sendMail(email,"您有丢失物品被找到","您丢失的"+name+"被找到，请根据下面的联系方式与捡到者联系:\n"+teleMathod);
        return true;
    }

    @Override
    public List<Found> selectFoundByHostStudentID(String studentID){
        return userMapper.select_found_by_host_studentID(studentID);
    }

    @Override
    public List<Found>selectFoundByHostPhone(String phone){
        return userMapper.select_found_by_host_phone(phone);
    }

    @Override
    public List<Found>selectFoundByHostEmail(String email){
        return userMapper.select_found_by_host_email(email);
    }
}
