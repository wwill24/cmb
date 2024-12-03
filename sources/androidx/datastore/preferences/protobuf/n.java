package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class n {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5328b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f5329c = c();

    /* renamed from: d  reason: collision with root package name */
    private static volatile n f5330d;

    /* renamed from: e  reason: collision with root package name */
    static final n f5331e = new n(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<a, GeneratedMessageLite.e<?, ?>> f5332a;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f5333a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5334b;

        a(Object obj, int i10) {
            this.f5333a = obj;
            this.f5334b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5333a == aVar.f5333a && this.f5334b == aVar.f5334b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f5333a) * 65535) + this.f5334b;
        }
    }

    n() {
        this.f5332a = new HashMap();
    }

    public static n b() {
        n nVar = f5330d;
        if (nVar == null) {
            synchronized (n.class) {
                nVar = f5330d;
                if (nVar == null) {
                    if (f5328b) {
                        nVar = m.a();
                    } else {
                        nVar = f5331e;
                    }
                    f5330d = nVar;
                }
            }
        }
        return nVar;
    }

    static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends k0> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType containingtype, int i10) {
        return this.f5332a.get(new a(containingtype, i10));
    }

    n(boolean z10) {
        this.f5332a = Collections.emptyMap();
    }
}
