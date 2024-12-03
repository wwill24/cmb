package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/squareup/workflow1/e;", "RenderingT", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "rendering", "Lcom/squareup/workflow1/TreeSnapshot;", "b", "Lcom/squareup/workflow1/TreeSnapshot;", "()Lcom/squareup/workflow1/TreeSnapshot;", "snapshot", "<init>", "(Ljava/lang/Object;Lcom/squareup/workflow1/TreeSnapshot;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class e<RenderingT> {

    /* renamed from: a  reason: collision with root package name */
    private final RenderingT f23085a;

    /* renamed from: b  reason: collision with root package name */
    private final TreeSnapshot f23086b;

    public e(RenderingT renderingt, TreeSnapshot treeSnapshot) {
        j.g(treeSnapshot, "snapshot");
        this.f23085a = renderingt;
        this.f23086b = treeSnapshot;
    }

    public final RenderingT a() {
        return this.f23085a;
    }

    public final TreeSnapshot b() {
        return this.f23086b;
    }
}
