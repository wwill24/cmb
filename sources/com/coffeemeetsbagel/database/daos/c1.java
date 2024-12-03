package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import yb.c;

public abstract class c1 implements l<SuggestedLimitsEntity>, c {
    public h<List<SuggestedLimitsEntity>> a() {
        return i();
    }

    public long c(SuggestedLimitsEntity suggestedLimitsEntity) {
        j.g(suggestedLimitsEntity, "limits");
        g();
        return d(suggestedLimitsEntity);
    }

    public w<Integer> f(SuggestedLimitsEntity suggestedLimitsEntity) {
        j.g(suggestedLimitsEntity, "newLimits");
        return b(suggestedLimitsEntity);
    }

    public abstract void g();

    public abstract h<List<SuggestedLimitsEntity>> i();
}
