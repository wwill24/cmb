package coil.request;

import gk.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0003\u0017\u001d\u001eB\u001d\b\u0002\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u001a\u0010\u001bB\t\b\u0016¢\u0006\u0004\b\u001a\u0010\u001cJ!\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fJ\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u000eH\u0002J\u0013\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcoil/request/l;", "", "Lkotlin/Pair;", "", "Lcoil/request/l$c;", "", "T", "key", "g", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isEmpty", "", "d", "", "iterator", "other", "equals", "", "hashCode", "toString", "Lcoil/request/l$a;", "f", "a", "Ljava/util/Map;", "entries", "<init>", "(Ljava/util/Map;)V", "()V", "b", "c", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class l implements Iterable<Pair<? extends String, ? extends c>>, qk.a {

    /* renamed from: b  reason: collision with root package name */
    public static final b f8375b = new b((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    public static final l f8376c = new l();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f8377a;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007¨\u0006\f"}, d2 = {"Lcoil/request/l$a;", "", "Lcoil/request/l;", "a", "", "", "Lcoil/request/l$c;", "Ljava/util/Map;", "entries", "parameters", "<init>", "(Lcoil/request/l;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, c> f8378a;

        public a(l lVar) {
            this.f8378a = h0.w(lVar.f8377a);
        }

        public final l a() {
            return new l(coil.util.c.b(this.f8378a), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcoil/request/l$b;", "", "Lcoil/request/l;", "EMPTY", "Lcoil/request/l;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcoil/request/l$c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "value", "Ljava/lang/String;", "()Ljava/lang/String;", "memoryCacheKey", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f8379a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8380b;

        public final String a() {
            return this.f8380b;
        }

        public final Object b() {
            return this.f8379a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (!j.b(this.f8379a, cVar.f8379a) || !j.b(this.f8380b, cVar.f8380b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            Object obj = this.f8379a;
            int i11 = 0;
            if (obj != null) {
                i10 = obj.hashCode();
            } else {
                i10 = 0;
            }
            int i12 = i10 * 31;
            String str = this.f8380b;
            if (str != null) {
                i11 = str.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "Entry(value=" + this.f8379a + ", memoryCacheKey=" + this.f8380b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    private l(Map<String, c> map) {
        this.f8377a = map;
    }

    public /* synthetic */ l(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public final Map<String, String> d() {
        if (isEmpty()) {
            return h0.i();
        }
        Map<String, c> map = this.f8377a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String a10 = ((c) next.getValue()).a();
            if (a10 != null) {
                linkedHashMap.put(next.getKey(), a10);
            }
        }
        return linkedHashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && j.b(this.f8377a, ((l) obj).f8377a);
    }

    public final a f() {
        return new a(this);
    }

    public final <T> T g(String str) {
        c cVar = this.f8377a.get(str);
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public int hashCode() {
        return this.f8377a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f8377a.isEmpty();
    }

    public Iterator<Pair<String, c>> iterator() {
        Map<String, c> map = this.f8377a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(h.a((String) next.getKey(), (c) next.getValue()));
        }
        return arrayList.iterator();
    }

    public String toString() {
        return "Parameters(entries=" + this.f8377a + PropertyUtils.MAPPED_DELIM2;
    }

    public l() {
        this(h0.i());
    }
}
