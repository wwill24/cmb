package y6;

import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import c7.d;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent;
import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.models.responses.ResponseActivityReports;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.utils.model.Optional;
import com.mparticle.kits.AppsFlyerKit;
import com.uber.autodispose.m;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import qj.q;
import wb.c;
import y6.a;

public class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a7.a f18758a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18759b = l.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final com.coffeemeetsbagel.database.room_mappers.a f18760c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final h f18761d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, ActivityReport> f18762e;

    /* renamed from: f  reason: collision with root package name */
    private final m f18763f;

    /* renamed from: g  reason: collision with root package name */
    private final c f18764g;

    /* renamed from: h  reason: collision with root package name */
    private final AuthenticationScopeProvider f18765h;

    class a extends AsyncTask<Void, Void, List<ActivityReport>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f18766a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.C0223a f18767b;

        a(List list, a.C0223a aVar) {
            this.f18766a = list;
            this.f18767b = aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<ActivityReport> doInBackground(Void... voidArr) {
            return com.coffeemeetsbagel.database.room_mappers.a.f11975b.c(l.this.f18761d.m(this.f18766a));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(List<ActivityReport> list) {
            l.this.G(list);
            List p10 = l.this.u(this.f18766a);
            if (p10.size() == 0) {
                this.f18767b.a(new HashMap(l.this.f18762e));
                return;
            }
            l lVar = l.this;
            lVar.s(lVar.t(p10), this.f18767b, p10);
        }
    }

    public l(AuthenticationScopeProvider authenticationScopeProvider, com.coffeemeetsbagel.database.room_mappers.a aVar, h hVar, a7.a aVar2, d dVar, c cVar) {
        HashMap<String, ActivityReport> hashMap = new HashMap<>();
        this.f18762e = hashMap;
        this.f18758a = aVar2;
        this.f18764g = cVar;
        this.f18760c = aVar;
        this.f18761d = hVar;
        this.f18765h = authenticationScopeProvider;
        this.f18763f = (m) dVar.c(m.class);
        q<AuthenticationEvent> x10 = authenticationScopeProvider.x();
        Objects.requireNonNull(hashMap);
        ((p) x10.w(new g(hashMap)).g(com.uber.autodispose.a.a(authenticationScopeProvider))).b(new h(this), new i(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Throwable th2) throws Exception {
        fa.a.g(this.f18759b, "", th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(a.C0223a aVar, List list, Optional optional) throws Exception {
        if (!optional.d()) {
            aVar.a(new HashMap());
        } else {
            I(u(list), aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(a.C0223a aVar, Throwable th2) throws Exception {
        aVar.a(new HashMap());
        fa.a.g(this.f18759b, "Error refreshing activity reports.", th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(List list) throws Exception {
        this.f18760c.a(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(a.C0223a aVar) throws Exception {
        aVar.a(new HashMap(this.f18762e));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(Throwable th2) throws Exception {
        fa.a.f(this.f18759b, "Failed to save Activity Reports to database.");
    }

    /* access modifiers changed from: private */
    public void G(List<ActivityReport> list) {
        ha.a.c(Looper.myLooper().getThread(), "Updating Activity Report Map must be on UI thread");
        for (ActivityReport next : list) {
            this.f18762e.put(next.getProfileId(), next);
        }
    }

    private void H(List<ActivityReport> list, a.C0223a aVar) {
        ((m) qj.a.w(new d(this, list)).F(dk.a.c()).F(sj.a.a()).j(com.uber.autodispose.a.a(this.f18765h))).f(new e(this, aVar), new f(this));
    }

    private void I(List<String> list, a.C0223a aVar) {
        new a(list, aVar).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void x(ResponseActivityReports responseActivityReports, a.C0223a aVar) {
        if (responseActivityReports.getActivityReports() == null) {
            aVar.a(new HashMap());
            return;
        }
        List<ActivityReport> activityReports = responseActivityReports.getActivityReports();
        G(activityReports);
        H(activityReports, aVar);
    }

    /* access modifiers changed from: private */
    public void s(String str, a.C0223a aVar, List<String> list) {
        ((t) this.f18763f.a(TextUtils.join(AppsFlyerKit.COMMA, list)).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f18765h))).b(new b(this, aVar), new c(aVar));
    }

    /* access modifiers changed from: private */
    public String t(List<String> list) {
        String join = TextUtils.join(AppsFlyerKit.COMMA, list);
        return x4.a.f18540d + "activity_reports" + "?id=" + join;
    }

    /* access modifiers changed from: private */
    public List<String> u(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!w(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private boolean v(ActivityReport activityReport) {
        if (activityReport.getExpirationDate() == null || System.currentTimeMillis() >= DateUtils.getDate(activityReport.getExpirationDate()).getTime()) {
            return false;
        }
        return true;
    }

    private boolean w(String str) {
        ActivityReport activityReport = this.f18762e.get(str);
        if (activityReport == null || !v(activityReport)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(AuthenticationEvent authenticationEvent) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Got event: ");
        sb2.append(authenticationEvent);
    }

    public void a(boolean z10) {
        HashMap hashMap = new HashMap();
        if (z10) {
            hashMap.put("state", "Unlocked");
        } else {
            hashMap.put("state", "Locked");
        }
        this.f18758a.trackEvent("Activity Report", hashMap);
    }

    public void b(List<String> list, a.C0223a aVar) {
        if (list == null || list.size() == 0) {
            aVar.a(new HashMap());
        } else {
            ((t) this.f18764g.a().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this.f18765h))).b(new j(this, aVar, list), new k(this, aVar));
        }
    }
}
