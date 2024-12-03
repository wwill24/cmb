package com.mparticle.identity;

import androidx.annotation.NonNull;
import com.mparticle.internal.f;

public class AliasResponse {
    private String errorResponse;
    private String requestId;
    private AliasRequest requestMessage;
    private int responseCode;
    private boolean willRetry;

    public AliasResponse(@NonNull f.a aVar, @NonNull AliasRequest aliasRequest, @NonNull String str, boolean z10) {
        this.responseCode = aVar.b();
        this.requestId = str;
        this.willRetry = z10;
        this.requestMessage = aliasRequest;
        this.errorResponse = aVar.a();
    }

    public String getErrorResponse() {
        return this.errorResponse;
    }

    @NonNull
    public AliasRequest getRequest() {
        return this.requestMessage;
    }

    @NonNull
    public String getRequestId() {
        return this.requestId;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public boolean isSuccessful() {
        int i10 = this.responseCode;
        return i10 >= 200 && i10 < 300;
    }

    public boolean willRetry() {
        return this.willRetry;
    }
}
