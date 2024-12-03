package rf;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.core.graphics.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f24443a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f24444b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f24445c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f24446d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f24447e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f24448f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f24449g = {16842913, 16843623, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f24450h = {16842913, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f24451i = {16842913, 16843623};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f24452j = {16842913};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f24453k = {16842910, 16842919};

    /* renamed from: l  reason: collision with root package name */
    static final String f24454l = b.class.getSimpleName();

    private b() {
    }

    @NonNull
    public static ColorStateList a(ColorStateList colorStateList) {
        if (f24443a) {
            int[] iArr = f24446d;
            return new ColorStateList(new int[][]{f24452j, iArr, StateSet.NOTHING}, new int[]{c(colorStateList, f24448f), c(colorStateList, iArr), c(colorStateList, f24444b)});
        }
        int[] iArr2 = f24448f;
        int[] iArr3 = f24449g;
        int[] iArr4 = f24450h;
        int[] iArr5 = f24451i;
        int[] iArr6 = f24444b;
        int[] iArr7 = f24445c;
        int[] iArr8 = f24446d;
        int[] iArr9 = f24447e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f24452j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), c(colorStateList, iArr5), 0, c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), c(colorStateList, iArr9), 0});
    }

    @TargetApi(21)
    private static int b(int i10) {
        return a.l(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int i10;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i10 = 0;
        }
        if (f24443a) {
            return b(i10);
        }
        return i10;
    }

    @NonNull
    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(f24453k, 0));
        }
        return colorStateList;
    }

    public static boolean e(@NonNull int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
