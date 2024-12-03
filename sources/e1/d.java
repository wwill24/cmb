package e1;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import e1.b;

public final class d extends b<d> {
    private e A = null;
    private float B = Float.MAX_VALUE;
    private boolean C = false;

    public <K> d(K k10, c<K> cVar) {
        super(k10, cVar);
    }

    private void o() {
        e eVar = this.A;
        if (eVar != null) {
            double a10 = (double) eVar.a();
            if (a10 > ((double) this.f14545g)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a10 < ((double) this.f14546h)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public void i() {
        o();
        this.A.g((double) d());
        super.i();
    }

    /* access modifiers changed from: package-private */
    public boolean k(long j10) {
        if (this.C) {
            float f10 = this.B;
            if (f10 != Float.MAX_VALUE) {
                this.A.e(f10);
                this.B = Float.MAX_VALUE;
            }
            this.f14540b = this.A.a();
            this.f14539a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j11 = j10 / 2;
            b.o h10 = this.A.h((double) this.f14540b, (double) this.f14539a, j11);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            b.o h11 = this.A.h((double) h10.f14551a, (double) h10.f14552b, j11);
            this.f14540b = h11.f14551a;
            this.f14539a = h11.f14552b;
        } else {
            b.o h12 = this.A.h((double) this.f14540b, (double) this.f14539a, j10);
            this.f14540b = h12.f14551a;
            this.f14539a = h12.f14552b;
        }
        float max = Math.max(this.f14540b, this.f14546h);
        this.f14540b = max;
        float min = Math.min(max, this.f14545g);
        this.f14540b = min;
        if (!n(min, this.f14539a)) {
            return false;
        }
        this.f14540b = this.A.a();
        this.f14539a = 0.0f;
        return true;
    }

    public void l(float f10) {
        if (e()) {
            this.B = f10;
            return;
        }
        if (this.A == null) {
            this.A = new e(f10);
        }
        this.A.e(f10);
        i();
    }

    public boolean m() {
        return this.A.f14555b > 0.0d;
    }

    /* access modifiers changed from: package-private */
    public boolean n(float f10, float f11) {
        return this.A.c(f10, f11);
    }

    public d p(e eVar) {
        this.A = eVar;
        return this;
    }

    public void q() {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f14544f) {
            this.C = true;
        }
    }
}
