package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;

public final /* synthetic */ class j implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f4828a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f4829b;

    public /* synthetic */ j(l lVar, a0 a0Var) {
        this.f4828a = lVar;
        this.f4829b = a0Var;
    }

    public final void e(l lVar, Lifecycle.Event event) {
        this.f4828a.f(this.f4829b, lVar, event);
    }
}
