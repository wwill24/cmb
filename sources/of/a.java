package of;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.core.graphics.d;
import com.mparticle.kits.AppsFlyerKit;
import qf.b;

public class a {
    private static float a(String[] strArr, int i10) {
        float parseFloat = Float.parseFloat(strArr[i10]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static TimeInterpolator c(String str) {
        if (e(str, "cubic-bezier")) {
            String[] split = b(str, "cubic-bezier").split(AppsFlyerKit.COMMA);
            if (split.length == 4) {
                return androidx.core.view.animation.a.a(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        } else if (e(str, "path")) {
            return androidx.core.view.animation.a.b(d.e(b(str, "path")));
        } else {
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
    }

    private static boolean d(String str) {
        if (e(str, "cubic-bezier") || e(str, "path")) {
            return true;
        }
        return false;
    }

    private static boolean e(String str, String str2) {
        if (!str.startsWith(str2 + "(") || !str.endsWith(")")) {
            return false;
        }
        return true;
    }

    public static int f(@NonNull Context context, int i10, int i11) {
        return b.c(context, i10, i11);
    }

    @NonNull
    public static TimeInterpolator g(@NonNull Context context, int i10, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (d(valueOf)) {
                return c(valueOf);
            }
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}
