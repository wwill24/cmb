package androidx.databinding;

import java.lang.ref.WeakReference;

class i<T> extends WeakReference<ViewDataBinding> {

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f4995a;

    /* renamed from: b  reason: collision with root package name */
    private T f4996b;

    public boolean a() {
        boolean z10;
        T t10 = this.f4996b;
        if (t10 != null) {
            this.f4995a.a(t10);
            z10 = true;
        } else {
            z10 = false;
        }
        this.f4996b = null;
        return z10;
    }
}
