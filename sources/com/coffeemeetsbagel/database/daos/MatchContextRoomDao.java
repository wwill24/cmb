package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.MatchContext;
import com.coffeemeetsbagel.models.entities.MatchContextEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import u6.f;

public abstract class MatchContextRoomDao implements l<MatchContextEntity>, f {
    /* access modifiers changed from: private */
    public static final MatchContext f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (MatchContext) function1.invoke(obj);
    }

    public h<MatchContext> a(String str) {
        j.g(str, "matchId");
        h<R> Y = g(str).Y(new t(MatchContextRoomDao$getMatchContext$1.f11609a));
        j.f(Y, "getMatchContextById(matc…y\n            }\n        }");
        return Y;
    }

    public abstract h<MatchContextEntity> g(String str);

    public int i(List<? extends MatchContext> list) {
        j.g(list, "matchContexts");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (MatchContext matchContext : list) {
            arrayList.add(new MatchContextEntity(matchContext.getMatchId(), matchContext.getIcon(), matchContext.getTitle(), matchContext.getBody()));
        }
        return o(arrayList);
    }

    public int o(List<MatchContextEntity> list) {
        MatchContextEntity matchContextEntity;
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
                matchContextEntity = list.get(i10);
            } else {
                matchContextEntity = null;
            }
            if (matchContextEntity != null) {
                arrayList.add(matchContextEntity);
            }
            i10 = i11;
        }
        return (list.size() - arrayList.size()) + k(arrayList);
    }
}
