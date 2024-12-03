package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.lifecycle.t;
import androidx.work.impl.utils.futures.a;
import b2.h;

public class o implements h {

    /* renamed from: c  reason: collision with root package name */
    private final t<h.b> f7575c = new t<>();

    /* renamed from: d  reason: collision with root package name */
    private final a<h.b.c> f7576d = a.s();

    public o() {
        a(h.f7744b);
    }

    public void a(@NonNull h.b bVar) {
        this.f7575c.m(bVar);
        if (bVar instanceof h.b.c) {
            this.f7576d.o((h.b.c) bVar);
        } else if (bVar instanceof h.b.a) {
            this.f7576d.p(((h.b.a) bVar).a());
        }
    }
}
