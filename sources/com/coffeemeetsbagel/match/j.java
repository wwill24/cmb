package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.responses.ResponseBagel;
import j5.x;
import java.util.List;
import qj.q;

public interface j {

    public interface a {
        void a(Bagel bagel);

        void onError(String str);
    }

    public interface b {
        void o0();
    }

    public interface c {
        void P();
    }

    public interface d {
        void a(Throwable th2);
    }

    public interface e {
        void a(boolean z10);
    }

    List<Bagel> A();

    void B(c cVar);

    Bagel D(String str);

    void E(boolean z10, boolean z11, e eVar);

    void F(b bVar);

    com.jakewharton.rxrelay2.b<x> G();

    Boolean H();

    q<Bagel> a();

    void b(a aVar, Bagel bagel, Object obj);

    void clear();

    void d(String str, a aVar);

    q<List<Bagel>> e();

    void g(String str, g gVar);

    void h(long j10, k<ResponseBagel> kVar, d dVar);

    void i(Runnable runnable);

    void j(int i10, String str, k<ResponseBagel> kVar, d dVar);

    Bagel k(String str);

    void l(Bagel bagel, Bagel bagel2);

    Boolean m();

    void n();

    void o(c cVar);

    void p(boolean z10);

    void q(String str, String str2, String str3, a aVar);

    void r(b bVar);

    void s();

    void t(boolean z10, boolean z11, int i10, e eVar);

    void u(Bagel bagel);

    void w();

    boolean x();

    void y(boolean z10, e eVar);

    void z(ConnectionDetails connectionDetails, Bagel bagel);
}
