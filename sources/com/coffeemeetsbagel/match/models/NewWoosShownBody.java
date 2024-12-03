package com.coffeemeetsbagel.match.models;

import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NewWoosShownBody {
    @c("total_woos_seen")
    private final int totalWooSeen;

    public NewWoosShownBody(int i10) {
        this.totalWooSeen = i10;
    }

    private final int component1() {
        return this.totalWooSeen;
    }

    public static /* synthetic */ NewWoosShownBody copy$default(NewWoosShownBody newWoosShownBody, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = newWoosShownBody.totalWooSeen;
        }
        return newWoosShownBody.copy(i10);
    }

    public final NewWoosShownBody copy(int i10) {
        return new NewWoosShownBody(i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NewWoosShownBody) && this.totalWooSeen == ((NewWoosShownBody) obj).totalWooSeen;
    }

    public int hashCode() {
        return Integer.hashCode(this.totalWooSeen);
    }

    public String toString() {
        return "NewWoosShownBody(totalWooSeen=" + this.totalWooSeen + PropertyUtils.MAPPED_DELIM2;
    }
}
