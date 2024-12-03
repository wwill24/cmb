package retrofit2;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.util.Objects;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.s;
import okhttp3.y;
import retrofit2.l;

public final class r<T> {

    /* renamed from: a  reason: collision with root package name */
    private final a0 f42414a;

    /* renamed from: b  reason: collision with root package name */
    private final T f42415b;

    /* renamed from: c  reason: collision with root package name */
    private final b0 f42416c;

    private r(a0 a0Var, T t10, b0 b0Var) {
        this.f42414a = a0Var;
        this.f42415b = t10;
        this.f42416c = b0Var;
    }

    public static <T> r<T> c(int i10, b0 b0Var) {
        Objects.requireNonNull(b0Var, "body == null");
        if (i10 >= 400) {
            return d(b0Var, new a0.a().b(new l.c(b0Var.contentType(), b0Var.contentLength())).g(i10).n("Response.error()").q(Protocol.HTTP_1_1).s(new y.a().q("http://localhost/").b()).c());
        }
        throw new IllegalArgumentException("code < 400: " + i10);
    }

    public static <T> r<T> d(b0 b0Var, a0 a0Var) {
        Objects.requireNonNull(b0Var, "body == null");
        Objects.requireNonNull(a0Var, "rawResponse == null");
        if (!a0Var.isSuccessful()) {
            return new r<>(a0Var, (Object) null, b0Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> r<T> i(T t10) {
        return j(t10, new a0.a().g(200).n(MessageTemplateConstants.Values.OK_TEXT).q(Protocol.HTTP_1_1).s(new y.a().q("http://localhost/").b()).c());
    }

    public static <T> r<T> j(T t10, a0 a0Var) {
        Objects.requireNonNull(a0Var, "rawResponse == null");
        if (a0Var.isSuccessful()) {
            return new r<>(a0Var, t10, (b0) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f42415b;
    }

    public int b() {
        return this.f42414a.f();
    }

    public b0 e() {
        return this.f42416c;
    }

    public s f() {
        return this.f42414a.n();
    }

    public boolean g() {
        return this.f42414a.isSuccessful();
    }

    public String h() {
        return this.f42414a.u();
    }

    public String toString() {
        return this.f42414a.toString();
    }
}
