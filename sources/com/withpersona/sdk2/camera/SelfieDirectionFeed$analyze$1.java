package com.withpersona.sdk2.camera;

import gk.g;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.SelfieDirectionFeed$analyze$1", f = "SelfieDirectionFeed.kt", l = {37}, m = "invokeSuspend")
final class SelfieDirectionFeed$analyze$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ Object $result;
    int label;
    final /* synthetic */ SelfieDirectionFeed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieDirectionFeed$analyze$1(SelfieDirectionFeed selfieDirectionFeed, Object obj, c<? super SelfieDirectionFeed$analyze$1> cVar) {
        super(2, cVar);
        this.this$0 = selfieDirectionFeed;
        this.$result = obj;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SelfieDirectionFeed$analyze$1(this.this$0, this.$result, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SelfieDirectionFeed$analyze$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            h j10 = this.this$0.f14193b;
            Result a10 = Result.a(this.$result);
            this.label = 1;
            if (j10.c(a10, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
