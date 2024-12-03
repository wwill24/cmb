package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.RetryCall;
import com.coffeemeetsbagel.models.dto.RetryCallPartial;
import com.coffeemeetsbagel.models.entities.RetryCallEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import u6.m;

public abstract class o0 implements m {
    public void a(RetryCallPartial retryCallPartial) {
        j.g(retryCallPartial, "retryCall");
        e(retryCallPartial);
    }

    public List<RetryCall> b() {
        List<RetryCallEntity> f10 = f();
        ArrayList arrayList = new ArrayList(r.t(f10, 10));
        for (RetryCallEntity retryCallEntity : f10) {
            arrayList.add(new RetryCall(retryCallEntity.getId(), retryCallEntity.getInternalTag(), retryCallEntity.getPayloadObject(), retryCallEntity.getLastTimeTried(), retryCallEntity.getTimesTriedSoFar()));
        }
        return arrayList;
    }

    public boolean c(RetryCall retryCall) {
        j.g(retryCall, "retryCall");
        return d(retryCall) == 1;
    }

    public abstract int d(RetryCall retryCall);

    public abstract void e(RetryCallPartial retryCallPartial);

    public abstract List<RetryCallEntity> f();
}
