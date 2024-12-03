package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.i2;
import hf.a;

public class e {
    public static void a(@NonNull Window window, boolean z10, Integer num, Integer num2) {
        boolean z11;
        boolean z12 = false;
        if (num == null || num.intValue() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (num2 == null || num2.intValue() == 0) {
            z12 = true;
        }
        if (z11 || z12) {
            int b10 = a.b(window.getContext(), 16842801, -16777216);
            if (z11) {
                num = Integer.valueOf(b10);
            }
            if (z12) {
                num2 = Integer.valueOf(b10);
            }
        }
        i2.b(window, !z10);
        int c10 = c(window.getContext(), z10);
        int b11 = b(window.getContext(), z10);
        window.setStatusBarColor(c10);
        window.setNavigationBarColor(b11);
        f(window, d(c10, a.g(num.intValue())));
        e(window, d(b11, a.g(num2.intValue())));
    }

    @TargetApi(21)
    private static int b(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 27) {
            return androidx.core.graphics.a.l(a.b(context, 16843858, -16777216), 128);
        }
        if (z10) {
            return 0;
        }
        return a.b(context, 16843858, -16777216);
    }

    @TargetApi(21)
    private static int c(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return a.b(context, 16843857, -16777216);
    }

    private static boolean d(int i10, boolean z10) {
        return a.g(i10) || (i10 == 0 && z10);
    }

    public static void e(@NonNull Window window, boolean z10) {
        i2.a(window, window.getDecorView()).c(z10);
    }

    public static void f(@NonNull Window window, boolean z10) {
        i2.a(window, window.getDecorView()).d(z10);
    }
}
