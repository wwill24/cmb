package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class RefreshMyProfileUseCase$invoke$1 extends Lambda implements Function1<NetworkProfile, b0<? extends List<? extends Long>>> {
    final /* synthetic */ RefreshMyProfileUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RefreshMyProfileUseCase$invoke$1(RefreshMyProfileUseCase refreshMyProfileUseCase) {
        super(1);
        this.this$0 = refreshMyProfileUseCase;
    }

    /* access modifiers changed from: private */
    public static final b0 f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* renamed from: e */
    public final b0<? extends List<Long>> invoke(final NetworkProfile networkProfile) {
        j.g(networkProfile, "networkProfile");
        final List e10 = p.e(networkProfile);
        w<Integer> t10 = this.this$0.f36062b.t(e10);
        final RefreshMyProfileUseCase refreshMyProfileUseCase = this.this$0;
        w<R> v10 = t10.v(new i0(new Function1<Integer, b0<? extends Integer>>() {
            /* renamed from: a */
            public final b0<? extends Integer> invoke(Integer num) {
                j.g(num, "it");
                return refreshMyProfileUseCase.f36063c.l(e10);
            }
        }));
        final RefreshMyProfileUseCase refreshMyProfileUseCase2 = this.this$0;
        w<R> v11 = v10.v(new j0(new Function1<Integer, b0<? extends List<? extends Long>>>() {
            /* renamed from: a */
            public final b0<? extends List<Long>> invoke(Integer num) {
                j.g(num, "it");
                return refreshMyProfileUseCase2.f36064d.X(e10);
            }
        }));
        final RefreshMyProfileUseCase refreshMyProfileUseCase3 = this.this$0;
        return v11.v(new k0(new Function1<List<? extends Long>, b0<? extends List<? extends Long>>>() {
            /* renamed from: a */
            public final b0<? extends List<Long>> invoke(List<Long> list) {
                j.g(list, "it");
                m c10 = refreshMyProfileUseCase3.f36065e;
                NetworkProfile networkProfile = networkProfile;
                j.f(networkProfile, "networkProfile");
                return c10.d(networkProfile);
            }
        }));
    }
}
