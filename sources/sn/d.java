package sn;

import retrofit2.r;

public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final r<T> f42454a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f42455b;

    private d(r<T> rVar, Throwable th2) {
        this.f42454a = rVar;
        this.f42455b = th2;
    }

    public static <T> d<T> a(Throwable th2) {
        if (th2 != null) {
            return new d<>((r) null, th2);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> b(r<T> rVar) {
        if (rVar != null) {
            return new d<>(rVar, (Throwable) null);
        }
        throw new NullPointerException("response == null");
    }
}
