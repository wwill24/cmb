package com.coffeemeetsbagel.suggested_history;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.suggested_history.suggested_history_match_container.d;
import kotlin.jvm.internal.j;
import o9.f;

public final class m extends s<SuggestedHistoryCompPresenter, o> implements f.a {

    /* renamed from: f  reason: collision with root package name */
    public bb.a f37126f;

    /* renamed from: g  reason: collision with root package name */
    private final f f37127g = new f(this);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final j f37128h = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final d f37129j = new a(this);

    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f37130a;

        a(m mVar) {
            this.f37130a = mVar;
        }

        public void a(String str) {
            j.g(str, "profileId");
            ((o) this.f37130a.B1()).m(this.f37130a.f37128h);
        }

        public void b(Bagel bagel) {
            j.g(bagel, Extra.BAGEL);
            ((o) this.f37130a.B1()).o(bagel);
        }

        public void c(String str) {
            j.g(str, "profileId");
            ((o) this.f37130a.B1()).m(this.f37130a.f37128h);
        }

        public void onError() {
            ((o) this.f37130a.B1()).p();
        }
    }

    public static final class b implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f37131a;

        b(m mVar) {
            this.f37131a = mVar;
        }

        public void n(Bagel bagel) {
            j.g(bagel, Extra.BAGEL);
            ((o) this.f37131a.B1()).n(bagel, this.f37131a.f37129j);
        }
    }

    private final long J1() {
        return DateUtils.getTimestampForNextNoon() + 3000;
    }

    private final void M1() {
        long J1 = J1();
        this.f37127g.start();
        this.f37127g.g(J1);
    }

    public final bb.a K1() {
        bb.a aVar = this.f37126f;
        if (aVar != null) {
            return aVar;
        }
        j.y("stringProvider");
        return null;
    }

    public final void L1() {
        ((o) B1()).m(this.f37128h);
    }

    public void g0() {
        ((SuggestedHistoryCompPresenter) this.f7875e).k(K1().a(R.string.timer_zero, new Object[0]));
    }

    public void l0(long j10) {
        String str;
        int b10 = c.b((float) (j10 / 1000));
        if (b10 > 0) {
            str = DateUtils.getCountdownTimerFromSeconds(b10);
            j.f(str, "getCountdownTimerFromSeconds(secondsLeft)");
        } else {
            str = K1().a(R.string.timer_zero, new Object[0]);
        }
        ((SuggestedHistoryCompPresenter) this.f7875e).k(str);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        M1();
        ((o) B1()).m(this.f37128h);
    }
}
