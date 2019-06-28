package com.smalaca.systemtests.dto;

import java.nio.DoubleBuffer;

public class CreditStatus {
    private static final String SUCCESSFUL = "SUCCESS";
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccessful() {
        return SUCCESSFUL.equals(status);
    }
}
