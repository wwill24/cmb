package com.coffeemeetsbagel.models;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class FeedbackBody {
    private final String appVersion;
    private final String feedback;
    private final String source;

    public FeedbackBody(String str, String str2, String str3) {
        j.g(str, "feedback");
        j.g(str3, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        this.feedback = str;
        this.source = str2;
        this.appVersion = str3;
    }

    public static /* synthetic */ FeedbackBody copy$default(FeedbackBody feedbackBody, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedbackBody.feedback;
        }
        if ((i10 & 2) != 0) {
            str2 = feedbackBody.source;
        }
        if ((i10 & 4) != 0) {
            str3 = feedbackBody.appVersion;
        }
        return feedbackBody.copy(str, str2, str3);
    }

    public final String component1() {
        return this.feedback;
    }

    public final String component2() {
        return this.source;
    }

    public final String component3() {
        return this.appVersion;
    }

    public final FeedbackBody copy(String str, String str2, String str3) {
        j.g(str, "feedback");
        j.g(str3, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        return new FeedbackBody(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedbackBody)) {
            return false;
        }
        FeedbackBody feedbackBody = (FeedbackBody) obj;
        return j.b(this.feedback, feedbackBody.feedback) && j.b(this.source, feedbackBody.source) && j.b(this.appVersion, feedbackBody.appVersion);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getFeedback() {
        return this.feedback;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = this.feedback.hashCode() * 31;
        String str = this.source;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.appVersion.hashCode();
    }

    public String toString() {
        return "FeedbackBody(feedback=" + this.feedback + ", source=" + this.source + ", appVersion=" + this.appVersion + PropertyUtils.MAPPED_DELIM2;
    }
}
