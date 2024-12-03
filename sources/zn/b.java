package zn;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import yn.a;

@TargetApi(5)
public class b extends a {

    /* renamed from: h  reason: collision with root package name */
    private int f42551h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f42552i = 0;

    public b(Context context) {
        super(context);
    }

    public boolean a(MotionEvent motionEvent) {
        int i10;
        int action = motionEvent.getAction() & 255;
        int i11 = 0;
        if (action == 0) {
            this.f42551h = motionEvent.getPointerId(0);
        } else if (action == 1 || action == 3) {
            this.f42551h = -1;
        } else if (action == 6) {
            int a10 = a.a(motionEvent.getAction());
            if (motionEvent.getPointerId(a10) == this.f42551h) {
                if (a10 == 0) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                this.f42551h = motionEvent.getPointerId(i10);
                this.f42545b = motionEvent.getX(i10);
                this.f42546c = motionEvent.getY(i10);
            }
        }
        int i12 = this.f42551h;
        if (i12 != -1) {
            i11 = i12;
        }
        this.f42552i = motionEvent.findPointerIndex(i11);
        try {
            return super.a(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f42552i);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* access modifiers changed from: package-private */
    public float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f42552i);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }
}
