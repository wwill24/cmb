package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    Animatable2.AnimationCallback f7067a;

    class a extends Animatable2.AnimationCallback {
        a() {
        }

        public void onAnimationEnd(Drawable drawable) {
            b.this.b(drawable);
        }

        public void onAnimationStart(Drawable drawable) {
            b.this.c(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public Animatable2.AnimationCallback a() {
        if (this.f7067a == null) {
            this.f7067a = new a();
        }
        return this.f7067a;
    }

    public void b(Drawable drawable) {
    }

    public void c(Drawable drawable) {
    }
}
