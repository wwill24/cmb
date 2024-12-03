package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

public class FitWindowsFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private n0 f1051a;

    public FitWindowsFrameLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        n0 n0Var = this.f1051a;
        if (n0Var != null) {
            n0Var.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(n0 n0Var) {
        this.f1051a = n0Var;
    }
}
