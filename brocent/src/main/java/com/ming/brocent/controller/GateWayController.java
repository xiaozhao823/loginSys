package com.ming.brocent.controller;

import com.ming.brocent.domain.User;
import com.ming.brocent.service.IGateWayService;
import com.ming.brocent.utils.SendEmailCodeUtil;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class GateWayController {

    @Autowired
    SendEmailCodeUtil sendEmailCodeUtil;

    @Autowired
    IGateWayService gateWayService;

    @GetMapping
    public String ss() {
        sendEmailCodeUtil.sendEmail("16609711004@163.com","334443");
        return "发送成功";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user){
        List<User> userList = gateWayService.selectUserINfo(user);
        if(userList.size() == 1){
            return userList.get(0).getUserId();
        }else {
            return "false";
        }
    }

    @PostMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody User user){
        gateWayService.insertUserInfo(user);
        return "ok";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){
        gateWayService.updateUserInfo(user);
        return "ok";
    }
}
