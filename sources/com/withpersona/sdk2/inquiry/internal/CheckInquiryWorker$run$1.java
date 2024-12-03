package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$run$1", f = "CheckInquiryWorker.kt", l = {34, 42, 50, 71, 76, 79, 82}, m = "invokeSuspend")
final class CheckInquiryWorker$run$1 extends SuspendLambda implements Function2<c<? super CheckInquiryWorker.c>, kotlin.coroutines.c<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CheckInquiryWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInquiryWorker$run$1(CheckInquiryWorker checkInquiryWorker, kotlin.coroutines.c<? super CheckInquiryWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = checkInquiryWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        CheckInquiryWorker$run$1 checkInquiryWorker$run$1 = new CheckInquiryWorker$run$1(this.this$0, cVar);
        checkInquiryWorker$run$1.L$0 = obj;
        return checkInquiryWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super CheckInquiryWorker.c> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((CheckInquiryWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:26|25|72|(5:27|(4:30|31|(1:33)(1:34)|33)|71|66|(1:68))|35|36|37|(2:55|(2:57|(1:59)))(6:39|(1:41)|42|(4:44|(1:46)|47|(2:49|(1:51)))|53|54)|52|60|(1:62)(10:63|72|(5:27|(1:71)(0)|71|66|(0))|35|36|37|(0)(0)|52|60|(0))|62) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        return kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0183, code lost:
        r13 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ab, code lost:
        return kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097 A[SYNTHETIC, Splitter:B:30:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x017d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r12.label
            r2 = 1
            switch(r1) {
                case 0: goto L_0x0044;
                case 1: goto L_0x0040;
                case 2: goto L_0x0040;
                case 3: goto L_0x0031;
                case 4: goto L_0x0022;
                case 5: goto L_0x0022;
                case 6: goto L_0x0017;
                case 7: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0012:
            gk.g.b(r13)
            goto L_0x01a9
        L_0x0017:
            long r3 = r12.J$0
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r13)
            goto L_0x008a
        L_0x0022:
            long r3 = r12.J$0
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r13)
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            goto L_0x0141
        L_0x0031:
            long r3 = r12.J$0
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r13)     // Catch:{ IOException -> 0x008a }
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            goto L_0x00c7
        L_0x0040:
            gk.g.b(r13)
            goto L_0x0082
        L_0x0044:
            gk.g.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.flow.c r13 = (kotlinx.coroutines.flow.c) r13
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r1 = r12.this$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager r1 = r1.f26047g
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r1 = r1.e()
            if (r1 == 0) goto L_0x0085
            com.withpersona.sdk2.inquiry.internal.network.NextStep r3 = r1.c()
            if (r3 != 0) goto L_0x0072
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$b r1 = new com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$b
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$ConfigurationErrorInfo r3 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$ConfigurationErrorInfo
            java.lang.String r4 = "Fallback template's last state is not a terminal state."
            r3.<init>(r4)
            r1.<init>(r3)
            r12.label = r2
            java.lang.Object r13 = r13.c(r1, r12)
            if (r13 != r0) goto L_0x0082
            return r0
        L_0x0072:
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r2 = r12.this$0
            com.withpersona.sdk2.inquiry.internal.InquiryState r1 = r1.a()
            r3 = 2
            r12.label = r3
            java.lang.Object r13 = r2.g(r13, r1, r12)
            if (r13 != r0) goto L_0x0082
            return r0
        L_0x0082:
            kotlin.Unit r13 = kotlin.Unit.f32013a
            return r13
        L_0x0085:
            long r3 = java.lang.System.currentTimeMillis()
            r1 = r13
        L_0x008a:
            r13 = r12
        L_0x008b:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 90000(0x15f90, double:4.4466E-319)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x0189
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r5 = r13.this$0     // Catch:{ IOException -> 0x008b }
            com.withpersona.sdk2.inquiry.internal.network.p r5 = r5.f26044d     // Catch:{ IOException -> 0x008b }
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r6 = r13.this$0     // Catch:{ IOException -> 0x008b }
            java.lang.String r6 = r6.i()     // Catch:{ IOException -> 0x008b }
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r7 = r13.this$0     // Catch:{ IOException -> 0x008b }
            com.withpersona.sdk2.inquiry.shared.device.b r7 = r7.f26045e     // Catch:{ IOException -> 0x008b }
            java.lang.String r7 = r7.b()     // Catch:{ IOException -> 0x008b }
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r8 = r13.this$0     // Catch:{ IOException -> 0x008b }
            java.lang.String r8 = r8.h()     // Catch:{ IOException -> 0x008b }
            r13.L$0 = r1     // Catch:{ IOException -> 0x008b }
            r13.J$0 = r3     // Catch:{ IOException -> 0x008b }
            r9 = 3
            r13.label = r9     // Catch:{ IOException -> 0x008b }
            java.lang.Object r5 = r5.a(r6, r7, r8, r13)     // Catch:{ IOException -> 0x008b }
            if (r5 != r0) goto L_0x00c1
            return r0
        L_0x00c1:
            r11 = r0
            r0 = r13
            r13 = r5
            r4 = r3
            r3 = r1
            r1 = r11
        L_0x00c7:
            retrofit2.r r13 = (retrofit2.r) r13     // Catch:{ IOException -> 0x0183 }
            boolean r6 = r13.g()
            if (r6 == 0) goto L_0x0151
            okhttp3.s r6 = r13.f()
            java.lang.String r7 = "persona-device-id"
            java.lang.String r6 = r6.b(r7)
            if (r6 == 0) goto L_0x00e4
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r7 = r0.this$0
            com.withpersona.sdk2.inquiry.shared.device.b r7 = r7.f26045e
            r7.a(r6)
        L_0x00e4:
            java.lang.Object r13 = r13.a()
            if (r13 == 0) goto L_0x0145
            java.lang.String r6 = "requireNotNull(response.body())"
            kotlin.jvm.internal.j.f(r13, r6)
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse r13 = (com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse) r13
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Data r6 = r13.a()
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Attributes r6 = r6.a()
            java.lang.String r6 = r6.a()
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r8 = "SANDBOX"
            java.lang.String r7 = r8.toLowerCase(r7)
            java.lang.String r8 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.j.f(r7, r8)
            boolean r6 = kotlin.jvm.internal.j.b(r6, r7)
            if (r6 == 0) goto L_0x0119
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r6 = r0.this$0
            com.withpersona.sdk2.inquiry.sandbox.SandboxFlags r6 = r6.f26046f
            r6.c(r2)
        L_0x0119:
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Data r6 = r13.a()
            com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse$Attributes r6 = r6.a()
            boolean r6 = r6.f()
            if (r6 != 0) goto L_0x0141
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r6 = r0.this$0
            java.lang.String r6 = r6.i()
            com.withpersona.sdk2.inquiry.internal.InquiryState r13 = r13.b(r6)
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker r6 = r0.this$0
            r0.L$0 = r3
            r0.J$0 = r4
            r7 = 4
            r0.label = r7
            java.lang.Object r13 = r6.g(r3, r13, r0)
            if (r13 != r1) goto L_0x0141
            return r1
        L_0x0141:
            r13 = r1
            r1 = r3
            r3 = r4
            goto L_0x016e
        L_0x0145:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x0151:
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r13 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r13)
            boolean r6 = r13.isRecoverable()
            if (r6 != 0) goto L_0x0141
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$b r6 = new com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$b
            r6.<init>(r13)
            r0.L$0 = r3
            r0.J$0 = r4
            r13 = 5
            r0.label = r13
            java.lang.Object r13 = r3.c(r6, r0)
            if (r13 != r1) goto L_0x0141
            return r1
        L_0x016e:
            r5 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r1
            r0.J$0 = r3
            r7 = 6
            r0.label = r7
            java.lang.Object r5 = kotlinx.coroutines.s0.a(r5, r0)
            if (r5 != r13) goto L_0x017e
            return r13
        L_0x017e:
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x008b
        L_0x0183:
            r13 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L_0x008b
        L_0x0189:
            com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$b r2 = new com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$b
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r10 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo
            r4 = 0
            r6 = 1
            r7 = 0
            r8 = 8
            r9 = 0
            java.lang.String r5 = "Timeout error. Wait for transition exceeded 90000ms."
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r2.<init>(r10)
            r3 = 0
            r13.L$0 = r3
            r3 = 7
            r13.label = r3
            java.lang.Object r13 = r1.c(r2, r13)
            if (r13 != r0) goto L_0x01a9
            return r0
        L_0x01a9:
            kotlin.Unit r13 = kotlin.Unit.f32013a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
