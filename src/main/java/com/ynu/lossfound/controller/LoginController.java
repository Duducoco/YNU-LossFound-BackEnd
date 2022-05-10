package com.ynu.lossfound.controller;

import com.ynu.lossfound.bean.LoginUserInfo;
import com.ynu.lossfound.bean.User;
import com.ynu.lossfound.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/api/login")
    public Map login(LoginUserInfo user) {
        User data = null;
        String token = null;
        int is_success = 0;
        data = userService.selectUser(user.getStudentID(), user.getPassword());
        if (data != null) {
            token = user.getStudentID() + user.getPassword() + new Date().getTime();
            is_success = 1;
        }


        Map map = new HashMap();
        map.put("data", data);
        map.put("token", token);
        map.put("state", is_success);
        return map;
    }
}
