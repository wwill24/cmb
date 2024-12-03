package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.google.firebase.sessions.FirebaseSessions", f = "FirebaseSessions.kt", l = {111, 134, 149}, m = "initiateSessionStart")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final class FirebaseSessions$initiateSessionStart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseSessions this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirebaseSessions$initiateSessionStart$1(FirebaseSessions firebaseSessions, c<? super FirebaseSessions$initiateSessionStart$1> cVar) {
        super(cVar);
        this.this$0 = firebaseSessions;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initiateSessionStart((SessionDetails) null, this);
    }
}
