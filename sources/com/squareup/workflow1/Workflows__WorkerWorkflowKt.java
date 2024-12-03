package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j0;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aU\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00020\u00032$\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u00060\u0005H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0011\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"OutputT", "Lcom/squareup/workflow1/j;", "worker", "", "renderKey", "Lcom/squareup/workflow1/f;", "Lcom/squareup/workflow1/l;", "", "actionSink", "", "d", "(Lcom/squareup/workflow1/j;Ljava/lang/String;Lcom/squareup/workflow1/f;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/flow/b;", "c", "(Lcom/squareup/workflow1/j;)Lkotlinx/coroutines/flow/b;", "key", "b", "(Lcom/squareup/workflow1/j;Ljava/lang/String;)Ljava/lang/String;", "wf1-workflow-core"}, k = 5, mv = {1, 6, 0}, xs = "com/squareup/workflow1/Workflows")
final /* synthetic */ class Workflows__WorkerWorkflowKt {
    private static final String b(j<?> jVar, String str) {
        String obj = jVar.toString();
        if (r.w(str)) {
            return obj;
        }
        return obj + ':' + str;
    }

    /* access modifiers changed from: private */
    public static final <T> b<T> c(j<? extends T> jVar) {
        b<? extends T> run = jVar.run();
        if (run != null) {
            return run;
        }
        throw new NullPointerException("Worker " + jVar + " returned a null Flow. If this is a test mock, make sure you mock the run() method!");
    }

    public static final <OutputT> Object d(j<? extends OutputT> jVar, String str, f<? super l<? super j<? extends OutputT>, Integer, ? extends OutputT>> fVar, c<? super Unit> cVar) {
        Object g10 = h.g(new j0(b(jVar, str)), new Workflows__WorkerWorkflowKt$runWorker$2(jVar, fVar, str, (c<? super Workflows__WorkerWorkflowKt$runWorker$2>) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }
}
