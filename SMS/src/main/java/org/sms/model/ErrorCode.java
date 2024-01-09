package org.sms.model;

import java.util.Arrays;

public enum ErrorCode {
    ERR_001("USER_EXISTS");

    ErrorCode(String errorCode) {
    }
    public String getErrorDescription(ErrorCode code) {
           return Arrays.stream(values()).filter(e->e.equals(code)).findFirst().get().toString();
    }

}
