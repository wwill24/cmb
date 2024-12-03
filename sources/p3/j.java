package p3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f16937c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f16938d;

    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        private static final String f16939d;

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, List<i>> f16940e;

        /* renamed from: a  reason: collision with root package name */
        private boolean f16941a = true;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, List<i>> f16942b = f16940e;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16943c = true;

        static {
            String b10 = b();
            f16939d = b10;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b10)));
            }
            f16940e = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = property.charAt(i10);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb2.append(charAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        public j a() {
            this.f16941a = true;
            return new j(this.f16942b);
        }
    }

    static final class b implements i {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f16944a;

        b(@NonNull String str) {
            this.f16944a = str;
        }

        public String a() {
            return this.f16944a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f16944a.equals(((b) obj).f16944a);
            }
            return false;
        }

        public int hashCode() {
            return this.f16944a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f16944a + '\'' + '}';
        }
    }

    j(Map<String, List<i>> map) {
        this.f16937c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String b(@NonNull List<i> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String a10 = list.get(i10).a();
            if (!TextUtils.isEmpty(a10)) {
                sb2.append(a10);
                if (i10 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f16937c.entrySet()) {
            String b10 = b((List) next.getValue());
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put(next.getKey(), b10);
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f16938d == null) {
            synchronized (this) {
                if (this.f16938d == null) {
                    this.f16938d = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f16938d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f16937c.equals(((j) obj).f16937c);
        }
        return false;
    }

    public int hashCode() {
        return this.f16937c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f16937c + '}';
    }
}
