package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.channels.u;
import rn.b;
import rn.c;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", "", "T", "Lrn/b;", "c", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "value", "", "d", "(Ljava/lang/Object;)V", "onComplete", "", "t", "onError", "Lrn/c;", "s", "e", "b", "a", "", "J", "requestSize", "Lrn/c;", "subscription", "Lkotlinx/coroutines/channels/d;", "Lkotlinx/coroutines/channels/d;", "channel", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0})
final class ReactiveSubscriber<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final long f32606a;

    /* renamed from: b  reason: collision with root package name */
    private c f32607b;

    /* renamed from: c  reason: collision with root package name */
    private final d<T> f32608c;

    public ReactiveSubscriber(int i10, BufferOverflow bufferOverflow, long j10) {
        this.f32606a = j10;
        this.f32608c = g.b(i10 == 0 ? 1 : i10, bufferOverflow, (Function1) null, 4, (Object) null);
    }

    public final void a() {
        c cVar = this.f32607b;
        if (cVar == null) {
            j.y("subscription");
            cVar = null;
        }
        cVar.cancel();
    }

    public final void b() {
        c cVar = this.f32607b;
        if (cVar == null) {
            j.y("subscription");
            cVar = null;
        }
        cVar.r(this.f32606a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.coroutines.c<? super T> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1 r0 = (kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1 r0 = new kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            gk.g.b(r5)
            kotlinx.coroutines.channels.h r5 = (kotlinx.coroutines.channels.h) r5
            java.lang.Object r5 = r5.l()
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            kotlinx.coroutines.channels.d<T> r5 = r4.f32608c
            r0.label = r3
            java.lang.Object r5 = r5.A(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.Throwable r0 = kotlinx.coroutines.channels.h.e(r5)
            if (r0 != 0) goto L_0x0054
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.h.c
            if (r0 == 0) goto L_0x0053
            kotlinx.coroutines.channels.h.e(r5)
            r5 = 0
        L_0x0053:
            return r5
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ReactiveSubscriber.c(kotlin.coroutines.c):java.lang.Object");
    }

    public void d(T t10) {
        if (!h.j(this.f32608c.t(t10))) {
            throw new IllegalArgumentException(("Element " + t10 + " was not added to channel because it was full, " + this.f32608c).toString());
        }
    }

    public void e(c cVar) {
        this.f32607b = cVar;
        b();
    }

    public void onComplete() {
        u.a.a(this.f32608c, (Throwable) null, 1, (Object) null);
    }

    public void onError(Throwable th2) {
        this.f32608c.F(th2);
    }
}
