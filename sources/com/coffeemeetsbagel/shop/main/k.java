package com.coffeemeetsbagel.shop.main;

import b6.s;
import com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent;
import com.coffeemeetsbagel.shop.main.n;
import com.uber.autodispose.p;
import d6.a;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kb.c;
import oc.i;
import org.json.b;
import qj.q;

public class k extends s<n, o> implements n.b {

    /* renamed from: f  reason: collision with root package name */
    a f36450f;

    /* renamed from: g  reason: collision with root package name */
    a7.a f36451g;

    /* renamed from: h  reason: collision with root package name */
    c f36452h;

    /* renamed from: j  reason: collision with root package name */
    hb.c f36453j;

    /* renamed from: k  reason: collision with root package name */
    MainShopTabs f36454k;

    /* renamed from: l  reason: collision with root package name */
    private PublishSubject<Integer> f36455l = PublishSubject.C0();

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean L1(ActivityLifecycleEvent activityLifecycleEvent) throws Exception {
        return activityLifecycleEvent == ActivityLifecycleEvent.RESUME;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(ActivityLifecycleEvent activityLifecycleEvent) throws Exception {
        this.f36451g.f("Bean Shop");
        this.f36451g.trackEvent("Bean Shop Viewed", new HashMap());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean N1(Integer num) throws Exception {
        return num.intValue() == 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1(Integer num, b bVar) throws Exception {
        P1(bVar);
    }

    private void P1(b bVar) {
        this.f36453j.w("last_seen_price_state", bVar.toString());
    }

    public void q(int i10) {
        this.f36455l.d(Integer.valueOf(i10));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) this.f7875e).o(((o) B1()).m());
        ((n) this.f7875e).n(this.f36454k);
        ((p) this.f36450f.a().B(new g()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(this));
        ((p) q.m(this.f36455l.s().B(new i()), this.f36452h.b().p(i.b()).s(), new oc.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(oc.b.b(new j(this)));
    }
}
