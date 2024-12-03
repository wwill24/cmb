package fc;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelComponentView;
import com.coffeemeetsbagel.today_view.main.e;

public class d extends b6.c<k, c> {

    public interface a extends j<g> {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final NoBagelComponentView f40783a;

        /* renamed from: b  reason: collision with root package name */
        private final g f40784b;

        b(NoBagelComponentView noBagelComponentView, g gVar) {
            this.f40783a = noBagelComponentView;
            this.f40784b = gVar;
        }

        /* access modifiers changed from: package-private */
        public j a() {
            return new j(this.f40783a, this.f40784b);
        }
    }

    public interface c {
        ActivityMain a();

        a7.a c();

        ProfileContract$Manager d();

        e.a g();

        a6.a x();
    }

    public d(c cVar) {
        super(cVar);
    }

    public k b(ViewGroup viewGroup) {
        g gVar = new g();
        NoBagelComponentView noBagelComponentView = (NoBagelComponentView) LayoutInflater.from(((c) a()).a()).inflate(R.layout.no_bagel_component, viewGroup, false);
        return new k(noBagelComponentView, b.a().b(new b(noBagelComponentView, gVar)).c((c) a()).a(), gVar);
    }
}
