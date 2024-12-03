package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.squareup.moshi.s;
import kotlin.jvm.internal.j;

public final class FallbackModeApiController implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FallbackModeService f26332a;

    /* renamed from: b  reason: collision with root package name */
    private final s f26333b;

    /* renamed from: c  reason: collision with root package name */
    private int f26334c;

    public FallbackModeApiController(FallbackModeService fallbackModeService, s sVar) {
        j.g(fallbackModeService, "service");
        j.g(sVar, "moshi");
        this.f26332a = fallbackModeService;
        this.f26333b = sVar;
    }

    /* access modifiers changed from: private */
    public final int d() {
        int i10 = this.f26334c + 1;
        this.f26334c = i10;
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: okhttp3.z} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r12, okhttp3.z r13, kotlin.coroutines.c<? super retrofit2.r<?>> r14) {
        /*
            r11 = this;
            java.lang.Class<com.withpersona.sdk2.inquiry.network.ErrorResponse> r0 = com.withpersona.sdk2.inquiry.network.ErrorResponse.class
            boolean r1 = r14 instanceof com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$1
            if (r1 == 0) goto L_0x0015
            r1 = r14
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$1 r1 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$1 r1 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$1
            r1.<init>(r11, r14)
        L_0x001a:
            java.lang.Object r14 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.b.d()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            java.lang.String r6 = "application/json"
            java.lang.String r7 = "moshi.adapter(ErrorRespo…llback mode API error.\"))"
            java.lang.String r8 = "Fallback mode API error."
            r9 = 0
            r10 = 0
            if (r3 == 0) goto L_0x0050
            if (r3 == r5) goto L_0x0043
            if (r3 != r4) goto L_0x003b
            java.lang.Object r12 = r1.L$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController r12 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController) r12
            gk.g.b(r14)
            goto L_0x00ee
        L_0x003b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0043:
            java.lang.Object r12 = r1.L$1
            r13 = r12
            okhttp3.z r13 = (okhttp3.z) r13
            java.lang.Object r12 = r1.L$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController r12 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController) r12
            gk.g.b(r14)
            goto L_0x006a
        L_0x0050:
            gk.g.b(r14)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.x0.a()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$result$1 r3 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$result$1
            r3.<init>(r11, r12, r13, r10)
            r1.L$0 = r11
            r1.L$1 = r13
            r1.label = r5
            java.lang.Object r14 = kotlinx.coroutines.h.g(r14, r3, r1)
            if (r14 != r2) goto L_0x0069
            return r2
        L_0x0069:
            r12 = r11
        L_0x006a:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r14 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r14
            boolean r3 = r14 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r3 == 0) goto L_0x0099
            okhttp3.b0$b r13 = okhttp3.b0.Companion
            com.squareup.moshi.s r12 = r12.f26333b
            com.squareup.moshi.h r12 = r12.c(r0)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Companion r14 = com.withpersona.sdk2.inquiry.network.ErrorResponse.Companion
            com.withpersona.sdk2.inquiry.network.ErrorResponse r14 = r14.create(r8)
            java.lang.String r12 = r12.toJson(r14)
            kotlin.jvm.internal.j.f(r12, r7)
            okhttp3.v$a r14 = okhttp3.v.f33190e
            okhttp3.v r14 = r14.a(r6)
            okhttp3.b0 r12 = r13.a(r12, r14)
            retrofit2.r r12 = retrofit2.r.c(r9, r12)
            java.lang.String r13 = "error<ResponseBody>(\n   ….toMediaType())\n        )"
            kotlin.jvm.internal.j.f(r12, r13)
            return r12
        L_0x0099:
            boolean r3 = r14 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r3 == 0) goto L_0x0131
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r14 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r14
            java.lang.Object r14 = r14.getResponse()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService$UploadUrlResponse r14 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService.UploadUrlResponse) r14
            if (r14 == 0) goto L_0x00ac
            java.lang.String r14 = r14.a()
            goto L_0x00ad
        L_0x00ac:
            r14 = r10
        L_0x00ad:
            if (r14 != 0) goto L_0x00d8
            okhttp3.b0$b r13 = okhttp3.b0.Companion
            com.squareup.moshi.s r12 = r12.f26333b
            com.squareup.moshi.h r12 = r12.c(r0)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Companion r14 = com.withpersona.sdk2.inquiry.network.ErrorResponse.Companion
            com.withpersona.sdk2.inquiry.network.ErrorResponse r14 = r14.create(r8)
            java.lang.String r12 = r12.toJson(r14)
            kotlin.jvm.internal.j.f(r12, r7)
            okhttp3.v$a r14 = okhttp3.v.f33190e
            okhttp3.v r14 = r14.a(r6)
            okhttp3.b0 r12 = r13.a(r12, r14)
            retrofit2.r r12 = retrofit2.r.c(r9, r12)
            java.lang.String r13 = "error<ResponseBody>(\n   …n\".toMediaType())\n      )"
            kotlin.jvm.internal.j.f(r12, r13)
            return r12
        L_0x00d8:
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.x0.a()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$uploadResult$1 r5 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$uploadResult$1
            r5.<init>(r12, r14, r13, r10)
            r1.L$0 = r12
            r1.L$1 = r10
            r1.label = r4
            java.lang.Object r14 = kotlinx.coroutines.h.g(r3, r5, r1)
            if (r14 != r2) goto L_0x00ee
            return r2
        L_0x00ee:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r14 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r14
            boolean r13 = r14 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r13 == 0) goto L_0x011d
            okhttp3.b0$b r13 = okhttp3.b0.Companion
            com.squareup.moshi.s r12 = r12.f26333b
            com.squareup.moshi.h r12 = r12.c(r0)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Companion r14 = com.withpersona.sdk2.inquiry.network.ErrorResponse.Companion
            com.withpersona.sdk2.inquiry.network.ErrorResponse r14 = r14.create(r8)
            java.lang.String r12 = r12.toJson(r14)
            kotlin.jvm.internal.j.f(r12, r7)
            okhttp3.v$a r14 = okhttp3.v.f33190e
            okhttp3.v r14 = r14.a(r6)
            okhttp3.b0 r12 = r13.a(r12, r14)
            retrofit2.r r12 = retrofit2.r.c(r9, r12)
            java.lang.String r13 = "{\n        Response.error…Type())\n        )\n      }"
            kotlin.jvm.internal.j.f(r12, r13)
            goto L_0x012a
        L_0x011d:
            boolean r12 = r14 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r12 == 0) goto L_0x012b
            retrofit2.r r12 = retrofit2.r.i(r10)
            java.lang.String r13 = "{\n        Response.success(null)\n      }"
            kotlin.jvm.internal.j.f(r12, r13)
        L_0x012a:
            return r12
        L_0x012b:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        L_0x0131:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController.a(java.lang.String, okhttp3.z, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r16, java.lang.String r17, java.util.Map<java.lang.String, ? extends com.withpersona.sdk2.inquiry.internal.InquiryField> r18, kotlin.coroutines.c<? super kotlin.Result<com.withpersona.sdk2.inquiry.internal.fallbackmode.m>> r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r19
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$1 r3 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0018
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001d
        L_0x0018:
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$1 r3 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$1
            r3.<init>(r15, r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.b.d()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0057
            if (r5 == r7) goto L_0x003f
            if (r5 != r6) goto L_0x0037
            java.lang.Object r1 = r3.L$0
            java.util.List r1 = (java.util.List) r1
            gk.g.b(r2)
            goto L_0x00e7
        L_0x0037:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003f:
            java.lang.Object r1 = r3.L$3
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r3.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r9 = r3.L$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController r9 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController) r9
            gk.g.b(r2)
            r13 = r1
            r12 = r5
            r11 = r7
            r10 = r9
            goto L_0x0090
        L_0x0057:
            gk.g.b(r2)
            if (r1 != 0) goto L_0x006e
            kotlin.Result$a r1 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException r1 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException
            java.lang.String r2 = "Expected templateId to be non-null"
            r1.<init>(r2)
            java.lang.Object r1 = gk.g.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
            return r1
        L_0x006e:
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.x0.a()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$response$1 r5 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$response$1
            r5.<init>(r15, r1, r8)
            r3.L$0 = r0
            r3.L$1 = r1
            r9 = r17
            r3.L$2 = r9
            r10 = r18
            r3.L$3 = r10
            r3.label = r7
            java.lang.Object r2 = kotlinx.coroutines.h.g(r2, r5, r3)
            if (r2 != r4) goto L_0x008c
            return r4
        L_0x008c:
            r11 = r1
            r12 = r9
            r13 = r10
            r10 = r0
        L_0x0090:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r2
            boolean r1 = r2 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r1 == 0) goto L_0x00a8
            kotlin.Result$a r1 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException r1 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException
            java.lang.String r2 = "Failed to check status"
            r1.<init>(r2)
            java.lang.Object r1 = gk.g.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
            return r1
        L_0x00a8:
            boolean r1 = r2 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r1 == 0) goto L_0x0138
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r2
            java.lang.Object r1 = r2.getResponse()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService$StatusResponse r1 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService.StatusResponse) r1
            if (r1 == 0) goto L_0x00c1
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService$StaticTemplate r1 = r1.a()
            if (r1 == 0) goto L_0x00c1
            java.util.List r1 = r1.a()
            goto L_0x00c2
        L_0x00c1:
            r1 = r8
        L_0x00c2:
            if (r1 == 0) goto L_0x0126
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x00cb
            goto L_0x0126
        L_0x00cb:
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.x0.a()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$sessionIdResponse$1 r5 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$sessionIdResponse$1
            r14 = 0
            r9 = r5
            r9.<init>(r10, r11, r12, r13, r14)
            r3.L$0 = r1
            r3.L$1 = r8
            r3.L$2 = r8
            r3.L$3 = r8
            r3.label = r6
            java.lang.Object r2 = kotlinx.coroutines.h.g(r2, r5, r3)
            if (r2 != r4) goto L_0x00e7
            return r4
        L_0x00e7:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r2
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r3 == 0) goto L_0x00ee
            goto L_0x0100
        L_0x00ee:
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r3 == 0) goto L_0x0120
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r2
            java.lang.Object r2 = r2.getResponse()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService$SessionIdResponse r2 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService.SessionIdResponse) r2
            if (r2 == 0) goto L_0x0100
            java.lang.String r8 = r2.a()
        L_0x0100:
            if (r8 != 0) goto L_0x0114
            kotlin.Result$a r1 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException r1 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException
            java.lang.String r2 = "Failed to create session"
            r1.<init>(r2)
            java.lang.Object r1 = gk.g.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
            return r1
        L_0x0114:
            kotlin.Result$a r2 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r2 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.m
            r2.<init>(r1, r8)
            java.lang.Object r1 = kotlin.Result.b(r2)
            return r1
        L_0x0120:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0126:
            kotlin.Result$a r1 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException r1 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException
            java.lang.String r2 = "Expected steps to contain at least one step"
            r1.<init>(r2)
            java.lang.Object r1 = gk.g.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
            return r1
        L_0x0138:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController.b(java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.c):java.lang.Object");
    }

    public final FallbackModeService e() {
        return this.f26332a;
    }
}
