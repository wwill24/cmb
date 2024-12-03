package c3;

import com.airbnb.lottie.c;
import com.airbnb.lottie.f0;
import java.util.HashSet;
import java.util.Set;

public class e implements f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7927a = new HashSet();

    public void a(String str) {
        b(str, (Throwable) null);
    }

    public void b(String str, Throwable th2) {
        Set<String> set = f7927a;
        if (!set.contains(str)) {
            set.add(str);
        }
    }

    public void c(String str, Throwable th2) {
        boolean z10 = c.f8524a;
    }

    public void debug(String str) {
        c(str, (Throwable) null);
    }

    public void error(String str, Throwable th2) {
        boolean z10 = c.f8524a;
    }
}
