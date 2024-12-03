package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.n;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.x0;
import kotlinx.coroutines.z0;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010$\u001a\u00020\n¢\u0006\u0004\b+\u0010,B\u001d\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b+\u0010-J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0013\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010*\u001a\u00020\u00008\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010&\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/d;", "Lkotlinx/coroutines/r0;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "m0", "", "O", "E", "", "timeMillis", "Lkotlinx/coroutines/n;", "continuation", "k", "Lkotlinx/coroutines/z0;", "u", "", "toString", "", "other", "equals", "", "hashCode", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "d", "Ljava/lang/String;", "name", "e", "Z", "invokeImmediately", "_immediate", "Lkotlinx/coroutines/android/HandlerContext;", "f", "q0", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0})
public final class HandlerContext extends d {
    private volatile HandlerContext _immediate;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Handler f32275c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32276d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32277e;

    /* renamed from: f  reason: collision with root package name */
    private final HandlerContext f32278f;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f32279a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HandlerContext f32280b;

        public a(n nVar, HandlerContext handlerContext) {
            this.f32279a = nVar;
            this.f32280b = handlerContext;
        }

        public final void run() {
            this.f32279a.D(this.f32280b, Unit.f32013a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HandlerContext(Handler handler, String str, boolean z10) {
        super((DefaultConstructorMarker) null);
        HandlerContext handlerContext = null;
        this.f32275c = handler;
        this.f32276d = str;
        this.f32277e = z10;
        this._immediate = z10 ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(handler, str, true);
            this._immediate = handlerContext2;
        }
        this.f32278f = handlerContext2;
    }

    private final void m0(CoroutineContext coroutineContext, Runnable runnable) {
        v1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        x0.b().E(coroutineContext, runnable);
    }

    /* access modifiers changed from: private */
    public static final void t0(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f32275c.removeCallbacks(runnable);
    }

    public void E(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f32275c.post(runnable)) {
            m0(coroutineContext, runnable);
        }
    }

    public boolean O(CoroutineContext coroutineContext) {
        return !this.f32277e || !j.b(Looper.myLooper(), this.f32275c.getLooper());
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f32275c == this.f32275c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f32275c);
    }

    public void k(long j10, n<? super Unit> nVar) {
        a aVar = new a(nVar, this);
        if (this.f32275c.postDelayed(aVar, j.h(j10, 4611686018427387903L))) {
            nVar.o(new HandlerContext$scheduleResumeAfterDelay$1(this, aVar));
        } else {
            m0(nVar.getContext(), aVar);
        }
    }

    /* renamed from: q0 */
    public HandlerContext Y() {
        return this.f32278f;
    }

    public String toString() {
        String c02 = c0();
        if (c02 != null) {
            return c02;
        }
        String str = this.f32276d;
        if (str == null) {
            str = this.f32275c.toString();
        }
        if (!this.f32277e) {
            return str;
        }
        return str + ".immediate";
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f32275c.postDelayed(runnable, j.h(j10, 4611686018427387903L))) {
            return new c(this, runnable);
        }
        m0(coroutineContext, runnable);
        return e2.f32353a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
