package l8;

import java.util.Collection;
import java.util.concurrent.Callable;

public final /* synthetic */ class m1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n1 f16160a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Collection f16161b;

    public /* synthetic */ m1(n1 n1Var, Collection collection) {
        this.f16160a = n1Var;
        this.f16161b = collection;
    }

    public final Object call() {
        return this.f16160a.b(this.f16161b);
    }
}
