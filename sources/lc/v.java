package lc;

import com.jakewharton.rxrelay2.b;
import j5.x;
import kotlin.jvm.internal.j;
import qj.q;

public final class v {
    public static final void a(b<x> bVar) {
        j.g(bVar, "<this>");
        bVar.accept(x.a());
    }

    public static final <T> q<T> b(b<T> bVar) {
        j.g(bVar, "<this>");
        q<T> C0 = bVar.P().d0(1).C0();
        j.f(C0, "this.hide().replay(1).refCount()");
        return C0;
    }
}
