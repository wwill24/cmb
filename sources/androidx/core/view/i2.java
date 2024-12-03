package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;

public final class i2 {

    static class a {
        static void a(@NonNull Window window, boolean z10) {
            int i10;
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z10) {
                i10 = systemUiVisibility & -1793;
            } else {
                i10 = systemUiVisibility | 1792;
            }
            decorView.setSystemUiVisibility(i10);
        }
    }

    static class b {
        static void a(@NonNull Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    @NonNull
    public static s2 a(@NonNull Window window, @NonNull View view) {
        return new s2(window, view);
    }

    public static void b(@NonNull Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.a(window, z10);
        } else {
            a.a(window, z10);
        }
    }
}
