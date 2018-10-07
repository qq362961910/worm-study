package com.jy.wormstudy.shiyoueducattion;

public class AuthenticationHolder {

    private String rootSessionId;

    private String centerSessionId;

    private String workspaceSessionId;

    private String sessionId;

    private String validateCode;

    private String UC00OOIIll11;

    public String getRootSessionId() {
        return rootSessionId;
    }

    public void setRootSessionId(String rootSessionId) {
        this.rootSessionId = rootSessionId;
    }

    public String getCenterSessionId() {
        return centerSessionId;
    }

    public void setCenterSessionId(String centerSessionId) {
        this.centerSessionId = centerSessionId;
    }

    public String getWorkspaceSessionId() {
        return workspaceSessionId;
    }

    public void setWorkspaceSessionId(String workspaceSessionId) {
        this.workspaceSessionId = workspaceSessionId;
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
                "rootSessionId='" + rootSessionId + '\'' +
                ", centerSessionId='" + centerSessionId + '\'' +
                ", workspaceSessionId='" + workspaceSessionId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", validateCode='" + validateCode + '\'' +
                ", UC00OOIIll11='" + UC00OOIIll11 + '\'' +
                '}';
    }
}
