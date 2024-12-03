package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.b;
import wk.m;

@Metadata(bv = {}, d1 = {"com/squareup/workflow1/p", "com/squareup/workflow1/q", "com/squareup/workflow1/Workflows__StatefulWorkflowKt", "com/squareup/workflow1/Workflows__WorkerWorkflowKt", "com/squareup/workflow1/Workflows__WorkflowActionKt", "com/squareup/workflow1/Workflows__WorkflowIdentifierKt"}, d2 = {}, k = 4, mv = {1, 6, 0})
public final class o {
    public static final <PropsT, StateT, OutputT, RenderingT> h<PropsT, StateT, OutputT, RenderingT>.a a(a<? extends PropsT, StateT, ? super OutputT> aVar, h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar) {
        return Workflows__StatefulWorkflowKt.a(aVar, hVar);
    }

    public static final <PropsT, StateT, OutputT, RenderingT> l<PropsT, StateT, OutputT> b(h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar, String str, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        return Workflows__StatefulWorkflowKt.b(hVar, str, function1);
    }

    public static final <PropsT, StateT, OutputT, RenderingT> l<PropsT, StateT, OutputT> c(h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar, Function0<String> function0, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        return Workflows__StatefulWorkflowKt.c(hVar, function0, function1);
    }

    public static final <PropsT, StateT, OutputT> l<PropsT, StateT, OutputT> d(String str, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        return Workflows__WorkflowActionKt.a(str, function1);
    }

    public static final <PropsT, StateT, OutputT> l<PropsT, StateT, OutputT> e(Function0<String> function0, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        return Workflows__WorkflowActionKt.b(function0, function1);
    }

    public static final <PropsT, StateT, OutputT> Pair<StateT, n<OutputT>> h(l<? super PropsT, StateT, ? extends OutputT> lVar, PropsT propst, StateT statet) {
        return Workflows__WorkflowActionKt.d(lVar, propst, statet);
    }

    public static final <T, PropsT, StateT, OutputT> Object i(b<? extends T> bVar, f<? super l<? super PropsT, StateT, ? extends OutputT>> fVar, Function1<? super T, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1, c<? super Unit> cVar) {
        return q.a(bVar, fVar, function1, cVar);
    }

    public static final WorkflowIdentifier j(k<?, ?, ?> kVar) {
        return Workflows__WorkflowIdentifierKt.a(kVar);
    }

    public static final <OutputT> Object k(j<? extends OutputT> jVar, String str, f<? super l<? super j<? extends OutputT>, Integer, ? extends OutputT>> fVar, c<? super Unit> cVar) {
        return Workflows__WorkerWorkflowKt.d(jVar, str, fVar, cVar);
    }

    public static final <T, PropsT, StateT, OutputT> void l(a<? extends PropsT, StateT, ? super OutputT> aVar, j<? extends T> jVar, m mVar, String str, Function1<? super T, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
        p.a(aVar, jVar, mVar, str, function1);
    }

    public static final <PropsT, StateT, OutputT> Object m(f<? super l<? super PropsT, StateT, ? extends OutputT>> fVar, l<? super PropsT, StateT, ? extends OutputT> lVar, c<? super Unit> cVar) {
        return q.b(fVar, lVar, cVar);
    }

    public static final WorkflowIdentifier n(m mVar) {
        return Workflows__WorkflowIdentifierKt.b(mVar);
    }
}
