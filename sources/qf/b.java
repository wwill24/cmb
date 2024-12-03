package qf;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;

public class b {
    public static TypedValue a(@NonNull Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, int i10, boolean z10) {
        TypedValue a10 = a(context, i10);
        if (a10 == null || a10.type != 18) {
            return z10;
        }
        if (a10.data != 0) {
            return true;
        }
        return false;
    }

    public static int c(@NonNull Context context, int i10, int i11) {
        TypedValue a10 = a(context, i10);
        if (a10 == null || a10.type != 16) {
            return i11;
        }
        return a10.data;
    }

    public static int d(@NonNull Context context, int i10, @NonNull String str) {
        return e(context, i10, str).data;
    }

    @NonNull
    public static TypedValue e(@NonNull Context context, int i10, @NonNull String str) {
        TypedValue a10 = a(context, i10);
        if (a10 != null) {
            return a10;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i10)}));
    }

    @NonNull
    public static TypedValue f(@NonNull View view, int i10) {
        return e(view.getContext(), i10, view.getClass().getCanonicalName());
    }
}
