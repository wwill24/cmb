package f4;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class h extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f14723a = Integer.MIN_VALUE;

    public h(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    private long a(long j10) {
        int i10 = this.f14723a;
        if (i10 == 0) {
            return -1;
        }
        return (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) ? j10 : (long) i10;
    }

    private void b(long j10) {
        int i10 = this.f14723a;
        if (i10 != Integer.MIN_VALUE && j10 != -1) {
            this.f14723a = (int) (((long) i10) - j10);
        }
    }

    public int available() throws IOException {
        int i10 = this.f14723a;
        if (i10 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i10, super.available());
    }

    public synchronized void mark(int i10) {
        super.mark(i10);
        this.f14723a = i10;
    }

    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f14723a = Integer.MIN_VALUE;
    }

    public long skip(long j10) throws IOException {
        long a10 = a(j10);
        if (a10 == -1) {
            return 0;
        }
        long skip = super.skip(a10);
        b(skip);
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int a10 = (int) a((long) i11);
        if (a10 == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, a10);
        b((long) read);
        return read;
    }
}
