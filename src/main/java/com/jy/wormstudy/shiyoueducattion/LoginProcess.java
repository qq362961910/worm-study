package com.jy.wormstudy.shiyoueducattion;


import com.jy.util.common.HashUtil;
import com.jy.util.http.HttpResponseEntity;
import com.jy.util.http.RequestUtil;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginProcess {

    private static final Logger logger = LoggerFactory.getLogger(LoginProcess.class);

    private String username;
    private String password;
    private URI uri;

    public void login(AuthenticationHolder authenticationHolder) throws IOException, NoSuchAlgorithmException {

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Content-Type", "application/x-www-form-urlencoded;");
        headers.put("Cookie", "JSESSIONID=" + authenticationHolder.getCenterSessionId());
        headers.put("Host", uri.getHost());
        headers.put("Origin", "http://www.cupde.cn");
        headers.put("Connection", "close");
        headers.put("Referer", "http://www.cupde.cn/cms/");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3423.2 Safari/537.36");

        Map<String, Object> payload = new HashMap<>();
        payload.put("loginId", username);
        payload.put("passwd", HashUtil.md5(password));
        payload.put("pwd", password);
        payload.put("authCode", authenticationHolder.getValidateCode());
        payload.put("auto", false);
        payload.put("into", 0);

        HttpResponseEntity httpResponseEntity = RequestUtil.post(uri.toString(), headers, payload);
        for (Header header: httpResponseEntity.getHeaders()) {
            if(header.getName().equalsIgnoreCase("Set-Cookie")) {
                for (HeaderElement element: header.getElements()) {
                    if("UC00OOIIll11".equalsIgnoreCase(element.getName())) {
                        logger.info("login response UC00OOIIll11: {}", element);
                        authenticationHolder.setUC00OOIIll11(element.getValue());
                        break;
                    }
                }
            }
        }


        logger.info("login response code: {}", httpResponseEntity.getCode());
        logger.info("login response body: {}", new String(httpResponseEntity.getContent()));
    }

    public LoginProcess(String username, String password, URI uri) {
        this.username = username;
        this.password = password;
        this.uri = uri;
    }
}
