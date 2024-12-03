package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.x0;

@d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ Function2<k0, c<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(lifecycle, state, k0Var, function2, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
                int r2 = r1.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0038
                if (r2 != r4) goto L_0x0030
                java.lang.Object r0 = r1.L$5
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                java.lang.Object r0 = r1.L$4
                kotlinx.coroutines.k0 r0 = (kotlinx.coroutines.k0) r0
                java.lang.Object r0 = r1.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r1.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r1.L$1
                r2 = r0
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
                java.lang.Object r0 = r1.L$0
                r5 = r0
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref$ObjectRef) r5
                gk.g.b(r17)     // Catch:{ all -> 0x002d }
                goto L_0x00ac
            L_0x002d:
                r0 = move-exception
                goto L_0x00c7
            L_0x0030:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0038:
                gk.g.b(r17)
                androidx.lifecycle.Lifecycle r2 = r4
                androidx.lifecycle.Lifecycle$State r2 = r2.b()
                androidx.lifecycle.Lifecycle$State r5 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r2 != r5) goto L_0x0048
                kotlin.Unit r0 = kotlin.Unit.f32013a
                return r0
            L_0x0048:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
                r13.<init>()
                androidx.lifecycle.Lifecycle$State r5 = r5     // Catch:{ all -> 0x00c4 }
                androidx.lifecycle.Lifecycle r14 = r4     // Catch:{ all -> 0x00c4 }
                kotlinx.coroutines.k0 r8 = r6     // Catch:{ all -> 0x00c4 }
                kotlin.jvm.functions.Function2<kotlinx.coroutines.k0, kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r12 = r7     // Catch:{ all -> 0x00c4 }
                r1.L$0 = r2     // Catch:{ all -> 0x00c4 }
                r1.L$1 = r13     // Catch:{ all -> 0x00c4 }
                r1.L$2 = r5     // Catch:{ all -> 0x00c4 }
                r1.L$3 = r14     // Catch:{ all -> 0x00c4 }
                r1.L$4 = r8     // Catch:{ all -> 0x00c4 }
                r1.L$5 = r12     // Catch:{ all -> 0x00c4 }
                r1.label = r4     // Catch:{ all -> 0x00c4 }
                kotlinx.coroutines.o r15 = new kotlinx.coroutines.o     // Catch:{ all -> 0x00c4 }
                kotlin.coroutines.c r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r16)     // Catch:{ all -> 0x00c4 }
                r15.<init>(r6, r4)     // Catch:{ all -> 0x00c4 }
                r15.y()     // Catch:{ all -> 0x00c4 }
                androidx.lifecycle.Lifecycle$Event$a r6 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00c4 }
                androidx.lifecycle.Lifecycle$Event r7 = r6.c(r5)     // Catch:{ all -> 0x00c4 }
                androidx.lifecycle.Lifecycle$Event r9 = r6.a(r5)     // Catch:{ all -> 0x00c4 }
                r5 = 0
                kotlinx.coroutines.sync.c r11 = kotlinx.coroutines.sync.d.b(r5, r4, r3)     // Catch:{ all -> 0x00c4 }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r10 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00c4 }
                r5 = r10
                r6 = r7
                r7 = r2
                r3 = r10
                r10 = r15
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00c4 }
                r13.element = r3     // Catch:{ all -> 0x00c4 }
                java.lang.String r5 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.j.e(r3, r5)     // Catch:{ all -> 0x00c4 }
                r10 = r3
                androidx.lifecycle.i r10 = (androidx.lifecycle.i) r10     // Catch:{ all -> 0x00c4 }
                r14.a(r10)     // Catch:{ all -> 0x00c4 }
                java.lang.Object r3 = r15.v()     // Catch:{ all -> 0x00c4 }
                java.lang.Object r5 = kotlin.coroutines.intrinsics.b.d()     // Catch:{ all -> 0x00c4 }
                if (r3 != r5) goto L_0x00a7
                kotlin.coroutines.jvm.internal.f.c(r16)     // Catch:{ all -> 0x00c4 }
            L_0x00a7:
                if (r3 != r0) goto L_0x00aa
                return r0
            L_0x00aa:
                r5 = r2
                r2 = r13
            L_0x00ac:
                T r0 = r5.element
                kotlinx.coroutines.s1 r0 = (kotlinx.coroutines.s1) r0
                if (r0 == 0) goto L_0x00b6
                r3 = 0
                kotlinx.coroutines.s1.a.a(r0, r3, r4, r3)
            L_0x00b6:
                T r0 = r2.element
                androidx.lifecycle.i r0 = (androidx.lifecycle.i) r0
                if (r0 == 0) goto L_0x00c1
                androidx.lifecycle.Lifecycle r2 = r4
                r2.d(r0)
            L_0x00c1:
                kotlin.Unit r0 = kotlin.Unit.f32013a
                return r0
            L_0x00c4:
                r0 = move-exception
                r5 = r2
                r2 = r13
            L_0x00c7:
                T r3 = r5.element
                kotlinx.coroutines.s1 r3 = (kotlinx.coroutines.s1) r3
                if (r3 == 0) goto L_0x00d1
                r5 = 0
                kotlinx.coroutines.s1.a.a(r3, r5, r4, r5)
            L_0x00d1:
                T r2 = r2.element
                androidx.lifecycle.i r2 = (androidx.lifecycle.i) r2
                if (r2 == 0) goto L_0x00dc
                androidx.lifecycle.Lifecycle r3 = r4
                r3.d(r2)
            L_0x00dc:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2, c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> cVar) {
        super(2, cVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final k0 k0Var = (k0) this.L$0;
            c2 Y = x0.c().Y();
            final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
            final Lifecycle.State state = this.$state;
            final Function2<k0, c<? super Unit>, Object> function2 = this.$block;
            AnonymousClass1 r32 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            if (h.g(Y, r32, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
