package zj;

import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.w;
import qj.q;
import tj.b;
import vj.f;

public abstract class a<T> extends q<T> {
    private a<T> B0() {
        if (this instanceof w) {
            return bk.a.p(new ObservablePublishAlt(((w) this).a()));
        }
        return this;
    }

    public abstract void A0(f<? super b> fVar);

    public q<T> C0() {
        return bk.a.n(new ObservableRefCount(B0()));
    }
}
