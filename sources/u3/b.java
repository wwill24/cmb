package u3;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import f4.j;
import l3.c;

public abstract class b<T extends Drawable> implements c<T>, l3.b {

    /* renamed from: a  reason: collision with root package name */
    protected final T f18013a;

    public b(T t10) {
        this.f18013a = (Drawable) j.d(t10);
    }

    @NonNull
    /* renamed from: c */
    public final T get() {
        Drawable.ConstantState constantState = this.f18013a.getConstantState();
        if (constantState == null) {
            return this.f18013a;
        }
        return constantState.newDrawable();
    }

    public void initialize() {
        T t10 = this.f18013a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof w3.c) {
            ((w3.c) t10).e().prepareToDraw();
        }
    }
}
