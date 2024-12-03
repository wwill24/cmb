package io.sentry.clientreport;

import io.sentry.DataCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Map<c, AtomicLong> f31166a;

    public a() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (DiscardReason discardReason : DiscardReason.values()) {
            for (DataCategory category : DataCategory.values()) {
                concurrentHashMap.put(new c(discardReason.getReason(), category.getCategory()), new AtomicLong(0));
            }
        }
        this.f31166a = Collections.unmodifiableMap(concurrentHashMap);
    }

    public void a(c cVar, Long l10) {
        AtomicLong atomicLong = this.f31166a.get(cVar);
        if (atomicLong != null) {
            atomicLong.addAndGet(l10.longValue());
        }
    }

    public List<e> b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f31166a.entrySet()) {
            Long valueOf = Long.valueOf(((AtomicLong) next.getValue()).getAndSet(0));
            if (valueOf.longValue() > 0) {
                arrayList.add(new e(((c) next.getKey()).b(), ((c) next.getKey()).a(), valueOf));
            }
        }
        return arrayList;
    }
}
