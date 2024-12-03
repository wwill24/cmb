package com.squareup.workflow1;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "com.squareup.workflow1.Workflows__WorkerWorkflowKt$runWorker$2", f = "WorkerWorkflow.kt", l = {78}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"OutputT", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class Workflows__WorkerWorkflowKt$runWorker$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ f<l<? super j<? extends OutputT>, Integer, ? extends OutputT>> $actionSink;
    final /* synthetic */ String $renderKey;
    final /* synthetic */ j<OutputT> $worker;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Workflows__WorkerWorkflowKt$runWorker$2(j<? extends OutputT> jVar, f<? super l<? super j<? extends OutputT>, Integer, ? extends OutputT>> fVar, String str, c<? super Workflows__WorkerWorkflowKt$runWorker$2> cVar) {
        super(2, cVar);
        this.$worker = jVar;
        this.$actionSink = fVar;
        this.$renderKey = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Workflows__WorkerWorkflowKt$runWorker$2(this.$worker, this.$actionSink, this.$renderKey, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((Workflows__WorkerWorkflowKt$runWorker$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            b a10 = Workflows__WorkerWorkflowKt.c(this.$worker);
            f<l<? super j<? extends OutputT>, Integer, ? extends OutputT>> fVar = this.$actionSink;
            final j<OutputT> jVar = this.$worker;
            final String str = this.$renderKey;
            AnonymousClass1 r32 = new Function1<OutputT, l<? super j<? extends OutputT>, Integer, ? extends OutputT>>() {
                /* renamed from: a */
                public final l<j<? extends OutputT>, Integer, OutputT> invoke(OutputT outputt) {
                    return new b(jVar, str, outputt);
                }
            };
            this.label = 1;
            if (o.i(a10, fVar, r32, this) == d10) {
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
