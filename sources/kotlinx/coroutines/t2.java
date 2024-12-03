package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/t2;", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/CompletionHandler;", "", "state", "", "c", "(I)Ljava/lang/Void;", "e", "()V", "a", "cause", "d", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/s1;", "job", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "b", "Ljava/lang/Thread;", "targetThread", "Lkotlinx/coroutines/z0;", "Lkotlinx/coroutines/z0;", "cancelHandle", "<init>", "(Lkotlinx/coroutines/s1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class t2 implements Function1<Throwable, Unit> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32721d = AtomicIntegerFieldUpdater.newUpdater(t2.class, "_state");
    private volatile /* synthetic */ int _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final s1 f32722a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread f32723b = Thread.currentThread();

    /* renamed from: c  reason: collision with root package name */
    private z0 f32724c;

    public t2(s1 s1Var) {
        this.f32722a = s1Var;
    }

    private final Void c(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public final void a() {
        while (true) {
            int i10 = this._state;
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        c(i10);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f32721d.compareAndSet(this, i10, 1)) {
                z0 z0Var = this.f32724c;
                if (z0Var != null) {
                    z0Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void d(Throwable th2) {
        int i10;
        do {
            i10 = this._state;
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2 && i10 != 3) {
                    c(i10);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f32721d.compareAndSet(this, i10, 2));
        this.f32723b.interrupt();
        this._state = 3;
    }

    public final void e() {
        int i10;
        this.f32724c = this.f32722a.m(true, true, this);
        do {
            i10 = this._state;
            if (i10 != 0) {
                if (i10 != 2 && i10 != 3) {
                    c(i10);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f32721d.compareAndSet(this, i10, 0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((Throwable) obj);
        return Unit.f32013a;
    }
}
