package com.squareup.workflow1.ui;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "com.squareup.workflow1.ui.WorkflowLayout$start$1", f = "WorkflowLayout.kt", l = {87}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class WorkflowLayout$start$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ p $environment;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ b<Object> $renderings;
    final /* synthetic */ Lifecycle.State $repeatOnLifecycle;
    int label;
    final /* synthetic */ WorkflowLayout this$0;

    @d(c = "com.squareup.workflow1.ui.WorkflowLayout$start$1$1", f = "WorkflowLayout.kt", l = {212}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* renamed from: com.squareup.workflow1.ui.WorkflowLayout$start$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"com/squareup/workflow1/ui/WorkflowLayout$start$1$1$a", "Lkotlinx/coroutines/flow/c;", "value", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
        /* renamed from: com.squareup.workflow1.ui.WorkflowLayout$start$1$1$a */
        public static final class a implements kotlinx.coroutines.flow.c<Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WorkflowLayout f23186a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f23187b;

            public a(WorkflowLayout workflowLayout, p pVar) {
                this.f23186a = workflowLayout;
                this.f23187b = pVar;
            }

            public Object c(Object obj, c<? super Unit> cVar) {
                this.f23186a.d(obj, this.f23187b);
                return Unit.f32013a;
            }
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(bVar, workflowLayout, pVar, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                b<Object> bVar = bVar;
                a aVar = new a(workflowLayout, pVar);
                this.label = 1;
                if (bVar.a(aVar, this) == d10) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowLayout$start$1(Lifecycle lifecycle, Lifecycle.State state, b<? extends Object> bVar, WorkflowLayout workflowLayout, p pVar, c<? super WorkflowLayout$start$1> cVar) {
        super(2, cVar);
        this.$lifecycle = lifecycle;
        this.$repeatOnLifecycle = state;
        this.$renderings = bVar;
        this.this$0 = workflowLayout;
        this.$environment = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new WorkflowLayout$start$1(this.$lifecycle, this.$repeatOnLifecycle, this.$renderings, this.this$0, this.$environment, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((WorkflowLayout$start$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$repeatOnLifecycle;
            final b<Object> bVar = this.$renderings;
            final WorkflowLayout workflowLayout = this.this$0;
            final p pVar = this.$environment;
            AnonymousClass1 r32 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, r32, this) == d10) {
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
