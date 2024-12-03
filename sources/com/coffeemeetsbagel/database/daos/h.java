package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ActivityReportEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public interface h extends l<ActivityReportEntity> {

    public static final class a {
        public static int a(h hVar, List<ActivityReportEntity> list) {
            ActivityReportEntity activityReportEntity;
            j.g(list, "data");
            List<Long> s10 = hVar.s(list);
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (T next : s10) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    q.s();
                }
                if (-1 == ((Number) next).longValue()) {
                    activityReportEntity = list.get(i10);
                } else {
                    activityReportEntity = null;
                }
                if (activityReportEntity != null) {
                    arrayList.add(activityReportEntity);
                }
                i10 = i11;
            }
            return (list.size() - arrayList.size()) + hVar.k(arrayList);
        }
    }

    qj.h<List<ActivityReportEntity>> h(String str);

    List<ActivityReportEntity> m(List<String> list);

    int o(List<ActivityReportEntity> list);
}
