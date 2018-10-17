package xyz.leven.toolbox.service;

import org.springframework.stereotype.Service;
import xyz.leven.toolbox.config.datasource.Ds;
import xyz.leven.toolbox.mapper.ToolMapper;

import javax.annotation.Resource;

/**
 * @author leven
 * @since 2018/10/12
 */
@Service
public class ToolService {

    @Resource
    private ToolMapper toolMapper;

    @Ds("ggjDs")
    public Object toolList() {
        return toolMapper.selectAll();
    }
}
