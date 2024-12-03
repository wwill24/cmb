package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

public final class SaveMyProfileLocalUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36066a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final m f36067b;

    public SaveMyProfileLocalUseCase(UserRepository userRepository, m mVar) {
        j.g(userRepository, "userRepository");
        j.g(mVar, "capabilityRepository");
        this.f36066a = userRepository;
        this.f36067b = mVar;
    }

    /* access modifiers changed from: private */
    public static final b0 d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<List<Long>> c(NetworkProfile networkProfile) {
        j.g(networkProfile, "networkProfile");
        w<R> v10 = this.f36066a.v(networkProfile).v(new m0(new SaveMyProfileLocalUseCase$invoke$1(this, networkProfile)));
        j.f(v10, "operator fun invoke(netw…e(networkProfile) }\n    }");
        return v10;
    }
}
