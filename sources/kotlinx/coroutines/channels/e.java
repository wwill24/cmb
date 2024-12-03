package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.a;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u00101\u001a\u000200\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u00102\u001a\u00020\u0007\u0012\u0006\u00103\u001a\u00020\u0007¢\u0006\u0004\b4\u00105J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0001J\u001f\u0010\u000b\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00030\tH\u0001J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0003J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0001\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0011J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012HAø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u000e\u001a\u00028\u0000H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bJ\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R \u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b&\u0010$R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120(8\u0016X\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b.\u0010!\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/e;", "E", "Lkotlinx/coroutines/a;", "", "Lkotlinx/coroutines/channels/d;", "", "cause", "", "F", "Lkotlin/Function1;", "handler", "s", "Lkotlinx/coroutines/channels/f;", "iterator", "element", "offer", "(Ljava/lang/Object;)Z", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/h;", "A", "H", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "z", "()Ljava/lang/Object;", "t", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "Y", "c", "Lkotlinx/coroutines/channels/d;", "j1", "()Lkotlinx/coroutines/channels/d;", "_channel", "j", "()Z", "isClosedForReceive", "K", "isClosedForSend", "Lkotlinx/coroutines/selects/c;", "u", "()Lkotlinx/coroutines/selects/c;", "onReceive", "w", "onReceiveCatching", "i1", "channel", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/d;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class e<E> extends a<Unit> implements d<E> {

    /* renamed from: c  reason: collision with root package name */
    private final d<E> f32330c;

    public e(CoroutineContext coroutineContext, d<E> dVar, boolean z10, boolean z11) {
        super(coroutineContext, z10, z11);
        this.f32330c = dVar;
    }

    public Object A(c<? super h<? extends E>> cVar) {
        Object A = this.f32330c.A(cVar);
        Object unused = b.d();
        return A;
    }

    public Object E(c<? super E> cVar) {
        return this.f32330c.E(cVar);
    }

    public boolean F(Throwable th2) {
        return this.f32330c.F(th2);
    }

    public Object H(E e10, c<? super Unit> cVar) {
        return this.f32330c.H(e10, cVar);
    }

    public boolean K() {
        return this.f32330c.K();
    }

    public void Y(Throwable th2) {
        CancellationException X0 = JobSupport.X0(this, th2, (String) null, 1, (Object) null);
        this.f32330c.b(X0);
        W(X0);
    }

    public final void b(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(b0(), (Throwable) null, this);
            }
            Y(cancellationException);
        }
    }

    public final d<E> i1() {
        return this;
    }

    public f<E> iterator() {
        return this.f32330c.iterator();
    }

    public boolean j() {
        return this.f32330c.j();
    }

    /* access modifiers changed from: protected */
    public final d<E> j1() {
        return this.f32330c;
    }

    public boolean offer(E e10) {
        return this.f32330c.offer(e10);
    }

    public void s(Function1<? super Throwable, Unit> function1) {
        this.f32330c.s(function1);
    }

    public Object t(E e10) {
        return this.f32330c.t(e10);
    }

    public kotlinx.coroutines.selects.c<E> u() {
        return this.f32330c.u();
    }

    public kotlinx.coroutines.selects.c<h<E>> w() {
        return this.f32330c.w();
    }

    public Object z() {
        return this.f32330c.z();
    }
}
