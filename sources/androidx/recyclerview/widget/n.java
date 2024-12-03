package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import o1.c;

class n implements m {

    /* renamed from: a  reason: collision with root package name */
    static final m f6685a = new n();

    n() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float w10 = n0.w(childAt);
                if (w10 > f10) {
                    f10 = w10;
                }
            }
        }
        return f10;
    }

    public void a(@NonNull View view) {
        int i10 = c.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i10);
        if (tag instanceof Float) {
            n0.A0(view, ((Float) tag).floatValue());
        }
        view.setTag(i10, (Object) null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void b(@NonNull View view) {
    }

    public void c(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull View view, float f10, float f11, int i10, boolean z10) {
        if (z10) {
            int i11 = c.item_touch_helper_previous_elevation;
            if (view.getTag(i11) == null) {
                Float valueOf = Float.valueOf(n0.w(view));
                n0.A0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i11, valueOf);
            }
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }

    public void d(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull View view, float f10, float f11, int i10, boolean z10) {
    }
}
