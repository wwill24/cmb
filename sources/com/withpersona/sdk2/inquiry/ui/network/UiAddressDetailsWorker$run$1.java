package com.withpersona.sdk2.inquiry.ui.network;

import com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$run$1", f = "UiAddressDetailsWorker.kt", l = {19, 27, 29, 40}, m = "invokeSuspend")
final class UiAddressDetailsWorker$run$1 extends SuspendLambda implements Function2<c<? super UiAddressDetailsWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UiAddressDetailsWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiAddressDetailsWorker$run$1(UiAddressDetailsWorker uiAddressDetailsWorker, kotlin.coroutines.c<? super UiAddressDetailsWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = uiAddressDetailsWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        UiAddressDetailsWorker$run$1 uiAddressDetailsWorker$run$1 = new UiAddressDetailsWorker$run$1(this.this$0, cVar);
        uiAddressDetailsWorker$run$1.L$0 = obj;
        return uiAddressDetailsWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super UiAddressDetailsWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((UiAddressDetailsWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r6) goto L_0x0034
            if (r2 == r5) goto L_0x0028
            if (r2 == r4) goto L_0x0028
            if (r2 != r3) goto L_0x0020
            java.lang.Object r1 = r0.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            gk.g.b(r17)
            goto L_0x00c4
        L_0x0020:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0028:
            java.lang.Object r2 = r0.L$1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.c r4 = (kotlinx.coroutines.flow.c) r4
            gk.g.b(r17)
            goto L_0x0084
        L_0x0034:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            gk.g.b(r17)
            r6 = r17
            goto L_0x0057
        L_0x003e:
            gk.g.b(r17)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$run$1$1 r8 = new com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$run$1$1
            com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker r9 = r0.this$0
            r8.<init>(r9, r7)
            r0.L$0 = r2
            r0.label = r6
            java.lang.Object r6 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueRetriableRequestWithRetry(r8, r0)
            if (r6 != r1) goto L_0x0057
            return r1
        L_0x0057:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r6 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r6
            boolean r8 = r6 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r8 == 0) goto L_0x00a7
            r8 = r6
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r8 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r8
            java.lang.Object r8 = r8.getResponse()
            com.withpersona.sdk2.inquiry.ui.network.AddressDetailsResponse r8 = (com.withpersona.sdk2.inquiry.ui.network.AddressDetailsResponse) r8
            if (r8 == 0) goto L_0x006d
            com.withpersona.sdk2.inquiry.ui.network.LocationData r8 = r8.a()
            goto L_0x006e
        L_0x006d:
            r8 = r7
        L_0x006e:
            if (r8 == 0) goto L_0x0087
            com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$b r4 = new com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$b
            r4.<init>(r8)
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r4 = r2.c(r4, r0)
            if (r4 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r4 = r2
            r2 = r6
        L_0x0084:
            r6 = r2
            r2 = r4
            goto L_0x00a7
        L_0x0087:
            com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$a r5 = new com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r15 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 8
            r14 = 0
            java.lang.String r10 = "Expected body attributes to be non-null."
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r5.<init>(r15)
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r4 = r2.c(r5, r0)
            if (r4 != r1) goto L_0x0082
            return r1
        L_0x00a7:
            boolean r4 = r6 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r4 == 0) goto L_0x00c4
            r4 = r6
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r4 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r4
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r4 = r4.getNetworkErrorInfo()
            com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$a r5 = new com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$a
            r5.<init>(r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r2 = r2.c(r5, r0)
            if (r2 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            kotlin.Unit r1 = kotlin.Unit.f32013a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
