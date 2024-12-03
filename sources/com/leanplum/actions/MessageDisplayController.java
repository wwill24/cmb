package com.leanplum.actions;

import com.leanplum.ActionContext;
import com.leanplum.actions.internal.ActionsTrigger;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/leanplum/actions/MessageDisplayController;", "", "prioritizeMessages", "", "Lcom/leanplum/ActionContext;", "actions", "trigger", "Lcom/leanplum/actions/internal/ActionsTrigger;", "shouldDisplayMessage", "Lcom/leanplum/actions/MessageDisplayChoice;", "action", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public interface MessageDisplayController {
    List<ActionContext> prioritizeMessages(List<? extends ActionContext> list, ActionsTrigger actionsTrigger);

    MessageDisplayChoice shouldDisplayMessage(ActionContext actionContext);
}
