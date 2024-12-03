package z9;

import kotlin.jvm.internal.j;
import qj.v;

public final class a implements cb.a {
    public v a() {
        v a10 = sj.a.a();
        j.f(a10, "mainThread()");
        return a10;
    }

    public v b() {
        v a10 = dk.a.a();
        j.f(a10, "computation()");
        return a10;
    }

    public v c() {
        v c10 = dk.a.c();
        j.f(c10, "io()");
        return c10;
    }
}
