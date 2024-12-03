package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class n {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f21900b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile n f21901c;

    /* renamed from: d  reason: collision with root package name */
    static final n f21902d = new n(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<a, GeneratedMessageLite.e<?, ?>> f21903a;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f21904a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21905b;

        a(Object obj, int i10) {
            this.f21904a = obj;
            this.f21905b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f21904a == aVar.f21904a && this.f21905b == aVar.f21905b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f21904a) * 65535) + this.f21905b;
        }
    }

    n() {
        this.f21903a = new HashMap();
    }

    public static n b() {
        n nVar = f21901c;
        if (nVar == null) {
            synchronized (n.class) {
                nVar = f21901c;
                if (nVar == null) {
                    if (f21900b) {
                        nVar = m.a();
                    } else {
                        nVar = f21902d;
                    }
                    f21901c = nVar;
                }
            }
        }
        return nVar;
    }

    public <ContainingType extends l0> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType containingtype, int i10) {
        return this.f21903a.get(new a(containingtype, i10));
    }

    n(boolean z10) {
        this.f21903a = Collections.emptyMap();
    }
}
