package com.leanplum.actions.internal;

import com.leanplum.callbacks.VariablesChangedCallback;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.OperationQueue;
import com.leanplum.internal.Util;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/leanplum/actions/internal/ActionManagerExecutionKt$performActions$1", "Lcom/leanplum/callbacks/VariablesChangedCallback;", "variablesChanged", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class ActionManagerExecutionKt$performActions$1 extends VariablesChangedCallback {
    final /* synthetic */ ActionManager $this_performActions;

    ActionManagerExecutionKt$performActions$1(ActionManager actionManager) {
        this.$this_performActions = actionManager;
    }

    public void variablesChanged() {
        if (Util.isMainThread()) {
            ActionManagerExecutionKt.performActionsImpl(this.$this_performActions);
        } else {
            OperationQueue.sharedInstance().addUiOperation(new ActionManagerExecutionKt$performActions$1$variablesChanged$1(this));
        }
    }
}
