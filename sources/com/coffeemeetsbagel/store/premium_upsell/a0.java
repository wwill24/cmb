package com.coffeemeetsbagel.store.premium_upsell;

import android.graphics.drawable.Drawable;
import android.view.View;

public final class a0 {
    /* access modifiers changed from: private */
    public static final void b(View view, Drawable drawable) {
        int paddingTop = view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        int paddingStart = view.getPaddingStart();
        view.setBackground(drawable);
        view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }
}
