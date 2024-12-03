package qb;

import android.view.View;
import android.view.ViewGroup;
import lb.b;
import lb.e;

public class a extends b {

    /* renamed from: u  reason: collision with root package name */
    private final ViewGroup f41798u;

    public a(ViewGroup viewGroup) {
        super(viewGroup);
        this.f41798u = viewGroup;
    }

    public void V(e eVar) {
        View b10 = ((b) eVar).b();
        if (b10.getParent() instanceof ViewGroup) {
            ((ViewGroup) b10.getParent()).removeView(b10);
        }
        this.f41798u.addView(b10);
    }
}
