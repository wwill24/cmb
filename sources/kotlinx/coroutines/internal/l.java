package kotlinx.coroutines.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, d2 = {"", "a", "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f32543a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.f32010a;
            obj = Result.b(Class.forName("android.os.Build"));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        f32543a = Result.h(obj);
    }

    public static final boolean a() {
        return f32543a;
    }
}
