package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class e implements Continuation {
    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$1(task);
    }
}
