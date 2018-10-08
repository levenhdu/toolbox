package xyz.leven.toolbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.leven.toolbox.mapper.ToolMapper;
import xyz.leven.toolbox.util.HttpClient;
import xyz.leven.toolbox.util.bearychat.BearyChatClient;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("tool")
@Slf4j
public class ToolController {
    @Resource
    ToolMapper toolMapper;

    @PostMapping("info")
    public Object info() {
      return   BearyChatClient.sendMsg("lalala");
    }


}
