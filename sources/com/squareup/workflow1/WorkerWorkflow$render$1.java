package com.squareup.workflow1;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.squareup.workflow1.WorkerWorkflow$render$1", f = "WorkerWorkflow.kt", l = {57}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"OutputT", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class WorkerWorkflow$render$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<j<? extends OutputT>, Integer, OutputT, Unit>.a $context;
    final /* synthetic */ j<OutputT> $renderProps;
    int label;
    final /* synthetic */ WorkerWorkflow<OutputT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkerWorkflow$render$1(j<? extends OutputT> jVar, WorkerWorkflow<OutputT> workerWorkflow, h<? super j<? extends OutputT>, Integer, ? extends OutputT, Unit>.a aVar, c<? super WorkerWorkflow$render$1> cVar) {
        super(2, cVar);
        this.$renderProps = jVar;
        this.this$0 = workerWorkflow;
        this.$context = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new WorkerWorkflow$render$1(this.$renderProps, this.this$0, this.$context, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((WorkerWorkflow$render$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            j<OutputT> jVar = this.$renderProps;
            String h10 = this.this$0.f23063b;
            f c10 = this.$context.c();
            this.label = 1;
            if (o.k(jVar, h10, c10, this) == d10) {
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
