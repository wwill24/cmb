package io.sentry.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f31183a;

    public c(List<f> list) {
        this.f31183a = list;
    }

    public Map<String, String> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (f a10 : this.f31183a) {
            concurrentHashMap.putAll(a10.a(str));
        }
        return concurrentHashMap;
    }

    public String getProperty(String str) {
        for (f property : this.f31183a) {
            String property2 = property.getProperty(str);
            if (property2 != null) {
                return property2;
            }
        }
        return null;
    }
}
