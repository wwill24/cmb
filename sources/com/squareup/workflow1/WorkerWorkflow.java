package com.squareup.workflow1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import wk.m;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00022\u00020\u0006B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\b\u001a\u00020\u0007H\u0016J'\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0011\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012JH\u0010\u0017\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0014\u001a\u00020\u00042(\u0010\u0016\u001a$0\u0015R \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$¨\u0006("}, d2 = {"Lcom/squareup/workflow1/WorkerWorkflow;", "OutputT", "Lcom/squareup/workflow1/h;", "Lcom/squareup/workflow1/j;", "", "", "Lcom/squareup/workflow1/c;", "", "a", "props", "Lcom/squareup/workflow1/Snapshot;", "snapshot", "i", "(Lcom/squareup/workflow1/j;Lcom/squareup/workflow1/Snapshot;)Ljava/lang/Integer;", "old", "new", "state", "j", "(Lcom/squareup/workflow1/j;Lcom/squareup/workflow1/j;I)Ljava/lang/Integer;", "renderProps", "renderState", "Lcom/squareup/workflow1/h$a;", "context", "k", "l", "Lwk/m;", "Lwk/m;", "getWorkerType", "()Lwk/m;", "workerType", "b", "Ljava/lang/String;", "key", "Lcom/squareup/workflow1/WorkflowIdentifier;", "c", "Lcom/squareup/workflow1/WorkflowIdentifier;", "()Lcom/squareup/workflow1/WorkflowIdentifier;", "realIdentifier", "<init>", "(Lwk/m;Ljava/lang/String;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public final class WorkerWorkflow<OutputT> extends h<j<? extends OutputT>, Integer, OutputT, Unit> implements c {

    /* renamed from: a  reason: collision with root package name */
    private final m f23062a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f23063b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkflowIdentifier f23064c;

    public WorkerWorkflow(m mVar, String str) {
        j.g(mVar, "workerType");
        j.g(str, SDKConstants.PARAM_KEY);
        this.f23062a = mVar;
        this.f23063b = str;
        this.f23064c = o.n(mVar);
    }

    public String a() {
        return j.p("worker ", this.f23062a);
    }

    public WorkflowIdentifier c() {
        return this.f23064c;
    }

    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
        return j((j) obj, (j) obj2, ((Number) obj3).intValue());
    }

    public /* bridge */ /* synthetic */ Object f(Object obj, Object obj2, h.a aVar) {
        k((j) obj, ((Number) obj2).intValue(), aVar);
        return Unit.f32013a;
    }

    public /* bridge */ /* synthetic */ Snapshot g(Object obj) {
        return l(((Number) obj).intValue());
    }

    /* renamed from: i */
    public Integer d(j<? extends OutputT> jVar, Snapshot snapshot) {
        j.g(jVar, "props");
        return 0;
    }

    public Integer j(j<? extends OutputT> jVar, j<? extends OutputT> jVar2, int i10) {
        j.g(jVar, "old");
        j.g(jVar2, "new");
        if (!jVar.a(jVar2)) {
            i10++;
        }
        return Integer.valueOf(i10);
    }

    public void k(j<? extends OutputT> jVar, int i10, h<? super j<? extends OutputT>, Integer, ? extends OutputT, Unit>.a aVar) {
        j.g(jVar, "renderProps");
        j.g(aVar, IdentityHttpResponse.CONTEXT);
        aVar.a(String.valueOf(i10), new WorkerWorkflow$render$1(jVar, this, aVar, (c<? super WorkerWorkflow$render$1>) null));
    }

    public Snapshot l(int i10) {
        return null;
    }
}
