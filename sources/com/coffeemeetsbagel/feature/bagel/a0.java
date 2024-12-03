package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import java.util.Map;
import qj.y;
import y6.a;

public final /* synthetic */ class a0 implements a.C0223a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bagel f12699a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ y f12700b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12701c;

    public /* synthetic */ a0(Bagel bagel, y yVar, String str) {
        this.f12699a = bagel;
        this.f12700b = yVar;
        this.f12701c = str;
    }

    public final void a(Map map) {
        UpdateBagelLocalUseCase$invoke$2.f(this.f12699a, this.f12700b, this.f12701c, map);
    }
}
