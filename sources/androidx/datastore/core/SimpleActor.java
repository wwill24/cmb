package androidx.datastore.core;

import com.google.android.gms.common.api.a;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bh\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00040\u0018\u0012\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00040\u000b\u0012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR3\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/datastore/core/SimpleActor;", "T", "", "msg", "", "e", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/k0;", "a", "Lkotlinx/coroutines/k0;", "scope", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "b", "Lkotlin/jvm/functions/Function2;", "consumeMessage", "Lkotlinx/coroutines/channels/d;", "c", "Lkotlinx/coroutines/channels/d;", "messageQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "remainingMessages", "Lkotlin/Function1;", "", "onComplete", "onUndeliveredElement", "<init>", "(Lkotlinx/coroutines/k0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SimpleActor<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k0 f4999a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function2<T, c<? super Unit>, Object> f5000b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final d<T> f5001c = g.b(a.e.API_PRIORITY_OTHER, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f5002d = new AtomicInteger(0);

    public SimpleActor(k0 k0Var, final Function1<? super Throwable, Unit> function1, final Function2<? super T, ? super Throwable, Unit> function2, Function2<? super T, ? super c<? super Unit>, ? extends Object> function22) {
        j.g(k0Var, "scope");
        j.g(function1, "onComplete");
        j.g(function2, "onUndeliveredElement");
        j.g(function22, "consumeMessage");
        this.f4999a = k0Var;
        this.f5000b = function22;
        s1 s1Var = (s1) k0Var.G().c(s1.f32618v);
        if (s1Var != null) {
            s1Var.y(new Function1<Throwable, Unit>() {
                public final void a(Throwable th2) {
                    Unit unit;
                    function1.invoke(th2);
                    this.f5001c.F(th2);
                    do {
                        Object f10 = h.f(this.f5001c.z());
                        if (f10 == null) {
                            unit = null;
                            continue;
                        } else {
                            function2.invoke(f10, th2);
                            unit = Unit.f32013a;
                            continue;
                        }
                    } while (unit != null);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Throwable) obj);
                    return Unit.f32013a;
                }
            });
        }
    }

    public final void e(T t10) {
        Object t11 = this.f5001c.t(t10);
        if (t11 instanceof h.a) {
            Throwable e10 = h.e(t11);
            if (e10 == null) {
                e10 = new ClosedSendChannelException("Channel was closed normally");
            }
            throw e10;
        } else if (!h.j(t11)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.f5002d.getAndIncrement() == 0) {
            s1 unused = j.d(this.f4999a, (CoroutineContext) null, (CoroutineStart) null, new SimpleActor$offer$2(this, (c<? super SimpleActor$offer$2>) null), 3, (Object) null);
        }
    }
}
