package com.ht.dsmxx.controller;

import com.ht.dsmxx.websocket.domain.AlarmMailDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private AlarmMailDomain alarmMailDomain;

    @RequestMapping("/get/mail")
    @ResponseBody
    public String getMail(){
        //提交代码
        return alarmMailDomain.get(1).toString();
    }
}
