package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$progressFlow$1", f = "DocumentFileUploadWorker.kt", l = {143, 147}, m = "invokeSuspend")
final class DocumentFileUploadWorker$run$1$progressFlow$1 extends SuspendLambda implements Function2<c<? super DocumentFileUploadWorker.b.c>, kotlin.coroutines.c<? super Unit>, Object> {
    final /* synthetic */ b $fileReqBody;
    private /* synthetic */ Object L$0;
    int label;

    static final class a<T> implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c<DocumentFileUploadWorker.b.c> f25234a;

        a(c<? super DocumentFileUploadWorker.b.c> cVar) {
            this.f25234a = cVar;
        }

        public final Object a(int i10, kotlin.coroutines.c<? super Unit> cVar) {
            Object c10 = this.f25234a.c(new DocumentFileUploadWorker.b.c(i10), cVar);
            return c10 == b.d() ? c10 : Unit.f32013a;
        }

        public /* bridge */ /* synthetic */ Object c(Object obj, kotlin.coroutines.c cVar) {
            return a(((Number) obj).intValue(), cVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUploadWorker$run$1$progressFlow$1(b bVar, kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1$progressFlow$1> cVar) {
        super(2, cVar);
        this.$fileReqBody = bVar;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentFileUploadWorker$run$1$progressFlow$1 documentFileUploadWorker$run$1$progressFlow$1 = new DocumentFileUploadWorker$run$1$progressFlow$1(this.$fileReqBody, cVar);
        documentFileUploadWorker$run$1$progressFlow$1.L$0 = obj;
        return documentFileUploadWorker$run$1$progressFlow$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentFileUploadWorker.b.c> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentFileUploadWorker$run$1$progressFlow$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            gk.g.b(r7)
            goto L_0x005c
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r7)
            goto L_0x004a
        L_0x0023:
            gk.g.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.document.network.b r7 = r6.$fileReqBody
            kotlinx.coroutines.flow.r r7 = r7.j()
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$progressFlow$1$1 r5 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$progressFlow$1$1
            r5.<init>(r2)
            kotlinx.coroutines.flow.b r7 = kotlinx.coroutines.flow.d.H(r7, r5)
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$progressFlow$1$a r5 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$progressFlow$1$a
            r5.<init>(r1)
            r6.L$0 = r1
            r6.label = r4
            java.lang.Object r7 = r7.a(r5, r6)
            if (r7 != r0) goto L_0x004a
            return r0
        L_0x004a:
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$c r7 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$c
            r4 = 100
            r7.<init>(r4)
            r6.L$0 = r2
            r6.label = r3
            java.lang.Object r7 = r1.c(r7, r6)
            if (r7 != r0) goto L_0x005c
            return r0
        L_0x005c:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$progressFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
