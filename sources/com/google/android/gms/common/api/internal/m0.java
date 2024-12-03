package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.j0;
import java.util.ArrayList;
import java.util.Map;

final class m0 extends t0 {

    /* renamed from: b  reason: collision with root package name */
    private final Map f38686b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u0 f38687c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m0(u0 u0Var, Map map) {
        super(u0Var, (s0) null);
        this.f38687c = u0Var;
        this.f38686b = map;
    }

    public final void a() {
        j0 j0Var = new j0(this.f38687c.f38750d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f fVar : this.f38686b.keySet()) {
            if (!fVar.requiresGooglePlayServices() || ((j0) this.f38686b.get(fVar)).f38645c) {
                arrayList2.add(fVar);
            } else {
                arrayList.add(fVar);
            }
        }
        int i10 = -1;
        int i11 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i11 < size) {
                i10 = j0Var.b(this.f38687c.f38749c, (a.f) arrayList.get(i11));
                i11++;
                if (i10 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i11 < size2) {
                i10 = j0Var.b(this.f38687c.f38749c, (a.f) arrayList2.get(i11));
                i11++;
                if (i10 == 0) {
                    break;
                }
            }
        }
        if (i10 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i10, (PendingIntent) null);
            u0 u0Var = this.f38687c;
            u0Var.f38747a.r(new k0(this, u0Var, connectionResult));
            return;
        }
        u0 u0Var2 = this.f38687c;
        if (u0Var2.f38759m && u0Var2.f38757k != null) {
            u0Var2.f38757k.b();
        }
        for (a.f fVar2 : this.f38686b.keySet()) {
            d.c cVar = (d.c) this.f38686b.get(fVar2);
            if (!fVar2.requiresGooglePlayServices() || j0Var.b(this.f38687c.f38749c, fVar2) == 0) {
                fVar2.connect(cVar);
            } else {
                u0 u0Var3 = this.f38687c;
                u0Var3.f38747a.r(new l0(this, u0Var3, cVar));
            }
        }
    }
}
