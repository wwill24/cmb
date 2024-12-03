package com.coffeemeetsbagel.feature.chat.header;

import android.app.Activity;
import b6.t;
import com.coffeemeetsbagel.feature.chat.header.a;
import com.coffeemeetsbagel.match.j;
import fj.g;

public final class m {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a.b f12853a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f12854b;

        private a() {
        }

        public a.C0135a a() {
            g.a(this.f12853a, a.b.class);
            g.a(this.f12854b, a.c.class);
            return new b(this.f12853a, this.f12854b);
        }

        public a b(a.b bVar) {
            this.f12853a = (a.b) g.b(bVar);
            return this;
        }

        public a c(a.c cVar) {
            this.f12854b = (a.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements a.C0135a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f12855a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f12856b;

        /* renamed from: c  reason: collision with root package name */
        private final b f12857c;

        private b(a.b bVar, a.c cVar) {
            this.f12857c = this;
            this.f12855a = bVar;
            this.f12856b = cVar;
        }

        private ChatHeaderInteractor c(ChatHeaderInteractor chatHeaderInteractor) {
            t.a(chatHeaderInteractor, b.a(this.f12855a));
            h.a(chatHeaderInteractor, (j) g.d(this.f12856b.l()));
            h.b(chatHeaderInteractor, (s9.a) g.d(this.f12856b.b()));
            return chatHeaderInteractor;
        }

        /* renamed from: b */
        public void l1(ChatHeaderInteractor chatHeaderInteractor) {
            c(chatHeaderInteractor);
        }

        public Activity i() {
            return (Activity) g.d(this.f12856b.i());
        }
    }

    public static a a() {
        return new a();
    }
}
