package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import ja.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import ma.g;
import okhttp3.v;
import okhttp3.z;
import qj.b0;
import qj.w;
import retrofit2.r;

final class UserRepository$updateAppsFlyerId$1 extends Lambda implements Function1<b, b0<? extends Integer>> {
    final /* synthetic */ String $appsFlyerId;
    final /* synthetic */ UserRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepository$updateAppsFlyerId$1(String str, UserRepository userRepository) {
        super(1);
        this.$appsFlyerId = str;
        this.this$0 = userRepository;
    }

    /* access modifiers changed from: private */
    public static final b0 d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Integer> invoke(final b bVar) {
        j.g(bVar, "user");
        if (bVar.d() != null && r.u(bVar.d(), this.$appsFlyerId, false, 2, (Object) null)) {
            return w.C(0);
        }
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateAppsFlyerId(this.$appsFlyerId);
        z d10 = z.d(v.g("application/json"), modelProfileUpdateDelta.flush());
        g i10 = this.this$0.f12461a;
        j.f(d10, "requestBody");
        w<r<okhttp3.b0>> b10 = i10.b(d10);
        final String str = this.$appsFlyerId;
        final UserRepository userRepository = this.this$0;
        return b10.v(new f3(new Function1<r<okhttp3.b0>, b0<? extends Integer>>() {
            /* access modifiers changed from: private */
            public static final Integer d(String str, UserRepository userRepository, b bVar) {
                j.g(userRepository, "this$0");
                j.g(bVar, "$user");
                if (str != null) {
                    return Integer.valueOf(userRepository.f12462b.f(str, bVar.u()));
                }
                return null;
            }

            /* renamed from: c */
            public final b0<? extends Integer> invoke(r<okhttp3.b0> rVar) {
                j.g(rVar, "response");
                if (!rVar.g()) {
                    w C = w.C(0);
                    j.f(C, "just(0)");
                    return C;
                }
                w A = w.A(new g3(str, userRepository, bVar));
                j.f(A, "fromCallable {\n         …                        }");
                return A;
            }
        }));
    }
}
