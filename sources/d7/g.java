package d7;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.coffeemeetsbagel.activities.ActivityLogin;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.ManagerNotifications;
import com.coffeemeetsbagel.bakery.i1;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.exception.CmbSpecialException;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.UpgradeAvailability;
import com.coffeemeetsbagel.models.responses.ResponseLogin;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.login.LoginManager;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import d7.a;
import d7.c;
import h5.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lc.e;
import okhttp3.l;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import siftscience.android.Sift;

public class g implements c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final hb.c f14473a;

    /* renamed from: b  reason: collision with root package name */
    private final a f14474b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b7.c f14475c;

    /* renamed from: d  reason: collision with root package name */
    private final l f14476d;

    /* renamed from: e  reason: collision with root package name */
    private final CmbDatabase f14477e;

    /* renamed from: f  reason: collision with root package name */
    private final r f14478f;

    /* renamed from: g  reason: collision with root package name */
    private final List<com.coffeemeetsbagel.feature.logout.a> f14479g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AuthenticationScopeProvider f14480h;

    /* renamed from: i  reason: collision with root package name */
    private String f14481i;

    /* renamed from: j  reason: collision with root package name */
    private l f14482j = y();

    /* renamed from: k  reason: collision with root package name */
    private String f14483k;

    /* renamed from: l  reason: collision with root package name */
    private b f14484l;

    class a implements a.C0153a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.a f14485a;

        a(c.a aVar) {
            this.f14485a = aVar;
        }

        public void a(int i10) {
            if (i1.e(i10)) {
                this.f14485a.a(new CmbErrorCode(3));
            } else {
                this.f14485a.a(new CmbErrorCode(0));
            }
        }

        public void b(String str) {
            g.this.D(str);
            g.this.C(this.f14485a);
        }
    }

    class b implements a.C0153a {
        b() {
        }

        public void a(int i10) {
        }

        public void b(String str) {
            g.this.D(str);
        }
    }

    class c implements jc.b<ResponseLogin> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.a f14488a;

        c(c.a aVar) {
            this.f14488a = aVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            g.this.E((String) null);
            this.f14488a.a(cmbErrorCode);
        }

        /* renamed from: c */
        public void a(ResponseLogin responseLogin, SuccessStatus successStatus) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#login responseLogin=");
            sb2.append(responseLogin);
            sb2.append(", status=");
            sb2.append(successStatus);
            g.this.f14480h.a();
            UpgradeAvailability upgradeAvailable = responseLogin.getUpgradeAvailable();
            String profileId = responseLogin.getProfileId();
            String r10 = g.this.f14473a.r("SELF_USER_PROFILE_ID");
            if (r10 == null || r10.equals(profileId)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Profile ID looks good, checking upgrade availability ... ");
                sb3.append(upgradeAvailable);
                if (!TextUtils.isEmpty(profileId)) {
                    fa.a.l(profileId);
                    g.this.F(profileId);
                } else {
                    fa.a.i(new CmbSpecialException("status=" + responseLogin.getStatusCode() + " but no profile ID in response"));
                }
                g.this.E(profileId);
                g.this.f14475c.b();
                this.f14488a.b(upgradeAvailable, profileId);
                return;
            }
            g.this.E((String) null);
            this.f14488a.a(new CmbErrorCode(0));
        }
    }

    public g(hb.c cVar, a aVar, b7.c cVar2, l lVar, AuthenticationScopeProvider authenticationScopeProvider, CmbDatabase cmbDatabase, r rVar) {
        this.f14473a = cVar;
        this.f14474b = aVar;
        this.f14475c = cVar2;
        this.f14476d = lVar;
        this.f14477e = cmbDatabase;
        this.f14478f = rVar;
        this.f14480h = authenticationScopeProvider;
        this.f14481i = cVar.r("SELF_USER_PROFILE_ID");
        A();
        this.f14483k = cVar.r("KEY_JSON_WEB_TOKEN");
        if (isLoggedIn()) {
            authenticationScopeProvider.a();
        }
        cVar2.e(isLoggedIn());
    }

    private void A() {
        String k10 = this.f14473a.k("KEY_JSON_WEB_TOKEN");
        if (!TextUtils.isEmpty(k10)) {
            this.f14473a.w("KEY_JSON_WEB_TOKEN", k10);
            this.f14473a.v("KEY_JSON_WEB_TOKEN");
        }
    }

    private void B() {
        i.b(EventType.LOGGED_OUT);
        for (com.coffeemeetsbagel.feature.logout.a a10 : this.f14479g) {
            a10.a();
        }
        this.f14476d.e();
    }

    /* access modifiers changed from: private */
    public void C(c.a aVar) {
        this.f14474b.a(new c(aVar));
    }

    private void G(AnalyticsConstants$Logout analyticsConstants$Logout, String[] strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason0", analyticsConstants$Logout.toString());
        int i10 = 0;
        while (i10 < strArr.length) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(JingleReason.ELEMENT);
            int i11 = i10 + 1;
            sb2.append(i11);
            hashMap.put(sb2.toString(), strArr[i10]);
            i10 = i11;
        }
        Bakery.w().z().j("Logout", hashMap);
    }

    private void u() {
        Bakery.w().r().clear();
        LoginManager.getInstance().logOut();
        Bakery.w().i().clear();
        Bakery.w().A().A();
        Bakery.w().F().clear();
        Bakery.w().G().clear();
        e.b();
        i1.c();
        ManagerNotifications.d();
        Bakery.w().h().a();
        Bakery.w().o().clear();
        Bakery.w().v().clear();
        Bakery.w().C().clear();
        Bakery.w().s().logout();
        this.f14475c.c();
        Bakery.w().z().logout();
        Sift.unsetUserId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(Context context) throws Exception {
        h5.l.e();
        this.f14473a.s();
        Bakery.w().B().c(context);
        this.f14477e.f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(AnalyticsConstants$Logout analyticsConstants$Logout, String[] strArr, BannedReason bannedReason, VerificationStatus verificationStatus) throws Exception {
        G(analyticsConstants$Logout, strArr);
        b bVar = this.f14484l;
        if (bVar != null) {
            bVar.i(bannedReason, verificationStatus);
        }
        this.f14480h.b();
    }

    private l y() {
        String r10 = this.f14473a.r("SESSION_COOKIE");
        if (!TextUtils.isEmpty(r10)) {
            try {
                return (l) new d().k(r10, l.class);
            } catch (JsonSyntaxException e10) {
                fa.a.g("AuthenticationManager", "Failed to parse session cookie.", e10);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void D(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saving jwt=");
        sb2.append(str);
        this.f14483k = str;
        this.f14473a.w("KEY_JSON_WEB_TOKEN", str);
    }

    /* access modifiers changed from: package-private */
    public void E(String str) {
        this.f14481i = str;
        this.f14473a.w("SELF_USER_PROFILE_ID", str);
    }

    /* access modifiers changed from: protected */
    public void F(String str) {
        Bakery.w().y().e(str);
        Bakery.w().t().setUserId(str);
    }

    @SuppressLint({"CheckResult"})
    public void a(Context context, AnalyticsConstants$Logout analyticsConstants$Logout, BannedReason bannedReason, VerificationStatus verificationStatus, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("type:");
        sb2.append(analyticsConstants$Logout);
        sb2.append(" reason:");
        sb2.append(bannedReason.name());
        if (isLoggedIn()) {
            f((l) null);
            D((String) null);
            this.f14481i = null;
            B();
            u();
            qj.a.w(new d(this, context)).F(dk.a.c()).f(new e(this, analyticsConstants$Logout, strArr, bannedReason, verificationStatus), new f());
        }
    }

    public void b(Activity activity, boolean z10, z9.g gVar, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr) {
        c(activity, analyticsConstants$Logout, strArr);
        if (!activity.isFinishing()) {
            if (gVar != null) {
                gVar.a();
            }
            Intent intent = new Intent(activity, ActivityLogin.class);
            intent.setFlags(268468224);
            intent.putExtra(Extra.DID_LOG_OUT, true);
            intent.putExtra(Extra.IS_ACCOUNT_DELETED, z10);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public void c(Context context, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr) {
        a(context, analyticsConstants$Logout, BannedReason.NONE, VerificationStatus.NONE, strArr);
    }

    public void d(String str, c.a aVar) {
        this.f14474b.b(str, new a(aVar));
    }

    public String e() {
        return this.f14483k;
    }

    public void f(l lVar) {
        this.f14482j = lVar;
        String str = null;
        if (lVar != null) {
            try {
                str = new d().u(lVar);
            } catch (JsonSyntaxException e10) {
                fa.a.g("AuthenticationManager", "Unable to save session cookie.", e10);
            }
            this.f14473a.w("SESSION_COOKIE", str);
            return;
        }
        this.f14473a.w("SESSION_COOKIE", (String) null);
    }

    public l g() {
        return this.f14482j;
    }

    public String getProfileId() {
        if (this.f14481i == null) {
            String str = "#login AuthenticationManager has null profile id.";
            String r10 = this.f14473a.r("SELF_USER_PROFILE_ID");
            this.f14481i = r10;
            if (r10 == null) {
                str = str + " FATAL: profile ID not in preferences";
            }
            fa.a.i(new IllegalStateException(str));
        }
        return this.f14481i;
    }

    public void h(String str) {
        for (com.coffeemeetsbagel.feature.logout.a b10 : this.f14479g) {
            b10.b(str);
        }
    }

    public void i(String str) {
        if (TextUtils.isEmpty(this.f14483k)) {
            this.f14474b.b(str, new b());
        }
    }

    public boolean isLoggedIn() {
        boolean z10;
        l lVar;
        if (!this.f14478f.a("SessionCookie.Deprecation.Android") ? (lVar = this.f14482j) == null || lVar.f() < System.currentTimeMillis() : this.f14483k == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || this.f14481i == null) {
            return false;
        }
        return true;
    }

    public void j(Activity activity, boolean z10, z9.g gVar, String str, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr) {
        fa.a.i(new Exception("Logout from purge headers"));
        b(activity, z10, gVar, analyticsConstants$Logout, strArr);
        if (str != null) {
            Set<String> stringSet = Bakery.w().M().a().getStringSet("previous_purge_headers", new HashSet());
            stringSet.add(str);
            Bakery.w().M().a().edit().putStringSet("previous_purge_headers", stringSet).commit();
        }
    }

    public void k(b bVar) {
        this.f14484l = bVar;
    }

    public void l(Context context, z9.g gVar, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr) {
        c(context, analyticsConstants$Logout, strArr);
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean m() {
        return this.f14481i != null;
    }

    public void z(String str, c.a aVar) {
        D(str);
        C(aVar);
    }
}
