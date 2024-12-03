package coil.util;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.n;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"coil/util/-Lifecycles$awaitStarted$2$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/l;", "owner", "", "onStart", "coil-base_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: coil.util.-Lifecycles$awaitStarted$2$1  reason: invalid class name */
public final class Lifecycles$awaitStarted$2$1 implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n<Unit> f8419a;

    Lifecycles$awaitStarted$2$1(n<? super Unit> nVar) {
        this.f8419a = nVar;
    }

    public void onStart(l lVar) {
        n<Unit> nVar = this.f8419a;
        Result.a aVar = Result.f32010a;
        nVar.resumeWith(Result.b(Unit.f32013a));
    }
}
