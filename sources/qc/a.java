package qc;

import com.coffeemeetsbagel.utils.model.Optional;
import com.jakewharton.rxrelay2.b;
import qj.q;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final b<Optional<String>> f41804a = b.D0(Optional.a());

    public q<Optional<String>> a() {
        return this.f41804a.P().d0(1).C0();
    }

    public void b(String str) {
        this.f41804a.accept(Optional.b(str));
    }
}
