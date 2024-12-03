package coil.decode;

import java.io.InputStream;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcoil/decode/g;", "Ljava/io/InputStream;", "", "bytesRead", "a", "read", "", "b", "off", "len", "", "n", "skip", "available", "", "close", "Ljava/io/InputStream;", "delegate", "I", "availableBytes", "<init>", "(Ljava/io/InputStream;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
final class g extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f8098a;

    /* renamed from: b  reason: collision with root package name */
    private int f8099b = 1073741824;

    public g(InputStream inputStream) {
        this.f8098a = inputStream;
    }

    private final int a(int i10) {
        if (i10 == -1) {
            this.f8099b = 0;
        }
        return i10;
    }

    public int available() {
        return this.f8099b;
    }

    public void close() {
        this.f8098a.close();
    }

    public int read() {
        return a(this.f8098a.read());
    }

    public long skip(long j10) {
        return this.f8098a.skip(j10);
    }

    public int read(byte[] bArr) {
        return a(this.f8098a.read(bArr));
    }

    public int read(byte[] bArr, int i10, int i11) {
        return a(this.f8098a.read(bArr, i10, i11));
    }
}
