package com.jy.wormstudy.shiyoueducattion;

public class AuthenticationHolder {

    private String jsessionid;

    private String sessionId;

    private String validateCode;

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "AuthenticationHolder{" +
                "jsessionid='" + jsessionid + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }
}
