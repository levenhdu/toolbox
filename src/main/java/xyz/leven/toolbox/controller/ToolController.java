package xyz.leven.toolbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.leven.toolbox.config.datasource.Ds;
import xyz.leven.toolbox.mapper.ToolMapper;
import xyz.leven.toolbox.service.ToolService;
import xyz.leven.toolbox.util.WorktileMsgClient;

import javax.annotation.Resource;

@RestController
@RequestMapping("tool")
@Slf4j
public class ToolController {
    @Resource
    ToolMapper toolMapper;

    @Resource
    ToolService toolService;


    @PostMapping("info")
    public Object info() {
        return toolService.toolList();
    }


}
