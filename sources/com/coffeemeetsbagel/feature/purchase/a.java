package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.store.k0;
import com.google.gson.j;
import java.util.Map;
import vj.f;

public final /* synthetic */ class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PurchaseManager f13366a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f13367b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13368c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f13369d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f13370e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k0.b f13371f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Class f13372g;

    public /* synthetic */ a(PurchaseManager purchaseManager, Map map, String str, long j10, boolean z10, k0.b bVar, Class cls) {
        this.f13366a = purchaseManager;
        this.f13367b = map;
        this.f13368c = str;
        this.f13369d = j10;
        this.f13370e = z10;
        this.f13371f = bVar;
        this.f13372g = cls;
    }

    public final void accept(Object obj) {
        this.f13366a.lambda$buyCmbItem$2(this.f13367b, this.f13368c, this.f13369d, this.f13370e, this.f13371f, this.f13372g, (j) obj);
    }
}
