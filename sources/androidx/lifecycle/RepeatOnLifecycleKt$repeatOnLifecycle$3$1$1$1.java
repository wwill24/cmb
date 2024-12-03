package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import gk.g;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.sync.c;

final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Lifecycle.Event f5966a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<s1> f5967b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ k0 f5968c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Lifecycle.Event f5969d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ n<Unit> f5970e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ c f5971f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function2<k0, kotlin.coroutines.c<? super Unit>, Object> f5972g;

    @d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, kotlin.coroutines.c<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(cVar, function2, cVar);
        }

        public final Object invoke(k0 k0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Throwable th2;
            c cVar;
            c cVar2;
            Function2<k0, kotlin.coroutines.c<? super Unit>, Object> function2;
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                cVar2 = cVar;
                function2 = function2;
                this.L$0 = cVar2;
                this.L$1 = function2;
                this.label = 1;
                if (cVar2.b((Object) null, this) == d10) {
                    return d10;
                }
            } else if (i10 == 1) {
                function2 = (Function2) this.L$1;
                g.b(obj);
                cVar2 = (c) this.L$0;
            } else if (i10 == 2) {
                cVar = (c) this.L$0;
                try {
                    g.b(obj);
                    Unit unit = Unit.f32013a;
                    cVar.c((Object) null);
                    return Unit.f32013a;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(function2, (kotlin.coroutines.c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1>) null);
                this.L$0 = cVar2;
                this.L$1 = null;
                this.label = 2;
                if (l0.g(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == d10) {
                    return d10;
                }
                cVar = cVar2;
                Unit unit2 = Unit.f32013a;
                cVar.c((Object) null);
                return Unit.f32013a;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                cVar = cVar2;
                th2 = th5;
                cVar.c((Object) null);
                throw th2;
            }
        }
    }

    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, Ref$ObjectRef<s1> ref$ObjectRef, k0 k0Var, Lifecycle.Event event2, n<? super Unit> nVar, c cVar, Function2<? super k0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> function2) {
        this.f5966a = event;
        this.f5967b = ref$ObjectRef;
        this.f5968c = k0Var;
        this.f5969d = event2;
        this.f5970e = nVar;
        this.f5971f = cVar;
        this.f5972g = function2;
    }

    public final void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "<anonymous parameter 0>");
        j.g(event, "event");
        if (event == this.f5966a) {
            Ref$ObjectRef<s1> ref$ObjectRef = this.f5967b;
            k0 k0Var = this.f5968c;
            final c cVar = this.f5971f;
            final Function2<k0, kotlin.coroutines.c<? super Unit>, Object> function2 = this.f5972g;
            ref$ObjectRef.element = j.d(k0Var, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((kotlin.coroutines.c<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        if (event == this.f5969d) {
            s1 s1Var = (s1) this.f5967b.element;
            if (s1Var != null) {
                s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f5967b.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            n<Unit> nVar = this.f5970e;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(Unit.f32013a));
        }
    }
}
