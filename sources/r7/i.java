package r7;

import android.view.MotionEvent;
import android.view.View;

public class i implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17385a;

    /* renamed from: b  reason: collision with root package name */
    private Float f17386b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17387c;

    public interface a {
        void a();

        void b();
    }

    public i(a aVar) {
        this.f17387c = aVar;
    }

    public boolean a() {
        return this.f17385a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f17386b = Float.valueOf(motionEvent.getRawY());
            this.f17385a = true;
            return false;
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                this.f17385a = true;
                if (this.f17386b == null) {
                    this.f17386b = Float.valueOf(motionEvent.getRawY());
                }
                double rawY = (double) (motionEvent.getRawY() - this.f17386b.floatValue());
                if (rawY > 0.0d) {
                    this.f17387c.b();
                } else if (rawY < 0.0d) {
                    this.f17387c.a();
                }
            }
            return false;
        } else {
            this.f17386b = null;
            this.f17385a = false;
            return false;
        }
    }
}
