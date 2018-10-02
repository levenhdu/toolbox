package xyz.leven.toolbox.dao;

import xyz.leven.toolbox.entity.ToolEntity;

import java.util.List;

public interface ToolDao {
    /**
     * 获取工具列表
     */
    List<ToolEntity> listTool();
}
