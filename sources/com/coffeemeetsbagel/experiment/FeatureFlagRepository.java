package com.coffeemeetsbagel.experiment;

import android.content.SharedPreferences;
import com.coffeemeetsbagel.features.models.FeatureFlag;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import fa.a;
import gk.f;
import hb.c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ka.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;

public final class FeatureFlagRepository {

    /* renamed from: a  reason: collision with root package name */
    private final s f12629a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f12630b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f12631c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f12632d = "FeatureFlagRepository";

    /* renamed from: e  reason: collision with root package name */
    private final int f12633e = 14400000;

    /* renamed from: f  reason: collision with root package name */
    private final f f12634f = b.b(new FeatureFlagRepository$appSharedPrefs$2(this));

    /* renamed from: g  reason: collision with root package name */
    private final f f12635g = b.b(new FeatureFlagRepository$ffSharedPrefs$2(this));

    /* renamed from: h  reason: collision with root package name */
    private final f f12636h = b.b(new FeatureFlagRepository$ffOverrideSharedPrefs$2(this));
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, Boolean> f12637i = new LinkedHashMap();

    public static final class a implements a.C0498a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeatureFlagRepository f12638a;

        a(FeatureFlagRepository featureFlagRepository) {
            this.f12638a = featureFlagRepository;
        }

        public void C() {
            this.f12638a.I(false).d();
        }

        public void c() {
        }

        public void f() {
        }
    }

    public FeatureFlagRepository(s sVar, c cVar, ka.a aVar, boolean z10) {
        j.g(sVar, "remote");
        j.g(cVar, "sharedPrefs");
        j.g(aVar, "cachePurgeContract");
        this.f12629a = sVar;
        this.f12630b = cVar;
        this.f12631c = z10;
        aVar.b(new a(this));
    }

    /* access modifiers changed from: private */
    public static final Boolean C(FeatureFlagRepository featureFlagRepository, String str, boolean z10) {
        j.g(featureFlagRepository, "this$0");
        j.g(str, "$key");
        return Boolean.valueOf(featureFlagRepository.x().edit().putBoolean(str, z10).commit());
    }

    /* access modifiers changed from: private */
    public static final void D(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Map F(FeatureFlagRepository featureFlagRepository) {
        j.g(featureFlagRepository, "this$0");
        return featureFlagRepository.x().getAll();
    }

    /* access modifiers changed from: private */
    public static final void G(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final qj.f J(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (qj.f) function1.invoke(obj);
    }

    private final qj.a K() {
        qj.a w10 = this.f12629a.a().K(dk.a.c()).w(new m(new FeatureFlagRepository$refreshInternal$1(this)));
        j.f(w10, "private fun refreshInter…map))\n            }\n    }");
        return w10;
    }

    /* access modifiers changed from: private */
    public static final qj.f L(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (qj.f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void N(FeatureFlagRepository featureFlagRepository, Map map) {
        j.g(featureFlagRepository, "this$0");
        SharedPreferences.Editor edit = featureFlagRepository.y().edit();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
            a.C0491a aVar = fa.a.f40771d;
            String str2 = featureFlagRepository.f12632d;
            aVar.a(str2, "saving feature flag: " + str + " - " + booleanValue);
            edit.putBoolean(str, booleanValue).apply();
        }
    }

    /* access modifiers changed from: private */
    public static final Boolean q(FeatureFlagRepository featureFlagRepository) {
        j.g(featureFlagRepository, "this$0");
        return Boolean.valueOf(featureFlagRepository.y().edit().clear().commit());
    }

    /* access modifiers changed from: private */
    public static final Boolean s(FeatureFlagRepository featureFlagRepository) {
        j.g(featureFlagRepository, "this$0");
        return Boolean.valueOf(featureFlagRepository.x().edit().clear().commit());
    }

    /* access modifiers changed from: private */
    public static final void t(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final SharedPreferences w() {
        return (SharedPreferences) this.f12634f.getValue();
    }

    private final SharedPreferences x() {
        return (SharedPreferences) this.f12636h.getValue();
    }

    private final SharedPreferences y() {
        return (SharedPreferences) this.f12635g.getValue();
    }

    public final boolean A(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        if (!this.f12631c || !this.f12637i.containsKey(str)) {
            return y().getBoolean(str, false);
        }
        Boolean bool = this.f12637i.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final w<Boolean> B(String str, boolean z10) {
        j.g(str, SDKConstants.PARAM_KEY);
        w<Boolean> r10 = w.A(new n(this, str, z10)).K(dk.a.c()).r(new o(new FeatureFlagRepository$overrideFeatureFlag$2(this, str, z10)));
        j.f(r10, "fun overrideFeatureFlag(…    }\n            }\n    }");
        return r10;
    }

    public final qj.a E() {
        qj.a B = w.A(new i(this)).r(new j(new FeatureFlagRepository$populateOverrideMemCache$2(this))).B();
        j.f(B, "fun populateOverrideMemC…   .ignoreElement()\n    }");
        return B;
    }

    public final qj.a H(List<String> list) {
        j.g(list, "names");
        qj.a F = this.f12629a.b(list).w(new g(new FeatureFlagRepository$refresh$1(this))).F(dk.a.c());
        j.f(F, "fun refresh(names: List<…On(Schedulers.io())\n    }");
        return F;
    }

    public final qj.a I(boolean z10) {
        if (!z10) {
            return K();
        }
        if (w().getLong("last_feature_sync", 0) + ((long) this.f12633e) <= System.currentTimeMillis()) {
            return K();
        }
        qj.a m10 = qj.a.m();
        j.f(m10, "{\n                Comple….complete()\n            }");
        return m10;
    }

    public final qj.a M(Map<String, Boolean> map) {
        boolean z10;
        if (map == null || map.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            qj.a m10 = qj.a.m();
            j.f(m10, "{\n            Completable.complete()\n        }");
            return m10;
        }
        qj.a w10 = qj.a.w(new p(this, map));
        j.f(w10, "{\n            Completabl…}\n            }\n        }");
        return w10;
    }

    public final w<Boolean> p() {
        w<Boolean> K = w.A(new f(this)).K(dk.a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Boolean> r() {
        w<Boolean> r10 = w.A(new k(this)).K(dk.a.c()).r(new l(new FeatureFlagRepository$clearOverrideFeatureFlags$2(this)));
        j.f(r10, "fun clearOverrideFeature…    }\n            }\n    }");
        return r10;
    }

    public final w<List<FeatureFlag>> u() {
        w<R> D = this.f12629a.a().K(dk.a.c()).D(new h(new FeatureFlagRepository$fetchFFsFromRemote$1(this)));
        j.f(D, "fun fetchFFsFromRemote()…ist()\n            }\n    }");
        return D;
    }

    public final Boolean z(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        return this.f12637i.get(str);
    }
}
