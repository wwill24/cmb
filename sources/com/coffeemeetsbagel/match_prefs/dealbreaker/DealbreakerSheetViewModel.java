package com.coffeemeetsbagel.match_prefs.dealbreaker;

import a6.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fa.a;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import qj.h;

public final class DealbreakerSheetViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private final a f34571d;

    /* renamed from: e  reason: collision with root package name */
    private final QuestionRepository f34572e;

    /* renamed from: f  reason: collision with root package name */
    private final UserRepository f34573f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f34574g = DealbreakerSheetViewModel.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final t<Boolean> f34575h;

    /* renamed from: i  reason: collision with root package name */
    private final LiveData<Boolean> f34576i;

    @d(c = "com.coffeemeetsbagel.match_prefs.dealbreaker.DealbreakerSheetViewModel$1", f = "DealbreakerSheetViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.match_prefs.dealbreaker.DealbreakerSheetViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;
        final /* synthetic */ DealbreakerSheetViewModel this$0;

        {
            this.this$0 = r1;
        }

        /* access modifiers changed from: private */
        public static final void k(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final void m(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = b.d();
            if (this.label == 0) {
                g.b(obj);
                h j10 = this.this$0.o();
                final DealbreakerSheetViewModel dealbreakerSheetViewModel = this.this$0;
                g gVar = new g(new Function1<Integer, Unit>() {
                    public final void a(Integer num) {
                        boolean z10;
                        t i10 = dealbreakerSheetViewModel.f34575h;
                        if (!dealbreakerSheetViewModel.k().a("dealbreaker_bottom_sheet")) {
                            j.f(num, "count");
                            if (num.intValue() >= 3) {
                                z10 = true;
                                i10.m(Boolean.valueOf(z10));
                            }
                        }
                        z10 = false;
                        i10.m(Boolean.valueOf(z10));
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((Integer) obj);
                        return Unit.f32013a;
                    }
                });
                final DealbreakerSheetViewModel dealbreakerSheetViewModel2 = this.this$0;
                j10.b(gVar, new h(new Function1<Throwable, Unit>() {
                    public final void a(Throwable th2) {
                        a.C0491a aVar = fa.a.f40771d;
                        String h10 = dealbreakerSheetViewModel2.f34574g;
                        j.f(h10, "tag");
                        j.f(th2, "error");
                        aVar.c(h10, "Couldn't get # of prefs to show sheet.", th2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((Throwable) obj);
                        return Unit.f32013a;
                    }
                }));
                return Unit.f32013a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DealbreakerSheetViewModel(a6.a aVar, QuestionRepository questionRepository, UserRepository userRepository) {
        j.g(aVar, "coachmark");
        j.g(questionRepository, "questionRepository");
        j.g(userRepository, "userRepository");
        this.f34571d = aVar;
        this.f34572e = questionRepository;
        this.f34573f = userRepository;
        t<Boolean> tVar = new t<>(Boolean.FALSE);
        this.f34575h = tVar;
        this.f34576i = tVar;
        if (!aVar.a("dealbreaker_bottom_sheet")) {
            s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (c<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final h<Integer> o() {
        h<R> v10 = this.f34573f.p().Y(new e(DealbreakerSheetViewModel$observeDealbreakerCount$1.f34577a)).M(new f(new DealbreakerSheetViewModel$observeDealbreakerCount$2(this))).v();
        j.f(v10, "private fun observeDealb…tinctUntilChanged()\n    }");
        return v10;
    }

    /* access modifiers changed from: private */
    public static final String p(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final rn.a q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    public final a6.a k() {
        return this.f34571d;
    }

    public final QuestionRepository l() {
        return this.f34572e;
    }

    public final LiveData<Boolean> m() {
        return this.f34576i;
    }

    public final void n() {
        this.f34571d.b("dealbreaker_bottom_sheet");
    }
}
