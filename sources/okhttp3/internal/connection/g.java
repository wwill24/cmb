package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.c0;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/connection/g;", "", "Lokhttp3/c0;", "failedRoute", "", "b", "route", "a", "", "c", "", "Ljava/util/Set;", "failedRoutes", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c0> f33077a = new LinkedHashSet();

    public final synchronized void a(c0 c0Var) {
        j.g(c0Var, "route");
        this.f33077a.remove(c0Var);
    }

    public final synchronized void b(c0 c0Var) {
        j.g(c0Var, "failedRoute");
        this.f33077a.add(c0Var);
    }

    public final synchronized boolean c(c0 c0Var) {
        j.g(c0Var, "route");
        return this.f33077a.contains(c0Var);
    }
}
