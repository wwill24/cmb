package com.squareup.workflow1;

import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0001J!\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0010\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00012\"\u0010\u000f\u001a\u001e0\u000eR\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"com/squareup/workflow1/WorkflowInterceptorKt$intercept$1", "Lcom/squareup/workflow1/h;", "props", "Lcom/squareup/workflow1/Snapshot;", "snapshot", "d", "(Ljava/lang/Object;Lcom/squareup/workflow1/Snapshot;)Ljava/lang/Object;", "old", "new", "state", "e", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "renderProps", "renderState", "Lcom/squareup/workflow1/h$a;", "context", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/squareup/workflow1/h$a;)Ljava/lang/Object;", "g", "(Ljava/lang/Object;)Lcom/squareup/workflow1/Snapshot;", "", "toString", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class WorkflowInterceptorKt$intercept$1 extends h<P, S, O, R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f23073a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h<P, S, O, R> f23074b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m.c f23075c;

    WorkflowInterceptorKt$intercept$1(m mVar, h<? super P, S, ? extends O, ? extends R> hVar, m.c cVar) {
        this.f23073a = mVar;
        this.f23074b = hVar;
        this.f23075c = cVar;
    }

    public S d(P p10, Snapshot snapshot) {
        return this.f23073a.c(p10, snapshot, new WorkflowInterceptorKt$intercept$1$initialState$1(this.f23074b), this.f23075c);
    }

    public S e(P p10, P p11, S s10) {
        return this.f23073a.e(p10, p11, s10, new WorkflowInterceptorKt$intercept$1$onPropsChanged$1(this.f23074b), this.f23075c);
    }

    public R f(P p10, S s10, h<? super P, S, ? extends O, ? extends R>.a aVar) {
        j.g(aVar, IdentityHttpResponse.CONTEXT);
        return this.f23073a.a(p10, s10, aVar, new WorkflowInterceptorKt$intercept$1$render$1(aVar, this.f23074b, this), this.f23075c);
    }

    public Snapshot g(S s10) {
        return this.f23073a.b(s10, new WorkflowInterceptorKt$intercept$1$snapshotState$1(this.f23074b), this.f23075c);
    }

    public String toString() {
        return "InterceptedWorkflow(" + this.f23074b + ", " + this + "@intercept)";
    }
}
