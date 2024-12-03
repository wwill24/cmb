package com.leanplum.actions.internal;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
final class ActionManagerExecutionKt$performActions$1$variablesChanged$1 implements Runnable {
    final /* synthetic */ ActionManagerExecutionKt$performActions$1 this$0;

    ActionManagerExecutionKt$performActions$1$variablesChanged$1(ActionManagerExecutionKt$performActions$1 actionManagerExecutionKt$performActions$1) {
        this.this$0 = actionManagerExecutionKt$performActions$1;
    }

    public final void run() {
        ActionManagerExecutionKt.performActionsImpl(this.this$0.$this_performActions);
    }
}
