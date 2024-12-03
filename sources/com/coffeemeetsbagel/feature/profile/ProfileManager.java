package com.coffeemeetsbagel.feature.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b6.w;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.daos.i0;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.profile.GetMyOwnProfileTmpUseCase;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveMyProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.GetTextAnswersUseCase;
import com.coffeemeetsbagel.services.ProfileUpdateJobIntentService;
import com.coffeemeetsbagel.transport.OperationResultReceiver;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.uber.autodispose.n;
import com.uber.autodispose.t;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.g;
import okhttp3.v;
import okhttp3.z;
import qj.b0;
import qj.q;
import retrofit2.r;
import v8.e;
import v8.h;
import v8.i;
import v8.k;
import v8.l;
import v8.m;
import v8.o;
import v8.p;
import v8.s;
import v8.u;
import z9.f;
import z9.j;

public class ProfileManager extends w implements f, ProfileContract$Manager {
    private final PublishSubject<androidx.core.util.d<Boolean, Integer>> B = PublishSubject.C0();
    private final GetMyOwnProfileTmpUseCase C;
    private final SaveProfilesLocalUseCase D;
    private final SaveMyProfileLocalUseCase E;
    private final r0 F;
    private final AuthenticationScopeProvider G;
    private NetworkProfile H;

    /* renamed from: d  reason: collision with root package name */
    private final Context f13141d;

    /* renamed from: e  reason: collision with root package name */
    private final y7.a f13142e;

    /* renamed from: f  reason: collision with root package name */
    private final d7.c f13143f;

    /* renamed from: g  reason: collision with root package name */
    private final t7.a f13144g;

    /* renamed from: h  reason: collision with root package name */
    private final hb.c f13145h;

    /* renamed from: j  reason: collision with root package name */
    private final e7.c f13146j;

    /* renamed from: k  reason: collision with root package name */
    private final UserRepository f13147k;

    /* renamed from: l  reason: collision with root package name */
    private final GetTextAnswersUseCase f13148l;

    /* renamed from: m  reason: collision with root package name */
    private final l5.c f13149m;

    /* renamed from: n  reason: collision with root package name */
    private final g f13150n;

    /* renamed from: p  reason: collision with root package name */
    private final PhotoRepository f13151p;

    /* renamed from: q  reason: collision with root package name */
    private final RefreshMyProfileUseCase f13152q;

    /* renamed from: t  reason: collision with root package name */
    private final PublishSubject<x> f13153t = PublishSubject.C0();

    /* renamed from: w  reason: collision with root package name */
    private final PublishSubject<x> f13154w = PublishSubject.C0();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final io.reactivex.subjects.a<ProfileStatus> f13155x = io.reactivex.subjects.a.C0();

    /* renamed from: y  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<Integer> f13156y = com.jakewharton.rxrelay2.b.C0();

    /* renamed from: z  reason: collision with root package name */
    private final List<j> f13157z = new ArrayList();

    public enum ProfileStatus {
        ACTIVE,
        DEACTIVATED
    }

    class a implements jc.b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    class b implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.b f13162a;

        class a implements jc.b<Void> {
            a() {
            }

            public void b(CmbErrorCode cmbErrorCode) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("errorCode=");
                sb2.append(cmbErrorCode);
            }

            /* renamed from: c */
            public void a(Void voidR, SuccessStatus successStatus) {
                ProfileManager.this.f13155x.d(ProfileStatus.ACTIVE);
            }
        }

        b(jc.b bVar) {
            this.f13162a = bVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f13162a.b(cmbErrorCode);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            ProfileManager.this.v0(false);
            ProfileManager.this.A0((String) null);
            jc.b bVar = this.f13162a;
            if (bVar != null) {
                bVar.a(voidR, successStatus);
            }
            ProfileManager.this.s0();
            Bakery.w().z().c("On Hold By User", "false");
            Bakery.w().D().b(new a(), false);
        }
    }

    class c implements qj.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EventType f13165a;

        c(EventType eventType) {
            this.f13165a = eventType;
        }

        public void a(tj.b bVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f13165a);
            sb2.append(" sent, refreshing cache.");
        }

        public void onComplete() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cache refresh complete after ");
            sb2.append(this.f13165a);
        }

        public void onError(Throwable th2) {
            fa.a.g("ProfileManager", "Failed cache refresh after " + this.f13165a, th2);
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13167a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f13168b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13168b = r0
                r1 = 1
                com.coffeemeetsbagel.models.enums.EventType r2 = com.coffeemeetsbagel.models.enums.EventType.BEANS_UPDATED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f13168b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r3 = com.coffeemeetsbagel.models.enums.EventType.SYNC_COMPLETE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.coffeemeetsbagel.feature.profile.ProfileContract$Manager$NotificationSettingsType[] r2 = com.coffeemeetsbagel.feature.profile.ProfileContract$Manager.NotificationSettingsType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f13167a = r2
                com.coffeemeetsbagel.feature.profile.ProfileContract$Manager$NotificationSettingsType r3 = com.coffeemeetsbagel.feature.profile.ProfileContract$Manager.NotificationSettingsType.DAILY_NOON_ALERT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f13167a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.coffeemeetsbagel.feature.profile.ProfileContract$Manager$NotificationSettingsType r2 = com.coffeemeetsbagel.feature.profile.ProfileContract$Manager.NotificationSettingsType.CHAT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f13167a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.coffeemeetsbagel.feature.profile.ProfileContract$Manager$NotificationSettingsType r1 = com.coffeemeetsbagel.feature.profile.ProfileContract$Manager.NotificationSettingsType.CUSTOMER_SERVICE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f13167a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.coffeemeetsbagel.feature.profile.ProfileContract$Manager$NotificationSettingsType r1 = com.coffeemeetsbagel.feature.profile.ProfileContract$Manager.NotificationSettingsType.VIDEO     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f13167a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.coffeemeetsbagel.feature.profile.ProfileContract$Manager$NotificationSettingsType r1 = com.coffeemeetsbagel.feature.profile.ProfileContract$Manager.NotificationSettingsType.NEW_LIKES     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.profile.ProfileManager.d.<clinit>():void");
        }
    }

    public ProfileManager(AuthenticationScopeProvider authenticationScopeProvider, y7.a aVar, d7.c cVar, t7.a aVar2, hb.c cVar2, e7.c cVar3, Context context, g gVar, UserRepository userRepository, PhotoRepository photoRepository, l5.c cVar4, GetTextAnswersUseCase getTextAnswersUseCase, GetMyOwnProfileTmpUseCase getMyOwnProfileTmpUseCase, SaveProfilesLocalUseCase saveProfilesLocalUseCase, SaveMyProfileLocalUseCase saveMyProfileLocalUseCase, RefreshMyProfileUseCase refreshMyProfileUseCase, r0 r0Var) {
        this.G = authenticationScopeProvider;
        this.f13142e = aVar;
        this.f13143f = cVar;
        this.f13144g = aVar2;
        this.f13141d = context;
        this.f13145h = cVar2;
        this.f13146j = cVar3;
        this.f13150n = gVar;
        this.f13147k = userRepository;
        this.f13151p = photoRepository;
        this.f13149m = cVar4;
        this.f13148l = getTextAnswersUseCase;
        this.C = getMyOwnProfileTmpUseCase;
        this.D = saveProfilesLocalUseCase;
        this.E = saveMyProfileLocalUseCase;
        this.f13152q = refreshMyProfileUseCase;
        this.F = r0Var;
        aVar.c(this, EventType.SYNC_COMPLETE, EventType.BEANS_UPDATED);
    }

    /* access modifiers changed from: private */
    public void A0(String str) {
        this.H.setReactivateDate(str);
    }

    private String V() {
        return this.f13145h.r("SELF_USER_PROFILE_ID");
    }

    private void W(Bundle bundle, v8.a aVar) {
        bundle.putBoolean("succeeded", false);
        if (aVar != null) {
            aVar.a(bundle);
        }
        this.f13142e.b(EventType.BEANS_UPDATED, bundle);
        this.B.d(new androidx.core.util.d(Boolean.FALSE, 0));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void X() throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(int i10, int i11, Integer num) throws Exception {
        if (num.intValue() <= -1) {
            fa.a.g("ProfileManager", "Failed to update user in local-db", new IllegalStateException("Failed to update user in local-db"));
            this.H.setBadgeCount(i10);
            this.f13146j.b(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(int i10, int i11, Throwable th2) throws Exception {
        fa.a.g("ProfileManager", "failed to update local db", th2);
        this.H.setBadgeCount(i10);
        this.f13146j.b(i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b0(ProfileContract$Manager.a aVar, ResponseGeneric responseGeneric) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("response=");
        sb2.append(responseGeneric);
        aVar.onSuccess(responseGeneric);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(Bundle bundle, v8.a aVar, ja.b bVar) throws Exception {
        NetworkProfile networkProfile = this.H;
        if (networkProfile != null) {
            networkProfile.setBeans(bVar.f());
        }
        bundle.putBoolean("succeeded", true);
        if (aVar != null) {
            aVar.a(bundle);
        }
        this.f13142e.b(EventType.BEANS_UPDATED, bundle);
        this.B.d(new androidx.core.util.d(Boolean.TRUE, Integer.valueOf(bundle.getInt(Extra.BEANS_EARNED, 0))));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(Bundle bundle, v8.a aVar, Throwable th2) throws Exception {
        fa.a.g("ProfileManager", "", th2);
        W(bundle, aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(Optional optional) throws Exception {
        if (!i0.a(optional)) {
            NetworkProfile networkProfile = (NetworkProfile) optional.get();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("got user profile: ");
            sb2.append(networkProfile.getId());
            z0(networkProfile);
            y0();
            return;
        }
        String profileId = this.f13143f.getProfileId();
        z0((NetworkProfile) null);
        throw new IllegalArgumentException("user not found in db: " + profileId);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g0(Throwable th2) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ b0 h0(NetworkProfile networkProfile) throws Exception {
        for (int i10 = 0; i10 < networkProfile.getPhotos().size(); i10++) {
            networkProfile.getPhotos().get(i10).setIdProfile(networkProfile.getId());
        }
        return qj.w.C(networkProfile);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 i0(NetworkProfile networkProfile, List list) throws Exception {
        return this.E.c(networkProfile);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void j0(List list) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(NetworkProfile networkProfile) throws Exception {
        z0(networkProfile);
        ((t) this.D.e(Collections.singletonList(networkProfile)).v(new h(this, networkProfile)).g(com.uber.autodispose.a.a(this.G))).c(new i());
        this.f13153t.d(x.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(List list) throws Exception {
        this.f13156y.accept(Integer.valueOf(list.size()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(Throwable th2) throws Exception {
        fa.a.g("ProfileManager", "failed to get answered questioned", th2);
        this.f13156y.accept(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(ja.b bVar) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("user DB table update, current user profile is ");
        sb2.append(this.H);
        NetworkProfile networkProfile = this.H;
        if (networkProfile != null) {
            networkProfile.setEligibleForFreeTrial(bVar.A());
            this.H.setAppsFlyerId(bVar.d());
            this.H.setBeans(bVar.f());
        }
        ((n) this.f13148l.b(QuestionGroupType.PROMPTS, bVar.u(), false).g(com.uber.autodispose.a.a(this))).b(new v8.j(this), new k(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ com.coffeemeetsbagel.utils.model.Optional q0(r rVar) throws Exception {
        String str;
        if (rVar.g()) {
            return com.coffeemeetsbagel.utils.model.Optional.e(new ResponseGeneric(rVar.b()));
        }
        if (rVar.e() != null) {
            str = rVar.e().string();
        } else {
            str = "";
        }
        return com.coffeemeetsbagel.utils.model.Optional.e(new ResponseGeneric(rVar.b(), str, rVar.b()));
    }

    private qj.a u0() {
        if (!this.f13143f.isLoggedIn() || !this.f13145h.p("HAS_SYNCED")) {
            return qj.a.m();
        }
        return this.C.f().L().r(new e(this)).B();
    }

    private void y0() {
        if (this.H != null) {
            NetworkProfile.NotificationSettings notificationSettings = new NetworkProfile.NotificationSettings();
            notificationSettings.dailyPush = this.f13145h.n("KEY_NOTIFICATION_SETTING_DAILY_PUSH", true);
            notificationSettings.chatPush = this.f13145h.n("KEY_NOTIFICATION_SETTING_CHAT", true);
            notificationSettings.customersPush = this.f13145h.n("KEY_NOTIFICATION_SETTING_CUSTOMER_SERVICE", true);
            notificationSettings.videoPush = this.f13145h.n("KEY_NOTIFICATION_SETTING_VIDEO", true);
            notificationSettings.newLikesPush = this.f13145h.n("KEY_NOTIFICATION_SETTING_NEW_LIKES", true);
            this.H.setNotificationSettings(notificationSettings);
        }
    }

    public ResponseGeneric B0(String str, boolean z10) {
        return (ResponseGeneric) ((com.coffeemeetsbagel.utils.model.Optional) this.f13150n.b(z.d(v.g("application/json"), str)).D(new m()).G(new o()).j()).g();
    }

    public q<androidx.core.util.d<Boolean, Integer>> T() {
        return this.B.P();
    }

    public void U(ProfileContract$Manager.a<ResponseGeneric> aVar, Integer num, String str) {
        int i10;
        g gVar = this.f13150n;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.intValue();
        }
        l lVar = new l(aVar);
        Objects.requireNonNull(aVar);
        ((t) gVar.d(i10, str).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(lVar, new v8.n(aVar));
    }

    public void a() {
        NetworkProfile networkProfile = this.H;
        if (networkProfile != null) {
            int badgeCount = networkProfile.getBadgeCount();
            this.H.setBadgeCount(0);
            int count = this.f13146j.getCount();
            this.f13146j.a();
            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
            modelProfileUpdateDelta.clearBadgeCount();
            modelProfileUpdateDelta.updateId(V());
            ((t) this.F.a(modelProfileUpdateDelta, this.H).g(com.uber.autodispose.a.a(this.G))).b(new v8.r(this, badgeCount, count), new s(this, badgeCount, count));
            return;
        }
        fa.a.g("ProfileManager", "Couldn't clear badge because in-memory cache is null", new IllegalStateException("Couldn't clear badge because in-memory cache is null"));
    }

    public boolean b() {
        NetworkProfile networkProfile = this.H;
        if (networkProfile == null || !networkProfile.isOver80()) {
            return true;
        }
        return this.f13145h.x();
    }

    public void c(NetworkPhoto networkPhoto) {
        NetworkProfile networkProfile = this.H;
        if (networkProfile != null) {
            ((com.uber.autodispose.m) this.f13151p.j(networkProfile.addReplacePhoto(networkPhoto), networkPhoto).j(com.uber.autodispose.a.a(this))).f(new v8.f(), new v8.g());
        }
    }

    public void clear() {
        z0((NetworkProfile) null);
        v();
    }

    public void d(jc.b<Void> bVar) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateOnHold(false);
        p(new b(bVar), modelProfileUpdateDelta, false);
    }

    public void e(Bundle bundle, v8.a aVar) {
        ((t) this.f13152q.h().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new v8.c(this, bundle, aVar), new v8.d(this, bundle, aVar));
    }

    public void f() {
        ((t) this.f13150n.getProfile().v(new v8.t()).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new u(this), new v8.v());
    }

    public void g(ProfileContract$Manager.NotificationSettingsType notificationSettingsType, boolean z10) {
        NetworkProfile networkProfile = this.H;
        if (networkProfile == null || networkProfile.getNotificationSettings() == null) {
            fa.a.f("CMB", "Unexpected null when updating notification settings.");
            return;
        }
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        int i10 = d.f13167a[notificationSettingsType.ordinal()];
        if (i10 == 1) {
            this.H.getNotificationSettings().dailyPush = z10;
            this.f13145h.f("KEY_NOTIFICATION_SETTING_DAILY_PUSH", z10);
            modelProfileUpdateDelta.updateDailyNoonAlertPushEnabled(z10);
        } else if (i10 == 2) {
            this.H.getNotificationSettings().chatPush = z10;
            this.f13145h.f("KEY_NOTIFICATION_SETTING_CHAT", z10);
            modelProfileUpdateDelta.updateChatPushEnabled(z10);
        } else if (i10 == 3) {
            this.H.getNotificationSettings().customersPush = z10;
            this.f13145h.f("KEY_NOTIFICATION_SETTING_CUSTOMER_SERVICE", z10);
            modelProfileUpdateDelta.updateCustomerServicePushEnabled(z10);
        } else if (i10 == 4) {
            this.H.getNotificationSettings().videoPush = z10;
            this.f13145h.f("KEY_NOTIFICATION_SETTING_VIDEO", z10);
            modelProfileUpdateDelta.updateVideoPushEnabled(z10);
        } else if (i10 == 5) {
            this.H.getNotificationSettings().newLikesPush = z10;
            this.f13145h.f("KEY_NOTIFICATION_SETTING_NEW_LIKES", z10);
            modelProfileUpdateDelta.updateNewLikesPushEnabled(z10);
        }
        p(new a(), modelProfileUpdateDelta, true);
    }

    public boolean h() {
        int i10;
        NetworkProfile j10 = j();
        if (j10 == null) {
            return false;
        }
        if (this.f13156y.F0()) {
            i10 = this.f13156y.E0().intValue();
        } else {
            i10 = 0;
        }
        if (!j10.isMissingDetailedInfo() || i10 >= 3) {
            return false;
        }
        return true;
    }

    public q<ProfileStatus> i() {
        return this.f13155x.s().P();
    }

    public NetworkProfile j() {
        if (!this.f13143f.isLoggedIn()) {
            return null;
        }
        if (this.H == null) {
            u0().B(new v8.b()).k();
        }
        return this.H;
    }

    public void k(j jVar) {
        for (j jVar2 : this.f13157z) {
            if (jVar2 == jVar) {
                return;
            }
        }
        this.f13157z.add(jVar);
    }

    public void l(j jVar) {
        this.f13157z.remove(jVar);
    }

    public q<x> m() {
        return this.f13153t.P();
    }

    public q<x> n() {
        return this.f13154w.P();
    }

    public void n0(EventType eventType, Bundle bundle) {
        int i10 = d.f13168b[eventType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            ((com.uber.autodispose.m) u0().F(dk.a.c()).j(com.uber.autodispose.a.a(this))).e(new c(eventType));
        }
    }

    public String o(Context context, NetworkProfile networkProfile) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtils.isEmpty((List) networkProfile.getListSchools())) {
            arrayList.add(networkProfile.getListSchools().get(0));
        }
        return StringUtils.join(arrayList, context.getResources().getString(R.string.new_line));
    }

    public void p(jc.b<Void> bVar, ModelProfileUpdateDelta modelProfileUpdateDelta, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("delta=");
        sb2.append(modelProfileUpdateDelta);
        sb2.append(", shouldAddToRequestQueue=");
        sb2.append(z10);
        Intent intent = new Intent();
        intent.setClass(this.f13141d, ProfileUpdateJobIntentService.class);
        String V = V();
        modelProfileUpdateDelta.updateId(V);
        intent.putExtra("ResultReceiver", new OperationResultReceiver(bVar));
        intent.putExtra("JSON_STRING_DATA", modelProfileUpdateDelta.flush());
        intent.putExtra(Extra.PROFILE_ID, V);
        intent.putExtra(Extra.SHOULD_ADD_TO_REQUEST_QUEUE, z10);
        ProfileUpdateJobIntentService.c(this.f13141d, intent);
    }

    public boolean q(NetworkProfile networkProfile) {
        if (networkProfile == null) {
            return false;
        }
        long currentTimestamp = DateUtils.getCurrentTimestamp();
        String registeredDate = networkProfile.getRegisteredDate();
        if (registeredDate == null) {
            fa.a.i(new IllegalArgumentException("Registered day is null"));
            return false;
        } else if (currentTimestamp - DateUtils.getMillisFromUtc(registeredDate).longValue() < 86400000) {
            return true;
        } else {
            return false;
        }
    }

    public void s0() {
        for (j t10 : this.f13157z) {
            t10.t();
        }
    }

    public void start() {
        super.start();
        ((n) this.f13147k.p().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new p(this), new v8.q());
    }

    public void t0(int i10, v8.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(Extra.BEANS_EARNED, i10);
        e(bundle, aVar);
    }

    public void v0(boolean z10) {
        this.H.setOnHold(z10);
        this.f13155x.d(ProfileStatus.DEACTIVATED);
    }

    public void w0(String str) {
        this.H.setOnHoldReasonManual(str);
    }

    /* access modifiers changed from: package-private */
    public void z0(NetworkProfile networkProfile) {
        ProfileStatus profileStatus;
        this.H = networkProfile;
        if (networkProfile != null) {
            if (networkProfile.isOnHold()) {
                profileStatus = ProfileStatus.DEACTIVATED;
            } else {
                profileStatus = ProfileStatus.ACTIVE;
            }
            this.f13155x.d(profileStatus);
        }
    }
}
