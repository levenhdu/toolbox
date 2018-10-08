package xyz.leven.toolbox.util.bearychat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.leven.toolbox.util.HttpClient;

import java.io.IOException;

public class BearyChatClient {
    private static Logger log = LoggerFactory.getLogger(BearyChatClient.class);


    /**
     * incoming robot hook url
     */
    private static final String INCOMING_HOOK_URL = "https://hook.bearychat.com/=bwEyA/incoming/25ae59a60bb5448b4f9be9bdb2bf94ae";

    public static String sendMsg(String msg) {
        String resp = "";
        try {
            resp = HttpClient.post(INCOMING_HOOK_URL, Msg.builder().text(msg).build().toString());
        } catch (IOException e) {
            log.info("[熊聊] 发送信息失败");
        }
        return resp;
    }
}
