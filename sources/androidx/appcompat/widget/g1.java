package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

class g1 extends x0 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1279b;

    public g1(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f1279b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Drawable a10 = a(i10);
        Context context = this.f1279b.get();
        if (!(a10 == null || context == null)) {
            w0.g().w(context, i10, a10);
        }
        return a10;
    }
}
