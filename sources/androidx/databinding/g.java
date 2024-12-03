package androidx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static e f4993a = new DataBinderMapperImpl();

    /* renamed from: b  reason: collision with root package name */
    private static f f4994b = null;

    static <T extends ViewDataBinding> T a(f fVar, View view, int i10) {
        return f4993a.b(fVar, view, i10);
    }

    static <T extends ViewDataBinding> T b(f fVar, View[] viewArr, int i10) {
        return f4993a.c(fVar, viewArr, i10);
    }

    private static <T extends ViewDataBinding> T c(f fVar, ViewGroup viewGroup, int i10, int i11) {
        int childCount = viewGroup.getChildCount();
        int i12 = childCount - i10;
        if (i12 == 1) {
            return a(fVar, viewGroup.getChildAt(childCount - 1), i11);
        }
        View[] viewArr = new View[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            viewArr[i13] = viewGroup.getChildAt(i13 + i10);
        }
        return b(fVar, viewArr, i11);
    }

    public static f d() {
        return f4994b;
    }

    public static <T extends ViewDataBinding> T e(@NonNull LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, f fVar) {
        boolean z11;
        int i11 = 0;
        if (viewGroup == null || !z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            i11 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i10, viewGroup, z10);
        if (z11) {
            return c(fVar, viewGroup, i11, i10);
        }
        return a(fVar, inflate, i10);
    }
}
