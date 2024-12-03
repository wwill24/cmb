package r7;

import a7.a;
import android.os.Bundle;
import b6.n;
import c9.d;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.store.k0;
import d7.c;
import l8.h;
import t8.l;

public class b extends n {

    /* renamed from: c  reason: collision with root package name */
    private boolean f17371c;

    public a C0() {
        return Bakery.w().z();
    }

    public c D0() {
        return Bakery.w().g();
    }

    public j E0() {
        return Bakery.w().i();
    }

    public k7.b F0() {
        return Bakery.w().A();
    }

    public s9.a G0() {
        return Bakery.w().s();
    }

    public FirebaseContract.Analytics H0() {
        return Bakery.w().t();
    }

    public InstagramContract$Manager I0() {
        return Bakery.w().v();
    }

    public h J0() {
        return Bakery.w().E();
    }

    public l L0() {
        return Bakery.w().F();
    }

    public ProfileContract$Manager M0() {
        return Bakery.w().G();
    }

    public k0 N0() {
        return Bakery.w().C();
    }

    public d O0() {
        return Bakery.w().J();
    }

    public hb.c P0() {
        return Bakery.w().M();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17371c = false;
    }

    public void onResume() {
        super.onResume();
        if (D0().isLoggedIn()) {
            Bakery.w().x().d();
        }
        this.f17371c = false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f17371c = true;
    }
}
