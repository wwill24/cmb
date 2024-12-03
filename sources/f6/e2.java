package f6;

import com.coffeemeetsbagel.models.Bagel;
import java.util.concurrent.Callable;

public final /* synthetic */ class e2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f2 f14792a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f14793b;

    public /* synthetic */ e2(f2 f2Var, Bagel bagel) {
        this.f14792a = f2Var;
        this.f14793b = bagel;
    }

    public final Object call() {
        return this.f14792a.o(this.f14793b);
    }
}
