package fl;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lfl/k;", "", "", "toString", "Lokhttp3/Protocol;", "a", "Lokhttp3/Protocol;", "protocol", "", "b", "I", "code", "c", "Ljava/lang/String;", "message", "<init>", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "d", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class k {

    /* renamed from: d  reason: collision with root package name */
    public static final a f29677d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Protocol f29678a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29679b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29680c;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lfl/k$a;", "", "", "statusLine", "Lfl/k;", "a", "", "HTTP_CONTINUE", "I", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a(String str) throws IOException {
            Protocol protocol;
            String str2;
            j.g(str, "statusLine");
            int i10 = 9;
            if (r.J(str, "HTTP/1.", false, 2, (Object) null)) {
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException(j.p("Unexpected status line: ", str));
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException(j.p("Unexpected status line: ", str));
                }
            } else if (r.J(str, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                i10 = 4;
            } else {
                throw new ProtocolException(j.p("Unexpected status line: ", str));
            }
            int i11 = i10 + 3;
            if (str.length() >= i11) {
                try {
                    String substring = str.substring(i10, i11);
                    j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (str.length() <= i11) {
                        str2 = "";
                    } else if (str.charAt(i11) == ' ') {
                        str2 = str.substring(i10 + 4);
                        j.f(str2, "this as java.lang.String).substring(startIndex)");
                    } else {
                        throw new ProtocolException(j.p("Unexpected status line: ", str));
                    }
                    return new k(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException(j.p("Unexpected status line: ", str));
                }
            } else {
                throw new ProtocolException(j.p("Unexpected status line: ", str));
            }
        }
    }

    public k(Protocol protocol, int i10, String str) {
        j.g(protocol, "protocol");
        j.g(str, "message");
        this.f29678a = protocol;
        this.f29679b = i10;
        this.f29680c = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f29678a == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.f29679b);
        sb2.append(' ');
        sb2.append(this.f29680c);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
