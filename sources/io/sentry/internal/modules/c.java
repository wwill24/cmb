package io.sentry.internal.modules;

import io.sentry.SentryLevel;
import io.sentry.h0;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
@ApiStatus.Internal
public final class c extends d {

    /* renamed from: d  reason: collision with root package name */
    private final Pattern f31292d;

    /* renamed from: e  reason: collision with root package name */
    private final Pattern f31293e;

    /* renamed from: f  reason: collision with root package name */
    private final ClassLoader f31294f;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f31295a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f31296b;

        public a(String str, String str2) {
            this.f31295a = str;
            this.f31296b = str2;
        }
    }

    public c(h0 h0Var) {
        this(c.class.getClassLoader(), h0Var);
    }

    private a d(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = this.f31293e.matcher(str);
        if (!matcher.matches() || matcher.groupCount() != 2) {
            return null;
        }
        return new a(matcher.group(1), matcher.group(2));
    }

    private List<a> e() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.f31294f.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                a d10 = d(f(resources.nextElement()));
                if (d10 != null) {
                    arrayList.add(d10);
                }
            }
        } catch (Throwable th2) {
            this.f31298a.b(SentryLevel.ERROR, "Unable to detect modules via manifest files.", th2);
        }
        return arrayList;
    }

    private String f(URL url) {
        Matcher matcher = this.f31292d.matcher(url.toString());
        if (!matcher.matches() || matcher.groupCount() != 1) {
            return null;
        }
        return matcher.group(1);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (a next : e()) {
            hashMap.put(next.f31295a, next.f31296b);
        }
        return hashMap;
    }

    c(ClassLoader classLoader, h0 h0Var) {
        super(h0Var);
        this.f31292d = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.f31293e = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.f31294f = io.sentry.util.a.a(classLoader);
    }
}
