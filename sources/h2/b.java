package h2;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lh2/b;", "", "", "a", "()Ljava/lang/String;", "processName", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f15274a = new b();

    private b() {
    }

    public final String a() {
        String a10 = Application.getProcessName();
        j.f(a10, "getProcessName()");
        return a10;
    }
}
