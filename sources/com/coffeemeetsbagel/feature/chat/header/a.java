package com.coffeemeetsbagel.feature.chat.header;

import android.app.Activity;
import b6.j;
import k6.c0;

public final class a extends b6.c<k, c> {

    /* renamed from: com.coffeemeetsbagel.feature.chat.header.a$a  reason: collision with other inner class name */
    public interface C0135a extends j<ChatHeaderInteractor> {
        Activity i();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c0 f12844a;

        public b(c0 c0Var) {
            kotlin.jvm.internal.j.g(c0Var, "binding");
            this.f12844a = c0Var;
        }

        public final j a() {
            return new j(this.f12844a);
        }
    }

    public interface c {
        s9.a b();

        Activity i();

        com.coffeemeetsbagel.match.j l();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final k b(c0 c0Var, String str) {
        kotlin.jvm.internal.j.g(c0Var, "binding");
        kotlin.jvm.internal.j.g(str, "matchId");
        ChatHeaderInteractor chatHeaderInteractor = new ChatHeaderInteractor(str);
        C0135a a10 = m.a().b(new b(c0Var)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new k(c0Var, a10, chatHeaderInteractor);
    }
}
