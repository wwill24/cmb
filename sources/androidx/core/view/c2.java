package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;

public final class c2 {

    static class a {
        static boolean a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
            return viewParent.onNestedFling(view, f10, f11, z10);
        }

        static boolean b(ViewParent viewParent, View view, float f10, float f11) {
            return viewParent.onNestedPreFling(view, f10, f11);
        }

        static void c(ViewParent viewParent, View view, int i10, int i11, int[] iArr) {
            viewParent.onNestedPreScroll(view, i10, i11, iArr);
        }

        static void d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13) {
            viewParent.onNestedScroll(view, i10, i11, i12, i13);
        }

        static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.onNestedScrollAccepted(view, view2, i10);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i10) {
            return viewParent.onStartNestedScroll(view, view2, i10);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(@NonNull ViewParent viewParent, @NonNull View view, float f10, float f11, boolean z10) {
        try {
            return a.a(viewParent, view, f10, f11, z10);
        } catch (AbstractMethodError unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ViewParent ");
            sb2.append(viewParent);
            sb2.append(" does not implement interface method onNestedFling");
            return false;
        }
    }

    public static boolean b(@NonNull ViewParent viewParent, @NonNull View view, float f10, float f11) {
        try {
            return a.b(viewParent, view, f10, f11);
        } catch (AbstractMethodError unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ViewParent ");
            sb2.append(viewParent);
            sb2.append(" does not implement interface method onNestedPreFling");
            return false;
        }
    }

    public static void c(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        if (viewParent instanceof e0) {
            ((e0) viewParent).k(view, i10, i11, iArr, i12);
        } else if (i12 == 0) {
            try {
                a.c(viewParent, view, i10, i11, iArr);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onNestedPreScroll");
            }
        }
    }

    public static void d(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof f0) {
            ((f0) viewParent2).m(view, i10, i11, i12, i13, i14, iArr);
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (viewParent2 instanceof e0) {
            ((e0) viewParent2).n(view, i10, i11, i12, i13, i14);
        } else if (i14 == 0) {
            try {
                a.d(viewParent, view, i10, i11, i12, i13);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onNestedScroll");
            }
        }
    }

    public static void e(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10, int i11) {
        if (viewParent instanceof e0) {
            ((e0) viewParent).i(view, view2, i10, i11);
        } else if (i11 == 0) {
            try {
                a.e(viewParent, view, view2, i10);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onNestedScrollAccepted");
            }
        }
    }

    public static boolean f(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10, int i11) {
        if (viewParent instanceof e0) {
            return ((e0) viewParent).o(view, view2, i10, i11);
        }
        if (i11 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i10);
        } catch (AbstractMethodError unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ViewParent ");
            sb2.append(viewParent);
            sb2.append(" does not implement interface method onStartNestedScroll");
            return false;
        }
    }

    public static void g(@NonNull ViewParent viewParent, @NonNull View view, int i10) {
        if (viewParent instanceof e0) {
            ((e0) viewParent).j(view, i10);
        } else if (i10 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onStopNestedScroll");
            }
        }
    }
}
