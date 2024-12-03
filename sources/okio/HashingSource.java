package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0011J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Ljava/security/MessageDigest;", "b", "Ljava/security/MessageDigest;", "messageDigest", "Ljavax/crypto/Mac;", "c", "Ljavax/crypto/Mac;", "mac", "d", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class HashingSource extends ForwardingSource {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f33363d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final MessageDigest f33364b;

    /* renamed from: c  reason: collision with root package name */
    private final Mac f33365c;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/HashingSource$Companion;", "", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public long N1(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "sink");
        long N1 = super.N1(buffer, j10);
        if (N1 != -1) {
            long size = buffer.size() - N1;
            long size2 = buffer.size();
            Segment segment = buffer.f33298a;
            j.d(segment);
            while (size2 > size) {
                segment = segment.f33414g;
                j.d(segment);
                size2 -= (long) (segment.f33410c - segment.f33409b);
            }
            while (size2 < buffer.size()) {
                int i10 = (int) ((((long) segment.f33409b) + size) - size2);
                MessageDigest messageDigest = this.f33364b;
                if (messageDigest != null) {
                    messageDigest.update(segment.f33408a, i10, segment.f33410c - i10);
                } else {
                    Mac mac = this.f33365c;
                    j.d(mac);
                    mac.update(segment.f33408a, i10, segment.f33410c - i10);
                }
                size2 += (long) (segment.f33410c - segment.f33409b);
                segment = segment.f33413f;
                j.d(segment);
                size = size2;
            }
        }
        return N1;
    }
}
