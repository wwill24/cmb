package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;

public final class GestureDetectorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final a f4742a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f4743a;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f4743a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.f4743a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(@NonNull Context context, @NonNull GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public boolean a(@NonNull MotionEvent motionEvent) {
        return this.f4742a.a(motionEvent);
    }

    public GestureDetectorCompat(@NonNull Context context, @NonNull GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f4742a = new b(context, onGestureListener, handler);
    }
}
