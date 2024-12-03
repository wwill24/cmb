package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import za.d;
import za.f;

public abstract class k0 implements l<f>, d {
    public int f(List<f> list) {
        j.g(list, ProfileConstants.Field.QUESTIONS);
        return o(list);
    }

    public int o(List<f> list) {
        f fVar;
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
                fVar = list.get(i10);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i10 = i11;
        }
        return (list.size() - arrayList.size()) + k(arrayList);
    }
}
