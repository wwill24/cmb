package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;

public class ObjectIdMapper {
    private SparseArray<Object> mIdToObjectMap = new SparseArray<>();
    private int mNextId = 1;
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    protected final Object mSync = new Object();

    public void clear() {
        SparseArray<Object> sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray<>();
        }
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            onUnmapped(sparseArray.valueAt(i10), sparseArray.keyAt(i10));
        }
    }

    public boolean containsId(int i10) {
        boolean z10;
        synchronized (this.mSync) {
            if (this.mIdToObjectMap.get(i10) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean containsObject(Object obj) {
        boolean containsKey;
        synchronized (this.mSync) {
            containsKey = this.mObjectToIdMap.containsKey(obj);
        }
        return containsKey;
    }

    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    public Object getObjectForId(int i10) {
        Object obj;
        synchronized (this.mSync) {
            obj = this.mIdToObjectMap.get(i10);
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public void onMapped(Object obj, int i10) {
    }

    /* access modifiers changed from: protected */
    public void onUnmapped(Object obj, int i10) {
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            Integer num = this.mObjectToIdMap.get(obj);
            if (num != null) {
                int intValue = num.intValue();
                return intValue;
            }
            int i10 = this.mNextId;
            this.mNextId = i10 + 1;
            Integer valueOf = Integer.valueOf(i10);
            this.mObjectToIdMap.put(obj, valueOf);
            this.mIdToObjectMap.put(valueOf.intValue(), obj);
            onMapped(obj, valueOf.intValue());
            return valueOf.intValue();
        }
    }

    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            Integer remove = this.mObjectToIdMap.remove(obj);
            if (remove == null) {
                return null;
            }
            this.mIdToObjectMap.remove(remove.intValue());
            onUnmapped(obj, remove.intValue());
            return remove;
        }
    }

    public Object removeObjectById(int i10) {
        synchronized (this.mSync) {
            Object obj = this.mIdToObjectMap.get(i10);
            if (obj == null) {
                return null;
            }
            this.mIdToObjectMap.remove(i10);
            this.mObjectToIdMap.remove(obj);
            onUnmapped(obj, i10);
            return obj;
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }
}
