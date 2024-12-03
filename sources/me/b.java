package me;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.mparticle.kits.AppsFlyerKit;

public final class b {
    public static boolean a(@NonNull int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean b(@NonNull T[] tArr, @NonNull T t10) {
        int length = tArr != null ? tArr.length : 0;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            } else if (!n.b(tArr[i10], t10)) {
                i10++;
            } else if (i10 >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void c(@NonNull StringBuilder sb2, @NonNull double[] dArr) {
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(Double.toString(dArr[i10]));
        }
    }

    public static void d(@NonNull StringBuilder sb2, @NonNull float[] fArr) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(Float.toString(fArr[i10]));
        }
    }

    public static void e(@NonNull StringBuilder sb2, @NonNull int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(Integer.toString(iArr[i10]));
        }
    }

    public static void f(@NonNull StringBuilder sb2, @NonNull long[] jArr) {
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(Long.toString(jArr[i10]));
        }
    }

    public static <T> void g(@NonNull StringBuilder sb2, @NonNull T[] tArr) {
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(tArr[i10]);
        }
    }

    public static void h(@NonNull StringBuilder sb2, @NonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(Boolean.toString(zArr[i10]));
        }
    }

    public static void i(@NonNull StringBuilder sb2, @NonNull String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append("\"");
            sb2.append(strArr[i10]);
            sb2.append("\"");
        }
    }
}
