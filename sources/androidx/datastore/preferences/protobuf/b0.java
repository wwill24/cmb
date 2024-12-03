package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.Collections;
import java.util.List;

abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static final b0 f5198a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final b0 f5199b = new c();

    private static final class b extends b0 {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?> f5200c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static <E> List<E> f(Object obj, long j10) {
            return (List) i1.A(obj, j10);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.datastore.preferences.protobuf.z} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.datastore.preferences.protobuf.z} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.datastore.preferences.protobuf.z} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> g(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.a0
                if (r1 == 0) goto L_0x0014
                androidx.datastore.preferences.protobuf.z r0 = new androidx.datastore.preferences.protobuf.z
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.t0
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.w.i
                if (r1 == 0) goto L_0x0024
                androidx.datastore.preferences.protobuf.w$i r0 = (androidx.datastore.preferences.protobuf.w.i) r0
                androidx.datastore.preferences.protobuf.w$i r6 = r0.a(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                androidx.datastore.preferences.protobuf.i1.O(r3, r4, r0)
                goto L_0x007f
            L_0x002d:
                java.lang.Class<?> r1 = f5200c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.i1.O(r3, r4, r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.h1
                if (r1 == 0) goto L_0x0062
                androidx.datastore.preferences.protobuf.z r1 = new androidx.datastore.preferences.protobuf.z
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                androidx.datastore.preferences.protobuf.h1 r0 = (androidx.datastore.preferences.protobuf.h1) r0
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.i1.O(r3, r4, r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.t0
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.w.i
                if (r1 == 0) goto L_0x007f
                r1 = r0
                androidx.datastore.preferences.protobuf.w$i r1 = (androidx.datastore.preferences.protobuf.w.i) r1
                boolean r2 = r1.h()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.w$i r0 = r1.a(r0)
                androidx.datastore.preferences.protobuf.i1.O(r3, r4, r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.b0.b.g(java.lang.Object, long, int):java.util.List");
        }

        /* access modifiers changed from: package-private */
        public void c(Object obj, long j10) {
            Object obj2;
            List list = (List) i1.A(obj, j10);
            if (list instanceof a0) {
                obj2 = ((a0) list).k();
            } else if (!f5200c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof t0) || !(list instanceof w.i)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    w.i iVar = (w.i) list;
                    if (iVar.h()) {
                        iVar.c();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            i1.O(obj, j10, obj2);
        }

        /* access modifiers changed from: package-private */
        public <E> void d(Object obj, Object obj2, long j10) {
            List f10 = f(obj2, j10);
            List g10 = g(obj, j10, f10.size());
            int size = g10.size();
            int size2 = f10.size();
            if (size > 0 && size2 > 0) {
                g10.addAll(f10);
            }
            if (size > 0) {
                f10 = g10;
            }
            i1.O(obj, j10, f10);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> e(Object obj, long j10) {
            return g(obj, j10, 10);
        }
    }

    private static final class c extends b0 {
        private c() {
            super();
        }

        static <E> w.i<E> f(Object obj, long j10) {
            return (w.i) i1.A(obj, j10);
        }

        /* access modifiers changed from: package-private */
        public void c(Object obj, long j10) {
            f(obj, j10).c();
        }

        /* access modifiers changed from: package-private */
        public <E> void d(Object obj, Object obj2, long j10) {
            w.i f10 = f(obj, j10);
            w.i f11 = f(obj2, j10);
            int size = f10.size();
            int size2 = f11.size();
            if (size > 0 && size2 > 0) {
                if (!f10.h()) {
                    f10 = f10.a(size2 + size);
                }
                f10.addAll(f11);
            }
            if (size > 0) {
                f11 = f10;
            }
            i1.O(obj, j10, f11);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> e(Object obj, long j10) {
            int i10;
            w.i f10 = f(obj, j10);
            if (f10.h()) {
                return f10;
            }
            int size = f10.size();
            if (size == 0) {
                i10 = 10;
            } else {
                i10 = size * 2;
            }
            w.i a10 = f10.a(i10);
            i1.O(obj, j10, a10);
            return a10;
        }
    }

    private b0() {
    }

    static b0 a() {
        return f5198a;
    }

    static b0 b() {
        return f5199b;
    }

    /* access modifiers changed from: package-private */
    public abstract void c(Object obj, long j10);

    /* access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j10);

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j10);
}
