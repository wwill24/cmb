package okhttp3;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lokhttp3/n;", "", "", "username", "password", "Ljava/nio/charset/Charset;", "charset", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f33146a = new n();

    private n() {
    }

    public static final String a(String str, String str2, Charset charset) {
        j.g(str, "username");
        j.g(str2, "password");
        j.g(charset, "charset");
        return j.p("Basic ", ByteString.f33308c.b(str + ':' + str2, charset).a());
    }
}
