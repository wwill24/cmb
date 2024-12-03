package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;

public final class t2 extends h0 {

    /* renamed from: d  reason: collision with root package name */
    private final Object f2906d;

    /* renamed from: e  reason: collision with root package name */
    private final l1 f2907e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f2908f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2909g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2910h;

    t2(o1 o1Var, l1 l1Var) {
        this(o1Var, (Size) null, l1Var);
    }

    @NonNull
    public Rect X0() {
        synchronized (this.f2906d) {
            if (this.f2908f == null) {
                Rect rect = new Rect(0, 0, getWidth(), getHeight());
                return rect;
            }
            Rect rect2 = new Rect(this.f2908f);
            return rect2;
        }
    }

    public int getHeight() {
        return this.f2910h;
    }

    public int getWidth() {
        return this.f2909g;
    }

    public void p0(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.f2906d) {
            this.f2908f = rect;
        }
    }

    @NonNull
    public l1 z1() {
        return this.f2907e;
    }

    public t2(@NonNull o1 o1Var, Size size, @NonNull l1 l1Var) {
        super(o1Var);
        this.f2906d = new Object();
        if (size == null) {
            this.f2909g = super.getWidth();
            this.f2910h = super.getHeight();
        } else {
            this.f2909g = size.getWidth();
            this.f2910h = size.getHeight();
        }
        this.f2907e = l1Var;
    }
}
