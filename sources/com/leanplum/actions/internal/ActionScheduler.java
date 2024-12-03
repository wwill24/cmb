package com.leanplum.actions.internal;

import com.leanplum.internal.OperationQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/leanplum/actions/internal/ActionScheduler;", "", "()V", "schedule", "", "action", "Lcom/leanplum/actions/internal/Action;", "delaySeconds", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public class ActionScheduler {
    public void schedule(Action action, int i10) {
        j.g(action, "action");
        OperationQueue.sharedInstance().addOperationAfterDelay(new ActionScheduler$sam$java_lang_Runnable$0(new ActionScheduler$schedule$appendActionRunnable$1(action)), ((long) i10) * 1000);
    }
}
