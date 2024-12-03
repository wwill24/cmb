package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$run$1", f = "DocumentSubmitWorker.kt", l = {37, 59, 61}, m = "invokeSuspend")
final class DocumentSubmitWorker$run$1 extends SuspendLambda implements Function2<c<? super DocumentSubmitWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DocumentSubmitWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentSubmitWorker$run$1(DocumentSubmitWorker documentSubmitWorker, kotlin.coroutines.c<? super DocumentSubmitWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = documentSubmitWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentSubmitWorker$run$1 documentSubmitWorker$run$1 = new DocumentSubmitWorker$run$1(this.this$0, cVar);
        documentSubmitWorker$run$1.L$0 = obj;
        return documentSubmitWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentSubmitWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentSubmitWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r10.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r5) goto L_0x002f
            if (r1 == r4) goto L_0x0023
            if (r1 != r3) goto L_0x001b
            java.lang.Object r0 = r10.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r0 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r0
            gk.g.b(r11)
            goto L_0x00a9
        L_0x001b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0023:
            java.lang.Object r1 = r10.L$1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            java.lang.Object r4 = r10.L$0
            kotlinx.coroutines.flow.c r4 = (kotlinx.coroutines.flow.c) r4
            gk.g.b(r11)
            goto L_0x008a
        L_0x002f:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r11)
            goto L_0x006d
        L_0x0037:
            gk.g.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.flow.c r11 = (kotlinx.coroutines.flow.c) r11
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker r1 = r10.this$0
            ui.a r1 = r1.f25249h
            com.withpersona.sdk2.inquiry.document.network.DocumentStepData r6 = new com.withpersona.sdk2.inquiry.document.network.DocumentStepData
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker r7 = r10.this$0
            java.lang.String r7 = r7.f25246e
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker r8 = r10.this$0
            java.util.List r8 = r8.f25250i
            r6.<init>(r7, r8)
            r1.b(r6)
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$run$1$1 r1 = new com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$run$1$1
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker r6 = r10.this$0
            r1.<init>(r6, r2)
            r10.L$0 = r11
            r10.label = r5
            java.lang.Object r1 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueVerificationRequestWithRetry(r1, r10)
            if (r1 != r0) goto L_0x006a
            return r0
        L_0x006a:
            r9 = r1
            r1 = r11
            r11 = r9
        L_0x006d:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r11 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r11
            boolean r5 = r11 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r5 == 0) goto L_0x008c
            r5 = r11
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r5 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r5
            r5.getResponse()
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$b$b r5 = com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker.b.C0307b.f25255a
            r10.L$0 = r1
            r10.L$1 = r11
            r10.label = r4
            java.lang.Object r4 = r1.c(r5, r10)
            if (r4 != r0) goto L_0x0088
            return r0
        L_0x0088:
            r4 = r1
            r1 = r11
        L_0x008a:
            r11 = r1
            r1 = r4
        L_0x008c:
            boolean r4 = r11 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r4 == 0) goto L_0x00a9
            r4 = r11
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r4 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r4
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r4 = r4.getNetworkErrorInfo()
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$b$a r5 = new com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$b$a
            r5.<init>(r4)
            r10.L$0 = r11
            r10.L$1 = r2
            r10.label = r3
            java.lang.Object r11 = r1.c(r5, r10)
            if (r11 != r0) goto L_0x00a9
            return r0
        L_0x00a9:
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
