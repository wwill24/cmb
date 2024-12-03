package qf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.h1;
import e.a;

public class c {
    public static ColorStateList a(@NonNull Context context, @NonNull TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList a10;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (a10 = a.a(context, resourceId)) == null) {
            return typedArray.getColorStateList(i10);
        }
        return a10;
    }

    public static ColorStateList b(@NonNull Context context, @NonNull h1 h1Var, int i10) {
        int n10;
        ColorStateList a10;
        if (!h1Var.s(i10) || (n10 = h1Var.n(i10, 0)) == 0 || (a10 = a.a(context, n10)) == null) {
            return h1Var.c(i10);
        }
        return a10;
    }

    public static int c(@NonNull Context context, @NonNull TypedArray typedArray, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i10, i11);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i11);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(@NonNull Context context, @NonNull TypedArray typedArray, int i10) {
        int resourceId;
        Drawable b10;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (b10 = a.b(context, resourceId)) == null) {
            return typedArray.getDrawable(i10);
        }
        return b10;
    }

    static int e(@NonNull TypedArray typedArray, int i10, int i11) {
        return typedArray.hasValue(i10) ? i10 : i11;
    }

    public static d f(@NonNull Context context, @NonNull TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean g(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
