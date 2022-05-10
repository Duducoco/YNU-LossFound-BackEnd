package com.ynu.lossfound.controller;

import com.ynu.lossfound.bean.User;
import com.ynu.lossfound.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/api/register")
    public boolean register(User user) {
        int insertNum=userService.insertUser(user);
        if (insertNum == 1){
            log.info("注册成功");
        }else{
            log.info("注册失败");
        }
        return insertNum != 0;
    }

    @ResponseBody
    @GetMapping("/api/update")
    public boolean update(User user) {
        int line = userService.updateUser(user);
        if (line == 1){
            log.info("修改信息成功");
        }else{
            log.info("修改信息失败");
        }
        return line != 0;
    }

    @ResponseBody
    @GetMapping("/api/changePassword")
    public boolean update(@RequestParam("studentID") String studentID,
                          @RequestParam("origin_password") String origin_password,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2) {
        if (!password.equals(password2)){
            return false;
        }
        int line = userService.updateUserPassword(studentID, origin_password, password, password2);
        if (line == 1){
            log.info("修改密码成功");
        }else{
            log.info("修改密码失败");
        }
        return line != 0;
    }

}
