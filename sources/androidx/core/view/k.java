package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;

public final /* synthetic */ class k implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f4830a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f4831b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a0 f4832c;

    public /* synthetic */ k(l lVar, Lifecycle.State state, a0 a0Var) {
        this.f4830a = lVar;
        this.f4831b = state;
        this.f4832c = a0Var;
    }

    public final void e(l lVar, Lifecycle.Event event) {
        this.f4830a.g(this.f4831b, this.f4832c, lVar, event);
    }
}
