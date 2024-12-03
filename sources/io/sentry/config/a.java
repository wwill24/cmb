package io.sentry.config;

import io.sentry.util.l;
import io.sentry.util.p;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

abstract class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final String f31178a;

    /* renamed from: b  reason: collision with root package name */
    private final Properties f31179b;

    protected a(String str, Properties properties) {
        this.f31178a = (String) l.c(str, "prefix is required");
        this.f31179b = (Properties) l.c(properties, "properties are required");
    }

    public Map<String, String> a(String str) {
        String str2 = this.f31178a + str + ".";
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f31179b.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str3 = (String) entry.getKey();
                if (str3.startsWith(str2)) {
                    hashMap.put(str3.substring(str2.length()), p.e((String) entry.getValue(), "\""));
                }
            }
        }
        return hashMap;
    }

    public String getProperty(String str) {
        Properties properties = this.f31179b;
        return p.e(properties.getProperty(this.f31178a + str), "\"");
    }

    protected a(Properties properties) {
        this("", properties);
    }
}
