package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.s;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import okhttp3.z;
import retrofit2.r;

public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final s f26384a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f26385b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26386c;

    public interface a {
        i a(int i10);
    }

    public i(s sVar, Context context, int i10) {
        j.g(sVar, "moshi");
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f26384a = sVar;
        this.f26385b = context;
        this.f26386c = i10;
    }

    public Object a(String str, z zVar, c<? super r<?>> cVar) {
        r i10 = r.i(null);
        j.f(i10, "success(null)");
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c6, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c7, code lost:
        kotlin.io.b.a(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r3, java.lang.String r4, java.util.Map<java.lang.String, ? extends com.withpersona.sdk2.inquiry.internal.InquiryField> r5, kotlin.coroutines.c<? super kotlin.Result<com.withpersona.sdk2.inquiry.internal.fallbackmode.m>> r6) {
        /*
            r2 = this;
            int r3 = r2.f26386c
            android.content.Context r4 = r2.f26385b
            android.content.res.Resources r4 = r4.getResources()
            java.io.InputStream r3 = r4.openRawResource(r3)
            java.lang.String r4 = "res.openRawResource(stepsJsonResourceId)"
            kotlin.jvm.internal.j.f(r3, r4)
            java.nio.charset.Charset r4 = kotlin.text.d.f32216b
            java.io.InputStreamReader r5 = new java.io.InputStreamReader
            r5.<init>(r3, r4)
            boolean r3 = r5 instanceof java.io.BufferedReader
            if (r3 == 0) goto L_0x001f
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5
            goto L_0x0027
        L_0x001f:
            java.io.BufferedReader r3 = new java.io.BufferedReader
            r4 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r5, r4)
            r5 = r3
        L_0x0027:
            java.lang.String r3 = kotlin.io.TextStreamsKt.f(r5)     // Catch:{ all -> 0x00c4 }
            r4 = 0
            kotlin.io.b.a(r5, r4)
            org.json.b r5 = new org.json.b
            r5.<init>((java.lang.String) r3)
            java.lang.String r3 = "steps"
            org.json.a r3 = r5.optJSONArray(r3)
            if (r3 == 0) goto L_0x00b2
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0043
            goto L_0x00b2
        L_0x0043:
            java.lang.Class<java.util.List> r5 = java.util.List.class
            r6 = 1
            java.lang.reflect.Type[] r6 = new java.lang.reflect.Type[r6]
            r0 = 0
            java.lang.Class<com.withpersona.sdk2.inquiry.internal.network.NextStep> r1 = com.withpersona.sdk2.inquiry.internal.network.NextStep.class
            r6[r0] = r1
            java.lang.reflect.ParameterizedType r5 = com.squareup.moshi.w.j(r5, r6)
            com.squareup.moshi.s r6 = r2.f26384a
            com.squareup.moshi.h r5 = r6.d(r5)
            java.lang.Object r3 = r5.fromJson((java.lang.String) r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x007e
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.r.t(r3, r5)
            r4.<init>(r5)
            java.util.Iterator r3 = r3.iterator()
        L_0x006e:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r3.next()
            com.withpersona.sdk2.inquiry.internal.network.NextStep r5 = (com.withpersona.sdk2.inquiry.internal.network.NextStep) r5
            r4.add(r5)
            goto L_0x006e
        L_0x007e:
            if (r4 == 0) goto L_0x00a0
            boolean r3 = r4.isEmpty()
            if (r3 == 0) goto L_0x0087
            goto L_0x00a0
        L_0x0087:
            kotlin.Result$a r3 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.m r3 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.m
            java.util.UUID r5 = java.util.UUID.randomUUID()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "randomUUID().toString()"
            kotlin.jvm.internal.j.f(r5, r6)
            r3.<init>(r4, r5)
            java.lang.Object r3 = kotlin.Result.b(r3)
            return r3
        L_0x00a0:
            kotlin.Result$a r3 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException r3 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException
            java.lang.String r4 = "Expected steps to contain at least one step"
            r3.<init>(r4)
            java.lang.Object r3 = gk.g.a(r3)
            java.lang.Object r3 = kotlin.Result.b(r3)
            return r3
        L_0x00b2:
            kotlin.Result$a r3 = kotlin.Result.f32010a
            com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException r3 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackException
            java.lang.String r4 = "Failed to resource as static template"
            r3.<init>(r4)
            java.lang.Object r3 = gk.g.a(r3)
            java.lang.Object r3 = kotlin.Result.b(r3)
            return r3
        L_0x00c4:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r4 = move-exception
            kotlin.io.b.a(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.fallbackmode.i.b(java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.c):java.lang.Object");
    }
}
