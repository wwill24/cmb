package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.a;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.background.systemjob.g;
import b2.f;
import g2.v;
import h2.n;
import java.util.List;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7600a = f.i("Schedulers");

    @NonNull
    static t a(@NonNull Context context, @NonNull e0 e0Var) {
        g gVar = new g(context, e0Var);
        n.a(context, SystemJobService.class, true);
        f.e().a(f7600a, "Created SystemJobScheduler and enabled SystemJobService");
        return gVar;
    }

    public static void b(@NonNull a aVar, @NonNull WorkDatabase workDatabase, List<t> list) {
        if (list != null && list.size() != 0) {
            v K = workDatabase.K();
            workDatabase.e();
            try {
                List<g2.u> o10 = K.o(aVar.h());
                List<g2.u> k10 = K.k(200);
                if (o10 != null && o10.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (g2.u uVar : o10) {
                        K.m(uVar.f15077a, currentTimeMillis);
                    }
                }
                workDatabase.C();
                if (o10 != null && o10.size() > 0) {
                    g2.u[] uVarArr = (g2.u[]) o10.toArray(new g2.u[o10.size()]);
                    for (t next : list) {
                        if (next.e()) {
                            next.d(uVarArr);
                        }
                    }
                }
                if (k10 != null && k10.size() > 0) {
                    g2.u[] uVarArr2 = (g2.u[]) k10.toArray(new g2.u[k10.size()]);
                    for (t next2 : list) {
                        if (!next2.e()) {
                            next2.d(uVarArr2);
                        }
                    }
                }
            } finally {
                workDatabase.j();
            }
        }
    }
}
