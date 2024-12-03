package r6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final /* synthetic */ class h {
    public static /* synthetic */ Map a(Map.Entry[] entryArr) {
        HashMap hashMap = new HashMap(entryArr.length);
        int length = entryArr.length;
        int i10 = 0;
        while (i10 < length) {
            Map.Entry entry = entryArr[i10];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (hashMap.put(key, value) == null) {
                i10++;
            } else {
                throw new IllegalArgumentException("duplicate key: " + key);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
