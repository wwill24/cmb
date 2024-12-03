package x1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f18361a = true;

    static y a(@NonNull ViewGroup viewGroup) {
        return new x(viewGroup);
    }

    @SuppressLint({"NewApi"})
    private static void b(@NonNull ViewGroup viewGroup, boolean z10) {
        if (f18361a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f18361a = false;
            }
        }
    }

    static void c(@NonNull ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z10);
        } else {
            b(viewGroup, z10);
        }
    }
}
