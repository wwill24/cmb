package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.GiveTake;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseInfiniteScrollGiveTakes {
    @c("cursor_before")
    private final String cursorBefore;
    private final List<GiveTake> data;
    @c("more_before")
    private final boolean moreBefore;

    public ResponseInfiniteScrollGiveTakes(String str, boolean z10, List<? extends GiveTake> list) {
        j.g(str, "cursorBefore");
        j.g(list, "data");
        this.cursorBefore = str;
        this.moreBefore = z10;
        this.data = list;
    }

    public static /* synthetic */ ResponseInfiniteScrollGiveTakes copy$default(ResponseInfiniteScrollGiveTakes responseInfiniteScrollGiveTakes, String str, boolean z10, List<GiveTake> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = responseInfiniteScrollGiveTakes.cursorBefore;
        }
        if ((i10 & 2) != 0) {
            z10 = responseInfiniteScrollGiveTakes.moreBefore;
        }
        if ((i10 & 4) != 0) {
            list = responseInfiniteScrollGiveTakes.data;
        }
        return responseInfiniteScrollGiveTakes.copy(str, z10, list);
    }

    public final String component1() {
        return this.cursorBefore;
    }

    public final boolean component2() {
        return this.moreBefore;
    }

    public final List<GiveTake> component3() {
        return this.data;
    }

    public final ResponseInfiniteScrollGiveTakes copy(String str, boolean z10, List<? extends GiveTake> list) {
        j.g(str, "cursorBefore");
        j.g(list, "data");
        return new ResponseInfiniteScrollGiveTakes(str, z10, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseInfiniteScrollGiveTakes)) {
            return false;
        }
        ResponseInfiniteScrollGiveTakes responseInfiniteScrollGiveTakes = (ResponseInfiniteScrollGiveTakes) obj;
        return j.b(this.cursorBefore, responseInfiniteScrollGiveTakes.cursorBefore) && this.moreBefore == responseInfiniteScrollGiveTakes.moreBefore && j.b(this.data, responseInfiniteScrollGiveTakes.data);
    }

    public final String getCursorBefore() {
        return this.cursorBefore;
    }

    public final List<GiveTake> getData() {
        return this.data;
    }

    public final boolean getMoreBefore() {
        return this.moreBefore;
    }

    public int hashCode() {
        int hashCode = this.cursorBefore.hashCode() * 31;
        boolean z10 = this.moreBefore;
        if (z10) {
            z10 = true;
        }
        return ((hashCode + (z10 ? 1 : 0)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "ResponseInfiniteScrollGiveTakes(cursorBefore=" + this.cursorBefore + ", moreBefore=" + this.moreBefore + ", data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}
