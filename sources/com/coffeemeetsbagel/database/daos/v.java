package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.MatchEntity;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import com.coffeemeetsbagel.models.util.DateUtils;
import j$.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import u6.g;

public abstract class v implements l<MatchEntity>, g {
    public int a(MatchType matchType, OffsetDateTime offsetDateTime, List<String> list) {
        j.g(matchType, "type");
        j.g(offsetDateTime, "distantPast");
        j.g(list, "exceptions");
        return u(matchType.getKey(), offsetDateTime, list);
    }

    public int c(String str, MatchAction matchAction) {
        j.g(str, "profileId");
        j.g(matchAction, "matchAction");
        return v(str, matchAction);
    }

    public int f(MatchType matchType) {
        j.g(matchType, "type");
        String formattedUtcDate = DateUtils.getFormattedUtcDate(System.currentTimeMillis(), DateUtils.DATE_WITH_TIME_PATTERN);
        String key = matchType.getKey();
        j.f(formattedUtcDate, "now");
        return t(key, formattedUtcDate);
    }

    public w<Integer> g(String str, boolean z10) {
        j.g(str, "profileId");
        return w(str, z10);
    }

    public int i(List<MatchEntity> list) {
        j.g(list, "entities");
        return o(list);
    }

    public h<List<MatchEntity>> j(String str) {
        j.g(str, "matchId");
        return n(str);
    }

    public abstract h<List<MatchEntity>> n(String str);

    public int o(List<MatchEntity> list) {
        MatchEntity matchEntity;
        j.g(list, "data");
        List<Long> s10 = s(list);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T next : s10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            if (-1 == ((Number) next).longValue()) {
                matchEntity = list.get(i10);
            } else {
                matchEntity = null;
            }
            if (matchEntity != null) {
                arrayList.add(matchEntity);
            }
            i10 = i11;
        }
        return (list.size() - arrayList.size()) + k(arrayList);
    }

    public abstract int t(String str, String str2);

    public abstract int u(String str, OffsetDateTime offsetDateTime, List<String> list);

    public abstract int v(String str, MatchAction matchAction);

    public abstract w<Integer> w(String str, boolean z10);
}
