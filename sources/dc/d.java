package dc;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.today_view.card.deactivated.DeactivatedComponentView;
import com.coffeemeetsbagel.today_view.main.e;

public class d extends b6.c<j, c> {

    public interface a extends j<f> {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final DeactivatedComponentView f40594a;

        /* renamed from: b  reason: collision with root package name */
        private final f f40595b;

        b(DeactivatedComponentView deactivatedComponentView, f fVar) {
            this.f40594a = deactivatedComponentView;
            this.f40595b = fVar;
        }

        /* access modifiers changed from: package-private */
        public i a() {
            return new i(this.f40594a, this.f40595b);
        }
    }

    public interface c {
        ActivityMain a();

        a7.a c();

        ProfileContract$Manager d();

        e.a r();
    }

    public d(c cVar) {
        super(cVar);
    }

    public j b(ViewGroup viewGroup) {
        f fVar = new f();
        DeactivatedComponentView deactivatedComponentView = (DeactivatedComponentView) LayoutInflater.from(((c) a()).a()).inflate(R.layout.deactivated_component, viewGroup, false);
        return new j(deactivatedComponentView, b.a().b(new b(deactivatedComponentView, fVar)).c((c) a()).a(), fVar);
    }
}
