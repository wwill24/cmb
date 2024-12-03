package com.leanplum.actions;

import com.leanplum.ActionContext;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/leanplum/actions/MessageDisplayListener;", "", "onActionExecuted", "", "name", "", "action", "Lcom/leanplum/ActionContext;", "onMessageDismissed", "onMessageDisplayed", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public interface MessageDisplayListener {
    void onActionExecuted(String str, ActionContext actionContext);

    void onMessageDismissed(ActionContext actionContext);

    void onMessageDisplayed(ActionContext actionContext);
}
