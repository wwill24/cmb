package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.p2;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR$\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/l0;", "", "Lkotlinx/coroutines/p2;", "element", "value", "", "a", "Lkotlin/coroutines/CoroutineContext;", "context", "b", "Lkotlin/coroutines/CoroutineContext;", "", "[Ljava/lang/Object;", "values", "c", "[Lkotlinx/coroutines/p2;", "elements", "", "d", "I", "i", "n", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f32544a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f32545b;

    /* renamed from: c  reason: collision with root package name */
    private final p2<Object>[] f32546c;

    /* renamed from: d  reason: collision with root package name */
    private int f32547d;

    public l0(CoroutineContext coroutineContext, int i10) {
        this.f32544a = coroutineContext;
        this.f32545b = new Object[i10];
        this.f32546c = new p2[i10];
    }

    public final void a(p2<?> p2Var, Object obj) {
        Object[] objArr = this.f32545b;
        int i10 = this.f32547d;
        objArr[i10] = obj;
        p2<Object>[] p2VarArr = this.f32546c;
        this.f32547d = i10 + 1;
        p2VarArr[i10] = p2Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f32546c.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                p2<Object> p2Var = this.f32546c[length];
                j.d(p2Var);
                p2Var.I(coroutineContext, this.f32545b[length]);
                if (i10 >= 0) {
                    length = i10;
                } else {
                    return;
                }
            }
        }
    }
}
