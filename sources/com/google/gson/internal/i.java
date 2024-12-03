package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

public class i {

    private static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f21364a;

        class a extends b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Method f21365b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f21365b = method;
            }

            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f21365b.invoke(accessibleObject, new Object[]{obj})).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* renamed from: com.google.gson.internal.i$b$b  reason: collision with other inner class name */
        class C0247b extends b {
            C0247b() {
                super();
            }

            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001f  */
        static {
            /*
                boolean r0 = com.google.gson.internal.d.d()
                if (r0 == 0) goto L_0x001c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001c }
                r3 = 0
                java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
                r2[r3] = r4     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x001c }
                com.google.gson.internal.i$b$a r1 = new com.google.gson.internal.i$b$a     // Catch:{ NoSuchMethodException -> 0x001c }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x001c }
                goto L_0x001d
            L_0x001c:
                r1 = 0
            L_0x001d:
                if (r1 != 0) goto L_0x0024
                com.google.gson.internal.i$b$b r1 = new com.google.gson.internal.i$b$b
                r1.<init>()
            L_0x0024:
                f21364a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.i.b.<clinit>():void");
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f21364a.a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult b(List<ReflectionAccessFilter> list, Class<?> cls) {
        for (ReflectionAccessFilter a10 : list) {
            ReflectionAccessFilter.FilterResult a11 = a10.a(cls);
            if (a11 != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return a11;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}
