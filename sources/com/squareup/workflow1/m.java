package com.squareup.workflow1;

import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.TlsProceed;
import pk.n;
import pk.o;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002!\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JQ\u0010\u000f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J[\u0010\u0015\u001a\u00028\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0001\u0010\u001e\u001a\u00028\u0003\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\u0017\"\u0004\b\u0003\u0010\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001b22\u0010\u000e\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001d\u0012\u0004\u0012\u00028\u00030\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ=\u0010!\u001a\u0004\u0018\u00010\u000b\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0013\u001a\u00028\u00002\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000b0 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/squareup/workflow1/m;", "", "Lkotlinx/coroutines/k0;", "workflowScope", "Lcom/squareup/workflow1/m$c;", "session", "", "d", "P", "S", "props", "Lcom/squareup/workflow1/Snapshot;", "snapshot", "Lkotlin/Function2;", "proceed", "c", "(Ljava/lang/Object;Lcom/squareup/workflow1/Snapshot;Lkotlin/jvm/functions/Function2;Lcom/squareup/workflow1/m$c;)Ljava/lang/Object;", "old", "new", "state", "Lkotlin/Function3;", "e", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lpk/n;Lcom/squareup/workflow1/m$c;)Ljava/lang/Object;", "O", "R", "renderProps", "renderState", "Lcom/squareup/workflow1/a;", "context", "Lcom/squareup/workflow1/m$b;", "a", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/squareup/workflow1/a;Lpk/n;Lcom/squareup/workflow1/m$c;)Ljava/lang/Object;", "Lkotlin/Function1;", "b", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lcom/squareup/workflow1/m$c;)Lcom/squareup/workflow1/Snapshot;", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public interface m {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static <P, S> S a(m mVar, P p10, Snapshot snapshot, Function2<? super P, ? super Snapshot, ? extends S> function2, c cVar) {
            j.g(mVar, "this");
            j.g(function2, TlsProceed.ELEMENT);
            j.g(cVar, Session.ELEMENT);
            return function2.invoke(p10, snapshot);
        }

        public static <P, S> S b(m mVar, P p10, P p11, S s10, n<? super P, ? super P, ? super S, ? extends S> nVar, c cVar) {
            j.g(mVar, "this");
            j.g(nVar, TlsProceed.ELEMENT);
            j.g(cVar, Session.ELEMENT);
            return nVar.l(p10, p11, s10);
        }

        public static <P, S, O, R> R c(m mVar, P p10, S s10, a<? extends P, S, ? super O> aVar, n<? super P, ? super S, ? super b<P, S, O>, ? extends R> nVar, c cVar) {
            j.g(mVar, "this");
            j.g(aVar, IdentityHttpResponse.CONTEXT);
            j.g(nVar, TlsProceed.ELEMENT);
            j.g(cVar, Session.ELEMENT);
            return nVar.l(p10, s10, null);
        }

        public static void d(m mVar, k0 k0Var, c cVar) {
            j.g(mVar, "this");
            j.g(k0Var, "workflowScope");
            j.g(cVar, Session.ELEMENT);
        }

        public static <S> Snapshot e(m mVar, S s10, Function1<? super S, Snapshot> function1, c cVar) {
            j.g(mVar, "this");
            j.g(function1, TlsProceed.ELEMENT);
            j.g(cVar, Session.ELEMENT);
            return function1.invoke(s10);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004JH\u0010\n\u001a\u00020\b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052$\u0010\t\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0016Jh\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007\u0012\u0004\u0012\u00020\b0\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JÇ\u0001\u0010\u001a\u001a\u00028\u0005\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u00142\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00152\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\f\u001a\u00020\u000b2$\u0010\u0018\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u00072T\u0010\t\u001aP\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0015\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u000b\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0007\u0012\u0004\u0012\u00028\u00050\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/squareup/workflow1/m$b;", "P", "S", "O", "", "Lcom/squareup/workflow1/l;", "action", "Lkotlin/Function1;", "", "proceed", "c", "", "key", "Lkotlin/coroutines/c;", "sideEffect", "Lkotlin/Function2;", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "CP", "CO", "CR", "Lcom/squareup/workflow1/k;", "child", "childProps", "handler", "Lkotlin/Function4;", "a", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lpk/o;)Ljava/lang/Object;", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public interface b<P, S, O> {
        <CP, CO, CR> CR a(k<? super CP, ? extends CO, ? extends CR> kVar, CP cp, String str, Function1<? super CO, ? extends l<? super P, S, ? extends O>> function1, o<? super k<? super CP, ? extends CO, ? extends CR>, ? super CP, ? super String, ? super Function1<? super CO, ? extends l<? super P, S, ? extends O>>, ? extends CR> oVar);

        void b(String str, Function1<? super kotlin.coroutines.c<? super Unit>, ? extends Object> function1, Function2<? super String, ? super Function1<? super kotlin.coroutines.c<? super Unit>, ? extends Object>, Unit> function2);

        void c(l<? super P, S, ? extends O> lVar, Function1<? super l<? super P, S, ? extends O>, Unit> function1);
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/squareup/workflow1/m$c;", "", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public interface c {
    }

    <P, S, O, R> R a(P p10, S s10, a<? extends P, S, ? super O> aVar, n<? super P, ? super S, ? super b<P, S, O>, ? extends R> nVar, c cVar);

    <S> Snapshot b(S s10, Function1<? super S, Snapshot> function1, c cVar);

    <P, S> S c(P p10, Snapshot snapshot, Function2<? super P, ? super Snapshot, ? extends S> function2, c cVar);

    void d(k0 k0Var, c cVar);

    <P, S> S e(P p10, P p11, S s10, n<? super P, ? super P, ? super S, ? extends S> nVar, c cVar);
}
