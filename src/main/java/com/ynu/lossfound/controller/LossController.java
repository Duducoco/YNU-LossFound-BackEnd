package com.ynu.lossfound.controller;

import com.ynu.lossfound.bean.Loss;
import com.ynu.lossfound.service.LossService;
import com.ynu.lossfound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LossController {
    @Autowired
    LossService lossService;

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/api/lossPages")
    public int selectFoundPages(){
        int count = lossService.selectLossCount();
        if (count % 10 == 0){
            return count / 10;
        }else{
            return count / 10 + 1;
        }
    }

    @ResponseBody
    @GetMapping("/api/postLoss")
    public void insertLoss(Loss loss){
        lossService.insertLoss(loss);
    }

    @ResponseBody
    @GetMapping("/api/selectLoss")
    public List<Loss> selectLoss(@RequestParam("start") int start){
        return lossService.selectLoss(start);
    }

    @ResponseBody
    @GetMapping("/api/selectLossByStudentID")
    public List<Loss> selectLossByStudentID(@RequestParam("studentID") String studentID){
        return lossService.selectLossByStudentID(studentID);
    }

    @ResponseBody
    @GetMapping("/api/deleteLossByID")
    public boolean deleteLossByID(@RequestParam("lossID") int lossID){
        return lossService.deleteLossByLossID(lossID);
    }


}
