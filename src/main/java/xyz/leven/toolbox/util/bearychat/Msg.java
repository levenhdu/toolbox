package xyz.leven.toolbox.util.bearychat;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StreamUtils;

@Getter
@Builder
public class Msg {
    /**
     * 文本内容（不能为空）
     */
    private String text;

    /**
     * 用于控制消息提醒的内容显示
     */
    private String notification;

    /**
     * 用于控制 text 是否解析为 markdown，默认为 true
     */
    private Boolean markdown;

    /**
     * 讨论组名称
     * 如果有该字段并且该讨论组对于机器人创建者可见，消息会发送到指定讨论组中
     */
    private String channel;

    /**
     * 用户名，邮箱或者手机
     * <p>
     * 在未指定 channel 时如果指定该字段并且该团队中有对应的成员，消息会发送到该成员和 BearyBot 的私聊会话中。
     * 注：如果是手机或者邮箱，该字段必须是验证过的。
     * </p>
     */
    private String user;

    /**
     * 附件
     */
    private Attach attach;

    @Override
    public String toString() {
        JSONObject jo = new JSONObject();
        jo.put("text",text);
        if(StringUtils.isNotEmpty(notification)){
            jo.put("notification",notification);
        }
        if(markdown!=null){
            jo.put("markdown",markdown);
        }
        if(StringUtils.isNotEmpty(channel)){
            jo.put("channel",channel);
        }
        if(StringUtils.isNotEmpty(user)){
            jo.put("user",user);
        }
        if (attach != null) {
            JSONObject attachJo = new JSONObject();
            if (StringUtils.isNotEmpty(attach.getTitle())) {
                attachJo.put("title", attach.getTitle());
            }
            if (StringUtils.isNotEmpty(attach.getUrl())) {
                attachJo.put("url", attach.getUrl());
            }
            if (StringUtils.isNotEmpty(attach.getText())) {
                attachJo.put("text", attach.getText());
            }
            if (StringUtils.isNotEmpty(attach.getColor())) {
                attachJo.put("color", attach.getColor());
            }
            if (attach.getImages() != null && attach.getImages().size() > 0) {
                attachJo.put("images", attach.getImages());
            }
            jo.put("attach",attachJo);
        }
        return jo.toString();
    }
}
