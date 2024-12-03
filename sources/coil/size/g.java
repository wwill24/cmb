package coil.size;

import coil.size.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcoil/size/g;", "", "Lcoil/size/c;", "a", "b", "", "toString", "", "hashCode", "other", "", "equals", "Lcoil/size/c;", "d", "()Lcoil/size/c;", "width", "c", "height", "<init>", "(Lcoil/size/c;Lcoil/size/c;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final a f8413c = new a((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final g f8414d;

    /* renamed from: a  reason: collision with root package name */
    private final c f8415a;

    /* renamed from: b  reason: collision with root package name */
    private final c f8416b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcoil/size/g$a;", "", "Lcoil/size/g;", "ORIGINAL", "Lcoil/size/g;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        c.b bVar = c.b.f8408a;
        f8414d = new g(bVar, bVar);
    }

    public g(c cVar, c cVar2) {
        this.f8415a = cVar;
        this.f8416b = cVar2;
    }

    public final c a() {
        return this.f8415a;
    }

    public final c b() {
        return this.f8416b;
    }

    public final c c() {
        return this.f8416b;
    }

    public final c d() {
        return this.f8415a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return j.b(this.f8415a, gVar.f8415a) && j.b(this.f8416b, gVar.f8416b);
    }

    public int hashCode() {
        return (this.f8415a.hashCode() * 31) + this.f8416b.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.f8415a + ", height=" + this.f8416b + PropertyUtils.MAPPED_DELIM2;
    }
}
