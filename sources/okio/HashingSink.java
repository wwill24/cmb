package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "Ljava/security/MessageDigest;", "b", "Ljava/security/MessageDigest;", "messageDigest", "Ljavax/crypto/Mac;", "c", "Ljavax/crypto/Mac;", "mac", "d", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class HashingSink extends ForwardingSink {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f33360d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final MessageDigest f33361b;

    /* renamed from: c  reason: collision with root package name */
    private final Mac f33362c;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/HashingSink$Companion;", "", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void k0(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "source");
        _UtilKt.b(buffer.size(), 0, j10);
        Segment segment = buffer.f33298a;
        j.d(segment);
        long j11 = 0;
        while (j11 < j10) {
            int min = (int) Math.min(j10 - j11, (long) (segment.f33410c - segment.f33409b));
            MessageDigest messageDigest = this.f33361b;
            if (messageDigest != null) {
                messageDigest.update(segment.f33408a, segment.f33409b, min);
            } else {
                Mac mac = this.f33362c;
                j.d(mac);
                mac.update(segment.f33408a, segment.f33409b, min);
            }
            j11 += (long) min;
            segment = segment.f33413f;
            j.d(segment);
        }
        super.k0(buffer, j10);
    }
}
