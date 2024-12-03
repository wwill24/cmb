package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import gk.g;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.n;

public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f5988a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Lifecycle f5989b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ n<Object> f5990c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Function0<Object> f5991d;

    public void e(l lVar, Lifecycle.Event event) {
        Object obj;
        j.g(lVar, "source");
        j.g(event, "event");
        if (event == Lifecycle.Event.Companion.c(this.f5988a)) {
            this.f5989b.d(this);
            n<Object> nVar = this.f5990c;
            Function0<Object> function0 = this.f5991d;
            try {
                Result.a aVar = Result.f32010a;
                obj = Result.b(function0.invoke());
            } catch (Throwable th2) {
                Result.a aVar2 = Result.f32010a;
                obj = Result.b(g.a(th2));
            }
            nVar.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.f5989b.d(this);
            n<Object> nVar2 = this.f5990c;
            Result.a aVar3 = Result.f32010a;
            nVar2.resumeWith(Result.b(g.a(new LifecycleDestroyedException())));
        }
    }
}
