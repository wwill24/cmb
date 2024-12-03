package zn;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected e f42544a;

    /* renamed from: b  reason: collision with root package name */
    float f42545b;

    /* renamed from: c  reason: collision with root package name */
    float f42546c;

    /* renamed from: d  reason: collision with root package name */
    final float f42547d;

    /* renamed from: e  reason: collision with root package name */
    final float f42548e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f42549f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42550g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f42548e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f42547d = (float) viewConfiguration.getScaledTouchSlop();
    }

    public boolean a(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f42549f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                ao.a.a().b("CupcakeGestureDetector", "Velocity tracker is null");
            }
            this.f42545b = e(motionEvent);
            this.f42546c = f(motionEvent);
            this.f42550g = false;
        } else if (action == 1) {
            if (this.f42550g && this.f42549f != null) {
                this.f42545b = e(motionEvent);
                this.f42546c = f(motionEvent);
                this.f42549f.addMovement(motionEvent);
                this.f42549f.computeCurrentVelocity(1000);
                float xVelocity = this.f42549f.getXVelocity();
                float yVelocity = this.f42549f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f42548e) {
                    this.f42544a.c(this.f42545b, this.f42546c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f42549f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f42549f = null;
            }
        } else if (action == 2) {
            float e10 = e(motionEvent);
            float f10 = f(motionEvent);
            float f11 = e10 - this.f42545b;
            float f12 = f10 - this.f42546c;
            if (!this.f42550g) {
                if (Math.sqrt((double) ((f11 * f11) + (f12 * f12))) >= ((double) this.f42547d)) {
                    z10 = true;
                }
                this.f42550g = z10;
            }
            if (this.f42550g) {
                this.f42544a.a(f11, f12);
                this.f42545b = e10;
                this.f42546c = f10;
                VelocityTracker velocityTracker3 = this.f42549f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f42549f) != null) {
            velocityTracker.recycle();
            this.f42549f = null;
        }
        return true;
    }

    public void b(e eVar) {
        this.f42544a = eVar;
    }

    public boolean c() {
        return this.f42550g;
    }

    /* access modifiers changed from: package-private */
    public float e(MotionEvent motionEvent) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public float f(MotionEvent motionEvent) {
        throw null;
    }
}
