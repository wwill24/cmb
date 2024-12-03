package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.dto.MatchContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MatchContextEntity implements MatchContext {
    private final String body;
    private final String icon;
    private final String matchId;
    private final String title;

    public MatchContextEntity(String str, String str2, String str3, String str4) {
        j.g(str, "matchId");
        this.matchId = str;
        this.icon = str2;
        this.title = str3;
        this.body = str4;
    }

    public static /* synthetic */ MatchContextEntity copy$default(MatchContextEntity matchContextEntity, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchContextEntity.getMatchId();
        }
        if ((i10 & 2) != 0) {
            str2 = matchContextEntity.getIcon();
        }
        if ((i10 & 4) != 0) {
            str3 = matchContextEntity.getTitle();
        }
        if ((i10 & 8) != 0) {
            str4 = matchContextEntity.getBody();
        }
        return matchContextEntity.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return getMatchId();
    }

    public final String component2() {
        return getIcon();
    }

    public final String component3() {
        return getTitle();
    }

    public final String component4() {
        return getBody();
    }

    public final MatchContextEntity copy(String str, String str2, String str3, String str4) {
        j.g(str, "matchId");
        return new MatchContextEntity(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchContextEntity)) {
            return false;
        }
        MatchContextEntity matchContextEntity = (MatchContextEntity) obj;
        return j.b(getMatchId(), matchContextEntity.getMatchId()) && j.b(getIcon(), matchContextEntity.getIcon()) && j.b(getTitle(), matchContextEntity.getTitle()) && j.b(getBody(), matchContextEntity.getBody());
    }

    public String getBody() {
        return this.body;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i10 = 0;
        int hashCode = ((((getMatchId().hashCode() * 31) + (getIcon() == null ? 0 : getIcon().hashCode())) * 31) + (getTitle() == null ? 0 : getTitle().hashCode())) * 31;
        if (getBody() != null) {
            i10 = getBody().hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "MatchContextEntity(matchId=" + getMatchId() + ", icon=" + getIcon() + ", title=" + getTitle() + ", body=" + getBody() + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MatchContextEntity(String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}
