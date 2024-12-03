package com.leanplum.actions.internal;

import com.leanplum.ActionContext;
import com.leanplum.actions.MessageDisplayListener;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.Log;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onDismiss"}, k = 3, mv = {1, 4, 2})
final class ActionManagerExecutionKt$performActionsImpl$1 implements ActionDidDismiss {
    final /* synthetic */ ActionContext $currentContext;
    final /* synthetic */ ActionManager $this_performActionsImpl;

    ActionManagerExecutionKt$performActionsImpl$1(ActionManager actionManager, ActionContext actionContext) {
        this.$this_performActionsImpl = actionManager;
        this.$currentContext = actionContext;
    }

    public final void onDismiss() {
        Log.d("[ActionManager]: actionDidDismiss: " + this.$currentContext + '.', new Object[0]);
        MessageDisplayListener messageDisplayListener = this.$this_performActionsImpl.getMessageDisplayListener();
        if (messageDisplayListener != null) {
            messageDisplayListener.onMessageDismissed(this.$currentContext);
        }
        this.$this_performActionsImpl.setCurrentAction((Action) null);
        ActionManagerExecutionKt.performActions(this.$this_performActionsImpl);
    }
}
