package zn;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class c extends b {

    /* renamed from: j  reason: collision with root package name */
    protected final ScaleGestureDetector f42553j;

    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            c.this.f42544a.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public c(Context context) {
        super(context);
        this.f42553j = new ScaleGestureDetector(context, new a());
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            this.f42553j.onTouchEvent(motionEvent);
            return super.a(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean d() {
        return this.f42553j.isInProgress();
    }
}
