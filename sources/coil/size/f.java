package coil.size;

import android.view.View;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\u00028\u00008\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00068\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcoil/size/f;", "Landroid/view/View;", "T", "Lcoil/size/ViewSizeResolver;", "", "other", "", "equals", "", "hashCode", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "b", "Z", "()Z", "subtractPadding", "<init>", "(Landroid/view/View;Z)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class f<T extends View> implements ViewSizeResolver<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f8411a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8412b;

    public f(T t10, boolean z10) {
        this.f8411a = t10;
        this.f8412b = z10;
    }

    public boolean a() {
        return this.f8412b;
    }

    public Object b(c<? super g> cVar) {
        return ViewSizeResolver.DefaultImpls.h(this, cVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!j.b(getView(), fVar.getView()) || a() != fVar.a()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public T getView() {
        return this.f8411a;
    }

    public int hashCode() {
        return (getView().hashCode() * 31) + Boolean.hashCode(a());
    }
}
