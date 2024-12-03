package w5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.cmbbottomnav.component.CmbBottomNavView;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import v5.e;

public class a extends b6.c<l, c> {

    /* renamed from: w5.a$a  reason: collision with other inner class name */
    public interface C0216a extends j<h> {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final h f18246a;

        /* renamed from: b  reason: collision with root package name */
        private final CmbBottomNavView f18247b;

        public b(h hVar, CmbBottomNavView cmbBottomNavView) {
            this.f18246a = hVar;
            this.f18247b = cmbBottomNavView;
        }

        /* access modifiers changed from: package-private */
        public k a(Activity activity) {
            return new k(this.f18247b, this.f18246a, activity);
        }
    }

    public interface c {
        x5.a E();

        ProfileRepositoryV2 J();

        y5.a S();

        y5.b W();

        s9.a b();

        UserRepository e();

        Activity i();
    }

    public a(c cVar) {
        super(cVar);
    }

    public l b(ViewGroup viewGroup) {
        h hVar = new h();
        CmbBottomNavView cmbBottomNavView = (CmbBottomNavView) LayoutInflater.from(((c) a()).i()).inflate(e.cmb_bottom_navigation, viewGroup, false);
        return new l(cmbBottomNavView, n.a().b(new b(hVar, cmbBottomNavView)).c((c) a()).a(), hVar);
    }
}
