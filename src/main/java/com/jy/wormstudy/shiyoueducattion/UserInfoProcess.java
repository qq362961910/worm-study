package com.jy.wormstudy.shiyoueducattion;

import com.jy.util.http.HttpResponseEntity;
import com.jy.util.http.RequestUtil;
import com.jy.wormstudy.shiyoueducattion.nanlyse.StudentInfoAnalyse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class UserInfoProcess {

    private static final Logger logger = LoggerFactory.getLogger(SsoLoginByUserCenterLogin.class);
    private URI uri;
    private StudentInfoAnalyse studentInfoAnalyse = new StudentInfoAnalyse();

    public void process(AuthenticationHolder authenticationHolder) throws IOException {
        Map<String, String> headers = new HashMap<>();
        StringBuilder cookieBuilder = new StringBuilder();
        cookieBuilder.append("JSESSIONID=").append(authenticationHolder.getWorkspaceSessionId());
        cookieBuilder.append(",UC00OOIIll11=").append(authenticationHolder.getUC00OOIIll11());
        headers.put("Cookie", cookieBuilder.toString());
        HttpResponseEntity responseEntity = RequestUtil.get(uri.toString(), headers, null);
        Document document = Jsoup.parse(new String(responseEntity.getContent()));
        authenticationHolder.setStudent(studentInfoAnalyse.analyse(document));
    }

    public UserInfoProcess(URI uri) {
        this.uri = uri;
    }
}
