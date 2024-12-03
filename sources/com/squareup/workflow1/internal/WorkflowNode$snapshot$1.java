package com.squareup.workflow1.internal;

import com.squareup.workflow1.TreeSnapshot;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"PropsT", "StateT", "OutputT", "RenderingT", "", "Lcom/squareup/workflow1/internal/h;", "Lcom/squareup/workflow1/TreeSnapshot;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class WorkflowNode$snapshot$1 extends Lambda implements Function0<Map<h, ? extends TreeSnapshot>> {
    final /* synthetic */ Map<h, TreeSnapshot> $childSnapshots;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowNode$snapshot$1(Map<h, TreeSnapshot> map) {
        super(0);
        this.$childSnapshots = map;
    }

    public final Map<h, TreeSnapshot> invoke() {
        return this.$childSnapshots;
    }
}
