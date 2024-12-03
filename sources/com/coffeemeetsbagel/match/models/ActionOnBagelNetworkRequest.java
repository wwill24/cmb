package com.coffeemeetsbagel.match.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class ActionOnBagelNetworkRequest {
    @c("action")
    private final int action;
    @c("like_comment")
    private final String likeComment;
    @c("action_source")
    private final String source;

    public ActionOnBagelNetworkRequest(int i10, String str, String str2) {
        this.action = i10;
        this.likeComment = str;
        this.source = str2;
    }

    private final int component1() {
        return this.action;
    }

    private final String component2() {
        return this.likeComment;
    }

    private final String component3() {
        return this.source;
    }

    public static /* synthetic */ ActionOnBagelNetworkRequest copy$default(ActionOnBagelNetworkRequest actionOnBagelNetworkRequest, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = actionOnBagelNetworkRequest.action;
        }
        if ((i11 & 2) != 0) {
            str = actionOnBagelNetworkRequest.likeComment;
        }
        if ((i11 & 4) != 0) {
            str2 = actionOnBagelNetworkRequest.source;
        }
        return actionOnBagelNetworkRequest.copy(i10, str, str2);
    }

    public final ActionOnBagelNetworkRequest copy(int i10, String str, String str2) {
        return new ActionOnBagelNetworkRequest(i10, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionOnBagelNetworkRequest)) {
            return false;
        }
        ActionOnBagelNetworkRequest actionOnBagelNetworkRequest = (ActionOnBagelNetworkRequest) obj;
        return this.action == actionOnBagelNetworkRequest.action && j.b(this.likeComment, actionOnBagelNetworkRequest.likeComment) && j.b(this.source, actionOnBagelNetworkRequest.source);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.action) * 31;
        String str = this.likeComment;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.source;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "ActionOnBagelNetworkRequest(action=" + this.action + ", likeComment=" + this.likeComment + ", source=" + this.source + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionOnBagelNetworkRequest(int i10, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
