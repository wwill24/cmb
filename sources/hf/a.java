package hf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import qf.b;

public class a {
    public static int a(int i10, int i11) {
        return androidx.core.graphics.a.l(i10, (Color.alpha(i10) * i11) / 255);
    }

    public static int b(@NonNull Context context, int i10, int i11) {
        TypedValue a10 = b.a(context, i10);
        if (a10 != null) {
            return k(context, a10);
        }
        return i11;
    }

    public static int c(Context context, int i10, String str) {
        return k(context, b.e(context, i10, str));
    }

    public static int d(@NonNull View view, int i10) {
        return k(view.getContext(), b.f(view, i10));
    }

    public static int e(@NonNull View view, int i10, int i11) {
        return b(view.getContext(), i10, i11);
    }

    public static ColorStateList f(@NonNull Context context, int i10) {
        TypedValue a10 = b.a(context, i10);
        if (a10 == null) {
            return null;
        }
        int i11 = a10.resourceId;
        if (i11 != 0) {
            return androidx.core.content.a.getColorStateList(context, i11);
        }
        int i12 = a10.data;
        if (i12 != 0) {
            return ColorStateList.valueOf(i12);
        }
        return null;
    }

    public static boolean g(int i10) {
        return i10 != 0 && androidx.core.graphics.a.e(i10) > 0.5d;
    }

    public static int h(int i10, int i11) {
        return androidx.core.graphics.a.h(i11, i10);
    }

    public static int i(int i10, int i11, float f10) {
        return h(i10, androidx.core.graphics.a.l(i11, Math.round(((float) Color.alpha(i11)) * f10)));
    }

    public static int j(@NonNull View view, int i10, int i11, float f10) {
        return i(d(view, i10), d(view, i11), f10);
    }

    private static int k(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        if (i10 != 0) {
            return androidx.core.content.a.getColor(context, i10);
        }
        return typedValue.data;
    }
}
