package com.withpersona.sdk2.inquiry.document.network;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;
import okhttp3.v;
import okhttp3.z;

public final class b extends z {

    /* renamed from: e  reason: collision with root package name */
    public static final a f25271e = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final File f25272b;

    /* renamed from: c  reason: collision with root package name */
    private final v f25273c;

    /* renamed from: d  reason: collision with root package name */
    private final i<Integer> f25274d = s.a(0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(File file, v vVar) {
        j.g(file, "file");
        this.f25272b = file;
        this.f25273c = vVar;
    }

    public v b() {
        return this.f25273c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        kotlin.io.b.a(r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(okio.BufferedSink r12) {
        /*
            r11 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.j.g(r12, r0)
            java.io.File r0 = r11.f25272b
            long r0 = r0.length()
            float r0 = (float) r0
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r11.f25272b
            r2.<init>(r3)
            int r3 = r2.read(r1)     // Catch:{ all -> 0x004f }
            r4 = 0
            r5 = 0
            r7 = r4
        L_0x001f:
            r8 = -1
            if (r3 == r8) goto L_0x0048
            long r8 = (long) r3     // Catch:{ all -> 0x004f }
            long r5 = r5 + r8
            r12.write(r1, r4, r3)     // Catch:{ all -> 0x004f }
            int r3 = r2.read(r1)     // Catch:{ all -> 0x004f }
            float r8 = (float) r5     // Catch:{ all -> 0x004f }
            float r8 = r8 / r0
            r9 = 1120403456(0x42c80000, float:100.0)
            float r8 = r8 * r9
            int r8 = sk.c.b(r8)     // Catch:{ all -> 0x004f }
            int r9 = r8 - r7
            r10 = 1
            if (r9 > r10) goto L_0x003d
            r9 = 100
            if (r8 < r9) goto L_0x001f
        L_0x003d:
            kotlinx.coroutines.flow.i<java.lang.Integer> r7 = r11.f25274d     // Catch:{ all -> 0x004f }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x004f }
            r7.e(r9)     // Catch:{ all -> 0x004f }
            r7 = r8
            goto L_0x001f
        L_0x0048:
            kotlin.Unit r12 = kotlin.Unit.f32013a     // Catch:{ all -> 0x004f }
            r12 = 0
            kotlin.io.b.a(r2, r12)
            return
        L_0x004f:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r0 = move-exception
            kotlin.io.b.a(r2, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.network.b.i(okio.BufferedSink):void");
    }

    public final r<Integer> j() {
        return d.a(this.f25274d);
    }
}
