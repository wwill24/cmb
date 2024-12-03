package r0;

import android.view.View;
import n0.c;
import n0.f;

public abstract class d extends f {

    public static class a extends d {
        public boolean b(View view, float f10, long j10, c cVar) {
            return this.f16371h;
        }

        public boolean c(View view, c cVar, float f10, long j10, double d10, double d11) {
            view.setRotation(a(f10, j10, view, cVar) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f16371h;
        }
    }

    public float a(float f10, long j10, View view, c cVar) {
        this.f16364a.c((double) f10, this.f16370g);
        float[] fArr = this.f16370g;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.f16371h = false;
            return fArr[2];
        } else if (Float.isNaN(this.f16373j)) {
            throw null;
        } else {
            this.f16373j = (float) ((((double) this.f16373j) + ((((double) (j10 - this.f16372i)) * 1.0E-9d) * ((double) f11))) % 1.0d);
            throw null;
        }
    }

    public abstract boolean b(View view, float f10, long j10, c cVar);
}
