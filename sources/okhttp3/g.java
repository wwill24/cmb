package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR%\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00070\u000e8G¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0016\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokhttp3/g;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "scheme", "", "b", "Ljava/util/Map;", "authParams", "()Ljava/util/Map;", "realm", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "charset", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f32923a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f32924b;

    public g(String str, Map<String, String> map) {
        String str2;
        j.g(str, "scheme");
        j.g(map, "authParams");
        this.f32923a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getKey();
            String str4 = (String) next.getValue();
            if (str3 == null) {
                str2 = null;
            } else {
                Locale locale = Locale.US;
                j.f(locale, "US");
                str2 = str3.toLowerCase(locale);
                j.f(str2, "this as java.lang.String).toLowerCase(locale)");
            }
            linkedHashMap.put(str2, str4);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        j.f(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f32924b = unmodifiableMap;
    }

    public final Charset a() {
        String str = this.f32924b.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                j.f(forName, "forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        j.f(charset, "ISO_8859_1");
        return charset;
    }

    public final String b() {
        return this.f32924b.get("realm");
    }

    public final String c() {
        return this.f32923a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (!j.b(gVar.f32923a, this.f32923a) || !j.b(gVar.f32924b, this.f32924b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f32923a.hashCode()) * 31) + this.f32924b.hashCode();
    }

    public String toString() {
        return this.f32923a + " authParams=" + this.f32924b;
    }
}
