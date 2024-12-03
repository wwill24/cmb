package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import com.withpersona.sdk2.inquiry.network.NetworkCallResult;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.p0;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$resultFlow$1", f = "DocumentFileUploadWorker.kt", l = {80, 84, 96, 121, 123, 130, 136}, m = "invokeSuspend")
final class DocumentFileUploadWorker$run$1$resultFlow$1 extends SuspendLambda implements Function2<c<? super DocumentFileUploadWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    final /* synthetic */ p0<NetworkCallResult<DocumentFileUploadResponse>> $result;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DocumentFileUploadWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUploadWorker$run$1$resultFlow$1(p0<? extends NetworkCallResult<DocumentFileUploadResponse>> p0Var, DocumentFileUploadWorker documentFileUploadWorker, kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1$resultFlow$1> cVar) {
        super(2, cVar);
        this.$result = p0Var;
        this.this$0 = documentFileUploadWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentFileUploadWorker$run$1$resultFlow$1 documentFileUploadWorker$run$1$resultFlow$1 = new DocumentFileUploadWorker$run$1$resultFlow$1(this.$result, this.this$0, cVar);
        documentFileUploadWorker$run$1$resultFlow$1.L$0 = obj;
        return documentFileUploadWorker$run$1$resultFlow$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentFileUploadWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentFileUploadWorker$run$1$resultFlow$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r12;
        r12 = r11.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        if ((r1 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        r4 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadResponse) ((com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r1).getResponse();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        if (r4 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r5 = r4.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        if (r5 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        r5 = r5.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (r5 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        r5 = r5.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r5 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r5 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileData.RemoteDocumentFile) kotlin.collections.CollectionsKt___CollectionsKt.P(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        if (r4 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r5 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        r6 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b.d(r12.f25223e, new com.withpersona.sdk2.inquiry.document.DocumentFile.Remote(r12.f25223e.d(), r5.a(), r5.b(), r4.a().b()));
        r11.L$0 = r3;
        r11.L$1 = r1;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ab, code lost:
        if (r3.c(r6, r11) != r0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ad, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ae, code lost:
        r12 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b.a(new com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError((java.lang.String) null, (java.lang.String) null, (com.withpersona.sdk2.inquiry.network.ErrorDetails) null, 7, (kotlin.jvm.internal.DefaultConstructorMarker) null));
        r11.L$0 = r3;
        r11.L$1 = r1;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c9, code lost:
        if (r3.c(r12, r11) != r0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cb, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ce, code lost:
        if ((r1 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) == false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d0, code lost:
        r12 = ((com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r1).getNetworkErrorInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00db, code lost:
        if (r12.isRecoverable() == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e3, code lost:
        if ((r12.getResponseError() instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError) == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e5, code lost:
        r12 = r12.getResponseError();
        kotlin.jvm.internal.j.e(r12, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError");
        r12 = ((com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError) r12).getErrorBody();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f4, code lost:
        if (r12 == null) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r12 = new com.squareup.moshi.s.b().a(com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.Companion.getAdapter()).d().c(com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.class).fromJson(r12.source());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015d, code lost:
        if (r12.isRecoverable() == false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015f, code lost:
        r12 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b.a(new com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError((java.lang.String) null, (java.lang.String) null, (com.withpersona.sdk2.inquiry.network.ErrorDetails) null, 7, (kotlin.jvm.internal.DefaultConstructorMarker) null));
        r11.L$0 = r1;
        r11.L$1 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017a, code lost:
        if (r3.c(r12, r11) != r0) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x017c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x017d, code lost:
        r4 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.b.C0305b(r12);
        r11.L$0 = r1;
        r11.L$1 = null;
        r11.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x018d, code lost:
        if (r3.c(r4, r11) != r0) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x018f, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r11.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0031;
                case 1: goto L_0x0028;
                case 2: goto L_0x001b;
                case 3: goto L_0x001b;
                case 4: goto L_0x0012;
                case 5: goto L_0x0012;
                case 6: goto L_0x0012;
                case 7: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0012:
            java.lang.Object r0 = r11.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r0 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r0
            gk.g.b(r12)
            goto L_0x0190
        L_0x001b:
            java.lang.Object r1 = r11.L$1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.flow.c r3 = (kotlinx.coroutines.flow.c) r3
            gk.g.b(r12)
            goto L_0x00cc
        L_0x0028:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r12)
            r3 = r1
            goto L_0x0048
        L_0x0031:
            gk.g.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.flow.c r12 = (kotlinx.coroutines.flow.c) r12
            kotlinx.coroutines.p0<com.withpersona.sdk2.inquiry.network.NetworkCallResult<com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadResponse>> r1 = r11.$result
            r11.L$0 = r12
            r3 = 1
            r11.label = r3
            java.lang.Object r1 = r1.v(r11)
            if (r1 != r0) goto L_0x0046
            return r0
        L_0x0046:
            r3 = r12
            r12 = r1
        L_0x0048:
            r1 = r12
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker r12 = r11.this$0
            boolean r4 = r1 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r4 == 0) goto L_0x00cc
            r4 = r1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r4 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r4
            java.lang.Object r4 = r4.getResponse()
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadResponse r4 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadResponse) r4
            if (r4 == 0) goto L_0x0075
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData r5 = r4.a()
            if (r5 == 0) goto L_0x0075
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData$Attributes r5 = r5.a()
            if (r5 == 0) goto L_0x0075
            java.util.List r5 = r5.a()
            if (r5 == 0) goto L_0x0075
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.P(r5)
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData$RemoteDocumentFile r5 = (com.withpersona.sdk2.inquiry.document.network.DocumentFileData.RemoteDocumentFile) r5
            goto L_0x0076
        L_0x0075:
            r5 = r2
        L_0x0076:
            if (r4 == 0) goto L_0x00ae
            if (r5 == 0) goto L_0x00ae
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$d r6 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$d
            com.withpersona.sdk2.inquiry.document.DocumentFile$Local r7 = r12.f25223e
            com.withpersona.sdk2.inquiry.document.DocumentFile$Local r12 = r12.f25223e
            java.lang.String r12 = r12.d()
            java.lang.String r8 = r5.b()
            java.lang.String r5 = r5.a()
            com.withpersona.sdk2.inquiry.document.network.DocumentFileData r4 = r4.a()
            java.lang.String r4 = r4.b()
            com.withpersona.sdk2.inquiry.document.DocumentFile$Remote r9 = new com.withpersona.sdk2.inquiry.document.DocumentFile$Remote
            r9.<init>(r12, r5, r8, r4)
            r6.<init>(r7, r9)
            r11.L$0 = r3
            r11.L$1 = r1
            r12 = 2
            r11.label = r12
            java.lang.Object r12 = r3.c(r6, r11)
            if (r12 != r0) goto L_0x00cc
            return r0
        L_0x00ae:
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a r12 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError r10 = new com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r12.<init>(r10)
            r11.L$0 = r3
            r11.L$1 = r1
            r4 = 3
            r11.label = r4
            java.lang.Object r12 = r3.c(r12, r11)
            if (r12 != r0) goto L_0x00cc
            return r0
        L_0x00cc:
            boolean r12 = r1 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r12 == 0) goto L_0x0190
            r12 = r1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r12 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r12
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r12 = r12.getNetworkErrorInfo()
            boolean r4 = r12.isRecoverable()
            if (r4 == 0) goto L_0x0159
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r4 = r12.getResponseError()
            boolean r4 = r4 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError
            if (r4 == 0) goto L_0x0159
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r12 = r12.getResponseError()
            java.lang.String r4 = "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError"
            kotlin.jvm.internal.j.e(r12, r4)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error$UnknownError r12 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError) r12
            okhttp3.b0 r12 = r12.getErrorBody()
            if (r12 == 0) goto L_0x011a
            okio.BufferedSource r12 = r12.source()     // Catch:{ Exception -> 0x011a }
            com.squareup.moshi.s$b r4 = new com.squareup.moshi.s$b     // Catch:{ Exception -> 0x011a }
            r4.<init>()     // Catch:{ Exception -> 0x011a }
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$Companion r5 = com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.Companion     // Catch:{ Exception -> 0x011a }
            com.squareup.moshi.h$e r5 = r5.getAdapter()     // Catch:{ Exception -> 0x011a }
            com.squareup.moshi.s$b r4 = r4.a(r5)     // Catch:{ Exception -> 0x011a }
            com.squareup.moshi.s r4 = r4.d()     // Catch:{ Exception -> 0x011a }
            java.lang.Class<com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse> r5 = com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.class
            com.squareup.moshi.h r4 = r4.c(r5)     // Catch:{ Exception -> 0x011a }
            java.lang.Object r12 = r4.fromJson((okio.BufferedSource) r12)     // Catch:{ Exception -> 0x011a }
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse r12 = (com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse) r12     // Catch:{ Exception -> 0x011a }
            goto L_0x011b
        L_0x011a:
            r12 = r2
        L_0x011b:
            if (r12 == 0) goto L_0x013b
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a r4 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a
            java.util.List r12 = r12.getErrors()
            r5 = 0
            java.lang.Object r12 = r12.get(r5)
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse r12 = (com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse.DocumentErrorResponse) r12
            r4.<init>(r12)
            r11.L$0 = r1
            r11.L$1 = r2
            r12 = 4
            r11.label = r12
            java.lang.Object r12 = r3.c(r4, r11)
            if (r12 != r0) goto L_0x0190
            return r0
        L_0x013b:
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a r12 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError r10 = new com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r12.<init>(r10)
            r11.L$0 = r1
            r11.L$1 = r2
            r1 = 5
            r11.label = r1
            java.lang.Object r12 = r3.c(r12, r11)
            if (r12 != r0) goto L_0x0190
            return r0
        L_0x0159:
            boolean r4 = r12.isRecoverable()
            if (r4 == 0) goto L_0x017d
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a r12 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$a
            com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError r10 = new com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse$DocumentErrorResponse$UnknownError
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r12.<init>(r10)
            r11.L$0 = r1
            r11.L$1 = r2
            r1 = 6
            r11.label = r1
            java.lang.Object r12 = r3.c(r12, r11)
            if (r12 != r0) goto L_0x0190
            return r0
        L_0x017d:
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$b r4 = new com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$b
            r4.<init>(r12)
            r11.L$0 = r1
            r11.L$1 = r2
            r12 = 7
            r11.label = r12
            java.lang.Object r12 = r3.c(r4, r11)
            if (r12 != r0) goto L_0x0190
            return r0
        L_0x0190:
            kotlin.Unit r12 = kotlin.Unit.f32013a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$resultFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
