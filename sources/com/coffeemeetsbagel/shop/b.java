package com.coffeemeetsbagel.shop;

import androidx.appcompat.app.c;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.shop.main.d;

public class b extends f<a> {

    public interface a extends g<b>, d.c {
        jb.a k0();
    }

    /* renamed from: com.coffeemeetsbagel.shop.b$b  reason: collision with other inner class name */
    public class C0446b {

        /* renamed from: a  reason: collision with root package name */
        private b6.d f36416a;

        C0446b(b6.d dVar) {
            this.f36416a = dVar;
        }

        /* access modifiers changed from: package-private */
        public c a() {
            return this.f36416a;
        }

        /* access modifiers changed from: package-private */
        public d6.a b() {
            return this.f36416a.I0();
        }

        /* access modifiers changed from: package-private */
        public jb.a c(jb.b bVar) {
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public jb.b d() {
            return new jb.b();
        }

        /* access modifiers changed from: package-private */
        public jb.c e(jb.b bVar) {
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public b6.d f() {
            return this.f36416a;
        }

        /* access modifiers changed from: package-private */
        public kb.a g(kb.b bVar) {
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public kb.b h() {
            return new kb.b();
        }

        /* access modifiers changed from: package-private */
        public kb.c i(kb.b bVar) {
            return bVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(b6.d dVar) {
        return a.a().b(new C0446b(dVar)).c(Bakery.j()).a();
    }

    /* access modifiers changed from: package-private */
    public void D0(String str) {
        ((a) A0()).k0().b(str);
    }
}
