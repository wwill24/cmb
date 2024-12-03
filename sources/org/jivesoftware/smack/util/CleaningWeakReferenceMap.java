package org.jivesoftware.smack.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CleaningWeakReferenceMap<K, V> extends HashMap<K, WeakReference<V>> {
    private static final long serialVersionUID = 0;
    private final int cleanInterval;
    private int numberOfInsertsSinceLastClean;

    public CleaningWeakReferenceMap() {
        this(50);
    }

    private void clean() {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!(entry == null || entry.getValue() == null || ((WeakReference) entry.getValue()).get() != null)) {
                it.remove();
            }
        }
    }

    public CleaningWeakReferenceMap(int i10) {
        this.numberOfInsertsSinceLastClean = 0;
        this.cleanInterval = i10;
    }

    public WeakReference<V> put(K k10, WeakReference<V> weakReference) {
        WeakReference<V> weakReference2 = (WeakReference) super.put(k10, weakReference);
        int i10 = this.numberOfInsertsSinceLastClean;
        this.numberOfInsertsSinceLastClean = i10 + 1;
        if (i10 > this.cleanInterval) {
            this.numberOfInsertsSinceLastClean = 0;
            clean();
        }
        return weakReference2;
    }
}
