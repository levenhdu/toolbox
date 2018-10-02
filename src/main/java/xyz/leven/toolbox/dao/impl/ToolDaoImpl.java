package xyz.leven.toolbox.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.leven.toolbox.dao.ToolDao;
import xyz.leven.toolbox.entity.ToolEntity;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ToolDaoImpl implements ToolDao {
    @Resource
    JdbcTemplate jdbcTemplate;

    public static final String LIST_QUERY_SQL="SELECT\n" +
            "  id,\n" +
            "  name\n" +
            "FROM tool";

    @Override
    public List<ToolEntity> listTool() {
        return jdbcTemplate.query(LIST_QUERY_SQL,new Object[]{},new BeanPropertyRowMapper<>(ToolEntity.class));
    }
}
