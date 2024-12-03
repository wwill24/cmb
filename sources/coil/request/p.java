package coil.request;

import coil.util.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0004B!\b\u0002\u0012\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\f¨\u0006\u0011"}, d2 = {"Lcoil/request/p;", "", "", "Ljava/lang/Class;", "a", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/util/Map;", "tags", "<init>", "(Ljava/util/Map;)V", "b", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class p {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8391b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    public static final p f8392c = new p(h0.i());

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, Object> f8393a;

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcoil/request/p$a;", "", "", "Ljava/lang/Class;", "tags", "Lcoil/request/p;", "a", "EMPTY", "Lcoil/request/p;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a(Map<Class<?>, ? extends Object> map) {
            return new p(c.b(map), (DefaultConstructorMarker) null);
        }
    }

    private p(Map<Class<?>, ? extends Object> map) {
        this.f8393a = map;
    }

    public /* synthetic */ p(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public final Map<Class<?>, Object> a() {
        return this.f8393a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && j.b(this.f8393a, ((p) obj).f8393a);
    }

    public int hashCode() {
        return this.f8393a.hashCode();
    }

    public String toString() {
        return "Tags(tags=" + this.f8393a + PropertyUtils.MAPPED_DELIM2;
    }
}
