package com.squareup.workflow1;

import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/squareup/workflow1/d;", "Lcom/squareup/workflow1/m;", "<init>", "()V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class d implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final d f23084a = new d();

    private d() {
    }

    public <P, S, O, R> R a(P p10, S s10, a<? extends P, S, ? super O> aVar, n<? super P, ? super S, ? super m.b<P, S, O>, ? extends R> nVar, m.c cVar) {
        return m.a.c(this, p10, s10, aVar, nVar, cVar);
    }

    public <S> Snapshot b(S s10, Function1<? super S, Snapshot> function1, m.c cVar) {
        return m.a.e(this, s10, function1, cVar);
    }

    public <P, S> S c(P p10, Snapshot snapshot, Function2<? super P, ? super Snapshot, ? extends S> function2, m.c cVar) {
        return m.a.a(this, p10, snapshot, function2, cVar);
    }

    public void d(k0 k0Var, m.c cVar) {
        m.a.d(this, k0Var, cVar);
    }

    public <P, S> S e(P p10, P p11, S s10, n<? super P, ? super P, ? super S, ? extends S> nVar, m.c cVar) {
        return m.a.b(this, p10, p11, s10, nVar, cVar);
    }
}
