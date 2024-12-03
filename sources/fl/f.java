package fl;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lfl/f;", "", "", "method", "", "d", "a", "c", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f29661a = new f();

    private f() {
    }

    public static final boolean a(String str) {
        j.g(str, FirebaseAnalytics.Param.METHOD);
        return !j.b(str, "GET") && !j.b(str, FirebasePerformance.HttpMethod.HEAD);
    }

    public static final boolean d(String str) {
        j.g(str, FirebaseAnalytics.Param.METHOD);
        if (j.b(str, "POST") || j.b(str, FirebasePerformance.HttpMethod.PUT) || j.b(str, FirebasePerformance.HttpMethod.PATCH) || j.b(str, "PROPPATCH") || j.b(str, "REPORT")) {
            return true;
        }
        return false;
    }

    public final boolean b(String str) {
        j.g(str, FirebaseAnalytics.Param.METHOD);
        return !j.b(str, "PROPFIND");
    }

    public final boolean c(String str) {
        j.g(str, FirebaseAnalytics.Param.METHOD);
        return j.b(str, "PROPFIND");
    }
}
