package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import q5.h;

public class CustomViewPagerNonSwipeable extends ViewPager {

    /* renamed from: s0  reason: collision with root package name */
    private boolean f11503s0;

    /* renamed from: t0  reason: collision with root package name */
    private float f11504t0;

    /* renamed from: u0  reason: collision with root package name */
    private float f11505u0;

    /* renamed from: v0  reason: collision with root package name */
    private h f11506v0;

    public CustomViewPagerNonSwipeable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f11504t0 = motionEvent.getX();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (action == 1) {
                this.f11505u0 = motionEvent.getX();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            } else {
                if (this.f11503s0) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                return false;
            }
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11504t0 = motionEvent.getX();
            return super.onTouchEvent(motionEvent);
        } else if (action == 1) {
            this.f11505u0 = motionEvent.getX();
            return super.onTouchEvent(motionEvent);
        } else if (action != 2) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (this.f11503s0) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public void setListenerOnLeftSwipe(h hVar) {
        this.f11506v0 = hVar;
    }

    public void setSwipeable(boolean z10) {
        this.f11503s0 = z10;
    }
}
