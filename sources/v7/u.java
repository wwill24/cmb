package v7;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.feature.purchase.requests.DiscoverLikesPurchaseRequest;
import com.coffeemeetsbagel.feature.purchase.requests.DiscoverSearchTakePurchaseRequest;
import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.profile.o;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.j0;
import com.coffeemeetsbagel.store.k0;
import com.uber.autodispose.t;
import h6.c;
import h6.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import qj.h;
import qj.v;
import qj.w;
import v7.a;
import v7.d;
import w7.j;
import y4.p0;

public class u implements d, z9.f {
    /* access modifiers changed from: private */
    public long B;
    /* access modifiers changed from: private */
    public j C;
    private final y6.a D;
    private final Set<d.b> E;
    private final Executor F;
    private final QuestionRepository G;
    private final v H = dk.a.b(Executors.newFixedThreadPool(4));
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final y7.a f18097a;

    /* renamed from: b  reason: collision with root package name */
    private final a f18098b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final n9.a f18099c;

    /* renamed from: d  reason: collision with root package name */
    private final k0 f18100d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t7.a f18101e;

    /* renamed from: f  reason: collision with root package name */
    private final d7.c f18102f;

    /* renamed from: g  reason: collision with root package name */
    private final com.coffeemeetsbagel.database.room_mappers.c f18103g;

    /* renamed from: h  reason: collision with root package name */
    private final com.coffeemeetsbagel.database.room_mappers.b f18104h;

    /* renamed from: j  reason: collision with root package name */
    private final PhotoRepository f18105j;

    /* renamed from: k  reason: collision with root package name */
    private final AuthenticationScopeProvider f18106k;

    /* renamed from: l  reason: collision with root package name */
    private final ProfileRepositoryV2 f18107l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public List<GiveTakeBase> f18108m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final List<GiveTakeBase> f18109n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public List<GiveTakeBase> f18110p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public List<GiveTakeBase> f18111q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public List<GiveTakeBase> f18112t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final HashSet<String> f18113w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f18114x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f18115y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f18116z;

    class a extends AsyncTask<Void, Void, List<GiveTakeBase>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f18117a;

        a(Runnable runnable) {
            this.f18117a = runnable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            u.this.x0();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(List list, Runnable runnable) {
            u.this.f18108m = list;
            if (u.this.f18115y) {
                u.this.f18112t = new ArrayList();
                u.this.f18112t.addAll(u.this.h0());
                u.this.f18112t.addAll(u.this.f18111q);
                u uVar = u.this;
                uVar.f0(uVar.f18112t, new t(this));
            } else {
                u.this.x0();
            }
            if (runnable != null) {
                runnable.run();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public List<GiveTakeBase> doInBackground(Void... voidArr) {
            try {
                Cursor a10 = com.coffeemeetsbagel.discover.e.f12177a.a(u.this.f18101e.b().getReadableDatabase(), String.valueOf(u.this.f18099c.getCurrentTimeMillis()));
                List<GiveTakeBase> d02 = u.this.d0(a10);
                if (!a10.isClosed()) {
                    a10.close();
                }
                return d02;
            } catch (Exception e10) {
                fa.a.g("DiscoverManager", "failed read discover matches from DB", e10);
                return new ArrayList();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public void onPostExecute(List<GiveTakeBase> list) {
            u.this.f0(list, new s(this, list, this.f18117a));
        }
    }

    class b implements k0.b<Object, Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f18119a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d.c f18120b;

        b(Runnable runnable, d.c cVar) {
            this.f18119a = runnable;
            this.f18120b = cVar;
        }

        public void a(Throwable th2) {
            this.f18120b.a(th2.getMessage());
        }

        public void b(Object obj) {
            this.f18119a.run();
        }
    }

    class c implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f18122a;

        c(List list) {
            this.f18122a = list;
        }

        public void onFailure() {
            fa.a.f("DiscoverManager", "Unable to refresh prices and update flower count");
        }

        public void onSuccess() {
            for (d.b bVar : this.f18122a) {
                v a10 = sj.a.a();
                Objects.requireNonNull(bVar);
                a10.c(new v(bVar));
            }
        }
    }

    class d implements a.C0214a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.a f18124a;

        d(d.a aVar) {
            this.f18124a = aVar;
        }

        public void a(List<GiveTake> list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("filtered takes, num takes received=");
            sb2.append(list.size());
            u.this.f18111q = new ArrayList();
            for (GiveTake next : list) {
                if (next.getProfile() != null) {
                    u.this.f18111q.add(next);
                }
            }
            u uVar = u.this;
            uVar.A0(uVar.f18111q);
            u.this.f18112t = new ArrayList();
            u.this.f18112t.addAll(u.this.h0());
            u.this.f18112t.addAll(u.this.f18111q);
            if (!u.this.f18115y) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(Extra.ARE_FILTERS_APPLIED, true);
                u.this.f18097a.b(EventType.FILTERS_STATE_CHANGED, bundle);
            }
            u.this.f18115y = true;
            u uVar2 = u.this;
            uVar2.B = uVar2.f18099c.a();
            u.this.f18112t = new ArrayList();
            u.this.f18112t.addAll(u.this.h0());
            u.this.f18112t.addAll(u.this.f18111q);
            u uVar3 = u.this;
            d.a aVar = this.f18124a;
            Objects.requireNonNull(aVar);
            uVar3.f0(list, new w(aVar));
        }

        public void onFailure() {
            u.this.C = new j();
            this.f18124a.onFailure();
        }
    }

    class e implements a.c {
        e() {
        }

        public void a(List<GiveTake> list) {
            u.this.f18114x = false;
            for (GiveTakeBase next : list) {
                if (next.getProfile() != null && !u.this.f18113w.contains(next.getProfileId())) {
                    u.this.f18113w.add(next.getProfileId());
                    u.this.f18109n.add(next);
                }
            }
            u uVar = u.this;
            uVar.A0(uVar.f18109n);
            u.this.f18110p = new ArrayList();
            u.this.f18110p.addAll(u.this.n());
            u.this.f18110p.addAll(u.this.f18109n);
            u uVar2 = u.this;
            uVar2.f0(uVar2.f18110p, new x(u.this));
            u.this.z0();
        }

        public void onFailure() {
            u.this.f18114x = false;
            fa.a.f("DiscoverManager", Bakery.w().getApplicationContext().getString(R.string.load_error_infinite_scroll));
            u.this.z0();
        }
    }

    class f implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RisingGiveTake f18127a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.b f18128b;

        f(RisingGiveTake risingGiveTake, a.b bVar) {
            this.f18127a = risingGiveTake;
            this.f18128b = bVar;
        }

        public void a(String str, int i10) {
            this.f18128b.a(str, i10);
        }

        public void b(ResponseGeneric responseGeneric) {
            this.f18127a.setAction(1);
            u.this.f18101e.c("rising_give_take", "rising_give_take_action", String.valueOf(1), "rising_give_take_id", this.f18127a.getId());
            this.f18128b.b(responseGeneric);
        }
    }

    public u(ProfileRepositoryV2 profileRepositoryV2, y7.a aVar, a aVar2, n9.a aVar3, PhotoRepository photoRepository, k0 k0Var, t7.a aVar4, d7.c cVar, y6.a aVar5, CmbDatabase cmbDatabase, AuthenticationScopeProvider authenticationScopeProvider, QuestionRepository questionRepository) {
        this.f18107l = profileRepositoryV2;
        this.f18097a = aVar;
        this.f18098b = aVar2;
        this.f18099c = aVar3;
        this.f18105j = photoRepository;
        this.f18100d = k0Var;
        this.f18101e = aVar4;
        this.f18102f = cVar;
        this.D = aVar5;
        this.f18103g = new com.coffeemeetsbagel.database.room_mappers.c(cmbDatabase);
        this.f18104h = new com.coffeemeetsbagel.database.room_mappers.b(cmbDatabase);
        this.f18106k = authenticationScopeProvider;
        this.G = questionRepository;
        this.f18108m = new ArrayList();
        this.f18109n = new ArrayList();
        this.f18110p = new ArrayList();
        this.f18113w = new HashSet<>();
        this.f18111q = new ArrayList();
        this.C = new j();
        this.E = new HashSet();
        this.F = Executors.newSingleThreadExecutor();
        aVar.c(this, EventType.SYNC_COMPLETE);
    }

    /* access modifiers changed from: private */
    public void A0(List<GiveTakeBase> list) {
        ((t) h.U(new ArrayList(list)).Y(new p()).s0().D(new q(this)).K(this.H).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f18106k))).b(new r(), new p0());
    }

    private void B0(Runnable runnable) {
        new a(runnable).executeOnExecutor(this.F, new Void[0]);
    }

    private void C0(String str, a.b bVar) {
        this.f18098b.sendLikeBackRisingGiveTake(str, bVar);
    }

    private void D0(List<? extends GiveTakeBase> list, Map<String, ActivityReport> map) {
        ActivityReport activityReport;
        for (GiveTakeBase giveTakeBase : list) {
            if (!(!map.containsKey(giveTakeBase.getProfileId()) || (activityReport = map.get(giveTakeBase.getProfileId())) == null || giveTakeBase.getProfile() == null)) {
                giveTakeBase.getProfile().setActivityReport(activityReport);
            }
        }
    }

    private void E0() {
        if (this.f18115y && this.f18099c.getCurrentTimeMillis() > this.B) {
            g();
        }
    }

    private ArrayList<GiveTakeBase> e0(List<GiveTakeBase> list) {
        ArrayList<GiveTakeBase> arrayList = new ArrayList<>();
        long currentTimeMillis = this.f18099c.getCurrentTimeMillis();
        for (GiveTakeBase next : list) {
            if (DateUtils.getMillisFromUtc(next.getEndDate()).longValue() > currentTimeMillis && next.getProfile() != null && !next.isBlocked()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void f0(List<? extends GiveTakeBase> list, Runnable runnable) {
        this.D.b(g0(list), new o(this, list, runnable));
    }

    private List<String> g0(List<? extends GiveTakeBase> list) {
        ArrayList arrayList = new ArrayList();
        for (GiveTakeBase profileId : list) {
            arrayList.add(profileId.getProfileId());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<GiveTakeBase> h0() {
        if (this.f18108m == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (GiveTakeBase next : this.f18108m) {
            if (next instanceof RisingGiveTake) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private boolean i0(String str) {
        Iterator it = new ArrayList(this.f18108m).iterator();
        while (it.hasNext()) {
            if (str.equals(((GiveTakeBase) it.next()).getProfileId())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ NetworkPhoto j0(Photo photo) {
        return new NetworkPhoto(photo.d(), photo.getUrl(), photo.c(), photo.e(), photo.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(List list, Runnable runnable, Map map) {
        D0(list, map);
        runnable.run();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0() {
        this.f18116z = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(d.c cVar, GiveTakeBase giveTakeBase) {
        if (!this.f18102f.isLoggedIn()) {
            cVar.a((String) null);
            return;
        }
        if (giveTakeBase instanceof GiveTake) {
            ((GiveTake) giveTakeBase).setIsTaken(true);
        }
        cVar.onSuccess();
        f(giveTakeBase);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0() {
        for (d.b h02 : new ArrayList(this.E)) {
            h02.h0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0() {
        for (d.b M0 : new ArrayList(this.E)) {
            M0.M0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0() {
        for (d.b o12 : new ArrayList(this.E)) {
            o12.o1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(Integer num) throws Exception {
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer s0(String str) throws Exception {
        t7.a aVar = this.f18101e;
        return Integer.valueOf(aVar.j("give_ten", "profile_id=" + str, (String[]) null));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(Integer num) throws Exception {
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer u0(String str) throws Exception {
        t7.a aVar = this.f18101e;
        return Integer.valueOf(aVar.j("rising_give_take", "profile_id=" + str, (String[]) null));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer v0(List list) throws Exception {
        int e10 = this.f18103g.e(list);
        this.f18104h.a(list);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("finished saving questions into room ");
        sb2.append(this.G.X(list).j());
        return Integer.valueOf(e10);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void w0(Integer num) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# profiles persisted from give take: ");
        sb2.append(num);
    }

    /* access modifiers changed from: private */
    public void x0() {
        sj.a.a().c(new i(this));
    }

    private void y0() {
        sj.a.a().c(new g(this));
    }

    /* access modifiers changed from: private */
    public void z0() {
        sj.a.a().c(new f(this));
    }

    public List<GiveTakeBase> a() {
        return this.f18111q;
    }

    public j b() {
        E0();
        return this.C;
    }

    public boolean c() {
        E0();
        return this.f18115y;
    }

    public void clear() {
        g();
        d();
    }

    public void d() {
        this.f18114x = false;
        this.f18109n.clear();
        this.f18110p.clear();
        this.f18113w.clear();
        this.f18098b.clearInfiniteScrollCursors();
    }

    /* access modifiers changed from: package-private */
    public List<GiveTakeBase> d0(Cursor cursor) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        try {
            if (cursor.moveToFirst()) {
                do {
                    Optional h10 = this.f18107l.j(cursor.getString(cursor.getColumnIndex(Extra.PROFILE_ID))).h();
                    if (h10.isPresent()) {
                        NetworkProfile a10 = o.f36130a.a((l) h10.get());
                        a10.setPhotos((List) this.f18105j.f(a10.getId()).h().stream().map(new h()).collect(Collectors.toList()));
                        if (cursor.getString(cursor.getColumnIndex("rising_give_take_id")) != null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            RisingGiveTake a11 = new d.a(cursor).a();
                            a11.setUserProfile(a10);
                            arrayList.add(a11);
                        } else {
                            GiveTake a12 = new c.a(cursor).a();
                            a12.setProfile(a10);
                            arrayList.add(a12);
                        }
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e10) {
            fa.a.g("DiscoverManager", "Failed to patch missing profiles or photos to matches", e10);
        }
        return arrayList;
    }

    public void e() {
        if (this.f18102f.isLoggedIn()) {
            B0((Runnable) null);
        }
    }

    public void f(GiveTakeBase giveTakeBase) {
        boolean l10 = l(giveTakeBase);
        boolean m10 = m(giveTakeBase);
        if (!l10 && !m10) {
            this.f18101e.c("give_ten", "give_ten_is_taken", String.valueOf(1), "give_ten_id", giveTakeBase.getId());
        }
        y0();
    }

    public void g() {
        this.f18111q.clear();
        this.f18115y = false;
        this.C = new j();
        this.f18097a.a(EventType.FILTERS_STATE_CHANGED);
    }

    public void h(Price price, GiveTakeBase giveTakeBase, d.c cVar) {
        j0 j0Var;
        boolean l10 = l(giveTakeBase);
        boolean m10 = m(giveTakeBase);
        m mVar = new m(this, cVar, giveTakeBase);
        String id2 = giveTakeBase.getId();
        if (l10 || m10) {
            j0Var = new DiscoverSearchTakePurchaseRequest(price, 1, id2);
        } else {
            j0Var = new DiscoverLikesPurchaseRequest(price, 1, id2);
        }
        this.f18100d.buyCmbItem(j0Var, new b(mVar, cVar), true);
    }

    public void i(d.b bVar) {
        this.E.add(bVar);
    }

    public void j(String str) {
        List<GiveTakeBase> list;
        if (c()) {
            ListIterator<GiveTakeBase> listIterator = this.f18112t.listIterator();
            while (true) {
                if (listIterator.hasNext()) {
                    if (listIterator.next().getProfileId().equals(str)) {
                        listIterator.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!this.f18110p.isEmpty()) {
            list = this.f18110p;
        } else {
            list = this.f18108m;
        }
        Iterator<GiveTakeBase> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GiveTakeBase next = it.next();
            if (next.getProfileId().equals(str)) {
                if (next instanceof RisingGiveTake) {
                    ((t) w.A(new e(this, str)).K(this.H).g(com.uber.autodispose.a.a(this.f18106k))).c(new j(this));
                } else if (next instanceof GiveTake) {
                    ((t) w.A(new k(this, str)).K(this.H).g(com.uber.autodispose.a.a(this.f18106k))).c(new l(this));
                }
                it.remove();
            }
        }
        y0();
    }

    public void k(RisingGiveTake risingGiveTake, a.b bVar) {
        C0(risingGiveTake.getProfileId(), new f(risingGiveTake, bVar));
    }

    public boolean l(GiveTakeBase giveTakeBase) {
        if (!this.f18115y) {
            return false;
        }
        for (GiveTakeBase id2 : this.f18111q) {
            if (giveTakeBase.getId().equals(id2.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean m(GiveTakeBase giveTakeBase) {
        for (GiveTakeBase id2 : this.f18109n) {
            if (giveTakeBase.getId().equals(id2.getId())) {
                return true;
            }
        }
        return false;
    }

    public void markGiveTakeAsSeen(String str, a.b bVar) {
        if (i0(str)) {
            this.f18098b.markGiveTakeAsSeen(str, bVar);
        } else {
            bVar.a("", -1);
        }
    }

    public void markRisingGiveTakeAsSeen(String str, a.b bVar) {
        this.f18098b.markRisingGiveTakeAsSeen(str, bVar);
    }

    public List<GiveTakeBase> n() {
        ArrayList<GiveTakeBase> e02 = e0(this.f18108m);
        if (!this.f18116z && e02.size() != this.f18108m.size()) {
            this.f18116z = true;
            B0(new n(this));
        }
        return Collections.unmodifiableList(e02);
    }

    public void n0(EventType eventType, Bundle bundle) {
        boolean z10;
        if (eventType == EventType.SYNC_COMPLETE) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            ha.a.d(z10, "discover mgr messaged off UI thread");
            e();
        }
    }

    public void o(j jVar, d.a aVar) {
        this.C = jVar;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("filtering takes with=");
        sb2.append(jVar);
        this.f18098b.filterTakes(jVar, new d(aVar));
    }

    public List<GiveTakeBase> p() {
        if (this.f18110p.isEmpty()) {
            return n();
        }
        return this.f18110p;
    }

    public void q() {
        this.f18100d.refreshPricesFromApi(new c(new ArrayList(this.E)));
    }

    public void r() {
        if (!this.f18114x) {
            this.f18114x = true;
            this.f18098b.getBagelsInfiniteScroll(new e());
            return;
        }
        z0();
    }

    public List<GiveTakeBase> s() {
        return this.f18112t;
    }

    public void t(d.b bVar) {
        this.E.remove(bVar);
    }
}
