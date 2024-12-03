package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.internal.TransitionBackWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$run$1", f = "TransitionBackWorker.kt", l = {22, 31, 39, 42}, m = "invokeSuspend")
final class TransitionBackWorker$run$1 extends SuspendLambda implements Function2<c<? super TransitionBackWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransitionBackWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransitionBackWorker$run$1(TransitionBackWorker transitionBackWorker, kotlin.coroutines.c<? super TransitionBackWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = transitionBackWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        TransitionBackWorker$run$1 transitionBackWorker$run$1 = new TransitionBackWorker$run$1(this.this$0, cVar);
        transitionBackWorker$run$1.L$0 = obj;
        return transitionBackWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super TransitionBackWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((TransitionBackWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r10.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r5) goto L_0x002f
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            gk.g.b(r11)
            goto L_0x00bd
        L_0x0019:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0021:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
        L_0x0025:
            gk.g.b(r11)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            goto L_0x00bd
        L_0x002a:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            goto L_0x0025
        L_0x002f:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r11)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            goto L_0x0068
        L_0x0037:
            gk.g.b(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker r11 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.network.p r11 = r11.f26276e     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker r6 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.String r6 = r6.e()     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker r7 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.String r7 = r7.d()     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.network.TransitionBackRequest$a r8 = com.withpersona.sdk2.inquiry.internal.network.TransitionBackRequest.f26891b     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker r9 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.String r9 = r9.c()     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.network.TransitionBackRequest r8 = r8.a(r9)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r10.L$0 = r1     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r10.label = r5     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.Object r11 = r11.c(r6, r7, r8, r10)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            if (r11 != r0) goto L_0x0068
            return r0
        L_0x0068:
            retrofit2.r r11 = (retrofit2.r) r11     // Catch:{ SocketTimeoutException -> 0x00a7 }
            boolean r5 = r11.g()     // Catch:{ SocketTimeoutException -> 0x00a7 }
            if (r5 == 0) goto L_0x0093
            java.lang.Object r11 = r11.a()     // Catch:{ SocketTimeoutException -> 0x00a7 }
            kotlin.jvm.internal.j.d(r11)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse r11 = (com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse) r11     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$b r3 = new com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$b     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker r5 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.String r5 = r5.e()     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.internal.InquiryState r11 = r11.b(r5)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r3.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r10.L$0 = r1     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r10.label = r4     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.Object r11 = r1.c(r3, r10)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            if (r11 != r0) goto L_0x00bd
            return r0
        L_0x0093:
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$a r4 = new com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$a     // Catch:{ SocketTimeoutException -> 0x00a7 }
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r11 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r11)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r4.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r10.L$0 = r1     // Catch:{ SocketTimeoutException -> 0x00a7 }
            r10.label = r3     // Catch:{ SocketTimeoutException -> 0x00a7 }
            java.lang.Object r11 = r1.c(r4, r10)     // Catch:{ SocketTimeoutException -> 0x00a7 }
            if (r11 != r0) goto L_0x00bd
            return r0
        L_0x00a7:
            r11 = move-exception
            com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$a r3 = new com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r11 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toSocketTimeoutErrorInfo(r11)
            r3.<init>(r11)
            r11 = 0
            r10.L$0 = r11
            r10.label = r2
            java.lang.Object r11 = r1.c(r3, r10)
            if (r11 != r0) goto L_0x00bd
            return r0
        L_0x00bd:
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
