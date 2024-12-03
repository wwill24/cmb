package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class B {

    /* renamed from: a  reason: collision with root package name */
    private final Map f42594a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f42595b;

    B(Map map) {
        this.f42594a = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                int i10 = C.f42598c;
                hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            Collections.sort(arrayList2, C.f42597b);
            hashMap.put((H) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put((Object) null, arrayList);
        }
        Collections.sort(arrayList, C.f42597b);
        this.f42595b = hashMap;
    }

    /* access modifiers changed from: package-private */
    public final String a(long j10, H h10) {
        Map map = (Map) this.f42594a.get(h10);
        if (map != null) {
            return (String) map.get(Long.valueOf(j10));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Iterator b(H h10) {
        List list = (List) this.f42595b.get(h10);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
