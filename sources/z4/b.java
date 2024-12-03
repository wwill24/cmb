package z4;

import com.coffeemeetsbagel.activities.main.active_fragment.ActiveFragment;
import io.reactivex.subjects.a;
import qj.q;

public class b implements c, a {

    /* renamed from: a  reason: collision with root package name */
    private a<ActiveFragment> f18832a = a.D0(ActiveFragment.TODAY);

    public void a(ActiveFragment activeFragment) {
        this.f18832a.d(activeFragment);
    }

    public q<ActiveFragment> b() {
        return this.f18832a.d0(1).C0().P();
    }
}
