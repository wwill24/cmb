package b6;

import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import b6.b;

public abstract class a<C extends b, A extends c> extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected C f7846a;

    public C A0() {
        return this.f7846a;
    }

    public void B0(A a10) {
        C c10 = this.f7846a;
        if (c10 != null) {
            c10.I(a10);
            return;
        }
        throw new IllegalStateException("Trying to inject activity before component is created");
    }

    /* access modifiers changed from: protected */
    public void C0(A a10) {
        z0(a10);
    }

    /* access modifiers changed from: protected */
    public abstract C z0(A a10);
}
