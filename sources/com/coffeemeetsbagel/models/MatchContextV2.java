package com.coffeemeetsbagel.models;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MatchContextV2 implements Serializable {
    private final String body;
    private final String icon;
    private final String title;

    public MatchContextV2() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public MatchContextV2(String str, String str2, String str3) {
        this.icon = str;
        this.title = str2;
        this.body = str3;
    }

    public static /* synthetic */ MatchContextV2 copy$default(MatchContextV2 matchContextV2, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchContextV2.icon;
        }
        if ((i10 & 2) != 0) {
            str2 = matchContextV2.title;
        }
        if ((i10 & 4) != 0) {
            str3 = matchContextV2.body;
        }
        return matchContextV2.copy(str, str2, str3);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.body;
    }

    public final MatchContextV2 copy(String str, String str2, String str3) {
        return new MatchContextV2(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchContextV2)) {
            return false;
        }
        MatchContextV2 matchContextV2 = (MatchContextV2) obj;
        return j.b(this.icon, matchContextV2.icon) && j.b(this.title, matchContextV2.title) && j.b(this.body, matchContextV2.body);
    }

    public final String getBody() {
        return this.body;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.icon;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.body;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "MatchContextV2(icon=" + this.icon + ", title=" + this.title + ", body=" + this.body + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MatchContextV2(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
