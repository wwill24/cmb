package com.leanplum.actions.internal;

import com.leanplum.ActionContext;
import com.leanplum.actions.MessageDisplayListener;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "actionNamedContext", "Lcom/leanplum/ActionContext;", "onActionExecuted"}, k = 3, mv = {1, 4, 2})
final class ActionManagerExecutionKt$performActionsImpl$2 implements ActionDidExecute {
    final /* synthetic */ ActionManager $this_performActionsImpl;

    ActionManagerExecutionKt$performActionsImpl$2(ActionManager actionManager) {
        this.$this_performActionsImpl = actionManager;
    }

    public final void onActionExecuted(ActionContext actionContext) {
        j.g(actionContext, "actionNamedContext");
        Log.d("[ActionManager]: actionDidExecute: " + actionContext + '.', new Object[0]);
        MessageDisplayListener messageDisplayListener = this.$this_performActionsImpl.getMessageDisplayListener();
        if (messageDisplayListener != null) {
            String actionName = actionContext.actionName();
            j.f(actionName, "actionNamedContext.actionName()");
            messageDisplayListener.onActionExecuted(actionName, actionContext);
        }
    }
}
