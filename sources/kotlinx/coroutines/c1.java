package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/c1;", "Lkotlinx/coroutines/n1;", "", "toString", "", "a", "Z", "()Z", "isActive", "Lkotlinx/coroutines/d2;", "f", "()Lkotlinx/coroutines/d2;", "list", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class c1 implements n1 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32290a;

    public c1(boolean z10) {
        this.f32290a = z10;
    }

    public boolean a() {
        return this.f32290a;
    }

    public d2 f() {
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(a() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
