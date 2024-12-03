package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.NetworkProfile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import w6.a;

final class UserRepository$refreshMyProfile$1 extends Lambda implements Function1<NetworkProfile, b0<? extends NetworkProfile>> {
    final /* synthetic */ UserRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepository$refreshMyProfile$1(UserRepository userRepository) {
        super(1);
        this.this$0 = userRepository;
    }

    /* access modifiers changed from: private */
    public static final Integer e(UserRepository userRepository, NetworkProfile networkProfile) {
        j.g(userRepository, "this$0");
        j.g(networkProfile, "$networkProfile");
        return Integer.valueOf(userRepository.f12462b.c(a.d(networkProfile)));
    }

    /* access modifiers changed from: private */
    public static final NetworkProfile f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (NetworkProfile) function1.invoke(obj);
    }

    /* renamed from: d */
    public final b0<? extends NetworkProfile> invoke(final NetworkProfile networkProfile) {
        j.g(networkProfile, "networkProfile");
        return w.A(new c3(this.this$0, networkProfile)).D(new d3(new Function1<Integer, NetworkProfile>() {
            /* renamed from: a */
            public final NetworkProfile invoke(Integer num) {
                j.g(num, "it");
                return networkProfile;
            }
        }));
    }
}
