package com.coffeemeetsbagel.models;

import java.io.Serializable;

public class CmbErrorCode implements Serializable {
    public static final int CANCELED = 1;
    public static final int EXCEPTION = 5;
    public static final int NETWORK = 2;
    public static final int REDIRECT = 3;
    public static final int SHOW_MESSAGE = 4;
    public static final int UNAUTHORIZED = 401;
    public static final int UNKNOWN = 0;
    private final BannedReason bannedReason;
    private final int mErrorCode;
    private String mErrorMessage;
    private final VerificationStatus verificationStatus;

    public CmbErrorCode(String str, int i10, BannedReason bannedReason2, VerificationStatus verificationStatus2) {
        this.mErrorMessage = str;
        this.mErrorCode = i10;
        this.bannedReason = bannedReason2;
        this.verificationStatus = verificationStatus2;
    }

    public BannedReason getBannedReason() {
        BannedReason bannedReason2 = this.bannedReason;
        if (bannedReason2 != null) {
            return bannedReason2;
        }
        return BannedReason.NONE;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public VerificationStatus getVerificationStatus() {
        VerificationStatus verificationStatus2 = this.verificationStatus;
        if (verificationStatus2 != null) {
            return verificationStatus2;
        }
        return VerificationStatus.NONE;
    }

    public CmbErrorCode setErrorMessage(String str) {
        this.mErrorMessage = str;
        return this;
    }

    public CmbErrorCode(String str, int i10) {
        this(str, i10, BannedReason.NONE, VerificationStatus.NONE);
    }

    public CmbErrorCode(String str) {
        this(str, 0);
    }

    public CmbErrorCode(int i10) {
        this((String) null, i10);
    }
}
