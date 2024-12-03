package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$runManualCaptureEnabledChecker$1", f = "SelfieWorkflow.kt", l = {748}, m = "invokeSuspend")
final class SelfieWorkflow$runManualCaptureEnabledChecker$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ Ref$BooleanRef $stillChecking;
    int label;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$runManualCaptureEnabledChecker$1(Ref$BooleanRef ref$BooleanRef, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow selfieWorkflow, c<? super SelfieWorkflow$runManualCaptureEnabledChecker$1> cVar) {
        super(2, cVar);
        this.$stillChecking = ref$BooleanRef;
        this.$context = aVar;
        this.this$0 = selfieWorkflow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SelfieWorkflow$runManualCaptureEnabledChecker$1(this.$stillChecking, this.$context, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SelfieWorkflow$runManualCaptureEnabledChecker$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            gk.g.b(r7)
            r7 = r6
            goto L_0x002d
        L_0x0010:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0018:
            gk.g.b(r7)
            r7 = r6
        L_0x001c:
            kotlin.jvm.internal.Ref$BooleanRef r1 = r7.$stillChecking
            boolean r1 = r1.element
            if (r1 == 0) goto L_0x0045
            r3 = 1000(0x3e8, double:4.94E-321)
            r7.label = r2
            java.lang.Object r1 = kotlinx.coroutines.s0.a(r3, r7)
            if (r1 != r0) goto L_0x002d
            return r0
        L_0x002d:
            com.squareup.workflow1.h<com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$b, com.withpersona.sdk2.inquiry.selfie.SelfieState, com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$c, java.lang.Object>$a r1 = r7.$context
            com.squareup.workflow1.f r1 = r1.c()
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow r3 = r7.this$0
            com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$runManualCaptureEnabledChecker$1$1 r4 = new com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$runManualCaptureEnabledChecker$1$1
            kotlin.jvm.internal.Ref$BooleanRef r5 = r7.$stillChecking
            r4.<init>(r5)
            r5 = 0
            com.squareup.workflow1.l r3 = com.squareup.workflow1.Workflows__StatefulWorkflowKt.d(r3, r5, r4, r2, r5)
            r1.d(r3)
            goto L_0x001c
        L_0x0045:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$runManualCaptureEnabledChecker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
