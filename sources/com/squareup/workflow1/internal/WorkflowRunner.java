package com.squareup.workflow1.internal;

import com.squareup.workflow1.TreeSnapshot;
import com.squareup.workflow1.e;
import com.squareup.workflow1.h;
import com.squareup.workflow1.k;
import com.squareup.workflow1.m;
import com.squareup.workflow1.n;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.selects.b;

@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004BI\u0012\u0006\u0010$\u001a\u00020#\u0012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020%\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005J\u001b\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bR*\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00028\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u001eR0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/squareup/workflow1/internal/WorkflowRunner;", "PropsT", "OutputT", "RenderingT", "", "Lcom/squareup/workflow1/e;", "g", "Lcom/squareup/workflow1/n;", "f", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "e", "Lcom/squareup/workflow1/h;", "a", "Lcom/squareup/workflow1/h;", "workflow", "Lcom/squareup/workflow1/internal/c;", "b", "Lcom/squareup/workflow1/internal/c;", "idCounter", "c", "Ljava/lang/Object;", "currentProps", "Lkotlinx/coroutines/channels/q;", "d", "Lkotlinx/coroutines/channels/q;", "getPropsChannel$annotations", "()V", "propsChannel", "Lcom/squareup/workflow1/internal/WorkflowNode;", "Lcom/squareup/workflow1/internal/WorkflowNode;", "rootNode", "Lkotlinx/coroutines/k0;", "scope", "Lcom/squareup/workflow1/k;", "protoWorkflow", "Lkotlinx/coroutines/flow/r;", "props", "Lcom/squareup/workflow1/TreeSnapshot;", "snapshot", "Lcom/squareup/workflow1/m;", "interceptor", "<init>", "(Lkotlinx/coroutines/k0;Lcom/squareup/workflow1/k;Lkotlinx/coroutines/flow/r;Lcom/squareup/workflow1/TreeSnapshot;Lcom/squareup/workflow1/m;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class WorkflowRunner<PropsT, OutputT, RenderingT> {

    /* renamed from: a  reason: collision with root package name */
    private final h<PropsT, ?, OutputT, RenderingT> f23114a;

    /* renamed from: b  reason: collision with root package name */
    private final c f23115b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public PropsT f23116c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final q<PropsT> f23117d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final WorkflowNode<PropsT, ? extends Object, OutputT, RenderingT> f23118e;

    public WorkflowRunner(k0 k0Var, k<? super PropsT, ? extends OutputT, ? extends RenderingT> kVar, r<? extends PropsT> rVar, TreeSnapshot treeSnapshot, m mVar) {
        k0 k0Var2 = k0Var;
        r<? extends PropsT> rVar2 = rVar;
        j.g(k0Var2, "scope");
        j.g(kVar, "protoWorkflow");
        j.g(rVar2, "props");
        m mVar2 = mVar;
        j.g(mVar2, "interceptor");
        h<? super PropsT, ?, ? extends OutputT, ? extends RenderingT> b10 = kVar.b();
        this.f23114a = b10;
        c cVar = new c();
        this.f23115b = cVar;
        this.f23116c = rVar.getValue();
        this.f23117d = d.E(d.o(rVar2, new WorkflowRunner$propsChannel$1(this, (c<? super WorkflowRunner$propsChannel$1>) null)), k0Var2);
        this.f23118e = new WorkflowNode(i.b(b10, (String) null, 1, (Object) null), b10, this.f23116c, treeSnapshot, k0Var.G(), (Function1) null, (m.c) null, mVar2, cVar, 96, (DefaultConstructorMarker) null);
    }

    public final void e(CancellationException cancellationException) {
        this.f23118e.d(cancellationException);
    }

    public final Object f(c<? super n<? extends OutputT>> cVar) {
        b bVar = new b(cVar);
        try {
            if (!this.f23117d.j()) {
                bVar.z(this.f23117d.w(), new WorkflowRunner$nextOutput$2$1(this, (c<? super WorkflowRunner$nextOutput$2$1>) null));
            }
            this.f23118e.p(bVar);
        } catch (Throwable th2) {
            bVar.d0(th2);
        }
        Object c02 = bVar.c0();
        if (c02 == b.d()) {
            f.c(cVar);
        }
        return c02;
    }

    public final e<RenderingT> g() {
        return new e<>(this.f23118e.m(this.f23114a, this.f23116c), this.f23118e.o(this.f23114a));
    }
}
