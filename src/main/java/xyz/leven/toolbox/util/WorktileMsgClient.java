package xyz.leven.toolbox.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.leven.toolbox.util.bearychat.Msg;

import java.io.IOException;

/**
 * worktile
 *
 * @author leven
 * @since 2018/10/9
 */
public class WorktileMsgClient {

    private static Logger log = LoggerFactory.getLogger(WorktileMsgClient.class);

    /**
     * incoming robot hook url
     */
    private static final String INCOMING_HOOK_URL = "https://hook.worktile.com/incoming/f290ab5b69764a078b74cc4881689245";

    public static String sendMsg(String msg) {
        String resp = "";
        try {
            resp = HttpClient.post(INCOMING_HOOK_URL, Msg.builder().text(msg).build().toString());
        } catch (IOException e) {
            log.info("[worktile] 发送信息失败");
        }
        return resp;
    }


}
