package xyz.leven.toolbox.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.leven.toolbox.dao.ToolDao;
import xyz.leven.toolbox.entity.ToolEntity;
import xyz.leven.toolbox.mapper.ToolMapper;

import javax.annotation.Resource;

@RestController
@RequestMapping("tool")
public class ToolController {
    @Resource
    ToolDao toolDao;

    @Resource
    ToolEntity toolEntity;

    @Resource
    ToolMapper toolMapper;

    @PostMapping("info")
    public Object info() {

        return toolMapper.listTool();
    }

}
