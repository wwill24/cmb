package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;

final class n0 extends t0 {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f38693b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u0 f38694c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(u0 u0Var, ArrayList arrayList) {
        super(u0Var, (s0) null);
        this.f38694c = u0Var;
        this.f38693b = arrayList;
    }

    public final void a() {
        u0 u0Var = this.f38694c;
        u0Var.f38747a.f38585p.f38843p = u0.y(u0Var);
        ArrayList arrayList = this.f38693b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            u0 u0Var2 = this.f38694c;
            ((a.f) arrayList.get(i10)).getRemoteService(u0Var2.f38761o, u0Var2.f38747a.f38585p.f38843p);
        }
    }
}
