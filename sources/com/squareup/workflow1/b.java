package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004B#\u0012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00028\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\b*\u00180\u0007R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004H\u0016R\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00028\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/squareup/workflow1/b;", "P", "S", "O", "Lcom/squareup/workflow1/l;", "", "toString", "Lcom/squareup/workflow1/l$c;", "", "a", "Lcom/squareup/workflow1/j;", "c", "Lcom/squareup/workflow1/j;", "worker", "d", "Ljava/lang/String;", "renderKey", "e", "Ljava/lang/Object;", "output", "<init>", "(Lcom/squareup/workflow1/j;Ljava/lang/String;Ljava/lang/Object;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
final class b<P, S, O> extends l<P, S, O> {

    /* renamed from: c  reason: collision with root package name */
    private final j<?> f23081c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23082d;

    /* renamed from: e  reason: collision with root package name */
    private final O f23083e;

    public b(j<?> jVar, String str, O o10) {
        j.g(jVar, "worker");
        j.g(str, "renderKey");
        this.f23081c = jVar;
        this.f23082d = str;
        this.f23083e = o10;
    }

    public void a(l<? super P, S, ? extends O>.c cVar) {
        j.g(cVar, "<this>");
        cVar.d(this.f23083e);
    }

    public String toString() {
        return l.b(b.class).d() + "(worker=" + this.f23081c + ", key=\"" + this.f23082d + "\")";
    }
}
