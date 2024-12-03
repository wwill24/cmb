package com.coffeemeetsbagel.domain.repository;

import ja.b;
import ja.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class UserRepository$getUser$1 extends Lambda implements Function1<c, a<? extends b>> {
    final /* synthetic */ UserRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepository$getUser$1(UserRepository userRepository) {
        super(1);
        this.this$0 = userRepository;
    }

    /* renamed from: a */
    public final a<? extends b> invoke(c cVar) {
        j.g(cVar, "it");
        return this.this$0.r(w6.a.c(cVar));
    }
}
