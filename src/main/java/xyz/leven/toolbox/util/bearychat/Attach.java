package xyz.leven.toolbox.util.bearychat;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Attach {

    /**
     * 标题
     */
    private String title;

    /**
     * 必需带有 scheme，当同时传有 title 和 url 时，title 字段会带超链接
     */
    private String url;

    /**
     * 文本内容
     */
    private String text;

    /**
     * 用于控制 attachment 在排版时左侧的竖线分隔符颜色
     */
    private String color;

    /**
     * 图片列表
     */
    private List<String> images;
}
