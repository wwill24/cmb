package com.withpersona.sdk2.camera;

import androidx.camera.core.l0;
import com.withpersona.sdk2.camera.camera2.a;
import kotlin.Result;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.l;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class SelfieDirectionFeed implements l0.a, l<Result<? extends w>>, a {

    /* renamed from: a  reason: collision with root package name */
    private final SelfieProcessor f14192a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final h<Result<w>> f14193b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f14194c = kotlinx.coroutines.l0.a(x0.a().e0(o2.b((s1) null, 1, (Object) null)));

    public SelfieDirectionFeed(SelfieProcessor selfieProcessor, h<Result<w>> hVar) {
        j.g(selfieProcessor, "selfieProcessor");
        j.g(hVar, "resultFlow");
        this.f14192a = selfieProcessor;
        this.f14193b = hVar;
    }

    public Object a(c<? super Result<? extends w>> cVar, kotlin.coroutines.c<?> cVar2) {
        return this.f14193b.a(cVar, cVar2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        nk.a.a(r8, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(android.media.Image r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "image"
            kotlin.jvm.internal.j.g(r8, r0)
            com.withpersona.sdk2.camera.SelfieProcessor r0 = r7.f14192a     // Catch:{ all -> 0x001e }
            java.lang.Object r9 = r0.c(r8, r9)     // Catch:{ all -> 0x001e }
            r0 = 0
            nk.a.a(r8, r0)
            kotlinx.coroutines.k0 r1 = r7.f14194c
            r2 = 0
            r3 = 0
            com.withpersona.sdk2.camera.SelfieDirectionFeed$analyze$2 r4 = new com.withpersona.sdk2.camera.SelfieDirectionFeed$analyze$2
            r4.<init>(r7, r9, r0)
            r5 = 3
            r6 = 0
            kotlinx.coroutines.s1 unused = kotlinx.coroutines.j.d(r1, r2, r3, r4, r5, r6)
            return
        L_0x001e:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r0 = move-exception
            nk.a.a(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.SelfieDirectionFeed.g(android.media.Image, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        nk.a.a(r9, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(androidx.camera.core.o1 r9) {
        /*
            r8 = this;
            java.lang.String r0 = "imageProxy"
            kotlin.jvm.internal.j.g(r9, r0)
            com.withpersona.sdk2.camera.SelfieProcessor r0 = r8.f14192a     // Catch:{ all -> 0x001e }
            java.lang.Object r0 = r0.a(r9)     // Catch:{ all -> 0x001e }
            r1 = 0
            nk.a.a(r9, r1)
            kotlinx.coroutines.k0 r2 = r8.f14194c
            r3 = 0
            r4 = 0
            com.withpersona.sdk2.camera.SelfieDirectionFeed$analyze$1 r5 = new com.withpersona.sdk2.camera.SelfieDirectionFeed$analyze$1
            r5.<init>(r8, r0, r1)
            r6 = 3
            r7 = 0
            kotlinx.coroutines.s1 unused = kotlinx.coroutines.j.d(r2, r3, r4, r5, r6, r7)
            return
        L_0x001e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            nk.a.a(r9, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.SelfieDirectionFeed.i(androidx.camera.core.o1):void");
    }
}
