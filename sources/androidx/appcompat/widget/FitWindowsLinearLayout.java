package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;

public class FitWindowsLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private n0 f1052a;

    public FitWindowsLinearLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        n0 n0Var = this.f1052a;
        if (n0Var != null) {
            n0Var.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(n0 n0Var) {
        this.f1052a = n0Var;
    }
}
