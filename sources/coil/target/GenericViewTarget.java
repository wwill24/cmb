package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import kotlin.Metadata;
import p2.b;
import r2.d;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0004J\b\u0010\u0014\u001a\u00020\bH\u0004R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcoil/target/GenericViewTarget;", "Landroid/view/View;", "T", "Lp2/b;", "Lr2/d;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/graphics/drawable/Drawable;", "placeholder", "", "b", "error", "c", "result", "a", "Landroidx/lifecycle/l;", "owner", "onStart", "onStop", "drawable", "h", "g", "", "Z", "isStarted", "d", "()Landroid/graphics/drawable/Drawable;", "f", "(Landroid/graphics/drawable/Drawable;)V", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public abstract class GenericViewTarget<T extends View> implements b<T>, d, DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8417a;

    public void a(Drawable drawable) {
        h(drawable);
    }

    public void b(Drawable drawable) {
        h(drawable);
    }

    public void c(Drawable drawable) {
        h(drawable);
    }

    public abstract Drawable d();

    public abstract void f(Drawable drawable);

    /* access modifiers changed from: protected */
    public final void g() {
        Animatable animatable;
        Drawable d10 = d();
        if (d10 instanceof Animatable) {
            animatable = (Animatable) d10;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            if (this.f8417a) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void h(Drawable drawable) {
        Animatable animatable;
        Drawable d10 = d();
        if (d10 instanceof Animatable) {
            animatable = (Animatable) d10;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            animatable.stop();
        }
        f(drawable);
        g();
    }

    public void onStart(l lVar) {
        this.f8417a = true;
        g();
    }

    public void onStop(l lVar) {
        this.f8417a = false;
        g();
    }
}
