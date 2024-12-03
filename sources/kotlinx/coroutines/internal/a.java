package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/a;", "", "T", "", "b", "element", "a", "(Ljava/lang/Object;)V", "d", "()Ljava/lang/Object;", "", "[Ljava/lang/Object;", "elements", "", "I", "head", "c", "tail", "", "()Z", "isEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f32514a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f32515b;

    /* renamed from: c  reason: collision with root package name */
    private int f32516c;

    private final void b() {
        Object[] objArr = this.f32514a;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        Object[] unused = k.i(objArr, objArr3, 0, this.f32515b, 0, 10, (Object) null);
        Object[] objArr4 = this.f32514a;
        int length2 = objArr4.length;
        int i10 = this.f32515b;
        Object[] unused2 = k.i(objArr4, objArr2, length2 - i10, 0, i10, 4, (Object) null);
        this.f32514a = objArr3;
        this.f32515b = 0;
        this.f32516c = length;
    }

    public final void a(T t10) {
        Object[] objArr = this.f32514a;
        int i10 = this.f32516c;
        objArr[i10] = t10;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f32516c = length;
        if (length == this.f32515b) {
            b();
        }
    }

    public final boolean c() {
        return this.f32515b == this.f32516c;
    }

    public final T d() {
        int i10 = this.f32515b;
        if (i10 == this.f32516c) {
            return null;
        }
        T[] tArr = this.f32514a;
        T t10 = tArr[i10];
        tArr[i10] = null;
        this.f32515b = (i10 + 1) & (tArr.length - 1);
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
