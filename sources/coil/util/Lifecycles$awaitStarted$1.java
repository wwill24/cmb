package coil.util;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "coil.util.-Lifecycles", f = "Lifecycles.kt", l = {44}, m = "awaitStarted")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-Lifecycles$awaitStarted$1  reason: invalid class name */
final class Lifecycles$awaitStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    Lifecycles$awaitStarted$1(c<? super Lifecycles$awaitStarted$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Lifecycles.a((Lifecycle) null, this);
    }
}
