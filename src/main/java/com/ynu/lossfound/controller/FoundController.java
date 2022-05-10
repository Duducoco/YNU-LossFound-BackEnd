package com.ynu.lossfound.controller;

import com.ynu.lossfound.bean.Found;
import com.ynu.lossfound.service.FoundService;
import com.ynu.lossfound.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class FoundController {
    @Autowired
    FoundService foundService;

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/api/postFound")
    public void postFound(Found found, @RequestParam("authorTeleMethod") String teleMethod){
        if (found.getEmailFeature() != null){
            userService.sendEmail(found.getEmailFeature(),found.getFoundName(), teleMethod);
        }else if(found.getStudentIDFeature() != null) {
            String email = userService.selectEmailByStudentID(found.getStudentIDFeature());
            if (email != null){
                userService.sendEmail(email, found.getFoundName(),teleMethod);
            }
        }else if (found.getPhoneFeature() != null){
            String email = userService.selectEmailByPhone(found.getPhoneFeature());
            if (email != null){
                userService.sendEmail(email, found.getFoundName(),teleMethod);
            }
        }
        foundService.insertFound(found);
    }

    @ResponseBody
    @GetMapping("/api/selectFound")
    public List<Found> selectFound(@RequestParam("start") int start){
        List<Found> founds = foundService.selectFound(start);
        log.info(founds.size()+"");
        log.info(founds.toString());
        return founds;
    }

    @ResponseBody
    @GetMapping("/api/foundPages")
    public int selectFoundPages(){
        int count = foundService.selectFoundCount();
        if (count % 10 == 0){
            return count / 10;
        }else{
            return count / 10 + 1;
        }
    }

    @ResponseBody
    @GetMapping("/api/selectFoundByStudentID")
    public List<Found> selectFoundByStudentID(@RequestParam("studentID") String studentID){
        return foundService.selectFoundByStudentID(studentID);
    }


    @ResponseBody
    @GetMapping("/api/deleteFoundByID")
    public boolean deleteFoundByID(@RequestParam("foundID") int foundID){
        return foundService.deleteFound(foundID);
    }



}
