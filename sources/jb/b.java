package jb;

import com.coffeemeetsbagel.utils.model.Optional;
import qj.q;

public class b implements a, c {

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<Optional<String>> f41050a = com.jakewharton.rxrelay2.b.D0(Optional.a());

    public q<Optional<String>> a() {
        return this.f41050a.P().d0(1).C0();
    }

    public void b(String str) {
        this.f41050a.accept(Optional.b(str));
    }
}
