package r0;

import android.view.View;
import n0.d;

public abstract class b extends d {

    public static class a extends b {
        public void b(View view, float f10) {
        }

        public void c(View view, float f10, double d10, double d11) {
            view.setRotation(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    public abstract void b(View view, float f10);
}
