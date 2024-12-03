package com.google.crypto.tink;

import ag.j;
import com.google.crypto.tink.f;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.a;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.l0;
import hg.x;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f20573a = Logger.getLogger(g.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<String, d> f20574b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentMap<String, c> f20575c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentMap<String, Boolean> f20576d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentMap<String, Object> f20577e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, j<?, ?>> f20578f = new ConcurrentHashMap();

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20579a;

        a(c cVar) {
            this.f20579a = cVar;
        }

        public Class<?> a() {
            return this.f20579a.getClass();
        }

        public Set<Class<?>> b() {
            return this.f20579a.h();
        }

        public <Q> ag.d<Q> c(Class<Q> cls) throws GeneralSecurityException {
            try {
                return new b(this.f20579a, cls);
            } catch (IllegalArgumentException e10) {
                throw new GeneralSecurityException("Primitive type not supported", e10);
            }
        }

        public ag.d<?> d() {
            c cVar = this.f20579a;
            return new b(cVar, cVar.a());
        }
    }

    class b implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20580a;

        b(c cVar) {
            this.f20580a = cVar;
        }
    }

    private interface c {
    }

    private interface d {
        Class<?> a();

        Set<Class<?>> b();

        <P> ag.d<P> c(Class<P> cls) throws GeneralSecurityException;

        ag.d<?> d();
    }

    private g() {
    }

    private static <T> T a(T t10) {
        t10.getClass();
        return t10;
    }

    private static <KeyProtoT extends l0> d b(c<KeyProtoT> cVar) {
        return new a(cVar);
    }

    private static <KeyProtoT extends l0> c c(c<KeyProtoT> cVar) {
        return new b(cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void d(java.lang.String r5, java.lang.Class<?> r6, boolean r7) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.crypto.tink.g> r0 = com.google.crypto.tink.g.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.g$d> r1 = f20574b     // Catch:{ all -> 0x0081 }
            boolean r2 = r1.containsKey(r5)     // Catch:{ all -> 0x0081 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0081 }
            com.google.crypto.tink.g$d r1 = (com.google.crypto.tink.g.d) r1     // Catch:{ all -> 0x0081 }
            java.lang.Class r2 = r1.a()     // Catch:{ all -> 0x0081 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0047
            if (r7 == 0) goto L_0x0045
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r6 = f20576d     // Catch:{ all -> 0x0081 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x0081 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0081 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0081 }
            if (r6 == 0) goto L_0x002e
            goto L_0x0045
        L_0x002e:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r7.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "New keys are already disallowed for key type "
            r7.append(r1)     // Catch:{ all -> 0x0081 }
            r7.append(r5)     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0081 }
            r6.<init>(r5)     // Catch:{ all -> 0x0081 }
            throw r6     // Catch:{ all -> 0x0081 }
        L_0x0045:
            monitor-exit(r0)
            return
        L_0x0047:
            java.util.logging.Logger r7 = f20573a     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r2.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "Attempted overwrite of a registered key manager for key type "
            r2.append(r3)     // Catch:{ all -> 0x0081 }
            r2.append(r5)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0081 }
            r7.warning(r2)     // Catch:{ all -> 0x0081 }
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0081 }
            r4 = 0
            r3[r4] = r5     // Catch:{ all -> 0x0081 }
            r5 = 1
            java.lang.Class r1 = r1.a()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0081 }
            r3[r5] = r1     // Catch:{ all -> 0x0081 }
            r5 = 2
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0081 }
            r3[r5] = r6     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0081 }
            r7.<init>(r5)     // Catch:{ all -> 0x0081 }
            throw r7     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.g.d(java.lang.String, java.lang.Class, boolean):void");
    }

    public static Class<?> e(Class<?> cls) {
        j jVar = f20578f.get(cls);
        if (jVar == null) {
            return null;
        }
        return jVar.b();
    }

    private static synchronized d f(String str) throws GeneralSecurityException {
        d dVar;
        synchronized (g.class) {
            ConcurrentMap<String, d> concurrentMap = f20574b;
            if (concurrentMap.containsKey(str)) {
                dVar = concurrentMap.get(str);
            } else {
                throw new GeneralSecurityException("No key manager found for key type " + str);
            }
        }
        return dVar;
    }

    private static <P> ag.d<P> g(String str, Class<P> cls) throws GeneralSecurityException {
        d f10 = f(str);
        if (cls == null) {
            return f10.d();
        }
        if (f10.b().contains(cls)) {
            return f10.c(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + f10.a() + ", supported primitives: " + s(f10.b()));
    }

    public static <P> P h(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return j(str, byteString, (Class) a(cls));
    }

    public static <P> P i(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return h(str, ByteString.i(bArr), cls);
    }

    private static <P> P j(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return g(str, cls).c(byteString);
    }

    public static <P> f<P> k(d dVar, ag.d<P> dVar2, Class<P> cls) throws GeneralSecurityException {
        return m(dVar, dVar2, (Class) a(cls));
    }

    public static <P> f<P> l(d dVar, Class<P> cls) throws GeneralSecurityException {
        return k(dVar, (ag.d) null, cls);
    }

    private static <P> f<P> m(d dVar, ag.d<P> dVar2, Class<P> cls) throws GeneralSecurityException {
        P p10;
        h.d(dVar.f());
        f<P> f10 = f.f(cls);
        for (a.c next : dVar.f().J()) {
            if (next.K() == KeyStatusType.ENABLED) {
                if (dVar2 == null || !dVar2.a(next.H().I())) {
                    p10 = j(next.H().I(), next.H().J(), cls);
                } else {
                    p10 = dVar2.c(next.H().J());
                }
                f.b<P> a10 = f10.a(p10, next);
                if (next.I() == dVar.f().K()) {
                    f10.g(a10);
                }
            }
        }
        return f10;
    }

    public static ag.d<?> n(String str) throws GeneralSecurityException {
        return f(str).d();
    }

    public static synchronized l0 o(x xVar) throws GeneralSecurityException {
        l0 d10;
        synchronized (g.class) {
            ag.d<?> n10 = n(xVar.I());
            if (f20576d.get(xVar.I()).booleanValue()) {
                d10 = n10.d(xVar.J());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + xVar.I());
            }
        }
        return d10;
    }

    public static synchronized KeyData p(x xVar) throws GeneralSecurityException {
        KeyData b10;
        synchronized (g.class) {
            ag.d<?> n10 = n(xVar.I());
            if (f20576d.get(xVar.I()).booleanValue()) {
                b10 = n10.b(xVar.J());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + xVar.I());
            }
        }
        return b10;
    }

    public static synchronized <KeyProtoT extends l0> void q(c<KeyProtoT> cVar, boolean z10) throws GeneralSecurityException {
        synchronized (g.class) {
            if (cVar != null) {
                String c10 = cVar.c();
                d(c10, cVar.getClass(), z10);
                ConcurrentMap<String, d> concurrentMap = f20574b;
                if (!concurrentMap.containsKey(c10)) {
                    concurrentMap.put(c10, b(cVar));
                    f20575c.put(c10, c(cVar));
                }
                f20576d.put(c10, Boolean.valueOf(z10));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <B, P> void r(j<B, P> jVar) throws GeneralSecurityException {
        synchronized (g.class) {
            if (jVar != null) {
                Class<P> c10 = jVar.c();
                ConcurrentMap<Class<?>, j<?, ?>> concurrentMap = f20578f;
                if (concurrentMap.containsKey(c10)) {
                    j jVar2 = concurrentMap.get(c10);
                    if (!jVar.getClass().equals(jVar2.getClass())) {
                        Logger logger = f20573a;
                        logger.warning("Attempted overwrite of a registered SetWrapper for type " + c10);
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{c10.getName(), jVar2.getClass().getName(), jVar.getClass().getName()}));
                    }
                }
                concurrentMap.put(c10, jVar);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static String s(Set<Class<?>> set) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Class next : set) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(next.getCanonicalName());
            z10 = false;
        }
        return sb2.toString();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.crypto.tink.f<B>, com.google.crypto.tink.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <B, P> P t(com.google.crypto.tink.f<B> r3, java.lang.Class<P> r4) throws java.security.GeneralSecurityException {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, ag.j<?, ?>> r0 = f20578f
            java.lang.Object r4 = r0.get(r4)
            ag.j r4 = (ag.j) r4
            if (r4 == 0) goto L_0x0044
            java.lang.Class r0 = r4.b()
            java.lang.Class r1 = r3.d()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001d
            java.lang.Object r3 = r4.a(r3)
            return r3
        L_0x001d:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Wrong input primitive class, expected "
            r1.append(r2)
            java.lang.Class r4 = r4.b()
            r1.append(r4)
            java.lang.String r4 = ", got "
            r1.append(r4)
            java.lang.Class r3 = r3.d()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0044:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No wrapper found for "
            r0.append(r1)
            java.lang.Class r3 = r3.d()
            java.lang.String r3 = r3.getName()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.g.t(com.google.crypto.tink.f, java.lang.Class):java.lang.Object");
    }
}
