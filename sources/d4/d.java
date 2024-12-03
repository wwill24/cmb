package d4;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import d4.f;

public class d implements f<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f14441a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14442b;

    public d(int i10, boolean z10) {
        this.f14441a = i10;
        this.f14442b = z10;
    }

    /* renamed from: b */
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable h10 = aVar.h();
        if (h10 == null) {
            h10 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{h10, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f14442b);
        transitionDrawable.startTransition(this.f14441a);
        aVar.e(transitionDrawable);
        return true;
    }
}
