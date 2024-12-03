package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import cf.a;
import com.google.android.material.internal.r;
import com.google.android.material.tabs.TabLayout;

class c {
    c() {
    }

    static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.D() || !(view instanceof TabLayout.i)) {
            return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        }
        return b((TabLayout.i) view, 24);
    }

    static RectF b(@NonNull TabLayout.i iVar, int i10) {
        int contentWidth = iVar.getContentWidth();
        int contentHeight = iVar.getContentHeight();
        int c10 = (int) r.c(iVar.getContext(), i10);
        if (contentWidth < c10) {
            contentWidth = c10;
        }
        int left = (iVar.getLeft() + iVar.getRight()) / 2;
        int top = (iVar.getTop() + iVar.getBottom()) / 2;
        int i11 = contentWidth / 2;
        return new RectF((float) (left - i11), (float) (top - (contentHeight / 2)), (float) (i11 + left), (float) (top + (left / 2)));
    }

    /* access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a10 = a(tabLayout, view);
        drawable.setBounds((int) a10.left, drawable.getBounds().top, (int) a10.right, drawable.getBounds().bottom);
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f10, @NonNull Drawable drawable) {
        RectF a10 = a(tabLayout, view);
        RectF a11 = a(tabLayout, view2);
        drawable.setBounds(a.c((int) a10.left, (int) a11.left, f10), drawable.getBounds().top, a.c((int) a10.right, (int) a11.right, f10), drawable.getBounds().bottom);
    }
}
