package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

@Deprecated
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static long f4640a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f4641b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f4642c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f4643d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f4644e;

    static class a {
        static void a(String str) {
            Trace.beginSection(str);
        }

        static void b() {
            Trace.endSection();
        }
    }

    static {
        Class<String> cls = String.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f4640a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls2 = Long.TYPE;
                f4641b = Trace.class.getMethod("isTagEnabled", new Class[]{cls2});
                Class cls3 = Integer.TYPE;
                f4642c = Trace.class.getMethod("asyncTraceBegin", new Class[]{cls2, cls, cls3});
                f4643d = Trace.class.getMethod("asyncTraceEnd", new Class[]{cls2, cls, cls3});
                f4644e = Trace.class.getMethod("traceCounter", new Class[]{cls2, cls, cls3});
            } catch (Exception unused) {
            }
        }
    }

    public static void a(@NonNull String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
