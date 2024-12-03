package yi;

import android.graphics.Bitmap;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.s;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final i<Bitmap> f33989a;

    /* renamed from: b  reason: collision with root package name */
    private final b<Bitmap> f33990b;

    public a(Bitmap bitmap) {
        i<Bitmap> a10 = s.a(bitmap);
        this.f33989a = a10;
        this.f33990b = d.n(a10, 1);
    }

    public final b<Bitmap> a() {
        return this.f33990b;
    }

    public final Bitmap b() {
        return this.f33989a.getValue();
    }

    public final void c(Bitmap bitmap) {
        this.f33989a.setValue(bitmap);
    }
}
