package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

public final class b2 {

    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z10) {
            viewGroup.setTransitionGroup(z10);
        }
    }

    public static boolean a(@NonNull ViewGroup viewGroup) {
        return a.b(viewGroup);
    }
}
