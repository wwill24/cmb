package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.facebook.stetho.common.Util;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

abstract class ViewHighlighter {

    private static final class NoopHighlighter extends ViewHighlighter {
        private NoopHighlighter() {
        }

        public void clearHighlight() {
        }

        public void setHighlightedView(View view, Rect rect, int i10) {
        }
    }

    @TargetApi(18)
    private static final class OverlayHighlighter extends ViewHighlighter {
        private AtomicReference<Rect> mBoundsToHighlight = new AtomicReference<>();
        private AtomicInteger mContentColor = new AtomicInteger();
        private final Rect mEmptyRect = new Rect();
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private final ViewHighlightOverlays mHighlightOverlays = ViewHighlightOverlays.newInstance();
        private final Runnable mHighlightViewOnUiThreadRunnable = new Runnable() {
            public void run() {
                OverlayHighlighter.this.highlightViewOnUiThread();
            }
        };
        private final Rect mHighlightedBounds = new Rect();
        private View mHighlightedView;
        private AtomicReference<View> mViewToHighlight = new AtomicReference<>();

        /* access modifiers changed from: private */
        public void highlightViewOnUiThread() {
            View andSet = this.mViewToHighlight.getAndSet((Object) null);
            Rect andSet2 = this.mBoundsToHighlight.getAndSet((Object) null);
            if (andSet2 == null) {
                andSet2 = this.mEmptyRect;
            }
            if (andSet != this.mHighlightedView || !this.mHighlightedBounds.equals(andSet2)) {
                View view = this.mHighlightedView;
                if (view != null) {
                    this.mHighlightOverlays.removeHighlight(view);
                }
                if (andSet != null) {
                    this.mHighlightOverlays.highlightView(andSet, andSet2, this.mContentColor.get());
                }
                this.mHighlightedView = andSet;
                if (andSet2 == null) {
                    this.mHighlightedBounds.setEmpty();
                } else {
                    this.mHighlightedBounds.set(andSet2);
                }
            }
        }

        private void setHighlightedViewImpl(View view, Rect rect, int i10) {
            this.mHandler.removeCallbacks(this.mHighlightViewOnUiThreadRunnable);
            this.mViewToHighlight.set(view);
            this.mBoundsToHighlight.set(rect);
            this.mContentColor.set(i10);
            this.mHandler.postDelayed(this.mHighlightViewOnUiThreadRunnable, 100);
        }

        public void clearHighlight() {
            setHighlightedViewImpl((View) null, (Rect) null, 0);
        }

        public void setHighlightedView(View view, Rect rect, int i10) {
            setHighlightedViewImpl((View) Util.throwIfNull(view), rect, i10);
        }
    }

    protected ViewHighlighter() {
    }

    public static ViewHighlighter newInstance() {
        return new OverlayHighlighter();
    }

    public abstract void clearHighlight();

    public abstract void setHighlightedView(View view, Rect rect, int i10);
}
