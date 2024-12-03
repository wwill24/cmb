package com.coffeemeetsbagel.domain.repository;

import ja.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import okhttp3.b0;
import qj.w;
import retrofit2.r;

final class UserRepository$update$1 extends Lambda implements Function1<r<b0>, qj.b0<? extends Integer>> {
    final /* synthetic */ c $userEntity;
    final /* synthetic */ UserRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepository$update$1(UserRepository userRepository, c cVar) {
        super(1);
        this.this$0 = userRepository;
        this.$userEntity = cVar;
    }

    /* access modifiers changed from: private */
    public static final Integer d(UserRepository userRepository, c cVar) {
        j.g(userRepository, "this$0");
        j.g(cVar, "$userEntity");
        return Integer.valueOf(userRepository.f12462b.c(cVar));
    }

    /* renamed from: c */
    public final qj.b0<? extends Integer> invoke(r<b0> rVar) {
        j.g(rVar, "response");
        if (rVar.g()) {
            return w.A(new e3(this.this$0, this.$userEntity));
        }
        return w.C(-1);
    }
}
