package net.bytebuddy;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public class TypeCache<T> extends ReferenceQueue<ClassLoader> {
    @AlwaysNull
    private static final Class<?> NOT_FOUND = null;
    protected final ConcurrentMap<StorageKey, ConcurrentMap<T, Object>> cache;
    protected final Sort sort;

    protected static class LookupKey {
        /* access modifiers changed from: private */
        @MaybeNull
        public final ClassLoader classLoader;
        /* access modifiers changed from: private */
        public final int hashCode;

        protected LookupKey(@MaybeNull ClassLoader classLoader2) {
            this.classLoader = classLoader2;
            this.hashCode = System.identityHashCode(classLoader2);
        }

        @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LookupKey) {
                if (this.classLoader == ((LookupKey) obj).classLoader) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof StorageKey)) {
                return false;
            } else {
                StorageKey storageKey = (StorageKey) obj;
                if (this.hashCode == storageKey.hashCode && this.classLoader == storageKey.get()) {
                    return true;
                }
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class SimpleKey {
        private transient /* synthetic */ int hashCode;
        private final Set<String> types;

        public SimpleKey(Class<?> cls, Class<?>... clsArr) {
            this(cls, (Collection<? extends Class<?>>) Arrays.asList(clsArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.types.equals(((SimpleKey) obj).types);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : this.types.hashCode();
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public SimpleKey(Class<?> cls, Collection<? extends Class<?>> collection) {
            this(CompoundList.of(cls, new ArrayList(collection)));
        }

        public SimpleKey(Collection<? extends Class<?>> collection) {
            this.types = new HashSet();
            for (Class name : collection) {
                this.types.add(name.getName());
            }
        }
    }

    public enum Sort {
        WEAK {
            /* access modifiers changed from: protected */
            public Reference<Class<?>> wrap(Class<?> cls) {
                return new WeakReference(cls);
            }
        },
        SOFT {
            /* access modifiers changed from: protected */
            public Reference<Class<?>> wrap(Class<?> cls) {
                return new SoftReference(cls);
            }
        },
        STRONG {
            /* access modifiers changed from: protected */
            public Class<?> wrap(Class<?> cls) {
                return cls;
            }
        };

        /* access modifiers changed from: protected */
        public abstract Object wrap(Class<?> cls);
    }

    protected static class StorageKey extends WeakReference<ClassLoader> {
        /* access modifiers changed from: private */
        public final int hashCode;

        protected StorageKey(@MaybeNull ClassLoader classLoader, ReferenceQueue<? super ClassLoader> referenceQueue) {
            super(classLoader, referenceQueue);
            this.hashCode = System.identityHashCode(classLoader);
        }

        @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LookupKey) {
                LookupKey lookupKey = (LookupKey) obj;
                if (this.hashCode == lookupKey.hashCode && get() == lookupKey.classLoader) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof StorageKey)) {
                return false;
            } else {
                StorageKey storageKey = (StorageKey) obj;
                if (this.hashCode == storageKey.hashCode && get() == storageKey.get()) {
                    return true;
                }
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class WithInlineExpunction<S> extends TypeCache<S> {
        public WithInlineExpunction() {
            this(Sort.STRONG);
        }

        public Class<?> find(@MaybeNull ClassLoader classLoader, S s10) {
            try {
                return TypeCache.super.find(classLoader, s10);
            } finally {
                expungeStaleEntries();
            }
        }

        public Class<?> findOrInsert(ClassLoader classLoader, S s10, Callable<Class<?>> callable) {
            try {
                return TypeCache.super.findOrInsert(classLoader, s10, callable);
            } finally {
                expungeStaleEntries();
            }
        }

        public Class<?> insert(@MaybeNull ClassLoader classLoader, S s10, Class<?> cls) {
            try {
                return TypeCache.super.insert(classLoader, s10, cls);
            } finally {
                expungeStaleEntries();
            }
        }

        public WithInlineExpunction(Sort sort) {
            super(sort);
        }

        public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, S s10, Callable<Class<?>> callable, Object obj) {
            try {
                return TypeCache.super.findOrInsert(classLoader, s10, callable, obj);
            } finally {
                expungeStaleEntries();
            }
        }
    }

    public TypeCache() {
        this(Sort.STRONG);
    }

    public void clear() {
        this.cache.clear();
    }

    public void expungeStaleEntries() {
        while (true) {
            Reference poll = poll();
            if (poll != null) {
                this.cache.remove(poll);
            } else {
                return;
            }
        }
    }

    @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"GC_UNRELATED_TYPES"})
    @MaybeNull
    public Class<?> find(@MaybeNull ClassLoader classLoader, T t10) {
        ConcurrentMap concurrentMap = this.cache.get(new LookupKey(classLoader));
        if (concurrentMap == null) {
            return NOT_FOUND;
        }
        Object obj = concurrentMap.get(t10);
        if (obj == null) {
            return NOT_FOUND;
        }
        if (obj instanceof Reference) {
            return (Class) ((Reference) obj).get();
        }
        return (Class) obj;
    }

    public Class<?> findOrInsert(ClassLoader classLoader, T t10, Callable<Class<?>> callable) {
        Class<?> find = find(classLoader, t10);
        if (find != null) {
            return find;
        }
        try {
            return insert(classLoader, t10, callable.call());
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Could not create type", th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = new java.util.concurrent.ConcurrentHashMap();
     */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"GC_UNRELATED_TYPES"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> insert(@net.bytebuddy.utility.nullability.MaybeNull java.lang.ClassLoader r4, T r5, java.lang.Class<?> r6) {
        /*
            r3 = this;
            java.util.concurrent.ConcurrentMap<net.bytebuddy.TypeCache$StorageKey, java.util.concurrent.ConcurrentMap<T, java.lang.Object>> r0 = r3.cache
            net.bytebuddy.TypeCache$LookupKey r1 = new net.bytebuddy.TypeCache$LookupKey
            r1.<init>(r4)
            java.lang.Object r0 = r0.get(r1)
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            if (r0 != 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            java.util.concurrent.ConcurrentMap<net.bytebuddy.TypeCache$StorageKey, java.util.concurrent.ConcurrentMap<T, java.lang.Object>> r1 = r3.cache
            net.bytebuddy.TypeCache$StorageKey r2 = new net.bytebuddy.TypeCache$StorageKey
            r2.<init>(r4, r3)
            java.lang.Object r4 = r1.putIfAbsent(r2, r0)
            java.util.concurrent.ConcurrentMap r4 = (java.util.concurrent.ConcurrentMap) r4
            if (r4 == 0) goto L_0x0024
            r0 = r4
        L_0x0024:
            net.bytebuddy.TypeCache$Sort r4 = r3.sort
            java.lang.Object r4 = r4.wrap(r6)
            java.lang.Object r1 = r0.putIfAbsent(r5, r4)
        L_0x002e:
            if (r1 == 0) goto L_0x0058
            boolean r2 = r1 instanceof java.lang.ref.Reference
            if (r2 == 0) goto L_0x003c
            r2 = r1
            java.lang.ref.Reference r2 = (java.lang.ref.Reference) r2
            java.lang.Object r2 = r2.get()
            goto L_0x003d
        L_0x003c:
            r2 = r1
        L_0x003d:
            java.lang.Class r2 = (java.lang.Class) r2
            if (r2 == 0) goto L_0x0042
            return r2
        L_0x0042:
            boolean r1 = r0.remove(r5, r1)
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = r0.putIfAbsent(r5, r4)
            goto L_0x002e
        L_0x004d:
            java.lang.Object r1 = r0.get(r5)
            if (r1 != 0) goto L_0x002e
            java.lang.Object r1 = r0.putIfAbsent(r5, r4)
            goto L_0x002e
        L_0x0058:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.TypeCache.insert(java.lang.ClassLoader, java.lang.Object, java.lang.Class):java.lang.Class");
    }

    public TypeCache(Sort sort2) {
        this.sort = sort2;
        this.cache = new ConcurrentHashMap();
    }

    public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, T t10, Callable<Class<?>> callable, Object obj) {
        Class<?> findOrInsert;
        Class<?> find = find(classLoader, t10);
        if (find != null) {
            return find;
        }
        synchronized (obj) {
            findOrInsert = findOrInsert(classLoader, t10, callable);
        }
        return findOrInsert;
    }
}
