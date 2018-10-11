package xyz.leven.toolbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.leven.toolbox.mapper.ToolMapper;
import xyz.leven.toolbox.util.WorktileMsgClient;

import javax.annotation.Resource;

@RestController
@RequestMapping("tool")
@Slf4j
public class ToolController {
    @Resource
    ToolMapper toolMapper;

    @PostMapping("info")
    public Object info() {
      return   WorktileMsgClient.sendMsg("123 > 12");
    }


}
