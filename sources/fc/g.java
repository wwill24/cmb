package fc;

import a6.a;
import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.today_view.main.e;
import com.uber.autodispose.p;
import j5.x;

public class g extends s<j, k> {

    /* renamed from: f  reason: collision with root package name */
    ProfileContract$Manager f40786f;

    /* renamed from: g  reason: collision with root package name */
    a f40787g;

    /* renamed from: h  reason: collision with root package name */
    e.a f40788h;

    /* renamed from: j  reason: collision with root package name */
    a7.a f40789j;

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(x xVar) throws Exception {
        N1();
    }

    private void N1() {
        NetworkProfile j10 = this.f40786f.j();
        if (j10 != null) {
            if (!j10.isFemale() || !j10.isStraight()) {
                if (!this.f40786f.h() || this.f40787g.a("has_completed_like_flow")) {
                    ((j) this.f7875e).n();
                } else {
                    ((j) this.f7875e).o();
                }
            } else if (this.f40786f.q(j10)) {
                if (!this.f40786f.h() || this.f40787g.a("has_completed_like_flow")) {
                    ((j) this.f7875e).l(j10.getPhotos(), j10.getUserFirstName());
                } else {
                    ((j) this.f7875e).m();
                }
            } else if (this.f40787g.a("has_completed_like_flow") || !this.f40786f.h()) {
                ((j) this.f7875e).n();
            } else {
                ((j) this.f7875e).o();
            }
            this.f40789j.f("Today's Bagel - Empty");
        }
    }

    /* access modifiers changed from: package-private */
    public void J1() {
        this.f40788h.d();
        this.f40789j.d("Today's Bagel - Empty - Check Discover Button Tapped");
    }

    /* access modifiers changed from: package-private */
    public void K1() {
        this.f40788h.f();
        this.f40789j.d("Today's Bagel - Empty - Complete Profile Button Tapped");
    }

    /* access modifiers changed from: package-private */
    public void L1() {
        this.f40788h.g();
        this.f40789j.d("Today's Bagel - Empty - See Tips Button Tapped");
    }

    /* access modifiers changed from: package-private */
    public void M1() {
        this.f40789j.d("Today's Bagel - Empty - Hardware Back Button Tapped");
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        N1();
        ((p) this.f40786f.n().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(this));
    }
}
