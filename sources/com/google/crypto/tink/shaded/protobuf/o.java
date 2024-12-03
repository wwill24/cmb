package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class o {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f20864b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile o f20865c;

    /* renamed from: d  reason: collision with root package name */
    static final o f20866d = new o(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<a, GeneratedMessageLite.e<?, ?>> f20867a;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f20868a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20869b;

        a(Object obj, int i10) {
            this.f20868a = obj;
            this.f20869b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f20868a == aVar.f20868a && this.f20869b == aVar.f20869b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f20868a) * 65535) + this.f20869b;
        }
    }

    o() {
        this.f20867a = new HashMap();
    }

    public static o b() {
        o oVar = f20865c;
        if (oVar == null) {
            synchronized (o.class) {
                oVar = f20865c;
                if (oVar == null) {
                    if (f20864b) {
                        oVar = n.a();
                    } else {
                        oVar = f20866d;
                    }
                    f20865c = oVar;
                }
            }
        }
        return oVar;
    }

    public <ContainingType extends l0> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType containingtype, int i10) {
        return this.f20867a.get(new a(containingtype, i10));
    }

    o(boolean z10) {
        this.f20867a = Collections.emptyMap();
    }
}
