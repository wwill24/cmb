package b6;

import android.view.View;
import b6.j;
import b6.s;

public abstract class u<V extends View, C extends j, I extends s> extends q<C, I> {

    /* renamed from: e  reason: collision with root package name */
    private final V f7876e;

    public u(V v10, C c10, I i10) {
        super(c10, i10);
        this.f7876e = v10;
    }

    public V l() {
        return this.f7876e;
    }
}
