package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import pk.n;
import pk.p;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/flow/e", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/f", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/g", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {1, 6, 0})
public final class d {
    public static final <T, R> b<R> A(b<? extends T> bVar, Function2<? super T, ? super c<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(bVar, function2);
    }

    public static final <T> b<T> B(Iterable<? extends b<? extends T>> iterable) {
        return FlowKt__MergeKt.b(iterable);
    }

    public static final <T> b<T> C(b<? extends T>... bVarArr) {
        return FlowKt__MergeKt.c(bVarArr);
    }

    public static final <T> b<T> D(b<? extends T> bVar, Function2<? super T, ? super c<? super Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.b(bVar, function2);
    }

    public static final <T> q<T> E(b<? extends T> bVar, k0 k0Var) {
        return FlowKt__ChannelsKt.d(bVar, k0Var);
    }

    public static final <T> r<T> F(b<? extends T> bVar, k0 k0Var, p pVar, T t10) {
        return FlowKt__ShareKt.d(bVar, k0Var, pVar, t10);
    }

    public static final <T> b<T> G(b<? extends T> bVar, int i10) {
        return FlowKt__LimitKt.e(bVar, i10);
    }

    public static final <T> b<T> H(b<? extends T> bVar, Function2<? super T, ? super c<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.f(bVar, function2);
    }

    public static final <T, R> b<R> I(b<? extends T> bVar, n<? super c<? super R>, ? super T, ? super c<? super Unit>, ? extends Object> nVar) {
        return FlowKt__MergeKt.d(bVar, nVar);
    }

    public static final <T, R> b<R> J(b<? extends T> bVar, n<? super c<? super R>, ? super T, ? super c<? super Boolean>, ? extends Object> nVar) {
        return FlowKt__LimitKt.g(bVar, nVar);
    }

    public static final <T> r<T> a(i<T> iVar) {
        return FlowKt__ShareKt.a(iVar);
    }

    public static final <T> b<T> b(b<? extends T> bVar, int i10, BufferOverflow bufferOverflow) {
        return f.a(bVar, i10, bufferOverflow);
    }

    public static final <T> b<T> d(Function2<? super o<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        return e.a(function2);
    }

    public static final <T> b<T> e(b<? extends T> bVar, n<? super c<? super T>, ? super Throwable, ? super c<? super Unit>, ? extends Object> nVar) {
        return FlowKt__ErrorsKt.a(bVar, nVar);
    }

    public static final <T> Object f(b<? extends T> bVar, c<? super T> cVar, c<? super Throwable> cVar2) {
        return FlowKt__ErrorsKt.b(bVar, cVar, cVar2);
    }

    public static final Object g(b<?> bVar, c<? super Unit> cVar) {
        return FlowKt__CollectKt.a(bVar, cVar);
    }

    public static final <T> Object h(b<? extends T> bVar, Function2<? super T, ? super c<? super Unit>, ? extends Object> function2, c<? super Unit> cVar) {
        return FlowKt__CollectKt.b(bVar, function2, cVar);
    }

    public static final <T1, T2, T3, T4, R> b<R> i(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, b<? extends T4> bVar4, p<? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super R>, ? extends Object> pVar) {
        return FlowKt__ZipKt.b(bVar, bVar2, bVar3, bVar4, pVar);
    }

    public static final <T1, T2, R> b<R> j(b<? extends T1> bVar, b<? extends T2> bVar2, n<? super T1, ? super T2, ? super c<? super R>, ? extends Object> nVar) {
        return FlowKt__ZipKt.c(bVar, bVar2, nVar);
    }

    public static final <T> b<T> k(b<? extends T> bVar) {
        return f.d(bVar);
    }

    public static final <T> b<T> l(b<? extends T> bVar, long j10) {
        return FlowKt__DelayKt.a(bVar, j10);
    }

    public static final <T> b<T> m(b<? extends T> bVar) {
        return FlowKt__DistinctKt.a(bVar);
    }

    public static final <T> b<T> n(b<? extends T> bVar, int i10) {
        return FlowKt__LimitKt.b(bVar, i10);
    }

    public static final <T> b<T> o(b<? extends T> bVar, Function2<? super T, ? super c<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.c(bVar, function2);
    }

    public static final <T> Object p(c<? super T> cVar, q<? extends T> qVar, c<? super Unit> cVar2) {
        return FlowKt__ChannelsKt.b(cVar, qVar, cVar2);
    }

    public static final <T> Object q(c<? super T> cVar, b<? extends T> bVar, c<? super Unit> cVar2) {
        return FlowKt__CollectKt.c(cVar, bVar, cVar2);
    }

    public static final void r(c<?> cVar) {
        g.a(cVar);
    }

    public static final <T> b<T> s(b<? extends T> bVar) {
        return FlowKt__TransformKt.a(bVar);
    }

    public static final <T> Object t(b<? extends T> bVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.a(bVar, cVar);
    }

    public static final <T> Object u(b<? extends T> bVar, Function2<? super T, ? super c<? super Boolean>, ? extends Object> function2, c<? super T> cVar) {
        return FlowKt__ReduceKt.b(bVar, function2, cVar);
    }

    public static final <T> b<T> v(Function2<? super c<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        return e.b(function2);
    }

    public static final <T1, T2, R> b<R> w(b<? extends T1> bVar, b<? extends T2> bVar2, n<? super T1, ? super T2, ? super c<? super R>, ? extends Object> nVar) {
        return FlowKt__ZipKt.d(bVar, bVar2, nVar);
    }

    public static final <T> b<T> x(T t10) {
        return e.c(t10);
    }

    public static final <T> b<T> y(b<? extends T> bVar, CoroutineContext coroutineContext) {
        return f.e(bVar, coroutineContext);
    }

    public static final <T> s1 z(b<? extends T> bVar, k0 k0Var) {
        return FlowKt__CollectKt.d(bVar, k0Var);
    }
}
