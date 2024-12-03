package com.coffeemeetsbagel.discover_feed.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.discover_feed.filters.DiscoverFeedFiltersView;

public class DiscoverFeedMainView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    int f12385a = getResources().getDimensionPixelOffset(R.dimen.baseline_2x);

    public DiscoverFeedMainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(View view) {
        int i10 = 0;
        while (true) {
            if (i10 >= getChildCount()) {
                i10 = 0;
                break;
            } else if (getChildAt(i10) instanceof DiscoverFeedFiltersView) {
                break;
            } else {
                i10++;
            }
        }
        addView(view, i10 + 1);
        View findViewById = findViewById(R.id.recycler_view);
        if (findViewById != null) {
            findViewById.setPadding(0, 0, 0, 0);
        }
    }

    public void b(View view) {
        removeView(view);
        View findViewById = findViewById(R.id.recycler_view);
        if (findViewById != null) {
            findViewById.setPadding(0, this.f12385a, 0, 0);
        }
    }
}
