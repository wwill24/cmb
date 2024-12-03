package io.sentry.config;

import com.mparticle.kits.AppsFlyerKit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface f {
    Map<String, String> a(String str);

    Long b(String str) {
        String property = getProperty(str);
        if (property != null) {
            try {
                return Long.valueOf(property);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    Double c(String str) {
        String property = getProperty(str);
        if (property != null) {
            try {
                return Double.valueOf(property);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    String d(String str, String str2) {
        String property = getProperty(str);
        return property != null ? property : str2;
    }

    List<String> e(String str) {
        String property = getProperty(str);
        if (property != null) {
            return Arrays.asList(property.split(AppsFlyerKit.COMMA));
        }
        return Collections.emptyList();
    }

    Boolean f(String str) {
        String property = getProperty(str);
        if (property != null) {
            return Boolean.valueOf(property);
        }
        return null;
    }

    String getProperty(String str);
}
