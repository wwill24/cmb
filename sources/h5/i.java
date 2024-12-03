package h5;

import android.os.Bundle;
import com.coffeemeetsbagel.models.enums.EventType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import z9.f;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Map<EventType, List<f>> f15358a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<f, List<EventType>> f15359b = new HashMap();

    public static synchronized void a(f fVar, EventType... eventTypeArr) {
        synchronized (i.class) {
            for (EventType eventType : eventTypeArr) {
                if (f15358a.containsKey(eventType)) {
                    List list = f15358a.get(eventType);
                    if (!list.contains(fVar)) {
                        list.add(fVar);
                    }
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(fVar);
                    f15358a.put(eventType, linkedList);
                }
                if (f15359b.containsKey(fVar)) {
                    List list2 = f15359b.get(fVar);
                    if (!list2.contains(eventType)) {
                        list2.add(eventType);
                    }
                } else {
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(eventType);
                    f15359b.put(fVar, linkedList2);
                }
            }
        }
    }

    public static synchronized boolean b(EventType eventType) {
        boolean c10;
        synchronized (i.class) {
            c10 = c(eventType, new Bundle());
        }
        return c10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean c(com.coffeemeetsbagel.models.enums.EventType r5, android.os.Bundle r6) {
        /*
            java.lang.Class<h5.i> r0 = h5.i.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "eventType="
            r1.append(r2)     // Catch:{ all -> 0x006c }
            r1.append(r5)     // Catch:{ all -> 0x006c }
            java.util.Map<com.coffeemeetsbagel.models.enums.EventType, java.util.List<z9.f>> r1 = f15358a     // Catch:{ all -> 0x006c }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x006c }
            r2 = 0
            if (r1 != 0) goto L_0x0028
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r6.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r1 = "No listener found for "
            r6.append(r1)     // Catch:{ all -> 0x006c }
            r6.append(r5)     // Catch:{ all -> 0x006c }
            monitor-exit(r0)
            return r2
        L_0x0028:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            java.util.Map<com.coffeemeetsbagel.models.enums.EventType, java.util.List<z9.f>> r3 = f15358a     // Catch:{ all -> 0x006c }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0040
            java.util.Map<com.coffeemeetsbagel.models.enums.EventType, java.util.List<z9.f>> r3 = f15358a     // Catch:{ all -> 0x006c }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x006c }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x006c }
            r1.addAll(r3)     // Catch:{ all -> 0x006c }
        L_0x0040:
            boolean r3 = r1.isEmpty()     // Catch:{ all -> 0x006c }
            if (r3 != 0) goto L_0x0063
            java.util.Iterator r3 = r1.iterator()     // Catch:{ all -> 0x006c }
        L_0x004a:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x006c }
            z9.f r4 = (z9.f) r4     // Catch:{ all -> 0x006c }
            r4.n0(r5, r6)     // Catch:{ all -> 0x006c }
            goto L_0x004a
        L_0x005a:
            int r5 = r1.size()     // Catch:{ all -> 0x006c }
            if (r5 <= 0) goto L_0x0061
            r2 = 1
        L_0x0061:
            monitor-exit(r0)
            return r2
        L_0x0063:
            java.lang.String r5 = "ManagerEvents"
            java.lang.String r6 = "No listeners to notify!"
            fa.a.f(r5, r6)     // Catch:{ all -> 0x006c }
            monitor-exit(r0)
            return r2
        L_0x006c:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.i.c(com.coffeemeetsbagel.models.enums.EventType, android.os.Bundle):boolean");
    }

    public static synchronized void d(f fVar, EventType... eventTypeArr) {
        boolean z10;
        synchronized (i.class) {
            if (eventTypeArr.length > 0) {
                for (EventType eventType : eventTypeArr) {
                    List list = f15358a.get(eventType);
                    if (list == null || !list.remove(fVar)) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10 && list.size() == 0) {
                        f15358a.remove(eventType);
                    }
                    if (f15359b.containsKey(fVar)) {
                        List list2 = f15359b.get(fVar);
                        list2.remove(eventType);
                        if (list2.size() == 0) {
                            f15359b.remove(fVar);
                        }
                    }
                }
            } else {
                f15359b.remove(fVar);
                Iterator<Map.Entry<EventType, List<f>>> it = f15358a.entrySet().iterator();
                while (it.hasNext()) {
                    List list3 = (List) it.next().getValue();
                    list3.remove(fVar);
                    if (list3.size() == 0) {
                        it.remove();
                    }
                }
            }
        }
    }
}
