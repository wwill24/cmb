package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.List;
import t2.t;
import x2.b;
import x2.d;
import y2.c;

public class ShapeStroke implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f8667a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8668b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f8669c;

    /* renamed from: d  reason: collision with root package name */
    private final x2.a f8670d;

    /* renamed from: e  reason: collision with root package name */
    private final d f8671e;

    /* renamed from: f  reason: collision with root package name */
    private final b f8672f;

    /* renamed from: g  reason: collision with root package name */
    private final LineCapType f8673g;

    /* renamed from: h  reason: collision with root package name */
    private final LineJoinType f8674h;

    /* renamed from: i  reason: collision with root package name */
    private final float f8675i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f8676j;

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap b() {
            int i10 = a.f8685a[ordinal()];
            if (i10 == 1) {
                return Paint.Cap.BUTT;
            }
            if (i10 != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join b() {
            int i10 = a.f8686b[ordinal()];
            if (i10 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i10 == 2) {
                return Paint.Join.MITER;
            }
            if (i10 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8685a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f8686b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8686b = r0
                r1 = 1
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.BEVEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8686b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.MITER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8686b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8685a = r3
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.BUTT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f8685a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.ROUND     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f8685a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r1 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.ShapeStroke.a.<clinit>():void");
        }
    }

    public ShapeStroke(String str, b bVar, List<b> list, x2.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f10, boolean z10) {
        this.f8667a = str;
        this.f8668b = bVar;
        this.f8669c = list;
        this.f8670d = aVar;
        this.f8671e = dVar;
        this.f8672f = bVar2;
        this.f8673g = lineCapType;
        this.f8674h = lineJoinType;
        this.f8675i = f10;
        this.f8676j = z10;
    }

    public t2.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new t(lottieDrawable, aVar, this);
    }

    public LineCapType b() {
        return this.f8673g;
    }

    public x2.a c() {
        return this.f8670d;
    }

    public b d() {
        return this.f8668b;
    }

    public LineJoinType e() {
        return this.f8674h;
    }

    public List<b> f() {
        return this.f8669c;
    }

    public float g() {
        return this.f8675i;
    }

    public String h() {
        return this.f8667a;
    }

    public d i() {
        return this.f8671e;
    }

    public b j() {
        return this.f8672f;
    }

    public boolean k() {
        return this.f8676j;
    }
}
