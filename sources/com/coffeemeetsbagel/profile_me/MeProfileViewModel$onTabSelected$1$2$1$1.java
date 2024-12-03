package com.coffeemeetsbagel.profile_me;

import gk.g;
import ja.b;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.profile_me.MeProfileViewModel$onTabSelected$1$2$1$1", f = "MeProfileViewModel.kt", l = {}, m = "invokeSuspend")
final class MeProfileViewModel$onTabSelected$1$2$1$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ b $user;
    int label;
    final /* synthetic */ MeProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeProfileViewModel$onTabSelected$1$2$1$1(MeProfileViewModel meProfileViewModel, b bVar, c<? super MeProfileViewModel$onTabSelected$1$2$1$1> cVar) {
        super(2, cVar);
        this.this$0 = meProfileViewModel;
        this.$user = bVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new MeProfileViewModel$onTabSelected$1$2$1$1(this.this$0, this.$user, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((MeProfileViewModel$onTabSelected$1$2$1$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            this.this$0.f36174l.o(this.$user);
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
