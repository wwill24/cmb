package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0016"}, d2 = {"Lokio/internal/b;", "Lokio/ForwardingSource;", "Lokio/Buffer;", "", "newSize", "", "b", "sink", "byteCount", "N1", "J", "size", "", "c", "Z", "truncate", "d", "bytesReceived", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;JZ)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class b extends ForwardingSource {

    /* renamed from: b  reason: collision with root package name */
    private final long f33451b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33452c;

    /* renamed from: d  reason: collision with root package name */
    private long f33453d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Source source, long j10, boolean z10) {
        super(source);
        j.g(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33451b = j10;
        this.f33452c = z10;
    }

    private final void b(Buffer buffer, long j10) {
        Buffer buffer2 = new Buffer();
        buffer2.o0(buffer);
        buffer.k0(buffer2, j10);
        buffer2.a();
    }

    public long N1(Buffer buffer, long j10) {
        j.g(buffer, "sink");
        long j11 = this.f33453d;
        long j12 = this.f33451b;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f33452c) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1;
            }
            j10 = Math.min(j10, j13);
        }
        long N1 = super.N1(buffer, j10);
        int i10 = (N1 > -1 ? 1 : (N1 == -1 ? 0 : -1));
        if (i10 != 0) {
            this.f33453d += N1;
        }
        long j14 = this.f33453d;
        long j15 = this.f33451b;
        if ((j14 >= j15 || i10 != 0) && j14 <= j15) {
            return N1;
        }
        if (N1 > 0 && j14 > j15) {
            b(buffer, buffer.size() - (this.f33453d - this.f33451b));
        }
        throw new IOException("expected " + this.f33451b + " bytes but got " + this.f33453d);
    }
}
