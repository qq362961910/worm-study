package com.jy.wormstudy.shiyoueducattion;

import com.jy.util.http.HttpResponseEntity;
import com.jy.util.http.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CenterLoginProcess {

    private static final Logger logger = LoggerFactory.getLogger(CenterLoginProcess.class);

    private URI uri;

    public void process(AuthenticationHolder authenticationHolder) throws IOException {

        Map<String, String> headers = new HashMap<>();
        StringBuilder cookieBuilder = new StringBuilder();
        cookieBuilder.append("JSESSIONID=").append(authenticationHolder.getCenterSessionId());
        cookieBuilder.append(",UC00OOIIll11=").append(authenticationHolder.getUC00OOIIll11());
        headers.put("Cookie", cookieBuilder.toString());
        HttpResponseEntity responseEntity = RequestUtil.get(uri.toString(), headers, null);

        logger.info("login check response code: {}", responseEntity.getCode());
        logger.info("login check response body: {}", new String(responseEntity.getContent()));
    }

    public CenterLoginProcess(URI uri) {
        this.uri = uri;
    }
}
