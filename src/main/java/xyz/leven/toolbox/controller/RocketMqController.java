package xyz.leven.toolbox.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.leven.toolbox.service.RocketMqService;

import javax.annotation.Resource;

@RequestMapping("rocketmq")
@RestController
public class RocketMqController {

    @Resource
    RocketMqService rocketMqService;

    @PostMapping("send")
    public Object send(){
        try {
//            rocketMqService.send();
//            rocketMqService.sendAsyn();
//            rocketMqService.sendOneWay();
//            rocketMqService.sendOrderMsg();
            rocketMqService.sendDelayMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
