package xyz.leven.toolbox.mapper;

import org.springframework.stereotype.Repository;
import xyz.leven.toolbox.entity.ToolEntity;

/**
 * @author leven
 * @since 2018/10/8
 */
@Repository
public interface ToolMapper {
    ToolEntity listTool();

}
