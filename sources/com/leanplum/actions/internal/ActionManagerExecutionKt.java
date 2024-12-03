package com.leanplum.actions.internal;

import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.actions.MessageDisplayChoice;
import com.leanplum.actions.MessageDisplayController;
import com.leanplum.actions.MessageDisplayListener;
import com.leanplum.actions.internal.Action;
import com.leanplum.callbacks.ActionCallback;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\n\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u0002H\u0003\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"appendAction", "", "Lcom/leanplum/internal/ActionManager;", "action", "Lcom/leanplum/actions/internal/Action;", "appendActions", "actions", "", "dismissCurrentAction", "insertAction", "insertActions", "performActions", "performActionsImpl", "prioritizePushNotificationActions", "recordImpression", "AndroidSDKCore_release"}, k = 2, mv = {1, 4, 2})
public final class ActionManagerExecutionKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MessageDisplayChoice.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageDisplayChoice.Type.DISCARD.ordinal()] = 1;
            iArr[MessageDisplayChoice.Type.DELAY.ordinal()] = 2;
            int[] iArr2 = new int[Action.ActionType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Action.ActionType.CHAINED.ordinal()] = 1;
            iArr2[Action.ActionType.SINGLE.ordinal()] = 2;
            iArr2[Action.ActionType.EMBEDDED.ordinal()] = 3;
        }
    }

    public static final void appendAction(ActionManager actionManager, Action action) {
        j.g(actionManager, "$this$appendAction");
        j.g(action, "action");
        if (actionManager.isEnabled()) {
            actionManager.getQueue().pushBack(action);
            performActions(actionManager);
        }
    }

    public static final void appendActions(ActionManager actionManager, List<Action> list) {
        j.g(actionManager, "$this$appendActions");
        j.g(list, "actions");
        if (actionManager.isEnabled()) {
            actionManager.getQueue().pushBack(list);
            performActions(actionManager);
        }
    }

    public static final void dismissCurrentAction(ActionManager actionManager) {
        ActionContext context;
        ActionDefinition findDefinition;
        ActionCallback dismissHandler;
        j.g(actionManager, "$this$dismissCurrentAction");
        Action currentAction = actionManager.getCurrentAction();
        if (currentAction != null && (context = currentAction.getContext()) != null && (findDefinition = actionManager.getDefinitions().findDefinition(context.actionName())) != null && (dismissHandler = findDefinition.getDismissHandler()) != null) {
            Log.d("[ActionManager]: dismiss requested for: " + context + '.', new Object[0]);
            try {
                dismissHandler.onResponse(context);
            } catch (Throwable th2) {
                Log.e("Cannot dismiss in-app", th2);
            }
        }
    }

    public static final void insertAction(ActionManager actionManager, Action action) {
        j.g(actionManager, "$this$insertAction");
        j.g(action, "action");
        if (actionManager.isEnabled()) {
            actionManager.getQueue().pushFront(action);
            performActions(actionManager);
        }
    }

    public static final void insertActions(ActionManager actionManager, List<Action> list) {
        j.g(actionManager, "$this$insertActions");
        j.g(list, "actions");
        if (actionManager.isEnabled()) {
            actionManager.getQueue().pushFront(list);
            performActions(actionManager);
        }
    }

    public static final void performActions(ActionManager actionManager) {
        j.g(actionManager, "$this$performActions");
        Log.d("[ActionManager]: performing all available actions: " + actionManager.getQueue(), new Object[0]);
        Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new ActionManagerExecutionKt$performActions$1(actionManager));
    }

    /* access modifiers changed from: private */
    public static final void performActionsImpl(ActionManager actionManager) {
        MessageDisplayChoice messageDisplayChoice;
        MessageDisplayChoice.Type type;
        boolean z10;
        ActionCallback presentHandler;
        if (!actionManager.isPaused() && actionManager.isEnabled()) {
            if (actionManager.getCurrentAction() != null) {
                prioritizePushNotificationActions(actionManager);
                return;
            }
            Action pop = actionManager.getQueue().pop();
            if (pop != null) {
                actionManager.setCurrentAction(pop);
                ActionContext context = actionManager.getCurrentAction().getContext();
                Log.d("[ActionManager]: action popped from queue: " + context + '.', new Object[0]);
                if (actionManager.getCurrentAction().getActionType() != Action.ActionType.SINGLE || !LeanplumInternal.shouldSuppressMessage(context)) {
                    MessageDisplayController messageDisplayController = actionManager.getMessageDisplayController();
                    if (messageDisplayController != null) {
                        messageDisplayChoice = messageDisplayController.shouldDisplayMessage(context);
                    } else {
                        messageDisplayChoice = null;
                    }
                    if (messageDisplayChoice != null) {
                        type = messageDisplayChoice.getType();
                    } else {
                        type = null;
                    }
                    if (type != null) {
                        int i10 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                        if (i10 == 1) {
                            actionManager.setCurrentAction((Action) null);
                            performActions(actionManager);
                            return;
                        } else if (i10 == 2) {
                            Log.d("[ActionManager]: delaying action: " + context + " for " + messageDisplayChoice.getDelaySeconds() + "s.", new Object[0]);
                            if (messageDisplayChoice.getDelaySeconds() > 0) {
                                ActionScheduler scheduler = actionManager.getScheduler();
                                Action currentAction = actionManager.getCurrentAction();
                                j.f(currentAction, "currentAction");
                                scheduler.schedule(currentAction, messageDisplayChoice.getDelaySeconds());
                            } else {
                                ActionQueue delayedQueue = actionManager.getDelayedQueue();
                                Action currentAction2 = actionManager.getCurrentAction();
                                j.f(currentAction2, "currentAction");
                                delayedQueue.pushBack(currentAction2);
                            }
                            actionManager.setCurrentAction((Action) null);
                            performActions(actionManager);
                            return;
                        }
                    }
                    ActionDefinition findDefinition = actionManager.getDefinitions().findDefinition(context.actionName());
                    context.setActionDidDismiss(new ActionManagerExecutionKt$performActionsImpl$1(actionManager, context));
                    context.setActionDidExecute(new ActionManagerExecutionKt$performActionsImpl$2(actionManager));
                    if (findDefinition == null || (presentHandler = findDefinition.getPresentHandler()) == null) {
                        z10 = false;
                    } else {
                        z10 = presentHandler.onResponse(context);
                    }
                    if (!z10) {
                        Log.d("[ActionManager]: action NOT presented: " + context + '.', new Object[0]);
                        actionManager.setCurrentAction((Action) null);
                        performActions(actionManager);
                        return;
                    }
                    if (actionManager.getCurrentAction() != null) {
                        Action currentAction3 = actionManager.getCurrentAction();
                        j.f(currentAction3, "currentAction");
                        recordImpression(actionManager, currentAction3);
                    }
                    Log.i("[ActionManager]: action presented: " + context + '.', new Object[0]);
                    MessageDisplayListener messageDisplayListener = actionManager.getMessageDisplayListener();
                    if (messageDisplayListener != null) {
                        messageDisplayListener.onMessageDisplayed(context);
                    }
                    performActions(actionManager);
                    return;
                }
                Log.i("[ActionManager]: Local IAM caps reached, suppressing " + context, new Object[0]);
                actionManager.setCurrentAction((Action) null);
                performActions(actionManager);
            }
        }
    }

    private static final void prioritizePushNotificationActions(ActionManager actionManager) {
        Action first;
        if (actionManager.getDismissOnPushOpened() && (first = actionManager.getQueue().first()) != null && first.isNotification()) {
            dismissCurrentAction(actionManager);
        }
    }

    private static final void recordImpression(ActionManager actionManager, Action action) {
        Integer num;
        try {
            ActionContext context = action.getContext();
            int i10 = WhenMappings.$EnumSwitchMapping$1[action.getActionType().ordinal()];
            if (i10 == 1) {
                ActionDefinition findDefinition = actionManager.getDefinitions().findDefinition(context.actionName());
                if (findDefinition != null) {
                    num = Integer.valueOf(findDefinition.getKind());
                } else {
                    num = null;
                }
                if (num != null) {
                    if (num.intValue() == 2) {
                        actionManager.recordChainedActionImpression(context.getMessageId());
                        return;
                    }
                }
                actionManager.recordMessageImpression(context.getMessageId());
            } else if (i10 == 2) {
                actionManager.recordMessageImpression(context.getMessageId());
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }
}
