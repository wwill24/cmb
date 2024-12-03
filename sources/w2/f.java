package w2;

import com.airbnb.lottie.h;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final f f18181b = new f();

    /* renamed from: a  reason: collision with root package name */
    private final androidx.collection.f<String, h> f18182a = new androidx.collection.f<>(20);

    f() {
    }

    public static f b() {
        return f18181b;
    }

    public h a(String str) {
        if (str == null) {
            return null;
        }
        return this.f18182a.get(str);
    }

    public void c(String str, h hVar) {
        if (str != null) {
            this.f18182a.put(str, hVar);
        }
    }
}
