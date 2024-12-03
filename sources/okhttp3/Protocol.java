package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/Protocol;", "", "", "toString", "protocol", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "a", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "okhttp"}, k = 1, mv = {1, 6, 0})
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f32832a = null;
    /* access modifiers changed from: private */
    public final String protocol;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lokhttp3/Protocol$a;", "", "", "protocol", "Lokhttp3/Protocol;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Protocol a(String str) throws IOException {
            j.g(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!j.b(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!j.b(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!j.b(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!j.b(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!j.b(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!j.b(str, protocol.protocol)) {
                                    throw new IOException(j.p("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }
    }

    static {
        f32832a = new a((DefaultConstructorMarker) null);
    }

    private Protocol(String str) {
        this.protocol = str;
    }

    public String toString() {
        return this.protocol;
    }
}
