package xyz.leven.toolbox.util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * http请求客户端
 */
public class HttpClient {
    private static Logger log = LoggerFactory.getLogger(HttpClient.class);

    public static final MediaType JSON_MEDIA_TYPE
            = MediaType.parse("application/json; charset=utf-8");

    /**
     * post
     */
    public static String post(String url, String json) throws IOException {
        return post(new OkHttpClient(), url, json);
    }

    /**
     * post
     */
    public static String post(OkHttpClient client, String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return call(client, request, json);
    }

    /**
     * get
     */
    public static String get(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return call(client, request);
    }

    /**
     * get
     */
    public static String get(String url) throws IOException {
        return get(new OkHttpClient(), url);
    }

    /**
     * 调用请求
     *
     * @param client  客户端
     * @param request 请求
     * @return 响应内容
     * @throws IOException IO异常
     */
    private static String call(OkHttpClient client, Request request, String body) throws IOException {
        Response response = client.newCall(request).execute();
        if (log.isDebugEnabled()) {
            log.debug("[httpCall] method:" + request.method() + " url:" + request.url() + " body:" + JSON.toJSONString(body));
        }
        String responseContent = response.body() == null ? null : response.body().string();
        if (log.isDebugEnabled()) {
            log.debug("[httpResp] content:" + responseContent);
        }
        return responseContent;
    }

    /**
     * 调用请求
     *
     * @param client  客户端
     * @param request 请求
     * @throws IOException IO异常
     */
    private static String call(OkHttpClient client, Request request) throws IOException {
        return call(client, request, null);
    }


}
