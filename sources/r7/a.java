package r7;

import androidx.fragment.app.h;
import b7.c;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17370a;

    public a7.a k0() {
        return Bakery.w().z();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f17370a = false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f17370a = true;
    }

    public c p0() {
        return Bakery.w().e();
    }

    public j q0() {
        return Bakery.w().i();
    }

    public y7.a r0() {
        return Bakery.w().q();
    }

    public s9.a s0() {
        return Bakery.w().s();
    }

    public InstagramContract$Manager t0() {
        return Bakery.w().v();
    }

    public ProfileContract$Manager u0() {
        return Bakery.w().G();
    }

    public t v0() {
        return Bakery.w().H();
    }

    public UpgradeContract.Manager w0() {
        return Bakery.w().N();
    }

    public boolean y0() {
        return this.f17370a;
    }
}
