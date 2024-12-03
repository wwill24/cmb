package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.h;
import com.squareup.workflow1.internal.d;
import com.squareup.workflow1.k;
import com.squareup.workflow1.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u00052\u001c\u0012\u0018\u0012\u0016\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u0006B_\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030\u0007\u0012$\u0010%\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00120\u0011\u0012\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030&¢\u0006\u0004\b5\u00106J\"\u0010\f\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\n\u001a\u00020\tJD\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0005\u0010\r\"\u0004\b\u0006\u0010\u000e\"\u0004\b\u0007\u0010\u000f\"\u0004\b\b\u0010\u00102$\u0010\u0013\u001a \u0012\u0004\u0012\u00028\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00120\u0011J5\u0010\u001b\u001a\u00028\u0005\"\u0004\b\u0005\u0010\u00162\u0016\u0010\u0018\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019R%\u0010\u0018\u001a\u0010\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030\u00078\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R4\u0010%\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00120\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R+\u0010*\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030&8\u0006¢\u0006\f\n\u0004\b\u001e\u0010'\u001a\u0004\b(\u0010)R8\u00101\u001a\u0018\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00008\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00104\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b+\u00103¨\u00067"}, d2 = {"Lcom/squareup/workflow1/internal/g;", "ChildPropsT", "ChildOutputT", "ParentPropsT", "ParentStateT", "ParentOutputT", "Lcom/squareup/workflow1/internal/d$a;", "Lcom/squareup/workflow1/k;", "otherWorkflow", "", "key", "", "h", "CO", "CP", "S", "O", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "newHandler", "", "j", "R", "Lcom/squareup/workflow1/h;", "workflow", "", "props", "i", "(Lcom/squareup/workflow1/h;Ljava/lang/Object;)Ljava/lang/Object;", "output", "c", "a", "Lcom/squareup/workflow1/k;", "f", "()Lcom/squareup/workflow1/k;", "b", "Lkotlin/jvm/functions/Function1;", "handler", "Lcom/squareup/workflow1/internal/WorkflowNode;", "Lcom/squareup/workflow1/internal/WorkflowNode;", "g", "()Lcom/squareup/workflow1/internal/WorkflowNode;", "workflowNode", "d", "Lcom/squareup/workflow1/internal/g;", "e", "()Lcom/squareup/workflow1/internal/g;", "k", "(Lcom/squareup/workflow1/internal/g;)V", "nextListNode", "Lcom/squareup/workflow1/internal/h;", "()Lcom/squareup/workflow1/internal/h;", "id", "<init>", "(Lcom/squareup/workflow1/k;Lkotlin/jvm/functions/Function1;Lcom/squareup/workflow1/internal/WorkflowNode;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class g<ChildPropsT, ChildOutputT, ParentPropsT, ParentStateT, ParentOutputT> implements d.a<g<?, ?, ?, ?, ?>> {

    /* renamed from: a  reason: collision with root package name */
    private final k<?, ChildOutputT, ?> f23131a;

    /* renamed from: b  reason: collision with root package name */
    private Function1<? super ChildOutputT, ? extends l<? super ParentPropsT, ParentStateT, ? extends ParentOutputT>> f23132b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkflowNode<ChildPropsT, ?, ChildOutputT, ?> f23133c;

    /* renamed from: d  reason: collision with root package name */
    private g<?, ?, ?, ?, ?> f23134d;

    public g(k<?, ? extends ChildOutputT, ?> kVar, Function1<? super ChildOutputT, ? extends l<? super ParentPropsT, ParentStateT, ? extends ParentOutputT>> function1, WorkflowNode<ChildPropsT, ?, ChildOutputT, ?> workflowNode) {
        j.g(kVar, "workflow");
        j.g(function1, "handler");
        j.g(workflowNode, "workflowNode");
        this.f23131a = kVar;
        this.f23132b = function1;
        this.f23133c = workflowNode;
    }

    public final l<ParentPropsT, ParentStateT, ParentOutputT> c(Object obj) {
        return (l) this.f23132b.invoke(obj);
    }

    public final h d() {
        return this.f23133c.g();
    }

    /* renamed from: e */
    public g<?, ?, ?, ?, ?> a() {
        return this.f23134d;
    }

    public final k<?, ChildOutputT, ?> f() {
        return this.f23131a;
    }

    public final WorkflowNode<ChildPropsT, ?, ChildOutputT, ?> g() {
        return this.f23133c;
    }

    public final boolean h(k<?, ?, ?> kVar, String str) {
        j.g(kVar, "otherWorkflow");
        j.g(str, SDKConstants.PARAM_KEY);
        return d().c(kVar, str);
    }

    public final <R> R i(h<?, ?, ?, ?> hVar, Object obj) {
        j.g(hVar, "workflow");
        return this.f23133c.m(hVar, obj);
    }

    public final <CO, CP, S, O> void j(Function1<? super CO, ? extends l<? super CP, S, ? extends O>> function1) {
        j.g(function1, "newHandler");
        this.f23132b = (Function1) p.d(function1, 1);
    }

    /* renamed from: k */
    public void b(g<?, ?, ?, ?, ?> gVar) {
        this.f23134d = gVar;
    }
}
