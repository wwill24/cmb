package org.apache.commons.beanutils;

import java.util.Map;
import java.util.WeakHashMap;

public class ContextClassLoaderLocal<T> {
    private T globalValue;
    private boolean globalValueInitialized = false;
    private final Map<ClassLoader, T> valueByClassLoader = new WeakHashMap();

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|3|4|(2:6|(1:10))|13|14|(1:16)|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized T get() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.ClassLoader, T> r0 = r3.valueByClassLoader     // Catch:{ all -> 0x003c }
            r0.isEmpty()     // Catch:{ all -> 0x003c }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ SecurityException -> 0x002b }
            java.lang.ClassLoader r0 = r0.getContextClassLoader()     // Catch:{ SecurityException -> 0x002b }
            if (r0 == 0) goto L_0x002b
            java.util.Map<java.lang.ClassLoader, T> r1 = r3.valueByClassLoader     // Catch:{ SecurityException -> 0x002b }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ SecurityException -> 0x002b }
            if (r1 != 0) goto L_0x0029
            java.util.Map<java.lang.ClassLoader, T> r2 = r3.valueByClassLoader     // Catch:{ SecurityException -> 0x002b }
            boolean r2 = r2.containsKey(r0)     // Catch:{ SecurityException -> 0x002b }
            if (r2 != 0) goto L_0x0029
            java.lang.Object r1 = r3.initialValue()     // Catch:{ SecurityException -> 0x002b }
            java.util.Map<java.lang.ClassLoader, T> r2 = r3.valueByClassLoader     // Catch:{ SecurityException -> 0x002b }
            r2.put(r0, r1)     // Catch:{ SecurityException -> 0x002b }
        L_0x0029:
            monitor-exit(r3)
            return r1
        L_0x002b:
            boolean r0 = r3.globalValueInitialized     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0038
            java.lang.Object r0 = r3.initialValue()     // Catch:{ all -> 0x003c }
            r3.globalValue = r0     // Catch:{ all -> 0x003c }
            r0 = 1
            r3.globalValueInitialized = r0     // Catch:{ all -> 0x003c }
        L_0x0038:
            T r0 = r3.globalValue     // Catch:{ all -> 0x003c }
            monitor-exit(r3)
            return r0
        L_0x003c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.ContextClassLoaderLocal.get():java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public T initialValue() {
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|(3:6|7|8)|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void set(T r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.ClassLoader, T> r0 = r2.valueByClassLoader     // Catch:{ all -> 0x001e }
            r0.isEmpty()     // Catch:{ all -> 0x001e }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ SecurityException -> 0x0017 }
            java.lang.ClassLoader r0 = r0.getContextClassLoader()     // Catch:{ SecurityException -> 0x0017 }
            if (r0 == 0) goto L_0x0017
            java.util.Map<java.lang.ClassLoader, T> r1 = r2.valueByClassLoader     // Catch:{ SecurityException -> 0x0017 }
            r1.put(r0, r3)     // Catch:{ SecurityException -> 0x0017 }
            monitor-exit(r2)
            return
        L_0x0017:
            r2.globalValue = r3     // Catch:{ all -> 0x001e }
            r3 = 1
            r2.globalValueInitialized = r3     // Catch:{ all -> 0x001e }
            monitor-exit(r2)
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.ContextClassLoaderLocal.set(java.lang.Object):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void unset() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ SecurityException -> 0x0010, all -> 0x000d }
            java.lang.ClassLoader r0 = r0.getContextClassLoader()     // Catch:{ SecurityException -> 0x0010, all -> 0x000d }
            r1.unset(r0)     // Catch:{ SecurityException -> 0x0010, all -> 0x000d }
            goto L_0x0010
        L_0x000d:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0010:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.ContextClassLoaderLocal.unset():void");
    }

    public synchronized void unset(ClassLoader classLoader) {
        this.valueByClassLoader.remove(classLoader);
    }
}
