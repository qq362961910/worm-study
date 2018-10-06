package com.jy.wormstudy.shiyoueducattion;

public class AuthenticationHolder {

    private String jsessionid;

    private String sessionId;

    private String validateCode;

    private String UC00OOIIll11;

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

    public String getUC00OOIIll11() {
        return UC00OOIIll11;
    }

    public void setUC00OOIIll11(String UC00OOIIll11) {
        this.UC00OOIIll11 = UC00OOIIll11;
    }

    @Override
    public String toString() {
        return "AuthenticationHolder{" +
                "jsessionid='" + jsessionid + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", validateCode='" + validateCode + '\'' +
                ", UC00OOIIll11='" + UC00OOIIll11 + '\'' +
                '}';
    }
}
