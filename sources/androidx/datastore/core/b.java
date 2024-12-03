package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0004\u001a\u00020\u0003R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/b;", "T", "Landroidx/datastore/core/j;", "", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "value", "", "I", "getHashCode", "()I", "hashCode", "<init>", "(Ljava/lang/Object;I)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
final class b<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f5029a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5030b;

    public b(T t10, int i10) {
        super((DefaultConstructorMarker) null);
        this.f5029a = t10;
        this.f5030b = i10;
    }

    public final void a() {
        T t10 = this.f5029a;
        boolean z10 = false;
        if ((t10 != null ? t10.hashCode() : 0) == this.f5030b) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final T b() {
        return this.f5029a;
    }
}
