package c4;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import d4.f;

public abstract class e<Z> extends i<ImageView, Z> implements f.a {

    /* renamed from: h  reason: collision with root package name */
    private Animatable f7951h;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void r(Z z10) {
        if (z10 instanceof Animatable) {
            Animatable animatable = (Animatable) z10;
            this.f7951h = animatable;
            animatable.start();
            return;
        }
        this.f7951h = null;
    }

    private void t(Z z10) {
        s(z10);
        r(z10);
    }

    public void b() {
        Animatable animatable = this.f7951h;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void e(Drawable drawable) {
        ((ImageView) this.f7954a).setImageDrawable(drawable);
    }

    public void f(@NonNull Z z10, f<? super Z> fVar) {
        if (fVar == null || !fVar.a(z10, this)) {
            t(z10);
        } else {
            r(z10);
        }
    }

    public Drawable h() {
        return ((ImageView) this.f7954a).getDrawable();
    }

    public void i(Drawable drawable) {
        super.i(drawable);
        t((Object) null);
        e(drawable);
    }

    public void k(Drawable drawable) {
        super.k(drawable);
        Animatable animatable = this.f7951h;
        if (animatable != null) {
            animatable.stop();
        }
        t((Object) null);
        e(drawable);
    }

    public void l(Drawable drawable) {
        super.l(drawable);
        t((Object) null);
        e(drawable);
    }

    public void m() {
        Animatable animatable = this.f7951h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void s(Z z10);
}
