package ti;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.c;
import androidx.core.view.s2;
import kotlin.jvm.internal.j;

public final class a {
    public static final c a(Context context) {
        j.g(context, "<this>");
        if (context instanceof c) {
            return (c) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        j.f(baseContext, "baseContext");
        return a(baseContext);
    }

    public static final String b(Context context) {
        String obj;
        j.g(context, "<this>");
        int i10 = context.getApplicationInfo().labelRes;
        if (i10 == 0) {
            try {
                CharSequence charSequence = context.getApplicationInfo().nonLocalizedLabel;
                if (charSequence == null || (obj = charSequence.toString()) == null) {
                    return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
                }
                return obj;
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        } else {
            String string = context.getString(i10);
            j.f(string, "{\n    getString(stringId)\n  }");
            return string;
        }
    }

    public static final void c(Context context) {
        View currentFocus;
        InputMethodManager inputMethodManager;
        j.g(context, "<this>");
        c a10 = a(context);
        if (a10 != null && (currentFocus = a10.getCurrentFocus()) != null) {
            Object systemService = context.getSystemService("input_method");
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    public static final boolean d(Context context) {
        j.g(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        j.e(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return ((AccessibilityManager) systemService).isEnabled();
    }

    public static final c e(Context context) {
        j.g(context, "<this>");
        c a10 = a(context);
        if (a10 != null) {
            return a10;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final void f(Context context, int i10) {
        Window window;
        boolean z10;
        j.g(context, "<this>");
        int rgb = Color.rgb(Color.red(i10), Color.green(i10), Color.blue(i10));
        c a10 = a(context);
        if (a10 != null && (window = a10.getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(rgb);
            double d10 = androidx.core.graphics.a.d(-1, rgb);
            double d11 = androidx.core.graphics.a.d(-16777216, rgb);
            View decorView = window.getDecorView();
            j.f(decorView, "window.decorView");
            s2 s2Var = new s2(window, decorView);
            if (d10 < d11) {
                z10 = true;
            } else {
                z10 = false;
            }
            s2Var.d(z10);
        }
    }
}
