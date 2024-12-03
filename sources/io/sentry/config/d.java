package io.sentry.config;

import io.sentry.util.p;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.cli.HelpFormatter;

final class d implements f {
    d() {
    }

    private String g(String str) {
        return "SENTRY_" + str.replace(".", JavaConstant.Dynamic.DEFAULT_NAME).replace(HelpFormatter.DEFAULT_OPT_PREFIX, JavaConstant.Dynamic.DEFAULT_NAME).toUpperCase(Locale.ROOT);
    }

    public Map<String, String> a(String str) {
        String e10;
        String str2 = g(str) + JavaConstant.Dynamic.DEFAULT_NAME;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : System.getenv().entrySet()) {
            String str3 = (String) next.getKey();
            if (str3.startsWith(str2) && (e10 = p.e((String) next.getValue(), "\"")) != null) {
                concurrentHashMap.put(str3.substring(str2.length()).toLowerCase(Locale.ROOT), e10);
            }
        }
        return concurrentHashMap;
    }

    public String getProperty(String str) {
        return p.e(System.getenv(g(str)), "\"");
    }
}
