package coil.decode;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcoil/decode/c;", "a", "()Lcoil/decode/c;"}, k = 3, mv = {1, 7, 1})
final class SvgDecoder$decode$2 extends Lambda implements Function0<c> {
    final /* synthetic */ SvgDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SvgDecoder$decode$2(SvgDecoder svgDecoder) {
        super(0);
        this.this$0 = svgDecoder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e3, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e4, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e7, code lost:
        throw r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil.decode.c invoke() {
        /*
            r10 = this;
            coil.decode.SvgDecoder r0 = r10.this$0
            coil.decode.k r0 = r0.f8084a
            okio.BufferedSource r0 = r0.b()
            java.io.InputStream r1 = r0.Z1()     // Catch:{ all -> 0x00e1 }
            com.caverock.androidsvg.SVG r1 = com.caverock.androidsvg.SVG.l(r1)     // Catch:{ all -> 0x00e1 }
            r2 = 0
            kotlin.io.b.a(r0, r2)
            android.graphics.RectF r0 = r1.g()
            coil.decode.SvgDecoder r3 = r10.this$0
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x002d
            if (r0 == 0) goto L_0x002d
            float r3 = r0.width()
            float r4 = r0.height()
            goto L_0x0035
        L_0x002d:
            float r3 = r1.h()
            float r4 = r1.f()
        L_0x0035:
            coil.decode.SvgDecoder r5 = r10.this$0
            coil.request.k r6 = r5.f8085b
            coil.size.Scale r6 = r6.n()
            kotlin.Pair r5 = r5.e(r3, r4, r6)
            java.lang.Object r6 = r5.a()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            java.lang.Object r5 = r5.b()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0074
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0074
            coil.decode.SvgDecoder r9 = r10.this$0
            coil.request.k r9 = r9.f8085b
            coil.size.Scale r9 = r9.n()
            float r5 = coil.decode.d.d(r3, r4, r6, r5, r9)
            float r6 = r5 * r3
            int r6 = (int) r6
            float r5 = r5 * r4
            int r5 = (int) r5
            goto L_0x007c
        L_0x0074:
            int r6 = sk.c.b(r6)
            int r5 = sk.c.b(r5)
        L_0x007c:
            if (r0 != 0) goto L_0x0087
            if (r8 <= 0) goto L_0x0087
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            r1.s(r7, r7, r3, r4)
        L_0x0087:
            java.lang.String r0 = "100%"
            r1.t(r0)
            r1.r(r0)
            coil.decode.SvgDecoder r0 = r10.this$0
            coil.request.k r0 = r0.f8085b
            android.graphics.Bitmap$Config r0 = r0.f()
            android.graphics.Bitmap$Config r0 = coil.util.i.d(r0)
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r6, r5, r0)
            java.lang.String r3 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.j.f(r0, r3)
            coil.decode.SvgDecoder r3 = r10.this$0
            coil.request.k r3 = r3.f8085b
            coil.request.l r3 = r3.l()
            java.lang.String r3 = coil.request.o.a(r3)
            if (r3 == 0) goto L_0x00bf
            com.caverock.androidsvg.c r2 = new com.caverock.androidsvg.c
            r2.<init>()
            com.caverock.androidsvg.c r2 = r2.a(r3)
        L_0x00bf:
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r0)
            r1.o(r3, r2)
            coil.decode.c r1 = new coil.decode.c
            coil.decode.SvgDecoder r2 = r10.this$0
            coil.request.k r2 = r2.f8085b
            android.content.Context r2 = r2.g()
            android.content.res.Resources r2 = r2.getResources()
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            r3.<init>(r2, r0)
            r0 = 1
            r1.<init>(r3, r0)
            return r1
        L_0x00e1:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.SvgDecoder$decode$2.invoke():coil.decode.c");
    }
}
