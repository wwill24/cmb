package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import l.a;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f1526a = getResources().getDimensionPixelOffset(a.browser_actions_context_menu_min_padding);

    /* renamed from: b  reason: collision with root package name */
    private final int f1527b = getResources().getDimensionPixelOffset(a.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f1526a * 2), this.f1527b), 1073741824), i11);
    }
}
