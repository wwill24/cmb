package com.coffeemeetsbagel.profile_me;

import com.coffeemeetsbagel.profile_me.MeProfileViewModel;
import gk.g;
import ja.b;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.profile_me.MeProfileViewModel$onTabSelected$1$2$1$2", f = "MeProfileViewModel.kt", l = {}, m = "invokeSuspend")
final class MeProfileViewModel$onTabSelected$1$2$1$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ HashMap<String, String> $attributes;
    final /* synthetic */ b $user;
    int label;
    final /* synthetic */ MeProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeProfileViewModel$onTabSelected$1$2$1$2(b bVar, HashMap<String, String> hashMap, MeProfileViewModel meProfileViewModel, c<? super MeProfileViewModel$onTabSelected$1$2$1$2> cVar) {
        super(2, cVar);
        this.$user = bVar;
        this.$attributes = hashMap;
        this.this$0 = meProfileViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new MeProfileViewModel$onTabSelected$1$2$1$2(this.$user, this.$attributes, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((MeProfileViewModel$onTabSelected$1$2$1$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            if (this.$user.l()) {
                this.$attributes.put("state", "confirm");
                this.this$0.f36173k.o(MeProfileViewModel.UpsellViewState.BOOST_ACTIVE);
            } else if (this.this$0.f36171i != null) {
                this.$attributes.put("state", "boost_me");
                this.this$0.f36173k.o(MeProfileViewModel.UpsellViewState.BOOST_AVAILABLE);
            } else {
                this.this$0.f36173k.o(MeProfileViewModel.UpsellViewState.NONE);
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
