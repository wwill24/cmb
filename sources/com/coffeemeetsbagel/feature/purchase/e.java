package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.store.k0;
import com.google.gson.j;
import java.util.Map;
import vj.f;

public final /* synthetic */ class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PurchaseManager f13378a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f13379b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13380c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f13381d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k0.b f13382e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Class f13383f;

    public /* synthetic */ e(PurchaseManager purchaseManager, Map map, String str, long j10, k0.b bVar, Class cls) {
        this.f13378a = purchaseManager;
        this.f13379b = map;
        this.f13380c = str;
        this.f13381d = j10;
        this.f13382e = bVar;
        this.f13383f = cls;
    }

    public final void accept(Object obj) {
        this.f13378a.lambda$buyCmbItem$0(this.f13379b, this.f13380c, this.f13381d, this.f13382e, this.f13383f, (j) obj);
    }
}
