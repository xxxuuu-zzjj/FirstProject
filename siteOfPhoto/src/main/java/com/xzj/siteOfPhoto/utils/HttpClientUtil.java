package com.xzj.siteOfPhoto.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * @author Yiheng Lin
 * @date 2020/8/28 14:49
 */
public class HttpClientUtil {

    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static RequestConfig globalConfig;
    private static CookieStore cookieStore;
    private static CloseableHttpClient httpClient;
    private static HttpClientContext context;

    static {
        globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .setDefaultCookieStore(cookieStore).build();
        context = HttpClientContext.create();
        context.setCookieStore(cookieStore);
    }

    public static CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public static HttpClientContext getHttpContext() {
        return context;
    }

    public static HttpRespInfo getRespInfo(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        Integer statusCode = response.getStatusLine().getStatusCode();
        String entityContent = IOUtils.toString(entity.getContent(), "UTF-8");
        System.out.println("状态码：" + statusCode);
        System.out.println("内容：" + entityContent);
        response.close();
        for (Cookie c : context.getCookieStore().getCookies()) {
            System.out.println(c.getName() + ": " + c.getValue());
        }
        return new HttpRespInfo(statusCode, entityContent);
    }

    public static HttpRespInfo getRespInfo(String json, String reqUrl) throws IOException {
        HttpPost httpPost = new HttpPost(reqUrl);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpRespInfo httpRespInfo = getRespInfo(response);
        return httpRespInfo;
    }
    public static HttpRespInfo getRespInfoBySendStr(String json, String reqUrl)throws IOException{
        StringBuilder reqBodyBuilder=new StringBuilder();
        reqBodyBuilder.append("info=").append(json);
        String reqBody=reqBodyBuilder.toString();
        StringEntity reqStringEntity = new StringEntity(reqBody, ContentType.create("application/x-www-form-urlencoded"));
        HttpPost httpPost = new HttpPost(reqUrl);
        httpPost.setEntity(reqStringEntity);
        CloseableHttpResponse response= httpClient.execute(httpPost);
        return getRespInfo(response);
    }

    public static void httpClientLogin(String loginUrl,String loginName,String password) throws IOException{
        StringBuilder reqBodyBuilder=new StringBuilder();
        reqBodyBuilder.append("loginName=").append(loginName).append("&");
        reqBodyBuilder.append("password=").append(password);
        String reqBody=reqBodyBuilder.toString();
        StringEntity sysUserStringEntity = new StringEntity(reqBody, ContentType.create("application/x-www-form-urlencoded"));
        HttpPost loginHttpPost = new HttpPost(loginUrl);
        loginHttpPost.setEntity(sysUserStringEntity);
        CloseableHttpResponse loginResp = httpClient.execute(loginHttpPost);
        HttpRespInfo loginRespInfo=HttpClientUtil.getRespInfo(loginResp);
        JSONObject loginStatus= JSON.parseObject(loginRespInfo.getContent());
        loginStatus.getBoolean("success");
        logger.info(loginStatus.getString("message"));
    }

    public static HttpRespInfo getRespInfoByGet(String reqUrl) throws IOException {
        HttpGet httpGet = new HttpGet(reqUrl);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpRespInfo httpRespInfo=getRespInfo(response);
        return httpRespInfo;
    }
}
