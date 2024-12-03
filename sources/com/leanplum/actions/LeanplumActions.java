package com.leanplum.actions;

import com.leanplum.actions.internal.ActionManagerTriggeringKt;
import com.leanplum.internal.ActionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0007H\u0007¨\u0006\u0015"}, d2 = {"Lcom/leanplum/actions/LeanplumActions;", "", "()V", "isQueueEnabled", "", "isQueuePaused", "setContinueOnActivityResumed", "", "flag", "setDismissOnPushOpened", "setMessageDisplayController", "controller", "Lcom/leanplum/actions/MessageDisplayController;", "setMessageDisplayListener", "listener", "Lcom/leanplum/actions/MessageDisplayListener;", "setQueueEnabled", "enabled", "setQueuePaused", "paused", "triggerDelayedMessages", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class LeanplumActions {
    public static final LeanplumActions INSTANCE = new LeanplumActions();

    private LeanplumActions() {
    }

    public static final boolean isQueueEnabled() {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        return instance.isEnabled();
    }

    public static final boolean isQueuePaused() {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        return instance.isPaused();
    }

    public static final void setContinueOnActivityResumed(boolean z10) {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        instance.setContinueOnActivityResumed(z10);
    }

    public static final void setDismissOnPushOpened(boolean z10) {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        instance.setDismissOnPushOpened(z10);
    }

    public static final void setMessageDisplayController(MessageDisplayController messageDisplayController) {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        instance.setMessageDisplayController(messageDisplayController);
    }

    public static final void setMessageDisplayListener(MessageDisplayListener messageDisplayListener) {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        instance.setMessageDisplayListener(messageDisplayListener);
    }

    public static final void setQueueEnabled(boolean z10) {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        instance.setEnabled(z10);
    }

    public static final void setQueuePaused(boolean z10) {
        setContinueOnActivityResumed(!z10);
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        instance.setPaused(z10);
    }

    public static final void triggerDelayedMessages() {
        ActionManager instance = ActionManager.getInstance();
        j.f(instance, "ActionManager.getInstance()");
        ActionManagerTriggeringKt.triggerDelayedMessages(instance);
    }
}
