package j$.time.zone;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList f42782a;

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap f42783b = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f42782a = copyOnWriteArrayList;
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new e(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected g() {
    }

    public static HashSet a() {
        return new HashSet(f42783b.keySet());
    }

    public static c b(String str, boolean z10) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f42783b;
        g gVar = (g) concurrentHashMap.get(str);
        if (gVar != null) {
            return gVar.c(str);
        }
        if (concurrentHashMap.isEmpty()) {
            throw new d("No time-zone data files registered");
        }
        throw new d("Unknown time-zone ID: " + str);
    }

    public static void e(g gVar) {
        Objects.requireNonNull(gVar, "provider");
        for (String str : gVar.d()) {
            Objects.requireNonNull(str, "zoneId");
            if (((g) f42783b.putIfAbsent(str, gVar)) != null) {
                throw new d("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + gVar);
            }
        }
        f42782a.add(gVar);
    }

    /* access modifiers changed from: protected */
    public abstract c c(String str);

    /* access modifiers changed from: protected */
    public abstract Set d();
}
