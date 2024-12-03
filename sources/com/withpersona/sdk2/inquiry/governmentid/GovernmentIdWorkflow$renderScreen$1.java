package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$renderScreen$1", f = "GovernmentIdWorkflow.kt", l = {}, m = "invokeSuspend")
final class GovernmentIdWorkflow$renderScreen$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    int label;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$1(GovernmentIdWorkflow.a aVar, GovernmentIdWorkflow governmentIdWorkflow, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2, GovernmentIdState governmentIdState, c<? super GovernmentIdWorkflow$renderScreen$1> cVar) {
        super(2, cVar);
        this.$renderProps = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$context = aVar2;
        this.$renderState = governmentIdState;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new GovernmentIdWorkflow$renderScreen$1(this.$renderProps, this.this$0, this.$context, this.$renderState, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((GovernmentIdWorkflow$renderScreen$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            if (this.$renderProps.e().size() == 1) {
                GovernmentIdWorkflow.a aVar = this.$renderProps;
                GovernmentIdWorkflow.C(aVar, this.this$0, this.$context, this.$renderState, (IdConfig) CollectionsKt___CollectionsKt.N(aVar.e()), false, (Boolean) null, 64, (Object) null);
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
