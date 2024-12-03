package androidx.lifecycle;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.j;

public class k0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, f0> f6047a = new LinkedHashMap();

    public final void a() {
        for (f0 a10 : this.f6047a.values()) {
            a10.a();
        }
        this.f6047a.clear();
    }

    public final f0 b(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        return this.f6047a.get(str);
    }

    public final Set<String> c() {
        return new HashSet(this.f6047a.keySet());
    }

    public final void d(String str, f0 f0Var) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(f0Var, "viewModel");
        f0 put = this.f6047a.put(str, f0Var);
        if (put != null) {
            put.d();
        }
    }
}
