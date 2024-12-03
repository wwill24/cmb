package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$run$1", f = "CreateInquirySessionWorker.kt", l = {27, 31, 40, 42}, m = "invokeSuspend")
final class CreateInquirySessionWorker$run$1 extends SuspendLambda implements Function2<c<? super CreateInquirySessionWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreateInquirySessionWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateInquirySessionWorker$run$1(CreateInquirySessionWorker createInquirySessionWorker, kotlin.coroutines.c<? super CreateInquirySessionWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = createInquirySessionWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        CreateInquirySessionWorker$run$1 createInquirySessionWorker$run$1 = new CreateInquirySessionWorker$run$1(this.this$0, cVar);
        createInquirySessionWorker$run$1.L$0 = obj;
        return createInquirySessionWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super CreateInquirySessionWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((CreateInquirySessionWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r5) goto L_0x002a
            if (r1 == r4) goto L_0x0022
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001d:
            gk.g.b(r8)
            goto L_0x00e2
        L_0x0022:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r8)
            goto L_0x007e
        L_0x002a:
            gk.g.b(r8)
            goto L_0x0054
        L_0x002e:
            gk.g.b(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker r8 = r7.this$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager r8 = r8.f26058e
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r8 = r8.e()
            if (r8 == 0) goto L_0x0057
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$b r2 = new com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$b
            java.lang.String r8 = r8.b()
            r2.<init>(r8)
            r7.label = r5
            java.lang.Object r8 = r1.c(r2, r7)
            if (r8 != r0) goto L_0x0054
            return r0
        L_0x0054:
            kotlin.Unit r8 = kotlin.Unit.f32013a
            return r8
        L_0x0057:
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker r8 = r7.this$0
            com.withpersona.sdk2.inquiry.internal.network.p r8 = r8.f26056c
            com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionRequest$a r5 = com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionRequest.f26436c
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker r6 = r7.this$0
            java.lang.String r6 = r6.f26055b
            com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionRequest r5 = r5.a(r6)
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker r6 = r7.this$0
            com.withpersona.sdk2.inquiry.shared.device.b r6 = r6.f26057d
            java.lang.String r6 = r6.b()
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.d(r5, r6, r7)
            if (r8 != r0) goto L_0x007e
            return r0
        L_0x007e:
            retrofit2.r r8 = (retrofit2.r) r8
            boolean r4 = r8.g()
            r5 = 0
            if (r4 == 0) goto L_0x00ce
            okhttp3.s r2 = r8.f()
            java.lang.String r4 = "persona-device-id"
            java.lang.String r2 = r2.b(r4)
            if (r2 == 0) goto L_0x009c
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker r4 = r7.this$0
            com.withpersona.sdk2.inquiry.shared.device.b r4 = r4.f26057d
            r4.a(r2)
        L_0x009c:
            java.lang.Object r8 = r8.a()
            kotlin.jvm.internal.j.d(r8)
            com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionResponse r8 = (com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionResponse) r8
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$b r2 = new com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Bearer "
            r4.append(r6)
            com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionResponse$Meta r8 = r8.b()
            java.lang.String r8 = r8.a()
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r2.<init>(r8)
            r7.L$0 = r5
            r7.label = r3
            java.lang.Object r8 = r1.c(r2, r7)
            if (r8 != r0) goto L_0x00e2
            return r0
        L_0x00ce:
            com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$a r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r8 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r8)
            r3.<init>(r8)
            r7.L$0 = r5
            r7.label = r2
            java.lang.Object r8 = r1.c(r3, r7)
            if (r8 != r0) goto L_0x00e2
            return r0
        L_0x00e2:
            kotlin.Unit r8 = kotlin.Unit.f32013a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
