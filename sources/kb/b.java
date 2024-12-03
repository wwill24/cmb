package kb;

import com.coffeemeetsbagel.utils.model.Optional;
import qj.q;

public class b implements a, c {

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<Optional<org.json.b>> f41065a = com.jakewharton.rxrelay2.b.D0(Optional.a());

    public void a(org.json.b bVar) {
        this.f41065a.accept(Optional.b(bVar));
    }

    public q<Optional<org.json.b>> b() {
        return this.f41065a.P().d0(1).C0();
    }
}
