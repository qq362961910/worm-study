package com.jy.wormstudy.shiyoueducattion;

import com.jy.util.media.code.ValidCodeHelper;

import java.net.URI;

public class Worker {

    public static void main(String[] args) throws Exception{

        AuthenticationHolder authenticationHolder = new AuthenticationHolder();

        String validCodeUri = "http://www.cupde.cn/center/sso/authimg?0.00405729292544288";
        ValidCodeHelper helper = new ValidCodeHelper("D:\\dev\\workspace\\idea\\tesseract\\tessdata");
        ValidCodeProcess validCodeProcess = new ValidCodeProcess(helper, validCodeUri);
        validCodeProcess.requestValidateCode(authenticationHolder);

        String username = "";
        String password = "";
        URI loginUri = URI.create("http://www.cupde.cn/center/center/login_login.action");
        LoginProcess loginProcess = new LoginProcess(username, password, loginUri);
        loginProcess.login(authenticationHolder);

        URI indexUri = URI.create("http://www.cupde.cn/workspace/sso/center/ssoLoginByUserCenter_login.action");
        IndexPageProcess indexPageProcess = new IndexPageProcess(indexUri);
        indexPageProcess.process(authenticationHolder);
    }
}
