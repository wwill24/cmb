package y4;

import a5.c;
import android.os.Bundle;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import com.coffeemeetsbagel.limelight.dialog.d;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.today_view.main.b;
import s6.d;
import w5.a;

public class a1 extends b6.a<a, ActivityMain> {

    /* renamed from: b  reason: collision with root package name */
    b f18669b;

    public interface a extends b6.b<ActivityMain>, d.c, a.c, c.a, b.a, d.c, e.a {
        void Z(a1 a1Var);

        ActivityMain i();
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        private ActivityMain f18670a;

        b(ActivityMain activityMain) {
            this.f18670a = activityMain;
        }

        /* access modifiers changed from: package-private */
        public z4.a a(z4.b bVar) {
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public z4.b b() {
            return new z4.b();
        }

        /* access modifiers changed from: package-private */
        public z4.c c(z4.b bVar) {
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.app.c d() {
            return this.f18670a;
        }

        /* access modifiers changed from: package-private */
        public y5.a e(NavStateManager navStateManager) {
            return navStateManager;
        }

        /* access modifiers changed from: package-private */
        public y5.b f(NavStateManager navStateManager) {
            return navStateManager;
        }

        /* access modifiers changed from: package-private */
        public x5.a g() {
            return new x5.a();
        }

        /* access modifiers changed from: package-private */
        public ActivityMain h() {
            return this.f18670a;
        }

        /* access modifiers changed from: package-private */
        public NavStateManager i() {
            return new NavStateManager();
        }

        public void j(ActivityMain activityMain) {
            this.f18670a = activityMain;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D0 */
    public a z0(ActivityMain activityMain) {
        this.f18669b = new b(activityMain);
        return y0.a().b(this.f18669b).c(Bakery.j()).a();
    }

    /* access modifiers changed from: protected */
    public void E0(ActivityMain activityMain) {
        this.f18669b.j(activityMain);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        if (this.f7846a == null) {
            this.f7846a = z0((ActivityMain) getActivity());
        } else {
            E0((ActivityMain) getActivity());
        }
        ((a) this.f7846a).Z(this);
        ActivityMain activityMain = (ActivityMain) getActivity();
        if (activityMain != null) {
            activityMain.Z2();
        }
    }
}
