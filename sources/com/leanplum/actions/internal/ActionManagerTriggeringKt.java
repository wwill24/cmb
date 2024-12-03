package com.leanplum.actions.internal;

import com.leanplum.ActionContext;
import com.leanplum.actions.MessageDisplayController;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.Log;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002¨\u0006\u000b"}, d2 = {"trigger", "", "Lcom/leanplum/internal/ActionManager;", "context", "Lcom/leanplum/ActionContext;", "priority", "Lcom/leanplum/actions/internal/Priority;", "contexts", "", "Lcom/leanplum/actions/internal/ActionsTrigger;", "triggerDelayedMessages", "AndroidSDKCore_release"}, k = 2, mv = {1, 4, 2})
public final class ActionManagerTriggeringKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Priority.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Priority.HIGH.ordinal()] = 1;
            iArr[Priority.DEFAULT.ordinal()] = 2;
        }
    }

    public static final void trigger(ActionManager actionManager, ActionContext actionContext, Priority priority) {
        j.g(actionManager, "$this$trigger");
        j.g(actionContext, IdentityHttpResponse.CONTEXT);
        j.g(priority, JingleS5BTransportCandidate.ATTR_PRIORITY);
        trigger$default(actionManager, p.e(actionContext), priority, (ActionsTrigger) null, 4, (Object) null);
    }

    public static /* synthetic */ void trigger$default(ActionManager actionManager, ActionContext actionContext, Priority priority, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            priority = Priority.DEFAULT;
        }
        trigger(actionManager, actionContext, priority);
    }

    public static final void triggerDelayedMessages(ActionManager actionManager) {
        j.g(actionManager, "$this$triggerDelayedMessages");
        ActionManagerExecutionKt.appendActions(actionManager, actionManager.getDelayedQueue().popAll());
    }

    public static final void trigger(ActionManager actionManager, List<? extends ActionContext> list, Priority priority, ActionsTrigger actionsTrigger) {
        List<ActionContext> list2;
        j.g(actionManager, "$this$trigger");
        j.g(list, "contexts");
        j.g(priority, JingleS5BTransportCandidate.ATTR_PRIORITY);
        if (!list.isEmpty()) {
            MessageDisplayController messageDisplayController = actionManager.getMessageDisplayController();
            if (messageDisplayController == null || (list2 = messageDisplayController.prioritizeMessages(list, actionsTrigger)) == null) {
                list2 = p.e(CollectionsKt___CollectionsKt.N(list));
            }
            ArrayList arrayList = new ArrayList(r.t(list2, 10));
            for (ActionContext create : list2) {
                arrayList.add(Action.Companion.create(create));
            }
            Log.d("[ActionManager]: triggering with priority: " + priority.name() + " and actions: " + list2, new Object[0]);
            int i10 = WhenMappings.$EnumSwitchMapping$0[priority.ordinal()];
            if (i10 == 1) {
                ActionManagerExecutionKt.insertActions(actionManager, arrayList);
            } else if (i10 == 2) {
                ActionManagerExecutionKt.appendActions(actionManager, arrayList);
            }
        }
    }

    public static /* synthetic */ void trigger$default(ActionManager actionManager, List list, Priority priority, ActionsTrigger actionsTrigger, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            priority = Priority.DEFAULT;
        }
        if ((i10 & 4) != 0) {
            actionsTrigger = null;
        }
        trigger(actionManager, list, priority, actionsTrigger);
    }
}
