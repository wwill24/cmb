package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.j;

public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f32145c = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random f() {
        Object obj = this.f32145c.get();
        j.f(obj, "implStorage.get()");
        return (Random) obj;
    }
}
