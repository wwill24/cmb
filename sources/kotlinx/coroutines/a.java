package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001f\u0012\u0006\u00102\u001a\u00020%\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u00104\u001a\u00020\f¢\u0006\u0004\b5\u00106J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004J\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u001b\u0010\u001cJJ\u0010#\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00012\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00110!ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u001d\u0010,\u001a\u00020%8\u0006¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)R\u0014\u00101\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lkotlinx/coroutines/a;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/s1;", "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/k0;", "value", "", "g1", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "f1", "", "b0", "", "state", "M0", "Lkotlin/Result;", "result", "resumeWith", "e1", "exception", "t0", "(Ljava/lang/Throwable;)V", "H0", "()Ljava/lang/String;", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "block", "h1", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "()V", "context", "G", "coroutineContext", "a", "()Z", "isActive", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class a<T> extends JobSupport implements c<T>, k0 {

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f32267b;

    public a(CoroutineContext coroutineContext, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            w0((s1) coroutineContext.c(s1.f32618v));
        }
        this.f32267b = coroutineContext.e0(this);
    }

    public CoroutineContext G() {
        return this.f32267b;
    }

    public String H0() {
        String b10 = CoroutineContextKt.b(this.f32267b);
        if (b10 == null) {
            return super.H0();
        }
        return '\"' + b10 + "\":" + super.H0();
    }

    /* access modifiers changed from: protected */
    public final void M0(Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            f1(b0Var.f32285a, b0Var.a());
            return;
        }
        g1(obj);
    }

    public boolean a() {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public String b0() {
        return m0.a(this) + " was cancelled";
    }

    /* access modifiers changed from: protected */
    public void e1(Object obj) {
        T(obj);
    }

    /* access modifiers changed from: protected */
    public void f1(Throwable th2, boolean z10) {
    }

    /* access modifiers changed from: protected */
    public void g1(T t10) {
    }

    public final CoroutineContext getContext() {
        return this.f32267b;
    }

    public final <R> void h1(CoroutineStart coroutineStart, R r10, Function2<? super R, ? super c<? super T>, ? extends Object> function2) {
        coroutineStart.b(function2, r10, this);
    }

    public final void resumeWith(Object obj) {
        Object F0 = F0(e0.d(obj, (Function1) null, 1, (Object) null));
        if (F0 != z1.f32742b) {
            e1(F0);
        }
    }

    public final void t0(Throwable th2) {
        i0.a(this.f32267b, th2);
    }
}
