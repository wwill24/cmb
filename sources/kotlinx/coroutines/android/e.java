package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\"\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/os/Looper;", "", "async", "Landroid/os/Handler;", "a", "Lkotlinx/coroutines/android/d;", "Lkotlinx/coroutines/android/d;", "getMain$annotations", "()V", "Main", "Landroid/view/Choreographer;", "choreographer", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 6, 0})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f32283a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        d dVar = null;
        try {
            Result.a aVar = Result.f32010a;
            obj = Result.b(new HandlerContext(a(Looper.getMainLooper(), true), (String) null, 2, (DefaultConstructorMarker) null));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        if (!Result.g(obj)) {
            dVar = obj;
        }
        f32283a = dVar;
    }

    public static final Handler a(Looper looper, boolean z10) {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
