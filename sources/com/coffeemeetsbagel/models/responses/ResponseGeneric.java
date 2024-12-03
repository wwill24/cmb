package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.CmbErrorCode;
import java.io.Serializable;

public class ResponseGeneric implements Serializable {
    private String error;
    private CmbErrorCode errorCode;
    private int statusCode;
    private boolean success;

    public ResponseGeneric() {
    }

    public CmbErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.error;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public boolean isSuccessful() {
        return this.statusCode == 200;
    }

    public void setErrorCode(CmbErrorCode cmbErrorCode) {
        this.errorCode = cmbErrorCode;
    }

    public void setErrorMessage(String str) {
        this.error = str;
    }

    public void setStatusCode(int i10) {
        this.statusCode = i10;
    }

    public void setSuccess(boolean z10) {
        this.success = z10;
    }

    public ResponseGeneric(int i10) {
        this.statusCode = i10;
    }

    public void setErrorCode(int i10) {
        this.errorCode = new CmbErrorCode(i10);
    }

    public ResponseGeneric(int i10, String str, int i11) {
        this.statusCode = i10;
        this.success = false;
        this.error = str;
        this.errorCode = new CmbErrorCode(i11);
    }

    public ResponseGeneric(String str, int i10) {
        this.success = false;
        this.error = str;
        this.errorCode = new CmbErrorCode(i10);
    }
}
