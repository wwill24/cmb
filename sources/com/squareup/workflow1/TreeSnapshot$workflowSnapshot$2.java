package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/squareup/workflow1/Snapshot;", "a", "()Lcom/squareup/workflow1/Snapshot;"}, k = 3, mv = {1, 6, 0})
final class TreeSnapshot$workflowSnapshot$2 extends Lambda implements Function0<Snapshot> {
    final /* synthetic */ Snapshot $workflowSnapshot;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TreeSnapshot$workflowSnapshot$2(Snapshot snapshot) {
        super(0);
        this.$workflowSnapshot = snapshot;
    }

    /* renamed from: a */
    public final Snapshot invoke() {
        Snapshot snapshot = this.$workflowSnapshot;
        if (snapshot != null) {
            if (!(snapshot.b().H() == 0)) {
                return snapshot;
            }
        }
        return null;
    }
}
