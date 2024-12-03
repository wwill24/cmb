package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$run$1", f = "CreateInquiryWorker.kt", l = {31, 43, 46, 52, 64, 68, 76}, m = "invokeSuspend")
final class CreateInquiryWorker$run$1 extends SuspendLambda implements Function2<c<? super CreateInquiryWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreateInquiryWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateInquiryWorker$run$1(CreateInquiryWorker createInquiryWorker, kotlin.coroutines.c<? super CreateInquiryWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = createInquiryWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        CreateInquiryWorker$run$1 createInquiryWorker$run$1 = new CreateInquiryWorker$run$1(this.this$0, cVar);
        createInquiryWorker$run$1.L$0 = obj;
        return createInquiryWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super CreateInquiryWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((CreateInquiryWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        return kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c4, code lost:
        if (((com.withpersona.sdk2.inquiry.network.InternalErrorInfo.NetworkErrorInfo) r11) != null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c6, code lost:
        r11 = r10.this$0.f26071i.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d2, code lost:
        if (r11 == null) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d4, code lost:
        r5 = r11.d();
        r11 = r11.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00de, code lost:
        if (r11 == null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e0, code lost:
        r4 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker.b.C0314b(r5, r11);
        r10.L$0 = null;
        r10.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ec, code lost:
        if (r1.c(r4, r10) != r0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ee, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f1, code lost:
        return kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fb, code lost:
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0105, code lost:
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r11 = r10.this$0.f26070h;
        r3 = com.withpersona.sdk2.inquiry.internal.network.CreateInquiryRequest.f26422b.a(r10.this$0.h(), r10.this$0.i(), r10.this$0.e(), r10.this$0.d(), r10.this$0.g(), r10.this$0.f());
        r10.L$0 = r1;
        r10.label = 4;
        r11 = r11.f(r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013f, code lost:
        if (r11 != r0) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0141, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0142, code lost:
        r11 = (retrofit2.r) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0148, code lost:
        if (r11.g() == false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x014a, code lost:
        r11 = r11.a();
        kotlin.jvm.internal.j.d(r11);
        r11 = (com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse) r11;
        r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker.b.C0314b(r11.a().b(), r11.a().a().c());
        r10.L$0 = r1;
        r10.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0175, code lost:
        if (r1.c(r3, r10) != r0) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0177, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0178, code lost:
        r11 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r11);
        r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker.b.a(r11.getMessage(), r11);
        r10.L$0 = r1;
        r10.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x018e, code lost:
        if (r1.c(r3, r10) != r0) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0190, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0191, code lost:
        r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker.b.a("There was a problem reaching the server.", com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toSocketTimeoutErrorInfo(r11));
        r10.L$0 = null;
        r10.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01a5, code lost:
        if (r1.c(r3, r10) == r0) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01a7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01aa, code lost:
        return kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        gk.g.b(r11);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0106=Splitter:B:45:0x0106, B:6:0x001b=Splitter:B:6:0x001b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r10.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0043;
                case 1: goto L_0x003f;
                case 2: goto L_0x0036;
                case 3: goto L_0x0031;
                case 4: goto L_0x0025;
                case 5: goto L_0x0020;
                case 6: goto L_0x0017;
                case 7: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0012:
            gk.g.b(r11)
            goto L_0x01a8
        L_0x0017:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
        L_0x001b:
            gk.g.b(r11)     // Catch:{ SocketTimeoutException -> 0x002e }
            goto L_0x01a8
        L_0x0020:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            goto L_0x001b
        L_0x0025:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r11)     // Catch:{ SocketTimeoutException -> 0x002e }
            goto L_0x0142
        L_0x002e:
            r11 = move-exception
            goto L_0x0191
        L_0x0031:
            gk.g.b(r11)
            goto L_0x00ef
        L_0x0036:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r11)
            goto L_0x00c2
        L_0x003f:
            gk.g.b(r11)
            goto L_0x0090
        L_0x0043:
            gk.g.b(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r11 = r10.this$0
            java.lang.String r11 = r11.h()
            r3 = 2
            if (r11 == 0) goto L_0x0093
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r11 = r10.this$0
            java.lang.String r11 = r11.h()
            r4 = 0
            java.lang.String r5 = "itmpl_"
            boolean r11 = kotlin.text.r.J(r11, r5, r4, r3, r2)
            if (r11 != 0) goto L_0x0093
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$a r11 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$IntegrationErrorInfo r2 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$IntegrationErrorInfo
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid template format: "
            r3.append(r4)
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r4 = r10.this$0
            java.lang.String r4 = r4.h()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.lang.String r3 = "The SDK needs a template ID that starts with `itmpl_`. If your template ID starts with `tmpl_`, you should use version v1.x of the Persona Android SDK. https://docs.withpersona.com/docs/mobile-sdks-v1"
            r11.<init>(r3, r2)
            r2 = 1
            r10.label = r2
            java.lang.Object r11 = r1.c(r11, r10)
            if (r11 != r0) goto L_0x0090
            return r0
        L_0x0090:
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        L_0x0093:
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r11 = r10.this$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager r11 = r11.f26071i
            boolean r11 = r11.f()
            if (r11 == 0) goto L_0x0106
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r11 = r10.this$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager r11 = r11.f26071i
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r4 = r10.this$0
            java.lang.String r4 = r4.h()
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r5 = r10.this$0
            java.lang.String r5 = r5.g()
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r6 = r10.this$0
            java.util.Map r6 = r6.f()
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = r11.d(r4, r5, r6, r10)
            if (r11 != r0) goto L_0x00c2
            return r0
        L_0x00c2:
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r11 = (com.withpersona.sdk2.inquiry.network.InternalErrorInfo.NetworkErrorInfo) r11
            if (r11 != 0) goto L_0x0106
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r11 = r10.this$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager r11 = r11.f26071i
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r11 = r11.e()
            java.lang.String r3 = "Required value was null."
            if (r11 == 0) goto L_0x00fc
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$b r4 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$b
            java.lang.String r5 = r11.d()
            com.withpersona.sdk2.inquiry.internal.network.NextStep r11 = r11.c()
            if (r11 == 0) goto L_0x00f2
            r4.<init>(r5, r11)
            r10.L$0 = r2
            r11 = 3
            r10.label = r11
            java.lang.Object r11 = r1.c(r4, r10)
            if (r11 != r0) goto L_0x00ef
            return r0
        L_0x00ef:
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        L_0x00f2:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r3.toString()
            r11.<init>(r0)
            throw r11
        L_0x00fc:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r3.toString()
            r11.<init>(r0)
            throw r11
        L_0x0106:
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r11 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.p r11 = r11.f26070h     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.CreateInquiryRequest$b r3 = com.withpersona.sdk2.inquiry.internal.network.CreateInquiryRequest.f26422b     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r4 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.String r4 = r4.h()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r5 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.String r5 = r5.i()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r6 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.Environment r6 = r6.e()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r7 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.String r7 = r7.d()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r8 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.String r8 = r8.g()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker r9 = r10.this$0     // Catch:{ SocketTimeoutException -> 0x002e }
            java.util.Map r9 = r9.f()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.CreateInquiryRequest r3 = r3.a(r4, r5, r6, r7, r8, r9)     // Catch:{ SocketTimeoutException -> 0x002e }
            r10.L$0 = r1     // Catch:{ SocketTimeoutException -> 0x002e }
            r4 = 4
            r10.label = r4     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.Object r11 = r11.f(r3, r10)     // Catch:{ SocketTimeoutException -> 0x002e }
            if (r11 != r0) goto L_0x0142
            return r0
        L_0x0142:
            retrofit2.r r11 = (retrofit2.r) r11     // Catch:{ SocketTimeoutException -> 0x002e }
            boolean r3 = r11.g()     // Catch:{ SocketTimeoutException -> 0x002e }
            if (r3 == 0) goto L_0x0178
            java.lang.Object r11 = r11.a()     // Catch:{ SocketTimeoutException -> 0x002e }
            kotlin.jvm.internal.j.d(r11)     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse r11 = (com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse) r11     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$b r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$b     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Data r4 = r11.a()     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.String r4 = r4.b()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Data r11 = r11.a()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Attributes r11 = r11.a()     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.network.NextStep r11 = r11.c()     // Catch:{ SocketTimeoutException -> 0x002e }
            r3.<init>(r4, r11)     // Catch:{ SocketTimeoutException -> 0x002e }
            r10.L$0 = r1     // Catch:{ SocketTimeoutException -> 0x002e }
            r11 = 5
            r10.label = r11     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.Object r11 = r1.c(r3, r10)     // Catch:{ SocketTimeoutException -> 0x002e }
            if (r11 != r0) goto L_0x01a8
            return r0
        L_0x0178:
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r11 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r11)     // Catch:{ SocketTimeoutException -> 0x002e }
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$a r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$a     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.String r4 = r11.getMessage()     // Catch:{ SocketTimeoutException -> 0x002e }
            r3.<init>(r4, r11)     // Catch:{ SocketTimeoutException -> 0x002e }
            r10.L$0 = r1     // Catch:{ SocketTimeoutException -> 0x002e }
            r11 = 6
            r10.label = r11     // Catch:{ SocketTimeoutException -> 0x002e }
            java.lang.Object r11 = r1.c(r3, r10)     // Catch:{ SocketTimeoutException -> 0x002e }
            if (r11 != r0) goto L_0x01a8
            return r0
        L_0x0191:
            com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$a r3 = new com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r11 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toSocketTimeoutErrorInfo(r11)
            java.lang.String r4 = "There was a problem reaching the server."
            r3.<init>(r4, r11)
            r10.L$0 = r2
            r11 = 7
            r10.label = r11
            java.lang.Object r11 = r1.c(r3, r10)
            if (r11 != r0) goto L_0x01a8
            return r0
        L_0x01a8:
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
