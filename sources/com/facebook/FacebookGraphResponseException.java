package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", "graphResponse", "Lcom/facebook/GraphResponse;", "errorMessage", "", "(Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "getGraphResponse", "()Lcom/facebook/GraphResponse;", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse2, String str) {
        super(str);
        this.graphResponse = graphResponse2;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public String toString() {
        FacebookRequestError facebookRequestError;
        GraphResponse graphResponse2 = this.graphResponse;
        if (graphResponse2 == null) {
            facebookRequestError = null;
        } else {
            facebookRequestError = graphResponse2.getError();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb2.append(message);
            sb2.append(" ");
        }
        if (facebookRequestError != null) {
            sb2.append("httpResponseCode: ");
            sb2.append(facebookRequestError.getRequestStatusCode());
            sb2.append(", facebookErrorCode: ");
            sb2.append(facebookRequestError.getErrorCode());
            sb2.append(", facebookErrorType: ");
            sb2.append(facebookRequestError.getErrorType());
            sb2.append(", message: ");
            sb2.append(facebookRequestError.getErrorMessage());
            sb2.append("}");
        }
        String sb3 = sb2.toString();
        j.f(sb3, "errorStringBuilder.toString()");
        return sb3;
    }
}
