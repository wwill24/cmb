package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.widget.k;
import d.j;

class p extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1384b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1385a;

    public p(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    private void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        h1 v10 = h1.v(context, attributeSet, j.PopupWindow, i10, i11);
        int i12 = j.PopupWindow_overlapAnchor;
        if (v10.s(i12)) {
            b(v10.a(i12, false));
        }
        setBackgroundDrawable(v10.g(j.PopupWindow_android_popupBackground));
        v10.w();
    }

    private void b(boolean z10) {
        if (f1384b) {
            this.f1385a = z10;
        } else {
            k.a(this, z10);
        }
    }

    public void showAsDropDown(View view, int i10, int i11) {
        if (f1384b && this.f1385a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f1384b && this.f1385a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f1384b && this.f1385a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
