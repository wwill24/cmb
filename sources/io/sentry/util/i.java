package io.sentry.util;

import io.sentry.h0;
import io.sentry.w;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class i {

    @FunctionalInterface
    public interface a<T> {
        void accept(T t10);
    }

    @FunctionalInterface
    public interface b {
        void a(Object obj, Class<?> cls);
    }

    @FunctionalInterface
    public interface c<T> {
        void accept(T t10);
    }

    public static w e(Object obj) {
        w wVar = new w();
        r(wVar, obj);
        return wVar;
    }

    public static Object f(w wVar) {
        return wVar.c("sentry:typeCheckHint");
    }

    public static boolean g(w wVar, Class<?> cls) {
        return cls.isInstance(f(wVar));
    }

    public static boolean h(w wVar) {
        return Boolean.TRUE.equals(wVar.d("sentry:isFromHybridSdk", Boolean.class));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k(Object obj, Class cls) {
    }

    public static <T> void m(w wVar, Class<T> cls, c<Object> cVar) {
        o(wVar, cls, new f(), new g(cVar));
    }

    public static <T> void n(w wVar, Class<T> cls, a<T> aVar) {
        o(wVar, cls, aVar, new e());
    }

    public static <T> void o(w wVar, Class<T> cls, a<T> aVar, b bVar) {
        Object f10 = f(wVar);
        if (!g(wVar, cls) || f10 == null) {
            bVar.a(f10, cls);
        } else {
            aVar.accept(f10);
        }
    }

    public static <T> void p(w wVar, Class<T> cls, h0 h0Var, a<T> aVar) {
        o(wVar, cls, aVar, new h(h0Var));
    }

    public static void q(w wVar, String str) {
        if (str.startsWith("sentry.javascript") || str.startsWith("sentry.dart") || str.startsWith("sentry.dotnet")) {
            wVar.i("sentry:isFromHybridSdk", Boolean.TRUE);
        }
    }

    public static void r(w wVar, Object obj) {
        wVar.i("sentry:typeCheckHint", obj);
    }

    public static boolean s(w wVar) {
        return !g(wVar, io.sentry.hints.c.class) || g(wVar, io.sentry.hints.b.class);
    }
}
