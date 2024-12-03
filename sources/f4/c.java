package f4;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f14710a;

    /* renamed from: b  reason: collision with root package name */
    private int f14711b;

    private c(@NonNull InputStream inputStream, long j10) {
        super(inputStream);
        this.f14710a = j10;
    }

    private int a(int i10) throws IOException {
        if (i10 >= 0) {
            this.f14711b += i10;
        } else if (this.f14710a - ((long) this.f14711b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f14710a + ", but read: " + this.f14711b);
        }
        return i10;
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, long j10) {
        return new c(inputStream, j10);
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f14710a - ((long) this.f14711b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return a(super.read(bArr, i10, i11));
    }
}
