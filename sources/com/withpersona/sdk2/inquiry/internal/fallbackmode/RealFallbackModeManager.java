package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.squareup.moshi.s;
import ji.a;
import kotlin.jvm.internal.j;

public final class RealFallbackModeManager implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f26368a;

    /* renamed from: b  reason: collision with root package name */
    private final s f26369b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26370c;

    /* renamed from: d  reason: collision with root package name */
    private m f26371d;

    public RealFallbackModeManager(a aVar, s sVar) {
        j.g(aVar, "apiController");
        j.g(sVar, "moshi");
        this.f26368a = aVar;
        this.f26369b = sVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r6, java.lang.String r7, java.lang.Object r8, kotlin.coroutines.c<? super retrofit2.r<?>> r9) {
        /*
            r5 = this;
            boolean r7 = r9 instanceof com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$transition$1
            if (r7 == 0) goto L_0x0013
            r7 = r9
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$transition$1 r7 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$transition$1) r7
            int r0 = r7.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r7.label = r0
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$transition$1 r7 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$transition$1
            r7.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            gk.g.b(r9)
            goto L_0x00e2
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            gk.g.b(r9)
            goto L_0x0081
        L_0x0039:
            gk.g.b(r9)
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r9 = r5.f26371d
            if (r9 == 0) goto L_0x0043
            r9.e()
        L_0x0043:
            boolean r9 = r8 instanceof com.withpersona.sdk2.inquiry.document.network.SubmitDocumentRequest
            r1 = 0
            if (r9 == 0) goto L_0x0053
            retrofit2.r r6 = retrofit2.r.i(r1)
            java.lang.String r7 = "{\n        // Documents\n …nse.success(null)\n      }"
            kotlin.jvm.internal.j.f(r6, r7)
            goto L_0x00f9
        L_0x0053:
            boolean r9 = r8 instanceof com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest
            if (r9 == 0) goto L_0x0082
            com.squareup.moshi.s r9 = r5.f26369b
            java.lang.Class<com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest> r1 = com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest.class
            com.squareup.moshi.h r9 = r9.c(r1)
            java.lang.String r8 = r9.toJson(r8)
            okhttp3.z$a r9 = okhttp3.z.f33274a
            java.lang.String r1 = "json"
            kotlin.jvm.internal.j.f(r8, r1)
            okhttp3.v$a r1 = okhttp3.v.f33190e
            java.lang.String r2 = "application/json"
            okhttp3.v r1 = r1.a(r2)
            okhttp3.z r8 = r9.b(r8, r1)
            com.withpersona.sdk2.inquiry.internal.fallbackmode.a r9 = r5.f26368a
            r7.label = r3
            java.lang.Object r9 = r9.a(r6, r8, r7)
            if (r9 != r0) goto L_0x0081
            return r0
        L_0x0081:
            return r9
        L_0x0082:
            boolean r9 = kotlin.jvm.internal.p.j(r8)
            if (r9 == 0) goto L_0x00f0
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r3
            if (r9 == 0) goto L_0x00f0
            r9 = r8
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = kotlin.collections.CollectionsKt___CollectionsKt.N(r9)
            boolean r9 = r9 instanceof okhttp3.w.c
            if (r9 == 0) goto L_0x00e6
            okhttp3.w$a r9 = new okhttp3.w$a
            r9.<init>(r1, r3, r1)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x00ad:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x00bf
            java.lang.Object r3 = r8.next()
            boolean r4 = r3 instanceof okhttp3.w.c
            if (r4 == 0) goto L_0x00ad
            r1.add(r3)
            goto L_0x00ad
        L_0x00bf:
            java.util.Iterator r8 = r1.iterator()
        L_0x00c3:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x00d3
            java.lang.Object r1 = r8.next()
            okhttp3.w$c r1 = (okhttp3.w.c) r1
            r9.c(r1)
            goto L_0x00c3
        L_0x00d3:
            okhttp3.w r8 = r9.d()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.a r9 = r5.f26368a
            r7.label = r2
            java.lang.Object r9 = r9.a(r6, r8, r7)
            if (r9 != r0) goto L_0x00e2
            return r0
        L_0x00e2:
            retrofit2.r r9 = (retrofit2.r) r9
            r6 = r9
            goto L_0x00ea
        L_0x00e6:
            retrofit2.r r6 = retrofit2.r.i(r1)
        L_0x00ea:
            java.lang.String r7 = "{\n        // Combined st…s(null)\n        }\n      }"
            kotlin.jvm.internal.j.f(r6, r7)
            goto L_0x00f9
        L_0x00f0:
            retrofit2.r r6 = retrofit2.r.i(r1)
            java.lang.String r7 = "{\n        Response.success(null)\n      }"
            kotlin.jvm.internal.j.f(r6, r7)
        L_0x00f9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager.a(java.lang.String, java.lang.String, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public void b(boolean z10) {
        this.f26370c = z10;
    }

    public boolean c() {
        return this.f26371d != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, ? extends com.withpersona.sdk2.inquiry.internal.InquiryField> r10, kotlin.coroutines.c<? super com.withpersona.sdk2.inquiry.network.InternalErrorInfo.NetworkErrorInfo> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$createFallbackSession$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$createFallbackSession$1 r0 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$createFallbackSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$createFallbackSession$1 r0 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager$createFallbackSession$1
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r8 = r0.L$0
            com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager r8 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager) r8
            gk.g.b(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r9 = r11.j()
            goto L_0x004c
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            gk.g.b(r11)
            com.withpersona.sdk2.inquiry.internal.fallbackmode.a r11 = r7.f26368a
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r9 = r11.b(r8, r9, r10, r0)
            if (r9 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r8 = r7
        L_0x004c:
            boolean r10 = kotlin.Result.h(r9)
            if (r10 == 0) goto L_0x0057
            r10 = r9
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r10 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.m) r10
            r8.f26371d = r10
        L_0x0057:
            java.lang.Throwable r8 = kotlin.Result.e(r9)
            if (r8 == 0) goto L_0x006c
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r8 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 8
            r6 = 0
            java.lang.String r2 = "Failed to create fallback session."
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r8
        L_0x006c:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager.d(java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.c):java.lang.Object");
    }

    public final m e() {
        return this.f26371d;
    }

    public boolean f() {
        return this.f26370c;
    }
}
