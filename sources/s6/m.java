package s6;

import b6.s;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.upsell_banner.i;
import com.uber.autodispose.n;
import io.reactivex.BackpressureStrategy;
import j5.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import qj.h;
import qj.q;
import v7.d;
import wb.c;

public class m extends s<o, p> implements d.b {

    /* renamed from: f  reason: collision with root package name */
    final i.a f17501f = new a();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final io.reactivex.subjects.a<Unit> f17502g = io.reactivex.subjects.a.C0();

    /* renamed from: h  reason: collision with root package name */
    d f17503h;

    /* renamed from: j  reason: collision with root package name */
    ActivityMain f17504j;

    /* renamed from: k  reason: collision with root package name */
    a7.a f17505k;

    /* renamed from: l  reason: collision with root package name */
    UserRepository f17506l;

    /* renamed from: m  reason: collision with root package name */
    k0 f17507m;

    /* renamed from: n  reason: collision with root package name */
    c f17508n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public io.reactivex.subjects.a<x> f17509p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f17510q;

    class a implements i.a {
        a() {
        }

        public void a() {
            ((p) m.this.B1()).o(new PurchaseSource("Give & Take", "Subscription Banner"));
        }

        public void b() {
        }
    }

    public class b {
        public b() {
        }

        public q<x> a() {
            return m.this.f17509p;
        }

        public void b() {
            m.this.f17502g.d(Unit.f32013a);
        }

        public void c() {
            ((p) m.this.B1()).t();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean N1(Unit unit) throws Exception {
        boolean z10 = true;
        int beanCost = this.f17507m.getPrice(PurchaseType.DISCOVER_LIKES).getBeanCost(1);
        if (this.f17503h.c() || beanCost <= 0 || this.f17503h.n().isEmpty()) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ androidx.core.util.d O1(Boolean bool, Boolean bool2, Boolean bool3) throws Exception {
        return new androidx.core.util.d(Boolean.valueOf(bool2.booleanValue() && !bool.booleanValue()), bool3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1(androidx.core.util.d dVar) throws Exception {
        if (((Boolean) dVar.f4735a).booleanValue()) {
            U1(((Boolean) dVar.f4736b).booleanValue());
        } else {
            ((p) B1()).n();
        }
    }

    private void R1() {
        ((n) h.m(this.f17508n.a().Y(new h()), this.f17502g.W(new i(this)).v0(BackpressureStrategy.LATEST), this.f17506l.p().Y(new g()), new j()).a0(sj.a.a()).v().g(com.uber.autodispose.a.a(this))).b(new k(this), new l());
    }

    private void U1(boolean z10) {
        String str;
        String str2;
        if (z10) {
            str = t9.a.discoverBannerFreeTrialCta;
        } else {
            str = t9.a.discoverBannerSubscriptionCta;
        }
        if (z10) {
            str2 = t9.a.discoverBannerFreeTrialText;
        } else {
            str2 = t9.a.discoverBannerSubscriptionText;
        }
        ((p) B1()).m(z10, str, str2, this.f17501f);
    }

    /* access modifiers changed from: protected */
    public void F1() {
        super.F1();
        this.f17503h.t(this);
    }

    public void I0() {
        ((p) B1()).w();
    }

    public void M0() {
        this.f17509p.d(x.a());
    }

    public void S1() {
        ((p) B1()).q();
    }

    public void T1(boolean z10) {
        if (!z10 || !((p) B1()).p()) {
            this.f17510q = z10;
        } else {
            ((p) B1()).v();
        }
    }

    public void h0() {
        List<GiveTakeBase> list;
        String str;
        if (this.f17503h.c()) {
            list = this.f17503h.s();
        } else {
            list = this.f17503h.n();
        }
        if (new ArrayList(list).isEmpty()) {
            ((p) B1()).t();
            a7.a aVar = this.f17505k;
            if (this.f17503h.c()) {
                str = "Empty Discover Filter Feed Shown";
            } else {
                str = "Empty Discover Feed Shown";
            }
            aVar.i(str);
        } else {
            ((p) B1()).u();
        }
        if (this.f17510q) {
            this.f17510q = false;
            ((p) B1()).v();
        }
        this.f17509p.d(x.a());
    }

    public void o1() {
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        this.f17509p = io.reactivex.subjects.a.C0();
        this.f17503h.i(this);
        this.f17503h.e();
        this.f17504j.X2();
        R1();
    }
}
