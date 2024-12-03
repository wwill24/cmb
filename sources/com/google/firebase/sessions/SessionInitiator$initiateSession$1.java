package com.google.firebase.sessions;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.google.firebase.sessions.SessionInitiator$initiateSession$1", f = "SessionInitiator.kt", l = {63}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class SessionInitiator$initiateSession$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ SessionDetails $sessionDetails;
    int label;
    final /* synthetic */ SessionInitiator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionInitiator$initiateSession$1(SessionInitiator sessionInitiator, SessionDetails sessionDetails, c<? super SessionInitiator$initiateSession$1> cVar) {
        super(2, cVar);
        this.this$0 = sessionInitiator;
        this.$sessionDetails = sessionDetails;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SessionInitiator$initiateSession$1(this.this$0, this.$sessionDetails, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SessionInitiator$initiateSession$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            SessionInitiateListener access$getSessionInitiateListener$p = this.this$0.sessionInitiateListener;
            SessionDetails sessionDetails = this.$sessionDetails;
            this.label = 1;
            if (access$getSessionInitiateListener$p.onInitiateSession(sessionDetails, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
