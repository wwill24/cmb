package a7;

import android.content.Intent;
import android.text.TextUtils;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.utils.model.Optional;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import com.mparticle.MParticle;
import com.uber.autodispose.n;
import hb.c;
import ja.b;
import java.util.HashMap;
import java.util.Map;
import q8.a;

public class h implements a {

    /* renamed from: d  reason: collision with root package name */
    private static Map<String, String> f158d;

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseContract.Analytics f159a;

    /* renamed from: b  reason: collision with root package name */
    private final a f160b;

    /* renamed from: c  reason: collision with root package name */
    private final c f161c;

    public h(FirebaseContract.Analytics analytics, a aVar, c cVar, SubscriptionRepository subscriptionRepository, UserRepository userRepository, AuthenticationScopeProvider authenticationScopeProvider, ProfileRepositoryV2 profileRepositoryV2) {
        this.f159a = analytics;
        this.f160b = aVar;
        this.f161c = cVar;
        x(subscriptionRepository, userRepository, profileRepositoryV2, authenticationScopeProvider);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(Optional optional) throws Exception {
        c("is_subscriber", String.valueOf(optional.d()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ rn.a s(ProfileRepositoryV2 profileRepositoryV2, b bVar) throws Exception {
        w(bVar);
        return profileRepositoryV2.j(bVar.u());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(java.util.Optional optional) throws Exception {
        optional.ifPresent(new g(this));
    }

    private void x(SubscriptionRepository subscriptionRepository, UserRepository userRepository, ProfileRepositoryV2 profileRepositoryV2, AuthenticationScopeProvider authenticationScopeProvider) {
        ((n) subscriptionRepository.T().v().g(com.uber.autodispose.a.a(authenticationScopeProvider))).b(new b(this), new c());
        ((n) userRepository.p().M(new d(this, profileRepositoryV2)).g(com.uber.autodispose.a.a(authenticationScopeProvider))).b(new e(this), new f());
    }

    private void y(String str, Map<String, String> map, long j10) {
        StringBuilder sb2 = new StringBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                sb2.append((String) next.getKey());
                sb2.append("=");
                sb2.append((String) next.getValue());
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("event: ");
        sb3.append(str);
        sb3.append(" attributes: [");
        sb3.append(sb2.toString());
        sb3.append("]");
        this.f160b.c(str, MParticle.EventType.Other, map);
    }

    public void a(NetworkProfile networkProfile) {
        this.f160b.a(networkProfile);
        this.f159a.setUserId(networkProfile.getId());
    }

    public void b(String str) {
        this.f160b.b(str);
    }

    public void c(String str, String str2) {
        this.f160b.setUserAttribute(str, str2);
    }

    public void d(String str) {
        y(str, new HashMap(), -1);
    }

    public String e(String str) {
        return TextUtils.isEmpty(str) ? "na" : str;
    }

    public void f(String str) {
        this.f160b.d(str);
        MParticle.getInstance().upload();
    }

    public void g(String str) {
        f(str);
    }

    public void h(Map<String, String> map) {
        String profileId = Bakery.w().g().getProfileId();
        if (profileId != null) {
            map.put(Extra.PROFILE_ID, profileId);
        }
        y("Android Onboarding Config Received", map, -1);
    }

    public void i(String str) {
        if (f158d == null) {
            f158d = new HashMap();
        }
        j(str, f158d);
    }

    public void j(String str, Map<String, String> map) {
        map.put("user id", String.valueOf(Bakery.w().g().getProfileId()));
        y(str, map, -1);
    }

    public void k(Intent intent) {
        boolean z10 = false;
        if (intent != null && intent.getBooleanExtra(Extra.IS_FROM_PUSH, false)) {
            z10 = true;
        }
        if (z10) {
            HashMap hashMap = new HashMap();
            if (Bakery.w().g().isLoggedIn() && !TextUtils.isEmpty(Bakery.w().g().getProfileId())) {
                hashMap.put("profile id", Bakery.w().g().getProfileId());
            }
            if (intent.getExtras() != null && intent.getExtras().containsKey("cmb_push_id")) {
                hashMap.put("cmb push id", intent.getStringExtra("cmb_push_id"));
            }
            trackEvent(Constants.PUSH_OPENED_EVENT_NAME, hashMap);
            this.f159a.trackEvent(Constants.PUSH_OPENED_EVENT_NAME, hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(FirebaseAnalytics.Param.METHOD, "push notification");
            hashMap2.put("is badged", String.valueOf(this.f161c.p("APP_BADGE_SHOWN")));
            j("App Launch", hashMap2);
        }
    }

    public void logout() {
        this.f160b.logout();
    }

    public void trackEvent(String str, Map<String, String> map) {
        y(str, map, -1);
    }

    public void v(l lVar) {
        this.f160b.setUserAttribute("Gender", lVar.h().getApiKey());
        this.f160b.setUserAttribute("City", lVar.b());
    }

    public void w(b bVar) {
        this.f160b.setUserAttribute("Match Region", bVar.r());
    }
}
