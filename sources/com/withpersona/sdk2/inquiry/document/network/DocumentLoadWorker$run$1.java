package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$run$1", f = "DocumentLoadWorker.kt", l = {25, 42, 44, 55}, m = "invokeSuspend")
final class DocumentLoadWorker$run$1 extends SuspendLambda implements Function2<c<? super DocumentLoadWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DocumentLoadWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentLoadWorker$run$1(DocumentLoadWorker documentLoadWorker, kotlin.coroutines.c<? super DocumentLoadWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = documentLoadWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentLoadWorker$run$1 documentLoadWorker$run$1 = new DocumentLoadWorker$run$1(this.this$0, cVar);
        documentLoadWorker$run$1.L$0 = obj;
        return documentLoadWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentLoadWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentLoadWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f0  */
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
            if (r2 == 0) goto L_0x003f
            if (r2 == r6) goto L_0x0035
            if (r2 == r5) goto L_0x0028
            if (r2 == r4) goto L_0x0028
            if (r2 != r3) goto L_0x0020
            java.lang.Object r1 = r0.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            gk.g.b(r17)
            goto L_0x0109
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
            goto L_0x00c9
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            gk.g.b(r17)
            r6 = r17
            goto L_0x0058
        L_0x003f:
            gk.g.b(r17)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$run$1$1 r8 = new com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$run$1$1
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker r9 = r0.this$0
            r8.<init>(r9, r7)
            r0.L$0 = r2
            r0.label = r6
            java.lang.Object r6 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueRetriableRequestWithRetry(r8, r0)
            if (r6 != r1) goto L_0x0058
            return r1
        L_0x0058:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r6 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r6
            boolean r8 = r6 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r8 == 0) goto L_0x00ec
            r8 = r6
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r8 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r8
            java.lang.Object r8 = r8.getResponse()
            com.withpersona.sdk2.inquiry.document.network.CreateDocumentResponse r8 = (com.withpersona.sdk2.inquiry.document.network.CreateDocumentResponse) r8
            if (r8 == 0) goto L_0x00cc
            java.util.List r4 = r8.b()
            if (r4 == 0) goto L_0x00b1
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0078:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x00b5
            java.lang.Object r9 = r4.next()
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData r9 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileData) r9
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData$Attributes r10 = r9.a()
            if (r10 == 0) goto L_0x00aa
            java.util.List r10 = r10.a()
            if (r10 == 0) goto L_0x00aa
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.N(r10)
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData$RemoteDocumentFile r10 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileData.RemoteDocumentFile) r10
            if (r10 == 0) goto L_0x00aa
            java.lang.String r11 = r10.b()
            java.lang.String r10 = r10.a()
            java.lang.String r9 = r9.b()
            com.withpersona.sdk2.inquiry.document.DocumentFile$Remote r12 = new com.withpersona.sdk2.inquiry.document.DocumentFile$Remote
            r12.<init>(r7, r10, r11, r9)
            goto L_0x00ab
        L_0x00aa:
            r12 = r7
        L_0x00ab:
            if (r12 == 0) goto L_0x0078
            r8.add(r12)
            goto L_0x0078
        L_0x00b1:
            java.util.List r8 = kotlin.collections.q.j()
        L_0x00b5:
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$b r4 = new com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$b
            r4.<init>(r8)
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r4 = r2.c(r4, r0)
            if (r4 != r1) goto L_0x00c7
            return r1
        L_0x00c7:
            r4 = r2
            r2 = r6
        L_0x00c9:
            r6 = r2
            r2 = r4
            goto L_0x00ec
        L_0x00cc:
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$a r5 = new com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r15 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 8
            r14 = 0
            java.lang.String r10 = "Expected body to be non-null"
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r5.<init>(r15)
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r4 = r2.c(r5, r0)
            if (r4 != r1) goto L_0x00c7
            return r1
        L_0x00ec:
            boolean r4 = r6 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r4 == 0) goto L_0x0109
            r4 = r6
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r4 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r4
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r4 = r4.getNetworkErrorInfo()
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$a r5 = new com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$a
            r5.<init>(r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r2 = r2.c(r5, r0)
            if (r2 != r1) goto L_0x0109
            return r1
        L_0x0109:
            kotlin.Unit r1 = kotlin.Unit.f32013a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
