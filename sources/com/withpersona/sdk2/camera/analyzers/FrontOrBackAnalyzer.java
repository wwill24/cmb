package com.withpersona.sdk2.camera.analyzers;

import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import gk.h;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class FrontOrBackAnalyzer implements b {

    /* renamed from: a  reason: collision with root package name */
    private final IdFrontAnalyzer f14228a;

    /* renamed from: b  reason: collision with root package name */
    private final BarcodePdf417Analyzer f14229b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<b, ParsedIdSideOrNone.Side> f14230c;

    public FrontOrBackAnalyzer(IdFrontAnalyzer idFrontAnalyzer, BarcodePdf417Analyzer barcodePdf417Analyzer) {
        j.g(idFrontAnalyzer, "idFrontAnalyzer");
        j.g(barcodePdf417Analyzer, "barcodePdf417Analyzer");
        this.f14228a = idFrontAnalyzer;
        this.f14229b = barcodePdf417Analyzer;
        this.f14230c = h0.l(h.a(barcodePdf417Analyzer, ParsedIdSideOrNone.Side.Back), h.a(idFrontAnalyzer, ParsedIdSideOrNone.Side.Front));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.withpersona.sdk2.camera.s r10, android.graphics.Rect r11, kotlin.coroutines.c<? super kotlin.Result<? extends com.withpersona.sdk2.camera.analyzers.a>> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer$analyze$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer$analyze$1 r0 = (com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer$analyze$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer$analyze$1 r0 = new com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer$analyze$1
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 != r3) goto L_0x0043
            java.lang.Object r10 = r0.L$4
            com.withpersona.sdk2.camera.ParsedIdSideOrNone$Side r10 = (com.withpersona.sdk2.camera.ParsedIdSideOrNone.Side) r10
            java.lang.Object r11 = r0.L$3
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r4 = r0.L$1
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            java.lang.Object r5 = r0.L$0
            com.withpersona.sdk2.camera.s r5 = (com.withpersona.sdk2.camera.s) r5
            gk.g.b(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.j()
            goto L_0x0091
        L_0x0043:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004b:
            gk.g.b(r12)
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            java.util.Map<com.withpersona.sdk2.camera.analyzers.b, com.withpersona.sdk2.camera.ParsedIdSideOrNone$Side> r2 = r9.f14230c
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
            r8 = r12
            r12 = r11
            r11 = r2
            r2 = r8
        L_0x0061:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L_0x00bb
            java.lang.Object r4 = r11.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.withpersona.sdk2.camera.analyzers.b r5 = (com.withpersona.sdk2.camera.analyzers.b) r5
            java.lang.Object r4 = r4.getValue()
            com.withpersona.sdk2.camera.ParsedIdSideOrNone$Side r4 = (com.withpersona.sdk2.camera.ParsedIdSideOrNone.Side) r4
            r0.L$0 = r10
            r0.L$1 = r12
            r0.L$2 = r2
            r0.L$3 = r11
            r0.L$4 = r4
            r0.label = r3
            java.lang.Object r5 = r5.a(r10, r12, r0)
            if (r5 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r8 = r5
            r5 = r10
            r10 = r4
            r4 = r12
            r12 = r8
        L_0x0091:
            boolean r6 = kotlin.Result.h(r12)
            if (r6 == 0) goto L_0x00ac
            r6 = r12
            com.withpersona.sdk2.camera.analyzers.a r6 = (com.withpersona.sdk2.camera.analyzers.a) r6
            com.withpersona.sdk2.camera.analyzers.a$b r7 = com.withpersona.sdk2.camera.analyzers.a.b.f14241a
            boolean r7 = kotlin.jvm.internal.j.b(r6, r7)
            if (r7 != 0) goto L_0x00ac
            com.withpersona.sdk2.camera.analyzers.a$c r11 = new com.withpersona.sdk2.camera.analyzers.a$c
            r11.<init>(r10, r6)
            java.lang.Object r10 = kotlin.Result.b(r11)
            return r10
        L_0x00ac:
            java.lang.Throwable r10 = kotlin.Result.e(r12)
            if (r10 == 0) goto L_0x00b8
            T r12 = r2.element
            if (r12 != 0) goto L_0x00b8
            r2.element = r10
        L_0x00b8:
            r12 = r4
            r10 = r5
            goto L_0x0061
        L_0x00bb:
            T r10 = r2.element
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            if (r10 == 0) goto L_0x00cc
            kotlin.Result$a r11 = kotlin.Result.f32010a
            java.lang.Object r10 = gk.g.a(r10)
            java.lang.Object r10 = kotlin.Result.b(r10)
            return r10
        L_0x00cc:
            kotlin.Result$a r10 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.analyzers.a$b r10 = com.withpersona.sdk2.camera.analyzers.a.b.f14241a
            java.lang.Object r10 = kotlin.Result.b(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer.a(com.withpersona.sdk2.camera.s, android.graphics.Rect, kotlin.coroutines.c):java.lang.Object");
    }
}
