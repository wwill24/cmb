package i8;

import a7.a;
import android.database.Cursor;
import b7.c;
import com.coffeemeetsbagel.bakery.h1;
import com.coffeemeetsbagel.data.CmbContentProvider;
import com.coffeemeetsbagel.discover.e;
import com.coffeemeetsbagel.match.j;
import f6.f2;
import java.util.HashMap;
import java.util.Map;

public class b implements a, h1.b {

    /* renamed from: a  reason: collision with root package name */
    private final c f15512a;

    /* renamed from: b  reason: collision with root package name */
    private final j f15513b;

    /* renamed from: c  reason: collision with root package name */
    private final a f15514c;

    /* renamed from: d  reason: collision with root package name */
    private final h1 f15515d;

    /* renamed from: e  reason: collision with root package name */
    private final hb.c f15516e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15517f;

    public b(c cVar, j jVar, a aVar, h1 h1Var, hb.c cVar2) {
        this.f15512a = cVar;
        this.f15513b = jVar;
        this.f15514c = aVar;
        this.f15515d = h1Var;
        this.f15516e = cVar2;
    }

    private boolean V() {
        return this.f15513b.H().booleanValue() || W();
    }

    private boolean W() {
        boolean z10;
        String valueOf = String.valueOf(System.currentTimeMillis());
        Cursor d10 = CmbContentProvider.d(f2.f().getReadableDatabase());
        Cursor a10 = e.f12177a.a(f2.f().getReadableDatabase(), valueOf);
        if (d10.getCount() != 0 || a10.getCount() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        d10.close();
        a10.close();
        return z10;
    }

    private void X(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("No Bagel User Action", str);
        this.f15514c.trackEvent("No Bagels", hashMap);
        this.f15517f = false;
    }

    public void A() {
    }

    public void G() {
        HashMap hashMap = new HashMap();
        hashMap.put("Color", "Default");
        this.f15514c.trackEvent("Shop Button Clicked", hashMap);
    }

    public void P() {
        if (this.f15517f) {
            X("left app");
        }
    }

    public void Q() {
    }

    public void S() {
    }

    public void T() {
        if (V()) {
            this.f15514c.trackEvent("visited_no_bagels_screen", (Map<String, String>) null);
            this.f15517f = true;
            return;
        }
        this.f15514c.trackEvent("visited_todays_bagel_screen", (Map<String, String>) null);
    }

    public void e() {
        this.f15516e.c("num_times_like_pass_flow_shown", this.f15516e.l("num_times_like_pass_flow_shown") + 1);
    }

    public void h() {
        if (this.f15517f) {
            X("left no bagel tab");
        }
    }

    public void p() {
        this.f15512a.d();
    }

    public void start() {
        this.f15515d.f(this);
    }

    public void stop() {
        this.f15515d.j(this);
    }
}
