package coil.size;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcoil/size/e;", "Lcoil/size/h;", "Lcoil/size/g;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "a", "Lcoil/size/g;", "size", "<init>", "(Lcoil/size/g;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private final g f8410a;

    public e(g gVar) {
        this.f8410a = gVar;
    }

    public Object b(c<? super g> cVar) {
        return this.f8410a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && j.b(this.f8410a, ((e) obj).f8410a);
    }

    public int hashCode() {
        return this.f8410a.hashCode();
    }
}
