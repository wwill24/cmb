package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.match.g;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Objects;

public class n0 implements i, j.c {

    /* renamed from: a  reason: collision with root package name */
    private final j f12959a;

    /* renamed from: b  reason: collision with root package name */
    private final h f12960b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public j f12961c;

    /* renamed from: d  reason: collision with root package name */
    private a7.a f12962d;

    class a implements g {
        a() {
        }

        public void a(String str) {
            if (n0.this.f12961c != null) {
                n0.this.f12961c.Q();
            }
        }

        public void onSuccess() {
            if (n0.this.f12961c != null) {
                n0.this.f12961c.a0();
            }
        }
    }

    n0(j jVar, j jVar2, h hVar, a7.a aVar) {
        this.f12961c = jVar;
        jVar.K(this);
        this.f12959a = jVar2;
        this.f12960b = hVar;
        this.f12962d = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(boolean z10) {
        x();
    }

    private void X() {
        this.f12959a.E(false, true, new m0(this));
    }

    public void E(Bagel bagel) {
        String str;
        HashMap hashMap = new HashMap();
        if (bagel.isPastDecouplingDate()) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        hashMap.put("Expired", str);
        this.f12962d.trackEvent("Chat Deleted", hashMap);
        this.f12959a.g(bagel.getId(), new a());
    }

    public void P() {
        x();
    }

    public void a() {
        X();
    }

    public void f() {
        X();
    }

    public void start() {
        this.f12959a.o(this);
    }

    public void stop() {
        this.f12959a.B(this);
    }

    public void x() {
        h hVar = this.f12960b;
        j jVar = this.f12961c;
        Objects.requireNonNull(jVar);
        hVar.a(new l0(jVar));
    }
}
