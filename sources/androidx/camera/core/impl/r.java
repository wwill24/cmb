package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

public interface r extends s1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Config.a<UseCaseConfigFactory> f2577a = Config.a.a("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);

    /* renamed from: b  reason: collision with root package name */
    public static final Config.a<q0> f2578b = Config.a.a("camerax.core.camera.compatibilityId", q0.class);

    /* renamed from: c  reason: collision with root package name */
    public static final Config.a<Integer> f2579c = Config.a.a("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);

    /* renamed from: d  reason: collision with root package name */
    public static final Config.a<u1> f2580d = Config.a.a("camerax.core.camera.SessionProcessor", u1.class);

    /* renamed from: e  reason: collision with root package name */
    public static final Config.a<Boolean> f2581e = Config.a.a("camerax.core.camera.isZslDisabled", Boolean.class);

    @NonNull
    q0 E();

    u1 J(u1 u1Var) {
        return (u1) g(f2580d, u1Var);
    }

    @NonNull
    UseCaseConfigFactory j() {
        return (UseCaseConfigFactory) g(f2577a, UseCaseConfigFactory.f2446a);
    }

    int t() {
        return ((Integer) g(f2579c, 0)).intValue();
    }
}
