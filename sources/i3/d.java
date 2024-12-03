package i3;

import androidx.annotation.NonNull;
import f4.j;
import java.security.MessageDigest;

public final class d<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f15460e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final T f15461a;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f15462b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15463c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f15464d;

    class a implements b<Object> {
        a() {
        }

        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t10, @NonNull MessageDigest messageDigest);
    }

    private d(@NonNull String str, T t10, @NonNull b<T> bVar) {
        this.f15463c = j.b(str);
        this.f15461a = t10;
        this.f15462b = (b) j.d(bVar);
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str, T t10, @NonNull b<T> bVar) {
        return new d<>(str, t10, bVar);
    }

    @NonNull
    private static <T> b<T> b() {
        return f15460e;
    }

    @NonNull
    private byte[] d() {
        if (this.f15464d == null) {
            this.f15464d = this.f15463c.getBytes(b.f15458a);
        }
        return this.f15464d;
    }

    @NonNull
    public static <T> d<T> e(@NonNull String str) {
        return new d<>(str, (Object) null, b());
    }

    @NonNull
    public static <T> d<T> f(@NonNull String str, @NonNull T t10) {
        return new d<>(str, t10, b());
    }

    public T c() {
        return this.f15461a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f15463c.equals(((d) obj).f15463c);
        }
        return false;
    }

    public void g(@NonNull T t10, @NonNull MessageDigest messageDigest) {
        this.f15462b.a(d(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f15463c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f15463c + '\'' + '}';
    }
}
