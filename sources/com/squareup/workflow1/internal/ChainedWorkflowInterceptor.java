package com.squareup.workflow1.internal;

import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.m;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.TlsProceed;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0004\b(\u0010)Jb\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0005H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016JQ\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u000e\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J[\u0010\u0019\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00012\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010 \u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u00012\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001e22\u0010\u0012\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0005\u0012\u0004\u0012\u00028\u00030\u00182\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J=\u0010#\u001a\u0004\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0017\u001a\u00028\u00002\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\"2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010%8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010&¨\u0006*"}, d2 = {"Lcom/squareup/workflow1/internal/ChainedWorkflowInterceptor;", "Lcom/squareup/workflow1/m;", "P", "S", "O", "Lcom/squareup/workflow1/m$b;", "inner", "g", "Lkotlinx/coroutines/k0;", "workflowScope", "Lcom/squareup/workflow1/m$c;", "session", "", "d", "props", "Lcom/squareup/workflow1/Snapshot;", "snapshot", "Lkotlin/Function2;", "proceed", "c", "(Ljava/lang/Object;Lcom/squareup/workflow1/Snapshot;Lkotlin/jvm/functions/Function2;Lcom/squareup/workflow1/m$c;)Ljava/lang/Object;", "old", "new", "state", "Lkotlin/Function3;", "e", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lpk/n;Lcom/squareup/workflow1/m$c;)Ljava/lang/Object;", "R", "renderProps", "renderState", "Lcom/squareup/workflow1/a;", "context", "a", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/squareup/workflow1/a;Lpk/n;Lcom/squareup/workflow1/m$c;)Ljava/lang/Object;", "Lkotlin/Function1;", "b", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lcom/squareup/workflow1/m$c;)Lcom/squareup/workflow1/Snapshot;", "", "Ljava/util/List;", "interceptors", "<init>", "(Ljava/util/List;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class ChainedWorkflowInterceptor implements m {

    /* renamed from: a  reason: collision with root package name */
    private final List<m> f23091a;

    public ChainedWorkflowInterceptor(List<? extends m> list) {
        j.g(list, "interceptors");
        this.f23091a = list;
    }

    /* access modifiers changed from: private */
    public final <P, S, O> m.b<P, S, O> g(m.b<P, S, O> bVar, m.b<P, S, O> bVar2) {
        if (bVar == null && bVar2 == null) {
            return null;
        }
        return bVar == null ? bVar2 : bVar2 == null ? bVar : new ChainedWorkflowInterceptor$wrap$1(bVar, bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: com.squareup.workflow1.internal.ChainedWorkflowInterceptor$onRender$chainedProceed$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.squareup.workflow1.internal.ChainedWorkflowInterceptor$onRender$chainedProceed$1$1} */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <P, S, O, R> R a(P r8, S r9, com.squareup.workflow1.a<? extends P, S, ? super O> r10, pk.n<? super P, ? super S, ? super com.squareup.workflow1.m.b<P, S, O>, ? extends R> r11, com.squareup.workflow1.m.c r12) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.g(r10, r0)
            java.lang.String r0 = "proceed"
            kotlin.jvm.internal.j.g(r11, r0)
            java.lang.String r0 = "session"
            kotlin.jvm.internal.j.g(r12, r0)
            java.util.List<com.squareup.workflow1.m> r0 = r7.f23091a
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0038
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L_0x001f:
            r6 = r11
            boolean r11 = r0.hasPrevious()
            if (r11 == 0) goto L_0x0037
            java.lang.Object r11 = r0.previous()
            r2 = r11
            com.squareup.workflow1.m r2 = (com.squareup.workflow1.m) r2
            com.squareup.workflow1.internal.ChainedWorkflowInterceptor$onRender$chainedProceed$1$1 r11 = new com.squareup.workflow1.internal.ChainedWorkflowInterceptor$onRender$chainedProceed$1$1
            r1 = r11
            r3 = r10
            r4 = r12
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x001f
        L_0x0037:
            r11 = r6
        L_0x0038:
            r10 = 0
            java.lang.Object r8 = r11.l(r8, r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.internal.ChainedWorkflowInterceptor.a(java.lang.Object, java.lang.Object, com.squareup.workflow1.a, pk.n, com.squareup.workflow1.m$c):java.lang.Object");
    }

    public <S> Snapshot b(S s10, Function1<? super S, Snapshot> function1, m.c cVar) {
        j.g(function1, TlsProceed.ELEMENT);
        j.g(cVar, Session.ELEMENT);
        List<m> list = this.f23091a;
        if (!list.isEmpty()) {
            ListIterator<m> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                function1 = new ChainedWorkflowInterceptor$onSnapshotState$chainedProceed$1$1(listIterator.previous(), function1, cVar);
            }
        }
        return function1.invoke(s10);
    }

    public <P, S> S c(P p10, Snapshot snapshot, Function2<? super P, ? super Snapshot, ? extends S> function2, m.c cVar) {
        j.g(function2, TlsProceed.ELEMENT);
        j.g(cVar, Session.ELEMENT);
        List<m> list = this.f23091a;
        if (!list.isEmpty()) {
            ListIterator<m> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                function2 = new ChainedWorkflowInterceptor$onInitialState$chainedProceed$1$1(listIterator.previous(), function2, cVar);
            }
        }
        return function2.invoke(p10, snapshot);
    }

    public void d(k0 k0Var, m.c cVar) {
        j.g(k0Var, "workflowScope");
        j.g(cVar, Session.ELEMENT);
        for (m d10 : this.f23091a) {
            d10.d(k0Var, cVar);
        }
    }

    public <P, S> S e(P p10, P p11, S s10, n<? super P, ? super P, ? super S, ? extends S> nVar, m.c cVar) {
        j.g(nVar, TlsProceed.ELEMENT);
        j.g(cVar, Session.ELEMENT);
        List<m> list = this.f23091a;
        if (!list.isEmpty()) {
            ListIterator<m> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                nVar = new ChainedWorkflowInterceptor$onPropsChanged$chainedProceed$1$1(listIterator.previous(), nVar, cVar);
            }
        }
        return nVar.l(p10, p11, s10);
    }
}
