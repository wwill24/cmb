package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

public final class ViewGroupUtil {
    private ViewGroupUtil() {
    }

    public static int findChildIndex(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (viewGroup.getChildAt(i10) == view) {
                return i10;
            }
        }
        return -1;
    }
}
