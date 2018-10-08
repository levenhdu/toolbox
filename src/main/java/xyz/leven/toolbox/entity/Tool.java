package xyz.leven.toolbox.entity;

import javax.persistence.*;

@Table(name = "`tool`")
public class Tool extends Base {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 工具名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取工具名称
     *
     * @return name - 工具名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置工具名称
     *
     * @param name 工具名称
     */
    public void setName(String name) {
        this.name = name;
    }
}