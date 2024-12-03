package com.leanplum.internal;

import androidx.annotation.NonNull;
import com.leanplum.internal.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountAggregator {
    private final Map<String, Integer> counts = new HashMap();
    private Set<String> enabledCounters = new HashSet();

    public Map<String, Integer> getAndClearCounts() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.counts);
        this.counts.clear();
        return hashMap;
    }

    public Map<String, Integer> getCounts() {
        return this.counts;
    }

    public void incrementCount(@NonNull String str) {
        incrementCount(str, 1);
    }

    public Map<String, Object> makeParams(@NonNull String str, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Constants.Values.SDK_COUNT);
        hashMap.put("name", str);
        hashMap.put("count", Integer.valueOf(i10));
        return hashMap;
    }

    public void sendAllCounts() {
        for (Map.Entry next : getAndClearCounts().entrySet()) {
            try {
                RequestSender.getInstance().send(RequestBuilder.withLogAction().andParams(makeParams((String) next.getKey(), ((Integer) next.getValue()).intValue())).create());
            } catch (Throwable unused) {
            }
        }
    }

    public void setEnabledCounters(Set<String> set) {
        this.enabledCounters = set;
    }

    public void incrementCount(@NonNull String str, int i10) {
        if (this.enabledCounters.contains(str)) {
            Integer num = 0;
            if (this.counts.containsKey(str)) {
                num = this.counts.get(str);
            }
            this.counts.put(str, Integer.valueOf(num.intValue() + i10));
        }
    }
}
