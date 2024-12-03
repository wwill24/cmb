package yl;

import am.f;
import am.r;
import am.v;
import am.w;
import dm.a;

public abstract class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final char f24791a;

    protected b(char c10) {
        this.f24791a = c10;
    }

    public int a(dm.b bVar, dm.b bVar2) {
        if ((bVar.a() || bVar2.c()) && bVar2.b() % 3 != 0 && (bVar.b() + bVar2.b()) % 3 == 0) {
            return 0;
        }
        if (bVar.length() < 2 || bVar2.length() < 2) {
            return 1;
        }
        return 2;
    }

    public char b() {
        return this.f24791a;
    }

    public int c() {
        return 1;
    }

    public char d() {
        return this.f24791a;
    }

    public void e(w wVar, w wVar2, int i10) {
        r rVar;
        String valueOf = String.valueOf(d());
        if (i10 == 1) {
            rVar = new f(valueOf);
        } else {
            rVar = new v(valueOf + valueOf);
        }
        r e10 = wVar.e();
        while (e10 != null && e10 != wVar2) {
            r e11 = e10.e();
            rVar.b(e10);
            e10 = e11;
        }
        wVar.h(rVar);
    }
}
