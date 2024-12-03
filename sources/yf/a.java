package yf;

import android.graphics.Bitmap;
import com.google.android.renderscript.Range2d;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: yf.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0295a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24782a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f24782a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yf.a.C0295a.<clinit>():void");
        }
    }

    public static final Bitmap a(Bitmap bitmap) {
        j.g(bitmap, "inputBitmap");
        return Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public static final void b(String str, Bitmap bitmap, boolean z10) {
        boolean z11;
        boolean z12;
        j.g(str, "function");
        j.g(bitmap, "inputBitmap");
        boolean z13 = true;
        if (z10) {
            if (bitmap.getConfig() == Bitmap.Config.ARGB_8888 || bitmap.getConfig() == Bitmap.Config.ALPHA_8) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalArgumentException(("RenderScript Toolkit. " + str + " supports only ARGB_8888 and ALPHA_8 bitmaps. " + bitmap.getConfig() + " provided.").toString());
            }
        } else {
            if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException(("RenderScript Toolkit. " + str + " supports only ARGB_8888. " + bitmap.getConfig() + " provided.").toString());
            }
        }
        if (bitmap.getWidth() * f(bitmap) != bitmap.getRowBytes()) {
            z13 = false;
        }
        if (!z13) {
            throw new IllegalArgumentException(("RenderScript Toolkit " + str + ". Only bitmaps with rowSize equal to the width * vectorSize are currently supported. Provided were rowBytes=" + bitmap.getRowBytes() + ", width={" + bitmap.getWidth() + ", and vectorSize=" + f(bitmap) + '.').toString());
        }
    }

    public static /* synthetic */ void c(String str, Bitmap bitmap, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        b(str, bitmap, z10);
    }

    public static final void d(String str, int i10, int i11, Range2d range2d) {
        j.g(str, "tag");
    }

    public static final void e(String str, Bitmap bitmap, Range2d range2d) {
        j.g(str, "tag");
        j.g(bitmap, "bitmap");
        d(str, bitmap.getWidth(), bitmap.getHeight(), range2d);
    }

    public static final int f(Bitmap bitmap) {
        int i10;
        j.g(bitmap, "bitmap");
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            i10 = -1;
        } else {
            i10 = C0295a.f24782a[config.ordinal()];
        }
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("RenderScript Toolkit. Only ARGB_8888 and ALPHA_8 Bitmap are supported.");
    }
}
