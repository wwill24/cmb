package com.squareup.moshi;

import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s {

    /* renamed from: e  reason: collision with root package name */
    static final List<h.e> f23012e;

    /* renamed from: a  reason: collision with root package name */
    private final List<h.e> f23013a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23014b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ThreadLocal<d> f23015c = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<Object, h<?>> f23016d = new LinkedHashMap();

    class a implements h.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f23017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f23018b;

        a(Type type, h hVar) {
            this.f23017a = type;
            this.f23018b = hVar;
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            if (!set.isEmpty() || !bi.c.w(this.f23017a, type)) {
                return null;
            }
            return this.f23018b;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final List<h.e> f23019a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        int f23020b = 0;

        public b a(h.e eVar) {
            if (eVar != null) {
                List<h.e> list = this.f23019a;
                int i10 = this.f23020b;
                this.f23020b = i10 + 1;
                list.add(i10, eVar);
                return this;
            }
            throw new IllegalArgumentException("factory == null");
        }

        public b b(Object obj) {
            if (obj != null) {
                return a(a.c(obj));
            }
            throw new IllegalArgumentException("adapter == null");
        }

        public <T> b c(Type type, h<T> hVar) {
            return a(s.h(type, hVar));
        }

        public s d() {
            return new s(this);
        }
    }

    static final class c<T> extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        final Type f23021a;

        /* renamed from: b  reason: collision with root package name */
        final String f23022b;

        /* renamed from: c  reason: collision with root package name */
        final Object f23023c;

        /* renamed from: d  reason: collision with root package name */
        h<T> f23024d;

        c(Type type, String str, Object obj) {
            this.f23021a = type;
            this.f23022b = str;
            this.f23023c = obj;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            h<T> hVar = this.f23024d;
            if (hVar != null) {
                return hVar.fromJson(jsonReader);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public void toJson(q qVar, T t10) throws IOException {
            h<T> hVar = this.f23024d;
            if (hVar != null) {
                hVar.toJson(qVar, t10);
                return;
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public String toString() {
            h<T> hVar = this.f23024d;
            return hVar != null ? hVar.toString() : super.toString();
        }
    }

    final class d {

        /* renamed from: a  reason: collision with root package name */
        final List<c<?>> f23025a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Deque<c<?>> f23026b = new ArrayDeque();

        /* renamed from: c  reason: collision with root package name */
        boolean f23027c;

        d() {
        }

        /* access modifiers changed from: package-private */
        public <T> void a(h<T> hVar) {
            this.f23026b.getLast().f23024d = hVar;
        }

        /* access modifiers changed from: package-private */
        public IllegalArgumentException b(IllegalArgumentException illegalArgumentException) {
            if (this.f23027c) {
                return illegalArgumentException;
            }
            this.f23027c = true;
            if (this.f23026b.size() == 1 && this.f23026b.getFirst().f23022b == null) {
                return illegalArgumentException;
            }
            StringBuilder sb2 = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<c<?>> descendingIterator = this.f23026b.descendingIterator();
            while (descendingIterator.hasNext()) {
                c next = descendingIterator.next();
                sb2.append("\nfor ");
                sb2.append(next.f23021a);
                if (next.f23022b != null) {
                    sb2.append(' ');
                    sb2.append(next.f23022b);
                }
            }
            return new IllegalArgumentException(sb2.toString(), illegalArgumentException);
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            this.f23026b.removeLast();
            if (this.f23026b.isEmpty()) {
                s.this.f23015c.remove();
                if (z10) {
                    synchronized (s.this.f23016d) {
                        int size = this.f23025a.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            c cVar = this.f23025a.get(i10);
                            h<T> hVar = (h) s.this.f23016d.put(cVar.f23023c, cVar.f23024d);
                            if (hVar != null) {
                                cVar.f23024d = hVar;
                                s.this.f23016d.put(cVar.f23023c, hVar);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public <T> h<T> d(Type type, String str, Object obj) {
            int size = this.f23025a.size();
            for (int i10 = 0; i10 < size; i10++) {
                c cVar = this.f23025a.get(i10);
                if (cVar.f23023c.equals(obj)) {
                    this.f23026b.add(cVar);
                    h<T> hVar = cVar.f23024d;
                    if (hVar != null) {
                        return hVar;
                    }
                    return cVar;
                }
            }
            c cVar2 = new c(type, str, obj);
            this.f23025a.add(cVar2);
            this.f23026b.add(cVar2);
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        f23012e = arrayList;
        arrayList.add(u.f23030a);
        arrayList.add(e.f22953b);
        arrayList.add(r.f23009c);
        arrayList.add(b.f22933c);
        arrayList.add(t.f23029a);
        arrayList.add(d.f22946d);
    }

    s(b bVar) {
        int size = bVar.f23019a.size();
        List<h.e> list = f23012e;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(bVar.f23019a);
        arrayList.addAll(list);
        this.f23013a = Collections.unmodifiableList(arrayList);
        this.f23014b = bVar.f23020b;
    }

    private Object g(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        return Arrays.asList(new Object[]{type, set});
    }

    static <T> h.e h(Type type, h<T> hVar) {
        if (type == null) {
            throw new IllegalArgumentException("type == null");
        } else if (hVar != null) {
            return new a(type, hVar);
        } else {
            throw new IllegalArgumentException("jsonAdapter == null");
        }
    }

    public <T> h<T> c(Class<T> cls) {
        return e(cls, bi.c.f18956a);
    }

    public <T> h<T> d(Type type) {
        return e(type, bi.c.f18956a);
    }

    public <T> h<T> e(Type type, Set<? extends Annotation> set) {
        return f(type, set, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r1 = r4.f23015c.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r1 = new com.squareup.moshi.s.d(r4);
        r4.f23015c.set(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r7 = r1.d(r5, r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r7 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r1.c(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r7 = r4.f23013a.size();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r2 >= r7) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r3 = r4.f23013a.get(r2).create(r5, r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r3 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r1.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        r1.c(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        throw new java.lang.IllegalArgumentException("No JsonAdapter for " + bi.c.u(r5, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        throw r1.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        r1.c(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.squareup.moshi.h<T> f(java.lang.reflect.Type r5, java.util.Set<? extends java.lang.annotation.Annotation> r6, java.lang.String r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0093
            if (r6 == 0) goto L_0x008b
            java.lang.reflect.Type r5 = bi.c.a(r5)
            java.lang.reflect.Type r5 = bi.c.p(r5)
            java.lang.Object r0 = r4.g(r5, r6)
            java.util.Map<java.lang.Object, com.squareup.moshi.h<?>> r1 = r4.f23016d
            monitor-enter(r1)
            java.util.Map<java.lang.Object, com.squareup.moshi.h<?>> r2 = r4.f23016d     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0088 }
            com.squareup.moshi.h r2 = (com.squareup.moshi.h) r2     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x001f
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            java.lang.ThreadLocal<com.squareup.moshi.s$d> r1 = r4.f23015c
            java.lang.Object r1 = r1.get()
            com.squareup.moshi.s$d r1 = (com.squareup.moshi.s.d) r1
            if (r1 != 0) goto L_0x0034
            com.squareup.moshi.s$d r1 = new com.squareup.moshi.s$d
            r1.<init>()
            java.lang.ThreadLocal<com.squareup.moshi.s$d> r2 = r4.f23015c
            r2.set(r1)
        L_0x0034:
            com.squareup.moshi.h r7 = r1.d(r5, r7, r0)
            r0 = 0
            if (r7 == 0) goto L_0x003f
            r1.c(r0)
            return r7
        L_0x003f:
            java.util.List<com.squareup.moshi.h$e> r7 = r4.f23013a     // Catch:{ IllegalArgumentException -> 0x007e }
            int r7 = r7.size()     // Catch:{ IllegalArgumentException -> 0x007e }
            r2 = r0
        L_0x0046:
            if (r2 >= r7) goto L_0x0061
            java.util.List<com.squareup.moshi.h$e> r3 = r4.f23013a     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ IllegalArgumentException -> 0x007e }
            com.squareup.moshi.h$e r3 = (com.squareup.moshi.h.e) r3     // Catch:{ IllegalArgumentException -> 0x007e }
            com.squareup.moshi.h r3 = r3.create(r5, r6, r4)     // Catch:{ IllegalArgumentException -> 0x007e }
            if (r3 != 0) goto L_0x0059
            int r2 = r2 + 1
            goto L_0x0046
        L_0x0059:
            r1.a(r3)     // Catch:{ IllegalArgumentException -> 0x007e }
            r5 = 1
            r1.c(r5)
            return r3
        L_0x0061:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x007e }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.String r3 = "No JsonAdapter for "
            r2.append(r3)     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.String r5 = bi.c.u(r5, r6)     // Catch:{ IllegalArgumentException -> 0x007e }
            r2.append(r5)     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.String r5 = r2.toString()     // Catch:{ IllegalArgumentException -> 0x007e }
            r7.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x007e }
            throw r7     // Catch:{ IllegalArgumentException -> 0x007e }
        L_0x007c:
            r5 = move-exception
            goto L_0x0084
        L_0x007e:
            r5 = move-exception
            java.lang.IllegalArgumentException r5 = r1.b(r5)     // Catch:{ all -> 0x007c }
            throw r5     // Catch:{ all -> 0x007c }
        L_0x0084:
            r1.c(r0)
            throw r5
        L_0x0088:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            throw r5
        L_0x008b:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "annotations == null"
            r5.<init>(r6)
            throw r5
        L_0x0093:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "type == null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.s.f(java.lang.reflect.Type, java.util.Set, java.lang.String):com.squareup.moshi.h");
    }

    public <T> h<T> i(h.e eVar, Type type, Set<? extends Annotation> set) {
        if (set != null) {
            Type p10 = bi.c.p(bi.c.a(type));
            int indexOf = this.f23013a.indexOf(eVar);
            if (indexOf != -1) {
                int size = this.f23013a.size();
                for (int i10 = indexOf + 1; i10 < size; i10++) {
                    h<?> create = this.f23013a.get(i10).create(p10, set, this);
                    if (create != null) {
                        return create;
                    }
                }
                throw new IllegalArgumentException("No next JsonAdapter for " + bi.c.u(p10, set));
            }
            throw new IllegalArgumentException("Unable to skip past unknown factory " + eVar);
        }
        throw new NullPointerException("annotations == null");
    }
}
