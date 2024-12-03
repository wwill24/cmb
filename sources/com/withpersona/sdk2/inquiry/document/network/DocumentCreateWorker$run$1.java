package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$run$1", f = "DocumentCreateWorker.kt", l = {23, 34, 36}, m = "invokeSuspend")
final class DocumentCreateWorker$run$1 extends SuspendLambda implements Function2<c<? super DocumentCreateWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DocumentCreateWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentCreateWorker$run$1(DocumentCreateWorker documentCreateWorker, kotlin.coroutines.c<? super DocumentCreateWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = documentCreateWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentCreateWorker$run$1 documentCreateWorker$run$1 = new DocumentCreateWorker$run$1(this.this$0, cVar);
        documentCreateWorker$run$1.L$0 = obj;
        return documentCreateWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentCreateWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentCreateWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x001f
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            gk.g.b(r12)
            goto L_0x009e
        L_0x001f:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r12)
            goto L_0x0060
        L_0x0027:
            gk.g.b(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker r12 = r11.this$0
            com.withpersona.sdk2.inquiry.document.network.a r12 = r12.f25191c
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker r5 = r11.this$0
            java.lang.String r5 = r5.f25190b
            com.withpersona.sdk2.inquiry.document.network.CreateDocumentRequest$a r6 = com.withpersona.sdk2.inquiry.document.network.CreateDocumentRequest.f25163c
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker r7 = r11.this$0
            java.lang.String r7 = r7.d()
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker r8 = r11.this$0
            int r8 = r8.f()
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker r9 = r11.this$0
            java.lang.String r9 = r9.e()
            java.lang.String r10 = "document"
            com.withpersona.sdk2.inquiry.document.network.CreateDocumentRequest r6 = r6.a(r10, r7, r8, r9)
            r11.L$0 = r1
            r11.label = r4
            java.lang.Object r12 = r12.a(r5, r6, r11)
            if (r12 != r0) goto L_0x0060
            return r0
        L_0x0060:
            retrofit2.r r12 = (retrofit2.r) r12
            boolean r4 = r12.g()
            r5 = 0
            if (r4 == 0) goto L_0x008a
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$b$b r2 = new com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$b$b
            java.lang.Object r12 = r12.a()
            kotlin.jvm.internal.j.d(r12)
            com.withpersona.sdk2.inquiry.document.network.CreateDocumentResponse r12 = (com.withpersona.sdk2.inquiry.document.network.CreateDocumentResponse) r12
            com.withpersona.sdk2.inquiry.document.network.CreateDocumentResponse$Data r12 = r12.a()
            java.lang.String r12 = r12.a()
            r2.<init>(r12)
            r11.L$0 = r5
            r11.label = r3
            java.lang.Object r12 = r1.c(r2, r11)
            if (r12 != r0) goto L_0x009e
            return r0
        L_0x008a:
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$b$a r3 = new com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r12 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r12)
            r3.<init>(r12)
            r11.L$0 = r5
            r11.label = r2
            java.lang.Object r12 = r1.c(r3, r11)
            if (r12 != r0) goto L_0x009e
            return r0
        L_0x009e:
            kotlin.Unit r12 = kotlin.Unit.f32013a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
