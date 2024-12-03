package com.coffeemeetsbagel.models;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class MatchContext implements Serializable {
    @c("v2")
    private final MatchContextV2 matchContextV2;

    public MatchContext(MatchContextV2 matchContextV22) {
        j.g(matchContextV22, "matchContextV2");
        this.matchContextV2 = matchContextV22;
    }

    public static /* synthetic */ MatchContext copy$default(MatchContext matchContext, MatchContextV2 matchContextV22, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matchContextV22 = matchContext.matchContextV2;
        }
        return matchContext.copy(matchContextV22);
    }

    public final MatchContextV2 component1() {
        return this.matchContextV2;
    }

    public final MatchContext copy(MatchContextV2 matchContextV22) {
        j.g(matchContextV22, "matchContextV2");
        return new MatchContext(matchContextV22);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MatchContext) && j.b(this.matchContextV2, ((MatchContext) obj).matchContextV2);
    }

    public final MatchContextV2 getMatchContextV2() {
        return this.matchContextV2;
    }

    public int hashCode() {
        return this.matchContextV2.hashCode();
    }

    public String toString() {
        return "MatchContext(matchContextV2=" + this.matchContextV2 + PropertyUtils.MAPPED_DELIM2;
    }
}
