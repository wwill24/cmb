package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$run$1", f = "DocumentFileDeleteWorker.kt", l = {25, 31, 33}, m = "invokeSuspend")
final class DocumentFileDeleteWorker$run$1 extends SuspendLambda implements Function2<c<? super DocumentFileDeleteWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DocumentFileDeleteWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileDeleteWorker$run$1(DocumentFileDeleteWorker documentFileDeleteWorker, kotlin.coroutines.c<? super DocumentFileDeleteWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = documentFileDeleteWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentFileDeleteWorker$run$1 documentFileDeleteWorker$run$1 = new DocumentFileDeleteWorker$run$1(this.this$0, cVar);
        documentFileDeleteWorker$run$1.L$0 = obj;
        return documentFileDeleteWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentFileDeleteWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentFileDeleteWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r8.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r5) goto L_0x002f
            if (r1 == r4) goto L_0x0023
            if (r1 != r3) goto L_0x001b
            java.lang.Object r0 = r8.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r0 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r0
            gk.g.b(r9)
            goto L_0x008f
        L_0x001b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0023:
            java.lang.Object r1 = r8.L$1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            java.lang.Object r4 = r8.L$0
            kotlinx.coroutines.flow.c r4 = (kotlinx.coroutines.flow.c) r4
            gk.g.b(r9)
            goto L_0x0070
        L_0x002f:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r9)
            goto L_0x0053
        L_0x0037:
            gk.g.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.flow.c r9 = (kotlinx.coroutines.flow.c) r9
            com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$run$1$1 r1 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$run$1$1
            com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker r6 = r8.this$0
            r1.<init>(r6, r2)
            r8.L$0 = r9
            r8.label = r5
            java.lang.Object r1 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueRetriableRequestWithRetry(r1, r8)
            if (r1 != r0) goto L_0x0050
            return r0
        L_0x0050:
            r7 = r1
            r1 = r9
            r9 = r7
        L_0x0053:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r9 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r9
            boolean r5 = r9 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r5 == 0) goto L_0x0072
            r5 = r9
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r5 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r5
            r5.getResponse()
            com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$b$b r5 = com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker.b.C0304b.f25216a
            r8.L$0 = r1
            r8.L$1 = r9
            r8.label = r4
            java.lang.Object r4 = r1.c(r5, r8)
            if (r4 != r0) goto L_0x006e
            return r0
        L_0x006e:
            r4 = r1
            r1 = r9
        L_0x0070:
            r9 = r1
            r1 = r4
        L_0x0072:
            boolean r4 = r9 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r4 == 0) goto L_0x008f
            r4 = r9
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r4 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r4
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r4 = r4.getNetworkErrorInfo()
            com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$b$a r5 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$b$a
            r5.<init>(r4)
            r8.L$0 = r9
            r8.L$1 = r2
            r8.label = r3
            java.lang.Object r9 = r1.c(r5, r8)
            if (r9 != r0) goto L_0x008f
            return r0
        L_0x008f:
            kotlin.Unit r9 = kotlin.Unit.f32013a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
