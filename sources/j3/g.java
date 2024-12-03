package j3;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f15562c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f15563d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f15564e;

    /* renamed from: a  reason: collision with root package name */
    private final byte f15565a;

    /* renamed from: b  reason: collision with root package name */
    private int f15566b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f15562c = bArr;
        int length = bArr.length;
        f15563d = length;
        f15564e = length + 2;
    }

    public g(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 < -1 || i10 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
        }
        this.f15565a = (byte) i10;
    }

    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i10;
        int i11;
        int i12 = this.f15566b;
        if (i12 < 2 || i12 > (i11 = f15564e)) {
            i10 = super.read();
        } else if (i12 == i11) {
            i10 = this.f15565a;
        } else {
            i10 = f15562c[i12 - 2] & 255;
        }
        if (i10 != -1) {
            this.f15566b++;
        }
        return i10;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j10) throws IOException {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.f15566b = (int) (((long) this.f15566b) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f15566b;
        int i14 = f15564e;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f15565a;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(i14 - i13, i11);
            System.arraycopy(f15562c, this.f15566b - 2, bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.f15566b += i12;
        }
        return i12;
    }
}
