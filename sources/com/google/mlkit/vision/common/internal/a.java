package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.internal.p;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map f21527a = new HashMap();

    /* renamed from: com.google.mlkit.vision.common.internal.a$a  reason: collision with other inner class name */
    public static class C0249a {

        /* renamed from: a  reason: collision with root package name */
        private final Class f21528a;

        /* renamed from: b  reason: collision with root package name */
        private final Provider f21529b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21530c;

        /* access modifiers changed from: package-private */
        public final int a() {
            return this.f21530c;
        }

        /* access modifiers changed from: package-private */
        public final Provider b() {
            return this.f21529b;
        }

        /* access modifiers changed from: package-private */
        public final Class c() {
            return this.f21528a;
        }
    }

    a(Set set) {
        HashMap hashMap = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C0249a aVar = (C0249a) it.next();
            Class c10 = aVar.c();
            if (!this.f21527a.containsKey(c10) || aVar.a() >= ((Integer) p.k((Integer) hashMap.get(c10))).intValue()) {
                this.f21527a.put(c10, aVar.b());
                hashMap.put(c10, Integer.valueOf(aVar.a()));
            }
        }
    }
}
