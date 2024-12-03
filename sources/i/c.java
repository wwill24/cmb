package i;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public class c extends f {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f15432c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f15433d = new a();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f15434e = new b();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private f f15435a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final f f15436b;

    private c() {
        d dVar = new d();
        this.f15436b = dVar;
        this.f15435a = dVar;
    }

    @NonNull
    public static Executor f() {
        return f15434e;
    }

    @NonNull
    public static c g() {
        if (f15432c != null) {
            return f15432c;
        }
        synchronized (c.class) {
            if (f15432c == null) {
                f15432c = new c();
            }
        }
        return f15432c;
    }

    public void a(@NonNull Runnable runnable) {
        this.f15435a.a(runnable);
    }

    public boolean b() {
        return this.f15435a.b();
    }

    public void c(@NonNull Runnable runnable) {
        this.f15435a.c(runnable);
    }
}
