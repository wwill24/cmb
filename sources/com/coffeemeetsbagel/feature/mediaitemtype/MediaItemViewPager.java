package com.coffeemeetsbagel.feature.mediaitemtype;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.interfaces.MediaItemContract;
import h5.i;
import java.util.List;
import k8.d;
import x4.q;

public class MediaItemViewPager extends ViewPager implements MediaItemContract.Listener {

    /* renamed from: s0  reason: collision with root package name */
    private d f13089s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public int f13090t0;

    /* renamed from: u0  reason: collision with root package name */
    private MediaItemContract.ViewPager.Listener f13091u0;

    /* renamed from: v0  reason: collision with root package name */
    private boolean f13092v0;

    class a implements ViewPager.j {
        a() {
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            MediaItemViewPager.this.f13090t0 = i10;
            Bundle bundle = new Bundle();
            bundle.putInt(Extra.VIEW_PAGER_POSITION, MediaItemViewPager.this.getCurrentItem());
            i.c(EventType.PROFILE_DETAILS_VIEW_PAGER_PAGE_SELECTED, bundle);
        }
    }

    public MediaItemViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13092v0 = context.obtainStyledAttributes(attributeSet, q.MediaItemViewPager, 0, 0).getBoolean(0, false);
        T();
    }

    private void T() {
        c(new a());
    }

    public int getCurrentPage() {
        return this.f13090t0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getCurrentItem() == 0 && getChildCount() == 0) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f13092v0) {
            super.onMeasure(i10, i11);
        } else {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) Math.ceil((double) ((float) i10)), 1073741824));
        }
    }

    public void onPhotoClicked() {
        MediaItemContract.ViewPager.Listener listener = this.f13091u0;
        if (listener != null) {
            listener.onPhotoClicked();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCurrentItem() == 0 && getChildCount() == 0) {
            return false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e10) {
            fa.a.i(e10);
            return false;
        } catch (IndexOutOfBoundsException e11) {
            fa.a.i(e11);
            return false;
        }
    }

    public void setListener(MediaItemContract.ViewPager.Listener listener) {
        this.f13091u0 = listener;
    }

    public void setMediaItems(List<MediaItemContract.MediaItem> list) {
        this.f13090t0 = 0;
        if (this.f13089s0 == null) {
            d dVar = new d(list, this, this.f13092v0);
            this.f13089s0 = dVar;
            setAdapter(dVar);
            return;
        }
        N(0, false);
        this.f13089s0.D(list);
    }
}
