package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.util.TLSUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/TlsVersion;", "", "", "javaName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "a", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "okhttp"}, k = 1, mv = {1, 6, 0})
public enum TlsVersion {
    TLS_1_3(TLSUtils.PROTO_TLSV1_3),
    TLS_1_2(TLSUtils.PROTO_TLSV1_2),
    TLS_1_1(TLSUtils.PROTO_TLSV1_1),
    TLS_1_0(TLSUtils.PROTO_TLSV1),
    SSL_3_0(TLSUtils.PROTO_SSL3);
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f32840a = null;
    private final String javaName;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lokhttp3/TlsVersion$a;", "", "", "javaName", "Lokhttp3/TlsVersion;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TlsVersion a(String str) {
            j.g(str, "javaName");
            int hashCode = str.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (str.equals(TLSUtils.PROTO_TLSV1_1)) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals(TLSUtils.PROTO_TLSV1_2)) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals(TLSUtils.PROTO_TLSV1_3)) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals(TLSUtils.PROTO_TLSV1)) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals(TLSUtils.PROTO_SSL3)) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException(j.p("Unexpected TLS version: ", str));
        }
    }

    static {
        f32840a = new a((DefaultConstructorMarker) null);
    }

    private TlsVersion(String str) {
        this.javaName = str;
    }

    public final String b() {
        return this.javaName;
    }
}
