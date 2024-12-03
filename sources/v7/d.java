package v7;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import java.util.List;
import v7.a;
import w7.j;

public interface d {

    public interface a {
        void onFailure();

        void onSuccess();
    }

    public interface b {
        void I0();

        void M0();

        void h0();

        void o1();
    }

    public interface c {
        void a(String str);

        void onSuccess();
    }

    List<GiveTakeBase> a();

    j b();

    boolean c();

    void clear();

    void d();

    void e();

    void f(GiveTakeBase giveTakeBase);

    void g();

    void h(Price price, GiveTakeBase giveTakeBase, c cVar);

    void i(b bVar);

    void j(String str);

    void k(RisingGiveTake risingGiveTake, a.b bVar);

    boolean l(GiveTakeBase giveTakeBase);

    boolean m(GiveTakeBase giveTakeBase);

    void markGiveTakeAsSeen(String str, a.b bVar);

    void markRisingGiveTakeAsSeen(String str, a.b bVar);

    List<GiveTakeBase> n();

    void o(j jVar, a aVar);

    List<GiveTakeBase> p();

    void q();

    void r();

    List<GiveTakeBase> s();

    void t(b bVar);
}
