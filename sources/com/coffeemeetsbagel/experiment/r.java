package com.coffeemeetsbagel.experiment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.coffeemeetsbagel.features.models.FeatureFlag;
import java.util.List;
import qj.w;
import s9.a;

public class r implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12665a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12666b;

    /* renamed from: c  reason: collision with root package name */
    private final FeatureFlagRepository f12667c;

    public r(Context context, FeatureFlagRepository featureFlagRepository, boolean z10) {
        this.f12665a = context;
        this.f12667c = featureFlagRepository;
        this.f12666b = z10;
        featureFlagRepository.E().d();
    }

    @Deprecated
    public boolean a(String str) {
        if (this.f12666b && this.f12667c.z(str) != null) {
            return this.f12667c.z(str).booleanValue();
        }
        SharedPreferences sharedPreferences = this.f12665a.getSharedPreferences("shared_prefs_features", 0);
        if (!sharedPreferences.contains(str) || !sharedPreferences.getBoolean(str, false)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public void b() {
        this.f12667c.r().d();
    }

    @Deprecated
    public w<List<FeatureFlag>> c() {
        return this.f12667c.u();
    }

    @Deprecated
    public void d(String str, boolean z10) {
        this.f12667c.B(str, z10).d();
    }

    @SuppressLint({"CheckResult"})
    @Deprecated
    public void logout() {
        this.f12667c.p().j();
    }
}
