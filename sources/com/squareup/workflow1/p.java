package com.squareup.workflow1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import wk.m;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a|\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2$\u0010\r\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\f0\u000bH\u0001¨\u0006\u0010"}, d2 = {"T", "PropsT", "StateT", "OutputT", "Lcom/squareup/workflow1/a;", "Lcom/squareup/workflow1/j;", "worker", "Lwk/m;", "workerType", "", "key", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "handler", "", "a", "wf1-workflow-core"}, k = 5, mv = {1, 6, 0}, xs = "com/squareup/workflow1/Workflows")
final /* synthetic */ class p {
    public static final <T, PropsT, StateT, OutputT> void a(a<? extends PropsT, StateT, ? super OutputT> aVar, j<? extends T> jVar, m mVar, String str, Function1<? super T, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
        j.g(aVar, "<this>");
        j.g(jVar, "worker");
        j.g(mVar, "workerType");
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function1, "handler");
        aVar.b(new WorkerWorkflow(mVar, str), jVar, str, function1);
    }
}
