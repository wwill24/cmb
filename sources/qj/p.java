package qj;

import io.reactivex.internal.util.NotificationLite;
import xj.b;

public final class p<T> {

    /* renamed from: b  reason: collision with root package name */
    static final p<Object> f33779b = new p<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    final Object f33780a;

    private p(Object obj) {
        this.f33780a = obj;
    }

    public static <T> p<T> a() {
        return f33779b;
    }

    public static <T> p<T> b(Throwable th2) {
        b.e(th2, "error is null");
        return new p<>(NotificationLite.h(th2));
    }

    public static <T> p<T> c(T t10) {
        b.e(t10, "value is null");
        return new p<>(t10);
    }

    public Throwable d() {
        Object obj = this.f33780a;
        if (NotificationLite.l(obj)) {
            return NotificationLite.i(obj);
        }
        return null;
    }

    public T e() {
        Object obj = this.f33780a;
        if (obj == null || NotificationLite.l(obj)) {
            return null;
        }
        return this.f33780a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return b.c(this.f33780a, ((p) obj).f33780a);
        }
        return false;
    }

    public boolean f() {
        return NotificationLite.l(this.f33780a);
    }

    public boolean g() {
        Object obj = this.f33780a;
        if (obj == null || NotificationLite.l(obj)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f33780a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f33780a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.l(obj)) {
            return "OnErrorNotification[" + NotificationLite.i(obj) + "]";
        }
        return "OnNextNotification[" + this.f33780a + "]";
    }
}
