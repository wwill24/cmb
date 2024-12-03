package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.core.view.ScrollingView;
import androidx.core.view.c0;
import androidx.core.view.d0;

public class CmbListView extends ListView implements ScrollingView, c0 {

    /* renamed from: a  reason: collision with root package name */
    private d0 f11483a;

    public CmbListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setNestedScrollingEnabled(true);
    }

    private d0 getScrollingChildHelper() {
        if (this.f11483a == null) {
            this.f11483a = new d0(this);
        }
        return this.f11483a;
    }

    public int computeHorizontalScrollExtent() {
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        return 0;
    }

    public int computeHorizontalScrollRange() {
        return 0;
    }

    public int computeVerticalScrollExtent() {
        return 0;
    }

    public int computeVerticalScrollOffset() {
        return 0;
    }

    public int computeVerticalScrollRange() {
        return 0;
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().m(z10);
    }

    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().o(i10);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }
}
