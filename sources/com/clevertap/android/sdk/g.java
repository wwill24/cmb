package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.pushnotification.j;
import com.clevertap.android.sdk.validation.Validator;
import i4.e;
import i4.i;
import java.util.concurrent.Callable;
import l4.c;
import p4.f;
import w4.d;

class g {

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f10212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f10213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CleverTapInstanceConfig f10214c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f10215d;

        a(k kVar, i iVar, CleverTapInstanceConfig cleverTapInstanceConfig, Context context) {
            this.f10212a = kVar;
            this.f10213b = iVar;
            this.f10214c = cleverTapInstanceConfig;
            this.f10215d = context;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            if (this.f10212a.g() == null || this.f10212a.g().x() == null || this.f10213b.h() != null) {
                return null;
            }
            this.f10212a.e().n().t(this.f10214c.e() + ":async_deviceID", "Initializing InAppFC with device Id = " + this.f10212a.g().x());
            this.f10213b.p(new m(this.f10215d, this.f10214c, this.f10212a.g().x()));
            return null;
        }
    }

    class b implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10216a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f10217b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CleverTapInstanceConfig f10218c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l f10219d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ i4.b f10220e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f10221f;

        b(Context context, i iVar, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, i4.b bVar, c cVar) {
            this.f10216a = context;
            this.f10217b = iVar;
            this.f10218c = cleverTapInstanceConfig;
            this.f10219d = lVar;
            this.f10220e = bVar;
            this.f10221f = cVar;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            g.b(this.f10216a, this.f10217b, this.f10218c, this.f10219d, this.f10220e, this.f10221f);
            return null;
        }
    }

    static k a(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        Context context2 = context;
        k kVar = new k(context2);
        j jVar = new j();
        kVar.t(jVar);
        Validator validator = new Validator();
        d dVar = new d();
        kVar.F(dVar);
        e eVar = new e();
        kVar.p(eVar);
        u4.a aVar = new u4.a();
        kVar.B(aVar);
        CleverTapInstanceConfig cleverTapInstanceConfig2 = new CleverTapInstanceConfig(cleverTapInstanceConfig);
        kVar.r(cleverTapInstanceConfig2);
        c cVar = new c(context2, cleverTapInstanceConfig2, jVar);
        kVar.w(cVar);
        n nVar = new n(context2, cleverTapInstanceConfig2);
        kVar.y(nVar);
        l lVar = new l(context2, cleverTapInstanceConfig2, str, jVar);
        kVar.v(lVar);
        i4.g gVar = new i4.g(cleverTapInstanceConfig2, lVar);
        kVar.q(gVar);
        r rVar = new r(cleverTapInstanceConfig2, jVar, validator, nVar);
        kVar.E(rVar);
        com.clevertap.android.sdk.db.b bVar = new com.clevertap.android.sdk.db.b(cleverTapInstanceConfig2, eVar);
        kVar.u(bVar);
        Validator validator2 = validator;
        i iVar = r0;
        com.clevertap.android.sdk.db.b bVar2 = bVar;
        r rVar2 = rVar;
        i4.g gVar2 = gVar;
        l lVar2 = lVar;
        n nVar2 = nVar;
        i iVar2 = new i(context, cleverTapInstanceConfig2, eVar, gVar, lVar, bVar2);
        kVar.s(iVar);
        com.clevertap.android.sdk.task.a.a(cleverTapInstanceConfig2).a().f("initFCManager", new a(kVar, iVar, cleverTapInstanceConfig2, context2));
        q4.b bVar3 = r0;
        CleverTapInstanceConfig cleverTapInstanceConfig3 = cleverTapInstanceConfig2;
        u4.a aVar2 = aVar;
        e eVar2 = eVar;
        d dVar2 = dVar;
        q4.b bVar4 = new q4.b(context, cleverTapInstanceConfig2, lVar2, jVar, dVar, iVar, bVar2, gVar2, eVar, validator2, nVar2);
        kVar.C(bVar3);
        l lVar3 = lVar2;
        q4.b bVar5 = bVar3;
        l4.d dVar3 = r0;
        i iVar3 = iVar;
        j jVar2 = jVar;
        l4.d dVar4 = new l4.d(bVar2, context, cleverTapInstanceConfig3, cVar, rVar2, gVar2, aVar2, lVar3, dVar2, bVar5, jVar, eVar2, nVar2);
        kVar.o(dVar3);
        Context context3 = context;
        CleverTapInstanceConfig cleverTapInstanceConfig4 = cleverTapInstanceConfig3;
        c cVar2 = new c(context3, cleverTapInstanceConfig4, dVar3, validator2, dVar2, jVar2, nVar2, lVar3, gVar2, iVar3, eVar2);
        kVar.n(cVar2);
        i4.g gVar3 = gVar2;
        c cVar3 = cVar2;
        InAppController inAppController = new InAppController(context3, cleverTapInstanceConfig4, aVar2, iVar3, gVar3, cVar3, jVar2);
        kVar.x(inAppController);
        kVar.f().o(inAppController);
        com.clevertap.android.sdk.task.a.a(cleverTapInstanceConfig3).a().f("initFeatureFlags", new b(context3, iVar3, cleverTapInstanceConfig3, lVar2, gVar3, cVar3));
        CleverTapInstanceConfig cleverTapInstanceConfig5 = cleverTapInstanceConfig3;
        j jVar3 = jVar2;
        kVar.z(new o(context, cleverTapInstanceConfig5, jVar3, dVar3));
        j J = j.J(context, cleverTapInstanceConfig5, bVar2, dVar2, cVar2, iVar3);
        kVar.D(J);
        Context context4 = context;
        CleverTapInstanceConfig cleverTapInstanceConfig6 = cleverTapInstanceConfig5;
        a aVar3 = r0;
        a aVar4 = new a(context4, cleverTapInstanceConfig6, cVar2, jVar3, rVar2, J, gVar2, inAppController, dVar3);
        kVar.m(aVar3);
        f fVar = r0;
        f fVar2 = new f(context4, cleverTapInstanceConfig6, lVar2, dVar2, dVar3, cVar2, jVar3, iVar3, rVar2, nVar2, gVar2, bVar2, eVar2);
        kVar.A(fVar);
        return kVar;
    }

    static void b(Context context, i iVar, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, i4.b bVar, c cVar) {
        cleverTapInstanceConfig.n().t(cleverTapInstanceConfig.e() + ":async_deviceID", "Initializing Feature Flags with device Id = " + lVar.x());
        if (cleverTapInstanceConfig.p()) {
            cleverTapInstanceConfig.n().f(cleverTapInstanceConfig.e(), "Feature Flag is not enabled for this instance");
            return;
        }
        iVar.l(m4.b.a(context, lVar.x(), cleverTapInstanceConfig, bVar, cVar));
        cleverTapInstanceConfig.n().t(cleverTapInstanceConfig.e() + ":async_deviceID", "Feature Flags initialized");
    }
}
