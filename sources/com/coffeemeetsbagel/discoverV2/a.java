package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.models.NetworkProfile;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f12280a;

    /* renamed from: b  reason: collision with root package name */
    private NetworkProfile f12281b;

    /* renamed from: c  reason: collision with root package name */
    private com.coffeemeetsbagel.discoverV2.list.a f12282c;

    /* renamed from: d  reason: collision with root package name */
    private final ActionListenerEvent f12283d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12284e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f12285f;

    public a(ActionListenerEvent actionListenerEvent, int i10, boolean z10, Integer num) {
        this.f12283d = actionListenerEvent;
        this.f12280a = i10;
        this.f12284e = z10;
        this.f12285f = num;
    }

    public ActionListenerEvent a() {
        return this.f12283d;
    }

    public Integer b() {
        return this.f12285f;
    }

    public int c() {
        return this.f12280a;
    }

    public NetworkProfile d() {
        return this.f12281b;
    }

    public boolean e() {
        return this.f12284e;
    }

    public void f(com.coffeemeetsbagel.discoverV2.list.a aVar) {
        this.f12282c = aVar;
    }

    public void g(NetworkProfile networkProfile) {
        this.f12281b = networkProfile;
    }
}
