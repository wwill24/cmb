package com.coffeemeetsbagel.feature.authentication.api;

import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.responses.ResponseLogin;
import jc.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class AuthenticationApi$login$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ b<ResponseLogin> $callBack;
    final /* synthetic */ AuthenticationApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthenticationApi$login$2(AuthenticationApi authenticationApi, b<ResponseLogin> bVar) {
        super(1);
        this.this$0 = authenticationApi;
        this.$callBack = bVar;
    }

    public final void a(Throwable th2) {
        this.this$0.j(this.$callBack, new CmbErrorCode("Unknown message", 0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
