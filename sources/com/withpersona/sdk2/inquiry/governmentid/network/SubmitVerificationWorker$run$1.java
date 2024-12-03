package com.withpersona.sdk2.inquiry.governmentid.network;

import com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$run$1", f = "SubmitVerificationWorker.kt", l = {58, 87, 106, 108, 115}, m = "invokeSuspend")
final class SubmitVerificationWorker$run$1 extends SuspendLambda implements Function2<c<? super SubmitVerificationWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SubmitVerificationWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitVerificationWorker$run$1(SubmitVerificationWorker submitVerificationWorker, kotlin.coroutines.c<? super SubmitVerificationWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = submitVerificationWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        SubmitVerificationWorker$run$1 submitVerificationWorker$run$1 = new SubmitVerificationWorker$run$1(this.this$0, cVar);
        submitVerificationWorker$run$1.L$0 = obj;
        return submitVerificationWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super SubmitVerificationWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((SubmitVerificationWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r1.label
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r8) goto L_0x003a
            if (r2 == r7) goto L_0x002d
            if (r2 == r6) goto L_0x0024
            if (r2 == r5) goto L_0x0024
            if (r2 != r4) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0024:
            java.lang.Object r0 = r1.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r0 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r0
            gk.g.b(r17)
            goto L_0x01e0
        L_0x002d:
            java.lang.Object r2 = r1.L$1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r2
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.flow.c r7 = (kotlinx.coroutines.flow.c) r7
            gk.g.b(r17)
            goto L_0x0140
        L_0x003a:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            gk.g.b(r17)
            r8 = r17
            goto L_0x00b3
        L_0x0044:
            gk.g.b(r17)
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            okhttp3.w$c[] r10 = new okhttp3.w.c[r5]
            okhttp3.w$c$a r11 = okhttp3.w.c.f33214c
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r12 = r1.this$0
            java.lang.String r12 = r12.f25879c
            java.lang.String r13 = "data[id]"
            okhttp3.w$c r12 = r11.b(r13, r12)
            r10[r3] = r12
            java.lang.String r12 = "data[type]"
            java.lang.String r13 = "inquiry"
            okhttp3.w$c r12 = r11.b(r12, r13)
            r10[r8] = r12
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r12 = r1.this$0
            java.lang.String r12 = r12.f25881e
            java.lang.String r13 = "meta[from_component]"
            okhttp3.w$c r12 = r11.b(r13, r12)
            r10[r7] = r12
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r12 = r1.this$0
            java.lang.String r12 = r12.f25880d
            java.lang.String r13 = "meta[from_step]"
            okhttp3.w$c r11 = r11.b(r13, r12)
            r10[r6] = r11
            java.util.List r10 = kotlin.collections.q.p(r10)
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r11 = r1.this$0
            com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments r11 = r11.f25883g
            if (r11 == 0) goto L_0x0094
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r12 = r1.this$0
            r12.m(r11, r10)
        L_0x0094:
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r11 = r1.this$0
            com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r11 = r11.f25884h
            if (r11 == 0) goto L_0x00a1
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r12 = r1.this$0
            r12.n(r11, r10)
        L_0x00a1:
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$run$1$1 r11 = new com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$run$1$1
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r12 = r1.this$0
            r11.<init>(r12, r10, r9)
            r1.L$0 = r2
            r1.label = r8
            java.lang.Object r8 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueVerificationRequestWithRetry(r11, r1)
            if (r8 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r8 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r8
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker r10 = r1.this$0
            boolean r11 = r8 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r11 == 0) goto L_0x0142
            r11 = r8
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r11 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r11
            r11.getResponse()
            ui.a r11 = r10.f25885i
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x0108
            com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments r11 = r10.f25883g
            if (r11 == 0) goto L_0x0108
            java.util.List r11 = r11.d()
            if (r11 == 0) goto L_0x0108
            java.util.Iterator r11 = r11.iterator()
        L_0x00db:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0108
            java.lang.Object r12 = r11.next()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentId r12 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentId) r12
            java.util.List r12 = r12.U1()
            java.util.Iterator r12 = r12.iterator()
        L_0x00ef:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x00db
            java.lang.Object r13 = r12.next()
            com.withpersona.sdk2.inquiry.governmentid.Frame r13 = (com.withpersona.sdk2.inquiry.governmentid.Frame) r13
            java.io.File r14 = new java.io.File
            java.lang.String r13 = r13.a()
            r14.<init>(r13)
            r14.delete()
            goto L_0x00ef
        L_0x0108:
            com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r11 = r10.f25884h
            if (r11 == 0) goto L_0x012f
            com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r11 = r10.f25884h
            java.io.File r11 = r11.a()
            r11.delete()
            com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r11 = r10.f25884h
            java.io.File r11 = r11.c()
            r11.delete()
            com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r10 = r10.f25884h
            java.io.File r10 = r10.e()
            r10.delete()
        L_0x012f:
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$c r10 = com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker.b.c.f25894a
            r1.L$0 = r2
            r1.L$1 = r8
            r1.label = r7
            java.lang.Object r7 = r2.c(r10, r1)
            if (r7 != r0) goto L_0x013e
            return r0
        L_0x013e:
            r7 = r2
            r2 = r8
        L_0x0140:
            r8 = r2
            r2 = r7
        L_0x0142:
            boolean r7 = r8 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r7 == 0) goto L_0x01e0
            r7 = r8
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r7 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r7
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r7 = r7.getNetworkErrorInfo()
            boolean r10 = r7.isRecoverable()
            if (r10 == 0) goto L_0x01ce
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r10 = r7.getResponseError()
            boolean r10 = r10 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError
            if (r10 == 0) goto L_0x01ce
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r4 = r7.getResponseError()
            java.lang.String r7 = "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError"
            kotlin.jvm.internal.j.e(r4, r7)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error$UnknownError r4 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError) r4
            okhttp3.b0 r4 = r4.getErrorBody()
            if (r4 == 0) goto L_0x0192
            okio.BufferedSource r4 = r4.source()     // Catch:{ Exception -> 0x0190 }
            com.squareup.moshi.s$b r7 = new com.squareup.moshi.s$b     // Catch:{ Exception -> 0x0190 }
            r7.<init>()     // Catch:{ Exception -> 0x0190 }
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$Companion r10 = com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.Companion     // Catch:{ Exception -> 0x0190 }
            com.squareup.moshi.h$e r10 = r10.getAdapter()     // Catch:{ Exception -> 0x0190 }
            com.squareup.moshi.s$b r7 = r7.a(r10)     // Catch:{ Exception -> 0x0190 }
            com.squareup.moshi.s r7 = r7.d()     // Catch:{ Exception -> 0x0190 }
            java.lang.Class<com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse> r10 = com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.class
            com.squareup.moshi.h r7 = r7.c(r10)     // Catch:{ Exception -> 0x0190 }
            java.lang.Object r4 = r7.fromJson((okio.BufferedSource) r4)     // Catch:{ Exception -> 0x0190 }
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse r4 = (com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse) r4     // Catch:{ Exception -> 0x0190 }
            goto L_0x0193
        L_0x0190:
            r0 = move-exception
            throw r0
        L_0x0192:
            r4 = r9
        L_0x0193:
            if (r4 == 0) goto L_0x01b1
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$b r5 = new com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$b
            java.util.List r4 = r4.getErrors()
            java.lang.Object r3 = r4.get(r3)
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse r3 = (com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.DocumentErrorResponse) r3
            r5.<init>(r3)
            r1.L$0 = r8
            r1.L$1 = r9
            r1.label = r6
            java.lang.Object r2 = r2.c(r5, r1)
            if (r2 != r0) goto L_0x01e0
            return r0
        L_0x01b1:
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$b r3 = new com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$b
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError r4 = new com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 7
            r15 = 0
            r10 = r4
            r10.<init>(r11, r12, r13, r14, r15)
            r3.<init>(r4)
            r1.L$0 = r8
            r1.L$1 = r9
            r1.label = r5
            java.lang.Object r2 = r2.c(r3, r1)
            if (r2 != r0) goto L_0x01e0
            return r0
        L_0x01ce:
            com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$a r3 = new com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$b$a
            r3.<init>(r7)
            r1.L$0 = r8
            r1.L$1 = r9
            r1.label = r4
            java.lang.Object r2 = r2.c(r3, r1)
            if (r2 != r0) goto L_0x01e0
            return r0
        L_0x01e0:
            kotlin.Unit r0 = kotlin.Unit.f32013a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
