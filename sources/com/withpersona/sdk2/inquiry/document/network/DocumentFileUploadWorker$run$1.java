package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import gk.g;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.x0;
import okhttp3.v;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1", f = "DocumentFileUploadWorker.kt", l = {151}, m = "invokeSuspend")
final class DocumentFileUploadWorker$run$1 extends SuspendLambda implements Function2<c<? super DocumentFileUploadWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DocumentFileUploadWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUploadWorker$run$1(DocumentFileUploadWorker documentFileUploadWorker, kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = documentFileUploadWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentFileUploadWorker$run$1 documentFileUploadWorker$run$1 = new DocumentFileUploadWorker$run$1(this.this$0, cVar);
        documentFileUploadWorker$run$1.L$0 = obj;
        return documentFileUploadWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentFileUploadWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentFileUploadWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final c cVar = (c) this.L$0;
            b bVar = new b(new File(this.this$0.f25223e.d()), v.f33190e.b(this.this$0.f25224f.a(this.this$0.f25223e.d())));
            b C = kotlinx.coroutines.flow.d.C(kotlinx.coroutines.flow.d.v(new DocumentFileUploadWorker$run$1$resultFlow$1(j.b(this.this$0.f25225g, x0.b(), (CoroutineStart) null, new DocumentFileUploadWorker$run$1$result$1(this.this$0, bVar, (kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1$result$1>) null), 2, (Object) null), this.this$0, (kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1$resultFlow$1>) null)), kotlinx.coroutines.flow.d.v(new DocumentFileUploadWorker$run$1$progressFlow$1(bVar, (kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1$progressFlow$1>) null)));
            AnonymousClass1 r32 = new c() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
                /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
                /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object c(com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$1$emit$1 r0 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$1$emit$1 r0 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0035
                        if (r2 != r3) goto L_0x002d
                        java.lang.Object r5 = r0.L$0
                        com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b r5 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b) r5
                        gk.g.b(r6)
                        goto L_0x0045
                    L_0x002d:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0035:
                        gk.g.b(r6)
                        kotlinx.coroutines.flow.c<com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b> r6 = r12
                        r0.L$0 = r5
                        r0.label = r3
                        java.lang.Object r6 = r6.c(r5, r0)
                        if (r6 != r1) goto L_0x0045
                        return r1
                    L_0x0045:
                        boolean r6 = r5 instanceof com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b.a
                        if (r6 == 0) goto L_0x004b
                        r5 = r3
                        goto L_0x004d
                    L_0x004b:
                        boolean r5 = r5 instanceof com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b.C0305b
                    L_0x004d:
                        if (r5 == 0) goto L_0x0057
                        kotlin.coroutines.CoroutineContext r5 = r0.getContext()
                        r6 = 0
                        kotlinx.coroutines.x1.d(r5, r6, r3, r6)
                    L_0x0057:
                        kotlin.Unit r5 = kotlin.Unit.f32013a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1.AnonymousClass1.c(com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b, kotlin.coroutines.c):java.lang.Object");
                }
            };
            this.label = 1;
            if (C.a(r32, this) == d10) {
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
