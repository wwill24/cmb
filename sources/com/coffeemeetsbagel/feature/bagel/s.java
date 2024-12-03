package com.coffeemeetsbagel.feature.bagel;

import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.feature.bagel.paging.BagelPagingMetaType;
import com.coffeemeetsbagel.feature.bagel.retry.payloads.BagelRetryPutActionPayload;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.BagelContract$RetryCallType;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.models.ActionOnBagelNetworkRequest;
import com.coffeemeetsbagel.match.models.MarkChatDeletedBody;
import com.coffeemeetsbagel.match.models.ReportBagelBody;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.match.w;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.LikeCommentStrings;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.RetryCall;
import com.coffeemeetsbagel.models.responses.ResponseBagel;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.jakewharton.rxrelay2.PublishRelay;
import com.uber.autodispose.t;
import j5.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ka.a;
import l8.h;
import qj.b0;
import qj.q;
import retrofit2.r;

public class s implements com.coffeemeetsbagel.match.j, a.C0498a, h.c {

    /* renamed from: a  reason: collision with root package name */
    private final k0 f12730a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final com.coffeemeetsbagel.match.l f12731b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ProfileContract$Manager f12732c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d7.c f12733d;

    /* renamed from: e  reason: collision with root package name */
    private final w f12734e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final f9.b f12735f;

    /* renamed from: g  reason: collision with root package name */
    private final hb.c f12736g;

    /* renamed from: h  reason: collision with root package name */
    private final PhotoRepository f12737h;

    /* renamed from: i  reason: collision with root package name */
    private final ProfileRepositoryV2 f12738i;

    /* renamed from: j  reason: collision with root package name */
    private final SaveProfilesLocalUseCase f12739j;

    /* renamed from: k  reason: collision with root package name */
    private final AuthenticationScopeProvider f12740k;

    /* renamed from: l  reason: collision with root package name */
    private List<Bagel> f12741l = null;

    /* renamed from: m  reason: collision with root package name */
    private long f12742m;

    /* renamed from: n  reason: collision with root package name */
    private final List<j.b> f12743n;

    /* renamed from: o  reason: collision with root package name */
    private final List<j.c> f12744o;

    /* renamed from: p  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<List<Bagel>> f12745p;

    /* renamed from: q  reason: collision with root package name */
    private final PublishRelay<Bagel> f12746q;

    /* renamed from: r  reason: collision with root package name */
    private List<Bagel> f12747r;

    /* renamed from: s  reason: collision with root package name */
    private final HashMap<String, Bagel> f12748s;

    /* renamed from: t  reason: collision with root package name */
    private Bagel f12749t;

    /* renamed from: u  reason: collision with root package name */
    private tj.b f12750u;

    /* renamed from: v  reason: collision with root package name */
    private final u f12751v;

    class a extends AsyncTask<Void, Void, List<f9.c<BagelRetryPutActionPayload>>> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<f9.c<BagelRetryPutActionPayload>> doInBackground(Void... voidArr) {
            return s.this.f12735f.a(BagelContract$RetryCallType.PUT_ACTION.a(), BagelRetryPutActionPayload.class);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(List<f9.c<BagelRetryPutActionPayload>> list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("going to retry ");
            sb2.append(list.size());
            sb2.append(" calls");
            for (f9.c next : list) {
                RetryCall b10 = next.b();
                BagelRetryPutActionPayload bagelRetryPutActionPayload = (BagelRetryPutActionPayload) next.a();
                s.this.J0(bagelRetryPutActionPayload.getId(), bagelRetryPutActionPayload.getAction(), new LikeCommentStrings(bagelRetryPutActionPayload.getCommentOnLike()), b10, (j.a) null);
            }
        }
    }

    class b implements retrofit2.d<ResponseBagel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12753a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j.a f12754b;

        b(String str, j.a aVar) {
            this.f12753a = str;
            this.f12754b = aVar;
        }

        public void onFailure(retrofit2.b<ResponseBagel> bVar, Throwable th2) {
            String str;
            if (th2 == null) {
                str = "Unknown exception fetching bagels.";
            } else {
                str = th2.getMessage();
            }
            this.f12754b.onError(str);
            fa.a.f("BagelManager", str);
        }

        public void onResponse(retrofit2.b<ResponseBagel> bVar, r<ResponseBagel> rVar) {
            if (!rVar.g() || rVar.a() == null) {
                this.f12754b.onError(rVar.h());
                return;
            }
            s.this.f12731b.i(this.f12753a, true);
            s.this.L0(this.f12753a);
            this.f12754b.a(rVar.a().getResult());
        }
    }

    class c implements retrofit2.d<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.coffeemeetsbagel.match.g f12757b;

        class a extends AsyncTask<Void, Void, Void> {
            a() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                s.this.f12731b.b(c.this.f12756a, true);
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void onPostExecute(Void voidR) {
                c cVar = c.this;
                s.this.L0(cVar.f12756a);
                c.this.f12757b.onSuccess();
            }
        }

        c(String str, com.coffeemeetsbagel.match.g gVar) {
            this.f12756a = str;
            this.f12757b = gVar;
        }

        public void onFailure(retrofit2.b<Object> bVar, Throwable th2) {
            String str;
            if (th2 == null) {
                str = "Unknown exception fetching bagels.";
            } else {
                str = th2.getMessage();
            }
            this.f12757b.a(str);
            fa.a.f("BagelManager", str);
        }

        public void onResponse(retrofit2.b<Object> bVar, r<Object> rVar) {
            if (rVar.g()) {
                new a().execute(new Void[0]);
                return;
            }
            fa.a.f("BagelManager", "Can't mark chat as deleted: " + rVar.h());
            fa.a.i(new IllegalStateException("Chat delete failure: " + rVar.h()));
            this.f12757b.a(rVar.h());
        }
    }

    class d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f12760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j.e f12761b;

        d(List list, j.e eVar) {
            this.f12760a = list;
            this.f12761b = eVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            s.this.O0(this.f12760a);
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            j.e eVar = this.f12761b;
            if (eVar != null) {
                eVar.a(true);
            }
        }
    }

    class e implements Predicate<Bagel> {
        e() {
        }

        /* renamed from: a */
        public boolean test(Bagel bagel) {
            return s.this.f12732c.j().getId().equals(bagel.getProfileId());
        }
    }

    class f implements com.coffeemeetsbagel.match.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j.a f12764a;

        f(j.a aVar) {
            this.f12764a = aVar;
        }

        public void a(Bagel bagel) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#push successfully got bagel=");
            sb2.append(bagel);
            if (s.this.f12732c.j() != null && s.this.f12732c.j().equals(bagel.getProfileId())) {
                fa.a.g("BagelManager", "bagel contains my profile", new IllegalArgumentException("bagel contains my profile"));
            }
            if (bagel.getLastUpdated() == null || bagel.getLastUpdated().isEmpty()) {
                String str = "Bagel " + bagel.getId() + "is missing last updated";
                fa.a.g("BagelManager", str, new IllegalArgumentException(str));
            }
            s.this.R0(bagel);
            if (TextUtils.isEmpty(bagel.getCoupleId()) || TextUtils.isEmpty(bagel.getDecouplingDate())) {
                fa.a.f("BagelManager", "#push notification: invalid bagel conn data=" + bagel);
                fa.a.i(new IllegalStateException("Invalid bagel connection details during notification after server fetch"));
            }
            this.f12764a.a(bagel);
        }

        public void b(boolean z10, String str) {
            fa.a.f("BagelManager", "#push http GET bagel failed: " + str);
            fa.a.i(new IllegalStateException("Could not fetch bagel from server during push with bagel id"));
            this.f12764a.onError(str);
        }
    }

    class g implements retrofit2.d<Bagel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.coffeemeetsbagel.match.f f12766a;

        g(com.coffeemeetsbagel.match.f fVar) {
            this.f12766a = fVar;
        }

        public void onFailure(retrofit2.b<Bagel> bVar, Throwable th2) {
            this.f12766a.b(true, th2.getMessage());
            fa.a.f("BagelManager", th2.getMessage());
        }

        public void onResponse(retrofit2.b<Bagel> bVar, r<Bagel> rVar) {
            if (rVar.g()) {
                this.f12766a.a(rVar.a());
                return;
            }
            this.f12766a.b(f9.d.c(rVar.b()), rVar.h());
        }
    }

    class h extends AsyncTask<Void, Void, List<Bagel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f12768a;

        h(Runnable runnable) {
            this.f12768a = runnable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<Bagel> doInBackground(Void... voidArr) {
            return s.this.p0();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(List<Bagel> list) {
            if (s.this.f12733d.isLoggedIn()) {
                List unused = s.this.S0(list);
                this.f12768a.run();
            }
        }
    }

    class i extends AsyncTask<Void, Void, List<Bagel>> {
        i() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<Bagel> doInBackground(Void... voidArr) {
            return s.this.p0();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(List<Bagel> list) {
            if (s.this.f12733d.isLoggedIn()) {
                List unused = s.this.S0(list);
                s.this.I0();
            }
        }
    }

    class j implements k0.b<ResponseBagel, Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.coffeemeetsbagel.match.k f12771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j.d f12772b;

        j(com.coffeemeetsbagel.match.k kVar, j.d dVar) {
            this.f12771a = kVar;
            this.f12772b = dVar;
        }

        public void a(Throwable th2) {
            this.f12772b.a(th2);
        }

        /* renamed from: c */
        public void b(ResponseBagel responseBagel) {
            this.f12771a.onSuccess(responseBagel);
        }
    }

    class k implements k0.b<ResponseBagel, Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.coffeemeetsbagel.match.k f12774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j.d f12775b;

        k(com.coffeemeetsbagel.match.k kVar, j.d dVar) {
            this.f12774a = kVar;
            this.f12775b = dVar;
        }

        public void a(Throwable th2) {
            this.f12775b.a(th2);
        }

        /* renamed from: c */
        public void b(ResponseBagel responseBagel) {
            Bagel result = responseBagel.getResult();
            if (result.getLastUpdated() == null || result.getLastUpdated().isEmpty()) {
                String str = "Bagel " + result.getId() + "is missing last updated";
                fa.a.g("BagelManager", str, new IllegalArgumentException(str));
            }
            s.this.R0(result);
            this.f12774a.onSuccess(responseBagel);
        }
    }

    class l extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bagel f12777a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j.a f12778b;

        l(Bagel bagel, j.a aVar) {
            this.f12777a = bagel;
            this.f12778b = aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            s.this.f12731b.g(this.f12777a.getId(), this.f12777a.getAction());
            if (TextUtils.isEmpty(this.f12777a.getLikeComment())) {
                return null;
            }
            s.this.f12731b.c(this.f12777a.getId(), this.f12777a.getLikeComment());
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            s.this.J0(this.f12777a.getId(), this.f12777a.getAction(), new LikeCommentStrings(this.f12777a.getLikeComment()), (RetryCall) null, this.f12778b);
        }
    }

    class m implements com.coffeemeetsbagel.match.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j.a f12780a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RetryCall f12781b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12782c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f12783d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LikeCommentStrings f12784e;

        m(j.a aVar, RetryCall retryCall, String str, int i10, LikeCommentStrings likeCommentStrings) {
            this.f12780a = aVar;
            this.f12781b = retryCall;
            this.f12782c = str;
            this.f12783d = i10;
            this.f12784e = likeCommentStrings;
        }

        public void a(Bagel bagel) {
            j.a aVar = this.f12780a;
            if (aVar != null) {
                aVar.a(bagel);
            }
        }

        public void b(boolean z10, String str) {
            fa.a.f("BagelManager", "Fail!! " + str);
            j.a aVar = this.f12780a;
            if (aVar != null) {
                aVar.onError(str);
            }
            if (z10) {
                RetryCall retryCall = this.f12781b;
                if (retryCall == null) {
                    BagelRetryPutActionPayload bagelRetryPutActionPayload = new BagelRetryPutActionPayload(this.f12782c, this.f12783d);
                    if (!TextUtils.isEmpty(this.f12784e.getComment())) {
                        bagelRetryPutActionPayload.setCommentOnLike(this.f12784e.getComment());
                    }
                    s.this.m0(bagelRetryPutActionPayload);
                    return;
                }
                s.this.K0(retryCall);
            }
        }
    }

    class n implements retrofit2.d<Bagel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.coffeemeetsbagel.match.f f12786a;

        n(com.coffeemeetsbagel.match.f fVar) {
            this.f12786a = fVar;
        }

        public void onFailure(retrofit2.b<Bagel> bVar, Throwable th2) {
            this.f12786a.b(true, th2.getMessage());
            fa.a.f("BagelManager", th2.getMessage());
        }

        public void onResponse(retrofit2.b<Bagel> bVar, r<Bagel> rVar) {
            if (rVar.g()) {
                this.f12786a.a(rVar.a());
                return;
            }
            this.f12786a.b(f9.d.c(rVar.b()), rVar.h());
        }
    }

    class o extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BagelRetryPutActionPayload f12788a;

        o(BagelRetryPutActionPayload bagelRetryPutActionPayload) {
            this.f12788a = bagelRetryPutActionPayload;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            s.this.f12735f.b(BagelContract$RetryCallType.PUT_ACTION.a(), this.f12788a);
            return null;
        }
    }

    class p extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RetryCall f12790a;

        p(RetryCall retryCall) {
            this.f12790a = retryCall;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            s.this.f12735f.c(this.f12790a);
            return null;
        }
    }

    public s(AuthenticationScopeProvider authenticationScopeProvider, PhotoRepository photoRepository, ProfileRepositoryV2 profileRepositoryV2, k0 k0Var, com.coffeemeetsbagel.match.l lVar, ProfileContract$Manager profileContract$Manager, d7.c cVar, w wVar, f9.b bVar, hb.c cVar2, ka.a aVar, SaveProfilesLocalUseCase saveProfilesLocalUseCase, u uVar) {
        this.f12735f = bVar;
        this.f12747r = new CopyOnWriteArrayList();
        this.f12748s = new HashMap<>();
        this.f12740k = authenticationScopeProvider;
        this.f12737h = photoRepository;
        this.f12738i = profileRepositoryV2;
        this.f12730a = k0Var;
        this.f12731b = lVar;
        this.f12732c = profileContract$Manager;
        this.f12733d = cVar;
        this.f12734e = wVar;
        this.f12736g = cVar2;
        this.f12739j = saveProfilesLocalUseCase;
        this.f12751v = uVar;
        this.f12743n = new CopyOnWriteArrayList();
        this.f12744o = new ArrayList();
        this.f12745p = com.jakewharton.rxrelay2.b.C0();
        this.f12746q = PublishRelay.C0();
        aVar.b(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(BagelPagingMetaType bagelPagingMetaType, String str, String str2, j.e eVar, String str3, List list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retrieved new pages, with prefix=");
        sb2.append(bagelPagingMetaType.l());
        sb2.append(" numBagels=");
        sb2.append(list.size());
        if (str3 != null) {
            bagelPagingMetaType.q(this.f12736g, str3);
        }
        Optional findFirst = list.stream().filter(new h()).findFirst();
        if (findFirst.isPresent()) {
            String str4 = "New bagels page has missing last updated - cursor before " + str + " current token " + str2 + " - bagel " + ((Bagel) findFirst.get()).getId();
            fa.a.g("BagelManager", str4, new IllegalArgumentException(str4));
        }
        N0(list, eVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean B0(Bagel bagel) {
        return bagel.getLastUpdated() == null || bagel.getLastUpdated().isEmpty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(BagelPagingMetaType bagelPagingMetaType, int i10, boolean z10, String str, String str2, j.e eVar, int i11, String str3, String str4, boolean z11, List list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retrieved previous pages, with prefix=");
        sb2.append(bagelPagingMetaType.l());
        sb2.append(" numBagels=");
        sb2.append(list.size());
        if (i11 > 0) {
            bagelPagingMetaType.p(this.f12736g, i10 + i11);
        }
        if (str4 != null) {
            bagelPagingMetaType.q(this.f12736g, str4);
        }
        if (!list.isEmpty()) {
            bagelPagingMetaType.r(this.f12736g, str3);
        }
        if (!z10) {
            bagelPagingMetaType.s(this.f12736g, z11);
        }
        Optional findFirst = list.stream().filter(new i()).findFirst();
        if (findFirst.isPresent()) {
            String str5 = "New bagels page has missing last updated - cursor before " + str + " current token " + str2 + " - bagel " + ((Bagel) findFirst.get()).getId();
            fa.a.g("BagelManager", str5, new IllegalArgumentException(str5));
        }
        N0(list, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean D0(Bagel bagel) throws Exception {
        this.f12731b.n(bagel);
        this.f12746q.accept(bagel);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 E0(Bagel bagel, List list) throws Exception {
        return qj.w.A(new f(this, bagel));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void F0(Bagel bagel, Boolean bool) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Inserted or updated to DB successfully bagel: ");
        sb2.append(bagel.getId());
        sb2.append(" - profile ");
        sb2.append(bagel.getProfile().getId());
    }

    private void H0() {
        for (j.c P : this.f12744o) {
            P.P();
        }
    }

    /* access modifiers changed from: private */
    public void I0() {
        for (j.b o02 : this.f12743n) {
            o02.o0();
        }
    }

    /* access modifiers changed from: private */
    public void J0(String str, int i10, LikeCommentStrings likeCommentStrings, RetryCall retryCall, j.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("putUserActionForBagel ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(i10);
        m mVar = new m(aVar, retryCall, str, i10, likeCommentStrings);
        this.f12751v.g(str, new ActionOnBagelNetworkRequest(i10, likeCommentStrings.getComment(), (String) null)).L(new n(mVar));
    }

    /* access modifiers changed from: private */
    public void K0(RetryCall retryCall) {
        new p(retryCall).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    public void L0(String str) {
        boolean z10;
        if (Looper.getMainLooper().getThread() == Looper.myLooper().getThread()) {
            z10 = true;
        } else {
            z10 = false;
        }
        ha.a.d(z10, "Updating connections cache must be on UI Thread");
        int i10 = 0;
        while (true) {
            if (i10 >= this.f12747r.size()) {
                i10 = -1;
                break;
            } else if (str.equals(this.f12747r.get(i10).getId())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            this.f12748s.remove(this.f12747r.remove(i10).getCoupleId());
        }
        List<Bagel> list = this.f12741l;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f12741l.size(); i11++) {
                Bagel bagel = this.f12741l.get(i11);
                if (!bagel.getId().equals(str)) {
                    arrayList.add(bagel);
                }
            }
            this.f12741l = arrayList;
        }
    }

    private static void M0(Bagel bagel, List<Bagel> list) {
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                i10 = -1;
                break;
            } else if (bagel.getCoupleId().equals(list.get(i10).getCoupleId())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            list.set(i10, bagel);
        }
    }

    private void N0(List<Bagel> list, j.e eVar) {
        if (!list.isEmpty()) {
            new d(list, eVar).execute(new Void[0]);
        } else if (eVar != null) {
            eVar.a(false);
        }
    }

    /* access modifiers changed from: private */
    public void O0(List<Bagel> list) {
        if (this.f12732c.j() != null && list.stream().filter(new e()).findFirst().isPresent()) {
            fa.a.g("BagelManager", "bagel list is containing my profile", new IllegalArgumentException("bagel list is containing my profile"));
        }
        ArrayList arrayList = new ArrayList();
        for (Bagel profile : list) {
            arrayList.add(profile.getProfile());
        }
        List j10 = this.f12739j.e(arrayList).j();
        this.f12731b.a(list);
    }

    /* access modifiers changed from: private */
    public boolean P0(Bagel bagel) {
        boolean z10 = !this.f12734e.a(bagel.getId());
        boolean z11 = !bagel.isActedUpon();
        boolean z12 = !bagel.isBlocked();
        boolean z13 = !bagel.isExpired();
        if (!z10 || !z11 || !z12 || !z13) {
            return false;
        }
        return true;
    }

    private void Q0() {
        if (System.currentTimeMillis() - this.f12742m >= DateUtils.MILLIS_IN_MINUTE) {
            this.f12742m = System.currentTimeMillis();
            new a().execute(new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    public void R0(Bagel bagel) {
        ((t) this.f12739j.e(Collections.singletonList(bagel.getProfile())).v(new b(this, bagel)).g(com.uber.autodispose.a.a(this.f12740k))).b(new c(bagel), new d(bagel));
    }

    /* access modifiers changed from: private */
    public List<Bagel> S0(List<Bagel> list) {
        if (list.size() != this.f12747r.size()) {
            this.f12747r.clear();
            this.f12748s.clear();
        }
        for (Bagel next : list) {
            if (next.isConnected()) {
                Bagel bagel = this.f12748s.get(next.getCoupleId());
                if (bagel == null) {
                    this.f12747r.add(next);
                    this.f12748s.put(next.getCoupleId(), next);
                } else if (q0(bagel, next)) {
                    M0(next, this.f12747r);
                    this.f12748s.put(next.getCoupleId(), next);
                }
            }
        }
        return this.f12747r;
    }

    /* access modifiers changed from: private */
    public void m0(BagelRetryPutActionPayload bagelRetryPutActionPayload) {
        new o(bagelRetryPutActionPayload).execute(new Void[0]);
    }

    private void n0(boolean z10) {
        this.f12747r.clear();
        this.f12748s.clear();
        if (z10) {
            H0();
        }
    }

    private void o0() {
        BagelPagingMetaType b10 = BagelPagingMetaType.b(false, false);
        BagelPagingMetaType b11 = BagelPagingMetaType.b(true, false);
        BagelPagingMetaType b12 = BagelPagingMetaType.b(false, true);
        BagelPagingMetaType b13 = BagelPagingMetaType.b(true, true);
        b10.a(this.f12736g);
        b11.a(this.f12736g);
        b12.a(this.f12736g);
        b13.a(this.f12736g);
    }

    /* access modifiers changed from: private */
    public List<Bagel> p0() {
        for (Bagel next : this.f12731b.h()) {
            Optional h10 = this.f12738i.j(next.getProfileId()).h();
            if (h10.isPresent()) {
                NetworkProfile a10 = com.coffeemeetsbagel.profile.o.f36130a.a((com.coffeemeetsbagel.profile.l) h10.get());
                a10.setPhotos((List) this.f12737h.f(next.getProfileId()).h().stream().map(new e()).collect(Collectors.toList()));
                next.setProfile(a10);
                Bagel bagel = this.f12748s.get(next.getCoupleId());
                if (next.isConnected()) {
                    if (bagel == null) {
                        this.f12747r.add(next);
                        this.f12748s.put(next.getCoupleId(), next);
                    } else if (q0(bagel, next)) {
                        M0(next, this.f12747r);
                        this.f12748s.put(next.getCoupleId(), next);
                    }
                }
            } else {
                String str = "failed to fetch profile from DB " + next.getProfileId();
                fa.a.g("BagelManager", str, new IllegalStateException(str));
            }
        }
        return this.f12747r;
    }

    private static boolean q0(Bagel bagel, Bagel bagel2) {
        int compareWithNullCheck = ComparisonUtils.compareWithNullCheck(bagel.getLastUpdated(), bagel2.getLastUpdated());
        if (compareWithNullCheck == 0) {
            return ComparisonUtils.isGreaterThanWithNullCheck(bagel2.getConnectionDetails(), bagel.getConnectionDetails());
        }
        if (compareWithNullCheck < 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ NetworkPhoto r0(Photo photo) {
        return new NetworkPhoto(photo.d(), photo.getUrl(), photo.c(), photo.e(), photo.a());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ NetworkPhoto s0(Photo photo) {
        return new NetworkPhoto(photo.d(), photo.getUrl(), photo.c(), photo.e(), photo.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(List list) throws Exception {
        List<Bagel> list2 = (List) list.stream().filter(new k(this)).collect(Collectors.toList());
        this.f12741l = list2;
        this.f12745p.accept(list2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List v0() throws Exception {
        return this.f12731b.j(System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 y0(List list) throws Exception {
        return this.f12738i.r((List) list.stream().map(new q()).collect(Collectors.toList())).L().D(new r(list));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean z0(Bagel bagel) {
        return bagel.getLastUpdated() == null || bagel.getLastUpdated().isEmpty();
    }

    public List<Bagel> A() {
        if (CollectionUtils.isEmpty((List) this.f12747r) && this.f12733d.isLoggedIn()) {
            this.f12747r = p0();
        }
        return this.f12747r;
    }

    public void B(j.c cVar) {
        this.f12744o.remove(cVar);
    }

    public void C() {
    }

    public Bagel D(String str) {
        return this.f12748s.get(str);
    }

    public void E(boolean z10, boolean z11, j.e eVar) {
        BagelPagingMetaType b10 = BagelPagingMetaType.b(z10, z11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retrieving new pages, with prefix=");
        sb2.append(b10.l());
        String i10 = b10.i(this.f12736g);
        String e10 = b10.e(this.f12736g);
        new g7.b(z10, z11, i10, e10, this.f12751v, new a(this, b10, i10, e10, eVar)).f();
    }

    public void F(j.b bVar) {
        if (this.f12743n.contains(bVar)) {
            this.f12743n.remove(bVar);
        }
    }

    public com.jakewharton.rxrelay2.b<x> G() {
        return this.f12731b.k();
    }

    public Boolean H() {
        boolean z10;
        if (this.f12749t == null) {
            n();
        }
        Bagel bagel = this.f12749t;
        if (bagel == null || bagel.isExpired() || !this.f12749t.isActedUpon()) {
            z10 = false;
        } else {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    public q<Bagel> a() {
        return this.f12746q.P();
    }

    public void b(j.a aVar, Bagel bagel, Object obj) {
        if (bagel.getAction() == 1 || bagel.getAction() == 2) {
            this.f12734e.b(bagel.getId());
        }
        new l(bagel, aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void c() {
    }

    public void clear() {
        List<Bagel> list = this.f12741l;
        if (list != null) {
            list.clear();
            this.f12741l = null;
        }
        this.f12747r.clear();
        this.f12748s.clear();
        this.f12744o.clear();
        this.f12749t = null;
    }

    public void d(String str, j.a aVar) {
        this.f12751v.b(str, "profile").L(new g(new f(aVar)));
    }

    public q<List<Bagel>> e() {
        return this.f12745p.s().P();
    }

    public void f() {
        o0();
    }

    public void g(String str, com.coffeemeetsbagel.match.g gVar) {
        this.f12751v.h(str, new MarkChatDeletedBody(Boolean.TRUE)).L(new c(str, gVar));
    }

    public void h(long j10, com.coffeemeetsbagel.match.k<ResponseBagel> kVar, j.d dVar) {
        this.f12730a.buyCmbItem(PurchaseType.BONUS_BAGEL, j10, 1, new j(kVar, dVar), ResponseBagel.class, (String) null, (String) null);
    }

    public void i(Runnable runnable) {
        new h(runnable).execute(new Void[0]);
    }

    public void j(int i10, String str, com.coffeemeetsbagel.match.k<ResponseBagel> kVar, j.d dVar) {
        this.f12730a.buyCmbItem(PurchaseType.REOPEN_CHAT, (long) i10, 1, new k(kVar, dVar), ResponseBagel.class, str, (String) null);
    }

    public Bagel k(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BagelManager bagelId=");
        sb2.append(str);
        Bagel o10 = this.f12731b.o(str);
        if (o10 != null) {
            Optional h10 = this.f12738i.j(o10.getProfileId()).h();
            if (h10.isPresent()) {
                NetworkProfile a10 = com.coffeemeetsbagel.profile.o.f36130a.a((com.coffeemeetsbagel.profile.l) h10.get());
                a10.setPhotos((List) this.f12737h.f(o10.getProfileId()).h().stream().map(new j()).collect(Collectors.toList()));
                o10.setProfile(a10);
            } else {
                String str2 = "failed to read profile from DB " + o10.getProfileId();
                fa.a.g("BagelManager", str2, new IllegalStateException(str2));
            }
        } else {
            fa.a.g("BagelManager", "failed to read current bagel from DB ", new IllegalStateException("failed to read current bagel from DB "));
        }
        return o10;
    }

    public void l(Bagel bagel, Bagel bagel2) {
        bagel.setDecouplingDate(bagel2.getDecouplingDate());
        bagel.setCoupleId(bagel2.getCoupleId());
        this.f12731b.d(bagel.getId(), String.valueOf(DateUtils.getMillisFromUtc(bagel2.getDecouplingDate())));
        this.f12731b.e(bagel.getId(), bagel2.getCoupleId());
    }

    public Boolean m() {
        boolean z10;
        if (this.f12749t == null) {
            n();
        }
        if (this.f12749t != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public void n() {
        this.f12749t = this.f12731b.l();
    }

    public void o(j.c cVar) {
        if (!this.f12744o.contains(cVar)) {
            this.f12744o.add(cVar);
        }
    }

    public void p(boolean z10) {
        List list;
        List<Bagel> list2 = this.f12741l;
        if (list2 != null) {
            list = (List) list2.stream().filter(new k(this)).collect(Collectors.toList());
        } else {
            list = Collections.emptyList();
        }
        if (z10 || list.isEmpty()) {
            tj.b bVar = this.f12750u;
            if (bVar != null && !bVar.c()) {
                this.f12750u.dispose();
            }
            this.f12750u = qj.w.A(new l(this)).K(dk.a.c()).v(new m(this)).b(new n(this), new o());
        } else {
            this.f12745p.accept(list);
        }
        Q0();
    }

    public void q(String str, String str2, String str3, j.a aVar) {
        this.f12751v.d(str, new ReportBagelBody(Boolean.TRUE, str2, str3)).L(new b(str, aVar));
    }

    public void r(j.b bVar) {
        if (!this.f12743n.contains(bVar)) {
            this.f12743n.add(bVar);
        }
    }

    public void s() {
        new i().execute(new Void[0]);
    }

    public void t(boolean z10, boolean z11, int i10, j.e eVar) {
        boolean z12;
        if (i10 == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        boolean z13 = z12;
        BagelPagingMetaType b10 = BagelPagingMetaType.b(z10, z11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retrieving previous pages, with prefix=");
        sb2.append(b10.l());
        int c10 = b10.c(this.f12736g);
        String i11 = b10.i(this.f12736g);
        String e10 = b10.e(this.f12736g);
        boolean o10 = b10.o(this.f12736g);
        u uVar = this.f12751v;
        new g7.c(z13, i10, i11, e10, o10, z10, z11, uVar, new p(this, b10, c10, z10, i11, e10, eVar)).f();
    }

    public void u(Bagel bagel) {
        if (this.f12741l != null) {
            for (int i10 = 0; i10 < this.f12741l.size(); i10++) {
                if (this.f12741l.get(i10).getId().equals(bagel.getId())) {
                    this.f12741l.set(i10, bagel);
                }
            }
        }
    }

    public void v() {
        n0(true);
    }

    public void w() {
        p(false);
    }

    public boolean x() {
        return !CollectionUtils.isEmpty((List) this.f12747r);
    }

    public void y(boolean z10, j.e eVar) {
        g7.a aVar = new g7.a(2, eVar);
        E(z10, false, aVar);
        E(z10, true, aVar);
    }

    public void z(ConnectionDetails connectionDetails, Bagel bagel) {
        if (TextUtils.isEmpty(bagel.getId()) || TextUtils.isEmpty(bagel.getCoupleId())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateConnDetails id=");
            sb2.append(bagel.getId());
            sb2.append(" cid=");
            sb2.append(bagel.getCoupleId());
            fa.a.i(new IllegalStateException("updateConnDetails missing data"));
            return;
        }
        connectionDetails.setProfileId(bagel.getProfileId());
        if (TextUtils.isEmpty(connectionDetails.getLastSenderProfileId()) && bagel.getConnectionDetails() != null && !TextUtils.isEmpty(bagel.getConnectionDetails().getLastSenderProfileId())) {
            connectionDetails.setLastSenderProfileId(bagel.getConnectionDetails().getLastSenderProfileId());
        }
        bagel.setConnectionDetails(connectionDetails);
        Bagel bagel2 = this.f12748s.get(bagel.getCoupleId());
        if (TextUtils.isEmpty(bagel.getRosterGroup()) && bagel2 != null && !TextUtils.isEmpty(bagel2.getRosterGroup())) {
            bagel.setRosterGroup(bagel2.getRosterGroup());
        }
        if (bagel2 == null) {
            this.f12748s.put(bagel.getCoupleId(), bagel);
            this.f12747r.add(bagel);
        } else if (q0(bagel2, bagel)) {
            this.f12748s.put(bagel.getCoupleId(), bagel);
            M0(bagel, this.f12747r);
        }
    }
}
