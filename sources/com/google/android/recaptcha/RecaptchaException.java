package com.google.android.recaptcha;

import androidx.annotation.NonNull;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class RecaptchaException extends Exception {
    private final RecaptchaErrorCode errorCode;
    private final String errorMessage;

    public RecaptchaException(@NonNull RecaptchaErrorCode recaptchaErrorCode, @NonNull String str) {
        super(str);
        this.errorCode = recaptchaErrorCode;
        this.errorMessage = str;
    }

    public final RecaptchaErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecaptchaException(@NonNull RecaptchaErrorCode recaptchaErrorCode, @NonNull String str, int i10, @NonNull DefaultConstructorMarker defaultConstructorMarker) {
        this(recaptchaErrorCode, (i10 & 2) != 0 ? recaptchaErrorCode.getErrorMessage() : str);
    }
}
