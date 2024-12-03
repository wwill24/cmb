package q6;

import android.os.Bundle;
import android.os.Looper;
import b6.p;
import com.coffeemeetsbagel.discover_feed.filters.DiscoverFeedFiltersView;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import h5.i;
import j5.x;
import sj.a;
import v7.d;
import z9.f;

public class k extends p<DiscoverFeedFiltersView> {

    /* renamed from: e  reason: collision with root package name */
    private final g f17185e;

    /* renamed from: f  reason: collision with root package name */
    private final d f17186f;

    /* renamed from: g  reason: collision with root package name */
    private final f f17187g = new j(this);

    public k(DiscoverFeedFiltersView discoverFeedFiltersView, g gVar, d dVar) {
        super(discoverFeedFiltersView);
        this.f17185e = gVar;
        this.f17186f = dVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(x xVar) throws Exception {
        this.f17185e.s0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(EventType eventType, Bundle bundle) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            p(bundle.getBoolean(Extra.ARE_FILTERS_APPLIED, false));
        }
    }

    private void p(boolean z10) {
        if (z10) {
            ((DiscoverFeedFiltersView) this.f7869c).D();
        } else {
            ((DiscoverFeedFiltersView) this.f7869c).E();
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((DiscoverFeedFiltersView) g()).B().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new i(this));
        p(this.f17186f.c());
        i.a(this.f17187g, EventType.FILTERS_STATE_CHANGED);
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        i.d(this.f17187g, EventType.FILTERS_STATE_CHANGED);
    }

    public void l() {
        ((DiscoverFeedFiltersView) this.f7869c).C();
    }

    public void o(int i10) {
        ((DiscoverFeedFiltersView) this.f7869c).F(i10);
    }
}
