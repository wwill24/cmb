package com.leanplum.actions.internal;

import com.leanplum.internal.ActionManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
final class ActionScheduler$schedule$appendActionRunnable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Action $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionScheduler$schedule$appendActionRunnable$1(Action action) {
        super(0);
        this.$action = action;
    }

    public final void invoke() {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        ActionManagerExecutionKt.appendAction(instance, this.$action);
    }
}
