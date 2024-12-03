package gl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.s;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0011"}, d2 = {"Lgl/a;", "", "", "b", "Lokhttp3/s;", "a", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "source", "", "J", "headerLimit", "<init>", "(Lokio/BufferedSource;)V", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0343a f29715c = new C0343a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f29716a;

    /* renamed from: b  reason: collision with root package name */
    private long f29717b = 262144;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lgl/a$a;", "", "", "HEADER_LIMIT", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: gl.a$a  reason: collision with other inner class name */
    public static final class C0343a {
        private C0343a() {
        }

        public /* synthetic */ C0343a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(BufferedSource bufferedSource) {
        j.g(bufferedSource, "source");
        this.f29716a = bufferedSource;
    }

    public final s a() {
        boolean z10;
        s.a aVar = new s.a();
        while (true) {
            String b10 = b();
            if (b10.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return aVar.f();
            }
            aVar.c(b10);
        }
    }

    public final String b() {
        String X = this.f29716a.X(this.f29717b);
        this.f29717b -= (long) X.length();
        return X;
    }
}
