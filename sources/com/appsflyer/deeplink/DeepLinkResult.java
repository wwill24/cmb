package com.appsflyer.deeplink;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONException;
import org.json.b;

public class DeepLinkResult {
    private final DeepLink deepLink;
    private final Error error;
    @NonNull
    private final Status status;

    public enum Error {
        TIMEOUT,
        NETWORK,
        HTTP_STATUS_CODE,
        UNEXPECTED,
        DEVELOPER_ERROR
    }

    public enum Status {
        FOUND,
        NOT_FOUND,
        ERROR
    }

    public DeepLinkResult(DeepLink deepLink2, Error error2) {
        this.deepLink = deepLink2;
        this.error = error2;
        if (error2 != null) {
            this.status = Status.ERROR;
        } else if (deepLink2 != null) {
            this.status = Status.FOUND;
        } else {
            this.status = Status.NOT_FOUND;
        }
    }

    public DeepLink getDeepLink() {
        return this.deepLink;
    }

    public Error getError() {
        return this.error;
    }

    @NonNull
    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        b bVar = new b();
        try {
            bVar.put(SDKConstants.PARAM_DEEP_LINK, (Object) this.deepLink);
            bVar.put("error", (Object) this.error);
            bVar.put("status", (Object) this.status);
        } catch (JSONException e10) {
            AFLogger.afErrorLogForExcManagerOnly("error while creating deep link json", e10);
        }
        return bVar.toString();
    }
}
